package io.shopping.user.cache;

import io.shopping.common.cache.AbstractCacheKeyPrefix;

/**
 * @author Wilson
 * @date 2019/9/23
 **/
public class UserKeyCache extends AbstractCacheKeyPrefix {

    public UserKeyCache(String prefix) {
        super(prefix + ":%s");
    }

    public String key(Object value) {
        return String.format(prefix(), value);
    }

    public UserKeyCache(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static UserKeyCache USER_ID = new UserKeyCache("user:id");

}
