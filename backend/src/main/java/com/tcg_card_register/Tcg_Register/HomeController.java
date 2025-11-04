package com.tcg_card_register.Tcg_Register;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String index()
    {
        return "index.html";
    }

}