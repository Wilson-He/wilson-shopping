package io.shopping.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.shopping.user.domain.entity.Goods;
import io.shopping.user.domain.entity.SeckillGoods;
import io.shopping.user.dto.SeckillGoodsDTO;
import io.shopping.user.dto.SeckillGoodsDetailDTO;
import io.shopping.user.mapper.GoodsMapper;
import io.shopping.user.mapper.SeckillGoodsMapper;
import io.shopping.user.service.GoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * Goods-业务接口
 * </p>
 *
 * @author
 * @since 2019-10-17
 */
@Service
public class GoodsServiceImpl implements GoodsService {
    @Resource
    private GoodsMapper goodsMapper;
    @Resource
    private SeckillGoodsMapper seckillGoodsMapper;

    @Override
    public IPage<Goods> page(long page, long size) {
        return goodsMapper.selectPage(new Page<>(page, size), new LambdaQueryWrapper<>());
    }

    @Override
    public IPage<SeckillGoodsDTO> pageSeckill(long page, long size) {
        IPage result = seckillGoodsMapper.selectPage(new Page<>(page, size), new LambdaQueryWrapper<>());
        List<SeckillGoods> seckillGoodsList = result.getRecords();
        List<SeckillGoodsDTO> dtoList = new ArrayList<>(seckillGoodsList.size());
        List<Long> goodsIds = seckillGoodsList.stream()
                .map(SeckillGoods::getGoodsId)
                .collect(Collectors.toList());
        Map<Long, Goods> goodsMap = goodsMapper.selectList(new LambdaQueryWrapper<Goods>().in(Goods::getId, goodsIds))
                .stream()
                .collect(Collectors.toMap(Goods::getId, goods -> goods));
        seckillGoodsList.forEach(seckillGoods ->
                dtoList.add(new SeckillGoodsDTO().init(goodsMap.get(seckillGoods.getGoodsId()), seckillGoods)));
        result.setRecords(dtoList);
        return result;
    }

    @Override
    public SeckillGoodsDetailDTO getSeckillDetail(Long seckillId) {
        SeckillGoods seckillGoods = seckillGoodsMapper.selectById(seckillId);
        Goods goods = goodsMapper.selectById(seckillGoods.getGoodsId());
        return new SeckillGoodsDetailDTO(goods, seckillGoods);
    }

    @Override
    public Goods findById(Long id) {
        return goodsMapper.selectById(id);
    }
}
