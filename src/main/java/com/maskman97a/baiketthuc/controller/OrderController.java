package com.maskman97a.baiketthuc.controller;

import com.maskman97a.baiketthuc.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("order")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @RequestMapping
    public String order(Model model) throws ParseException {
        return order(model, null, null, 1);
    }

    @RequestMapping("/search")
    public String order(Model model,
                        @RequestParam(name = "fromDate") String fromDateStr,
                        @RequestParam(name = "toDate") String toDateStr,
                        @RequestParam(name = "page", defaultValue = "1") Integer page) throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date fromDate = null;
        Date toDate = null;
        if (fromDateStr != null && !fromDateStr.isEmpty()) {
            fromDate = simpleDateFormat.parse(fromDateStr);

        }
        if (toDateStr != null && !toDateStr.isEmpty()) {
            toDate = simpleDateFormat.parse(toDateStr);
        }
        model.addAttribute("fromDate", fromDateStr);
        model.addAttribute("toDate", toDateStr);
        model.addAttribute("page", page);
        model.addAttribute("orderList", orderService.filter(fromDate, toDate, page));
        return "home";
    }

    @RequestMapping("/top")
    public String orderTop(Model model,
                           @RequestParam(name = "top") Integer top) throws ParseException {
        model.addAttribute("top", top);
        model.addAttribute("orderList", orderService.viewTop(top));
        return "home";
    }
}