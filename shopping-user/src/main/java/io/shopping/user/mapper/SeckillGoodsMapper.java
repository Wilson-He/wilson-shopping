package io.shopping.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.shopping.user.domain.entity.SeckillGoods;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 秒杀商品表Mapper 接口
 * </p>
 *
 * @author
 * @since 2019-10-17
 */
public interface SeckillGoodsMapper extends BaseMapper<SeckillGoods> {

    /**
     * @param seckillGoodsId
     */
    void reduceStock(@Param("id") Long seckillGoodsId);
}
