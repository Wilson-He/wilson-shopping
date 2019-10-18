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
 * 
 * </p>
 *
 * @author 
 * @since 2019-10-17
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Goods implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 商品名称
     */
    private String name;

    /**
     * 商品标题
     */
    private String title;

    /**
     * 商品图片
     */
    private String pictureImg;

    /**
     * 商品详情介绍
     */
    private String detail;

    /**
     * 商品单价
     */
    private BigDecimal price;

    /**
     * 库存,-1为没有限制
     */
    private Integer stock;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
