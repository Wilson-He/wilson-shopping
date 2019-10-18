package io.shopping.user.service;

import io.shopping.user.domain.entity.Goods;
import io.shopping.user.domain.entity.OrderInfo;
import io.shopping.user.domain.entity.SeckillGoods;
import io.shopping.user.domain.entity.SeckillOrder;

/**
 * <p>
 * SeckillOrder-订单表业务接口
 * </p>
 *
 * @author
 * @since 2019-10-17
 */
public interface SeckillOrderService {

    OrderInfo createOrder(Long userId, SeckillGoods seckillGoods, Goods goods);

    SeckillOrder findByUserAndSeckillGoodsId(Long userId, Long seckillGoodsId);
}
