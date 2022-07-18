package com.hospice.care.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/place")
@Controller
public class PlaceController {

    @GetMapping(value = "/placeHome")
    public String placeHome(){
        System.out.println("/placeHome");
        return "place/placeHome";
    }

    @GetMapping(value = "/placeSaitama")
    public String placeSaitama(){
        System.out.println("/placeSaitama");
        return "place/placeSaitama";
    }

    @GetMapping(value = "/placeTokyo")
    public String placeTokyo(){
        System.out.println("/placeTokyo");
        return "place/placeTokyo";
    }
    

}
