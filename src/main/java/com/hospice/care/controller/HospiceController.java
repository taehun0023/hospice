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

    @GetMapping(value = "/recruit")
    public String contact() {
        return "recruit/recruit";
    }

    @GetMapping(value = "recruit/recruit")
    public String contact2() {
        return "recruit/recruit";
    }

    @GetMapping(value = "/information")
    public String information() {
        return "information/information";
    }

    @GetMapping(value = "information/information")
    public String information2() {
        return "information/information";
    }

    @GetMapping(value = "/greetings")
    public String greetings() {
        return "information/greetings";
    }

    @GetMapping(value = "greetings/greetings")
    public String greetings2() {
        return "information/greetings";
    }

    @GetMapping(value = "/team")
    public String team() {
        return "information/team";
    }

    @GetMapping(value = "team/team")
    public String team2() {
        return "information/team";
    }



}
