package io.shopping.user.service.impl;

import io.shopping.user.domain.entity.SeckillGoods;
import io.shopping.user.mapper.SeckillGoodsMapper;
import io.shopping.user.service.SeckillGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * SeckillGoods-秒杀商品表业务接口
 * </p>
 *
 * @author
 * @since 2019-10-17
 */
@Service
public class SeckillGoodsServiceImpl implements SeckillGoodsService {
    @Resource
    private SeckillGoodsMapper seckillGoodsMapper;

    @Override
    public SeckillGoods findById(Long seckillGoodsId) {
        return seckillGoodsMapper.selectById(seckillGoodsId);
    }
}
