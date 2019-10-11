package io.shopping.common.cache;

/**
 * 缓存key通用设置
 *
 * @author Wilson
 * @date 2019/9/23
 **/
public interface CacheKeyPrefix<K> {
    /**
     * 获取默认缓存过期时间,0为不过期
     */
    int expireSeconds();

    /**
     * 获取缓存前缀
     */
    String prefix();
}
