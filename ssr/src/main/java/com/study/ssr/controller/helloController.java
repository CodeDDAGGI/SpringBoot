package com.study.ssr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class helloController {

    @GetMapping("/hello/1") // 서블릿

    public ModelAndView helloPage1() { // dispatch
        ModelAndView mav = new ModelAndView();
        mav.setViewName("views/hello");
        return mav;
    }


}
