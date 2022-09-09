package com.hospice.care.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/place")
@Controller
public class PlaceController {

    @GetMapping(value = "/placeHome")
    public String placeHome(){
        System.out.println("/place/placeHome");
        return "place/placeHome";
    }

    @GetMapping(value = "/placeSaitama")
    public String placeSaitama(){
        System.out.println("/place/placeSaitama");
        return "place/placeSaitama";
    }

    @GetMapping(value = "/placeTest")
    public String placeTest(){
        System.out.println("/place/placeTest");
        return "place/placeTest";
    }

}
