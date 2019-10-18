package io.shopping.user.controller;

import io.shopping.common.response.DefaultServerResponse;
import io.shopping.common.response.ServerResponse;
import io.shopping.user.constant.GoodsServerResponse;
import io.shopping.user.domain.entity.*;
import io.shopping.user.service.GoodsService;
import io.shopping.user.service.SeckillGoodsService;
import io.shopping.user.service.SeckillOrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author Wilson
 * @date 2019/10/18
 **/
@Controller("/order")
@RestController
public class OrderController {
    @Resource
    private SeckillOrderService seckillOrderService;
    @Resource
    private SeckillGoodsService seckillGoodsService;
    @Resource
    private GoodsService goodsService;

    @PostMapping("/seckill")
    public ServerResponse createSeckillOrder(@RequestParam Long seckillGoodsId, UserBase userBase) {
        if (userBase == null) {
            return DefaultServerResponse.UNAUTHORIZED;
        }
        Long userId = userBase.getId();
        SeckillGoods seckillGoods = seckillGoodsService.findById(seckillGoodsId);
        if (seckillGoods.getStock() < 1) {
            return GoodsServerResponse.STOCK_INSUFFICIENT;
        }
        SeckillOrder seckillOrder = seckillOrderService.findByUserAndSeckillGoodsId(userId, seckillGoods.getId());
        if (seckillOrder != null) {
            return GoodsServerResponse.REPEATED_PARTICIPATION;
        }
        Goods goods = goodsService.findById(seckillGoods.getGoodsId());
        OrderInfo orderInfo = seckillOrderService.createOrder(userId, seckillGoods, goods);
        return ServerResponse.success(orderInfo);
    }
}
