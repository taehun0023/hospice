package com.hospice.care.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@RequestMapping(value = "/")
@Controller
public class PlaceController {

    @RequestMapping(value = "/placeHome", method = RequestMethod.GET)
    public String placeHome(){
        return "place/placeHome";
    }

    @RequestMapping(value = "/placeSaitama", method = RequestMethod.GET)
    public String placeSaitama(){
        return "/place/placeSaitama";
    }

}
