package io.shopping.user.service;

import io.shopping.user.domain.entity.OrderInfo;
import io.shopping.user.vo.CreateOrderInfoVO;

/**
 * <p>
 * OrderInfo-订单信息表业务接口
 * </p>
 * 
 * @author 
 * @since 2019-10-17
 */
public interface OrderInfoService {

    OrderInfo createOrder(CreateOrderInfoVO vo);
}
