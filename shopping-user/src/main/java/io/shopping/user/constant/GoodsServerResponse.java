package io.shopping.user.constant;

import io.shopping.common.response.ServerResponse;

/**
 * @author Wilson
 * @date 2019/10/18
 **/
public interface GoodsServerResponse {
    ServerResponse STOCK_INSUFFICIENT = ServerResponse.error(30001,"库存不足");
    ServerResponse REPEATED_PARTICIPATION = ServerResponse.error(30002,"你已参与过该秒杀活动");

}
