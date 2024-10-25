package com.maskman97a.baiketthuc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("")
public class BaseController {
    @RequestMapping
    public String redirect() {
        return "redirect:/home";
    }
}
