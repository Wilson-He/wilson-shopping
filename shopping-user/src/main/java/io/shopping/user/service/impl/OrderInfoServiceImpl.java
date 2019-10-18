package io.shopping.user.service.impl;

import io.shopping.user.domain.constant.OrderInfoConstant;
import io.shopping.user.domain.entity.OrderInfo;
import io.shopping.user.mapper.OrderInfoMapper;
import io.shopping.user.service.OrderInfoService;
import io.shopping.user.vo.CreateOrderInfoVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * OrderInfo-订单信息表业务接口
 * </p>
 *
 * @author
 * @since 2019-10-17
 */
@Service
public class OrderInfoServiceImpl implements OrderInfoService {
    @Resource
    private OrderInfoMapper orderInfoMapper;

    @Override
    public OrderInfo createOrder(CreateOrderInfoVO vo) {
        OrderInfo orderInfo = vo.toOrderInfo();
        orderInfoMapper.insert(vo.toOrderInfo());
        return orderInfo;
    }
}
