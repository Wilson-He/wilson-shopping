package io.shopping.common.response;

/**
 * @author Wilson
 * @date 2019/10/14
 **/
public interface DefaultServerResponse {
    ServerResponse SUCCESS = ServerResponse.success(null);
    ServerResponse PARAM_FAILED = ServerResponse.error(400,"参数错误");
    ServerResponse UNAUTHORIZED = ServerResponse.error(401,"请先登录");
    ServerResponse NOT_FOUND= ServerResponse.error(404,"Not Found");
    ServerResponse METHOD_NOT_ALLOWED = ServerResponse.error(405,"Method Not Allowed");
    ServerResponse UNAUTHORIZATION = ServerResponse.error(406,"权限不足");
    ServerResponse REQUEST_TIMEOUT = ServerResponse.error(408,"请求超时");
    ServerResponse SERVER_ERROR = ServerResponse.error(500,"服务器内部错误");
    ServerResponse BAD_GATEWAY= ServerResponse.error(502,"网关错误");

    ServerResponse GATEWAY_TIMEOUT= ServerResponse.error(504,"网关超时");
    ServerResponse USER_NOT_EXIST = ServerResponse.error(10001,"用户不存在");
    ServerResponse PASSWORD_ERROR = ServerResponse.error(10002,"密码错误");
    ServerResponse SESSION_ERROR = ServerResponse.error(10000,"会话不存在或已过期");
}
