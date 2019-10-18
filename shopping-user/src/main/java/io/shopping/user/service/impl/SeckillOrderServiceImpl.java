package io.shopping.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import io.shopping.user.domain.entity.Goods;
import io.shopping.user.domain.entity.OrderInfo;
import io.shopping.user.domain.entity.SeckillGoods;
import io.shopping.user.domain.entity.SeckillOrder;
import io.shopping.user.mapper.SeckillGoodsMapper;
import io.shopping.user.mapper.SeckillOrderMapper;
import io.shopping.user.service.OrderInfoService;
import io.shopping.user.service.SeckillOrderService;
import io.shopping.user.vo.CreateOrderInfoVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>
 * SeckillOrder-订单表业务接口
 * </p>
 *
 * @author
 * @since 2019-10-17
 */
@Service
public class SeckillOrderServiceImpl implements SeckillOrderService {
    @Resource
    private SeckillOrderMapper seckillOrderMapper;
    @Resource
    private SeckillGoodsMapper seckillGoodsMapper;
    @Resource
    private OrderInfoService orderInfoService;

    @Override
    @Transactional
    public OrderInfo createOrder(Long userId, SeckillGoods seckillGoods, Goods goods) {
        // 减少秒杀商品库存
        seckillGoodsMapper.reduceStock(seckillGoods.getGoodsId());
        // 创建订单信息
        OrderInfo orderInfo = orderInfoService.createOrder(new CreateOrderInfoVO(userId, goods, seckillGoods));
        // 创建秒杀订单
        SeckillOrder seckillOrder = new SeckillOrder().setGoodsId(goods.getId())
                .setOrderId(orderInfo.getId())
                .setGoodsId(goods.getId())
                .setSeckillOrderId(seckillGoods.getId())
                .setUserId(userId);
        seckillOrderMapper.insert(seckillOrder);
        return orderInfo;
    }

    @Override
    public SeckillOrder findByUserAndSeckillGoodsId(Long userId, Long seckillGoodsId) {
        return seckillOrderMapper.selectOne(new LambdaQueryWrapper<SeckillOrder>()
                .eq(SeckillOrder::getUserId, userId)
                .eq(SeckillOrder::getSeckillOrderId, seckillGoodsId));
    }
}
