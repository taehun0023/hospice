package com.hospice.care.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

import com.hospice.care.model.dto.InquiryDto;
import com.hospice.care.service.EmailService;

@RequestMapping("/welfare")
@Controller
public class WelfareController {
    
    private String viewLocation = "welfare/";

    @Autowired
    private EmailService emailService;

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

    @PostMapping(value = "/pdfInview")
    public String pdfInview() {
        return viewLocation + "nurse/pdf_inview";
    }

    @PostMapping(value ="/inquiry")
    public String inquiry(Model model, @RequestBody InquiryDto inquiryDto) throws Exception {
        
        
        SimpleDateFormat tFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date now = new Date();
        String nowTime = tFormat.format(now);
        inquiryDto.setInqDate(nowTime);
        

        try {
            emailService.sendEmailMessage(inquiryDto);
            model.addAttribute("msg", "完了");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "index :: #resultDiv";
    }

    @PostMapping(value = "/inquriyCheck")
    public String inquriyCheck(Model model, InquiryDto inquiryDto) {
        model.addAttribute("inquriyDto", inquiryDto);
        return "/inquriyCheck_inview";
    }
}
