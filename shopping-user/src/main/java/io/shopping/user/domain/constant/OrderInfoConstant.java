package io.shopping.user.domain.constant;

import com.google.common.collect.ImmutableMap;

import java.util.Map;

/**
 * OrderInfo常量类
 *
 * @author 
 * @since 2019-10-17
 */
public interface OrderInfoConstant {

    /**
     * 订单状态(UNPAID-0:未支付,PAID-1:已支付,DELIVERING-2:已发货,RECEIVED-3:已收货,REFUNDED-4:已退款,FINISHED-5:已完成)
     */
    interface State {
        /**
         * 未支付
         */
        Integer UNPAID = 0;
        /**
         * 已支付
         */
        Integer PAID = 1;
        /**
         * 已发货
         */
        Integer DELIVERING = 2;
        /**
         * 已收货
         */
        Integer RECEIVED = 3;
        /**
         * 已退款
         */
        Integer REFUNDED = 4;
        /**
         * 已完成
         */
        Integer FINISHED = 5;
        Map<Object, Object> MAP = ImmutableMap.builder()
                .put(UNPAID, "未支付")
                .put(PAID, "已支付")
                .put(DELIVERING, "已发货")
                .put(RECEIVED, "已收货")
                .put(REFUNDED, "已退款")
                .build();
    }

    /**
     * 下单渠道(PC-1:电脑端,ANDROID-2:安卓端,IOS-3:苹果)
     */
    interface OrderChannel {
        /**
         * 电脑端
         */
        Integer PC = 1;
        /**
         * 安卓端
         */
        Integer ANDROID = 2;
        /**
         * 苹果
         */
        Integer IOS = 3;
        Map<Integer, String> MAP = ImmutableMap.of(
                PC, "电脑端",
                ANDROID, "安卓端",
                IOS, "苹果");
    }

    /**
     * 标志量(YES-是,NO-否)
     */
    interface Flag {
        /**
         * 是
         */
        String YES = "YES";
        /**
         * 否
         */
        String NO = "NO";
        Map<String, String> MAP = ImmutableMap.of(
                YES, "是",
                NO, "否");
    }

    /**
     * 测试标准(YES:是,NO:否)
     */
    interface SecondFlag {
        /**
         * 是
         */
        String YES = "YES";
        /**
         * 否
         */
        String NO = "NO";
        Map<String, String> MAP = ImmutableMap.of(
                YES, "是",
                NO, "否");
    }

}
