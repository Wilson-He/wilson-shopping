package io.shopping.user.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.shopping.user.domain.constant.OrderInfoConstant;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单信息表
 * </p>
 *
 * @author 
 * @since 2019-10-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class OrderInfo implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    private Long goodsId;

    /**
     * 订单状态(UNPAID-0:未支付,PAID-1:已支付,DELIVERING-2:已发货,RECEIVED-3:已收货,REFUNDED-4:已退款,FINISHED-5:已完成)
     */
    private Integer state;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 收货地址id
     */
    private Long deliveryAddrId;

    /**
     * 商品价格
     */
    private BigDecimal goodsPrice;

    /**
     * 商品数量
     */
    private Integer goodsCount;

    /**
     * 下单渠道(PC-1:电脑端,ANDROID-2:安卓端,IOS-3:苹果)
     */
    private Integer orderChannel;

    /**
     * 支付时间
     */
    private LocalDateTime payTime;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer isDelete;

}
