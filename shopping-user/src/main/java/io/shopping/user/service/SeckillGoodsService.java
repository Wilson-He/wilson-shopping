package io.shopping.user.service;

import io.shopping.user.domain.entity.SeckillGoods;

/**
 * <p>
 * SeckillGoods-秒杀商品表业务接口
 * </p>
 * 
 * @author 
 * @since 2019-10-17
 */
public interface SeckillGoodsService {

    SeckillGoods findById(Long seckillGoodsId);
}
