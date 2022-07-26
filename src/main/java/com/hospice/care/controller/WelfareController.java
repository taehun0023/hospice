package com.hospice.care.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/welfare")
@Controller
public class WelfareController {
    
    private String viewLocation = "welfare/";

    @GetMapping(value = "/facility")
    public String facility() {
        return viewLocation + "facility/facility";
    }

    @PostMapping(value = "/typeInview")
    public String AtypeInview(String typeCheck) {
        if (typeCheck.equals("Btype")) {
            return viewLocation + "facility/facilityBtype_inview";
        } else if (typeCheck.equals("Ctype")) {
            return viewLocation + "facility/facilityCtype_inview";
        }
        return viewLocation + "facility/facilityAtype_inview";
    }

    @GetMapping(value = "/equipment")
    public String equipment() {
        return viewLocation + "equipment/equipment";
    }

    @GetMapping(value = "/nurse")
    public String nurse() {
        return viewLocation + "nurse/nurse";
    }

    @PostMapping(value = "pdfInview")
    public String pdfInview() {
        return viewLocation + "nurse/pdf_inview";
    }

}
