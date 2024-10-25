package com.maskman97a.baiketthuc.controller;

import com.maskman97a.baiketthuc.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("home")
@RequiredArgsConstructor
public class HomeController {
    private final OrderService orderService;

    @RequestMapping
    public String home() {
        orderService.filter(null, null, 1);
        return "home";
    }
}
