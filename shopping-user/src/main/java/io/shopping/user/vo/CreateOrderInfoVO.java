package io.shopping.user.vo;

import io.shopping.user.domain.constant.OrderInfoConstant;
import io.shopping.user.domain.entity.Goods;
import io.shopping.user.domain.entity.OrderInfo;
import io.shopping.user.domain.entity.SeckillGoods;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Wilson
 * @date 2019/10/17
 **/
@AllArgsConstructor
@Data
public class CreateOrderInfoVO {
    private Long userId;
    private Goods goods;
    private SeckillGoods seckillGoods;

    public CreateOrderInfoVO(Long userId, Goods goods) {
        this.userId = userId;
        this.goods = goods;
    }

    public OrderInfo toOrderInfo() {
        OrderInfo orderInfo = new OrderInfo()
                .setUserId(userId)
                .setGoodsId(goods.getId())
                .setState(OrderInfoConstant.State.UNPAID)
                .setDeliveryAddrId(1L)
                .setGoodsName(goods.getName());
        if (seckillGoods == null) {
            orderInfo.setGoodsCount(goods.getStock())
                    .setGoodsPrice(goods.getPrice());
        } else {
            orderInfo.setGoodsCount(seckillGoods.getStock())
                    .setGoodsPrice(seckillGoods.getPrice());
        }
        return orderInfo;
    }
}
