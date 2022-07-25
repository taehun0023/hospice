package com.hospice.care.controller;

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

    @GetMapping(value = "/contact")
    public String contact() {
        return "contact/contact";
    }

    @GetMapping(value = "contact/contact")
    public String contact2() {
        return "contact/contact";
    }

    @GetMapping(value = "/information")
    public String information() {
        return "information/information";
    }

    @GetMapping(value = "information/information")
    public String information2() {
        return "information/information";
    }

    @GetMapping(value = "/aisatsu")
    public String aisatsu() {
        return "information/aisatsu";
    }

    @GetMapping(value = "aisatsu/aisatsu")
    public String aisatsu2() {
        return "information/aisatsu";
    }

}
