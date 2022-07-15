package com.hospice.care.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/")
@Controller
public class HospiceController {

    @GetMapping(value = "/test")
    public String test() {
        return "test";
    }
}
