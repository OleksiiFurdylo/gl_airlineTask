package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by OleksiiF on 11.05.2018.
 */
@Controller
public class HelloController {

    @RequestMapping("/")
    public ModelAndView showMessage() {
        ModelAndView mv = new ModelAndView("hello");
        return mv;
    }
}
