package io.shopping.user.dto;

import io.shopping.user.domain.entity.Goods;
import io.shopping.user.domain.entity.SeckillGoods;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Wilson
 * @date 2019/10/17
 **/
@Data
public class SeckillGoodsDetailDTO {
    private Long goodsId;

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

    private LocalDateTime startDate;
    private LocalDateTime endDate;

    public SeckillGoodsDetailDTO(Goods goods, SeckillGoods seckillGoods) {
        this.title = goods.getTitle();
        this.name = goods.getName();
        this.goodsId = goods.getId();
        this.pictureImg = goods.getPictureImg();
        this.detail = goods.getDetail();
        this.price = seckillGoods.getPrice();
        this.stock = seckillGoods.getStock();
        this.startDate = seckillGoods.getStartDate();
        this.endDate = seckillGoods.getEndDate();
    }
}
