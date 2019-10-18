package io.shopping.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.shopping.user.domain.entity.Goods;
import io.shopping.user.dto.SeckillGoodsDTO;
import io.shopping.user.dto.SeckillGoodsDetailDTO;

/**
 * <p>
 * Goods-业务接口
 * </p>
 *
 * @author
 * @since 2019-10-17
 */
public interface GoodsService {

    IPage<Goods> page(long page, long size);

    IPage<SeckillGoodsDTO> pageSeckill(long page, long size);

    SeckillGoodsDetailDTO getSeckillDetail(Long seckillId);

    Goods findById(Long id);
}
