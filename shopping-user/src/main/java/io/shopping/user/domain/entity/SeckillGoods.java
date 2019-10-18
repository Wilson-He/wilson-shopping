package io.shopping.user.domain.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 秒杀商品表
 * </p>
 *
 * @author 
 * @since 2019-10-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class SeckillGoods implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 秒杀价
     */
    private BigDecimal price;

    /**
     * 库存数量
     */
    private Integer stock;

    private LocalDateTime startDate;

    /**
     * 结束时间
     */
    private LocalDateTime endDate;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

    private Integer isDelete;

}
