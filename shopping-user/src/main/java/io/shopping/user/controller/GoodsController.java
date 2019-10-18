package io.shopping.user.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.shopping.user.domain.entity.UserBase;
import io.shopping.user.dto.SeckillGoodsDTO;
import io.shopping.user.dto.SeckillGoodsDetailDTO;
import io.shopping.user.service.GoodsService;
import io.shopping.user.service.UserBaseService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author Wilson
 * @date 2019/10/15
 **/
@Controller
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private UserBaseService userBaseService;
    @Resource
    private GoodsService goodsService;

    @GetMapping("/list")
    public String list(Model model, UserBase userBase) {
        model.addAttribute("user", userBase);
        model.addAttribute("goodsPage", goodsService.page(1, 10));
        return "goods_list";
    }

    @GetMapping("/page")
    public String page(@RequestParam Integer page, @RequestParam Integer size, Model model, UserBase userBase) {
        model.addAttribute("user", userBase);
        IPage<SeckillGoodsDTO> result = goodsService.pageSeckill(page, size);
        model.addAttribute("goodsPage", result);
        return "goods_list";
    }

    @GetMapping("/seckill/{seckillId}")

    public SeckillGoodsDetailDTO seckillDetail(@PathVariable("seckillId") Long seckillId, Model model, UserBase userBase) {
        model.addAttribute("user", userBase);
        SeckillGoodsDetailDTO dto = goodsService.getSeckillDetail(seckillId);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startTime = dto.getStartDate();
        LocalDateTime endTime = dto.getEndDate();
        long remainSeconds;
        int status;
        if (now.isBefore(startTime)) {
            status = 0;
            remainSeconds = Duration.between(now, startTime).toMillis() / 1000;
        } else if (now.isAfter(endTime)) {
            status = -1;
            remainSeconds = -1;
        } else {
            status = 1;
            remainSeconds = Duration.between(now, endTime).toMillis() / 1000;
        }
        model.addAttribute("goodsDetail", dto);
        model.addAttribute("status", status);
        model.addAttribute("remainSeconds", remainSeconds);
        return dto;
    }

}
