package com.hospice.care.web;

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

    @GetMapping(value = "/placeTokyo")
    public String placeTokyo(){
        System.out.println("/place/placeTokyo");
        return "place/placeTokyo";
    }

    @GetMapping(value = "/placeNishiba")
    public String placeNishiba(){
        System.out.println("/place/placeNishiba");
        return "place/placeNishiba";
    }

}
