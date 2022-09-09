package com.hospice.care.service;

import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;
import com.hospice.care.model.dao.InquiryMapper;
import com.hospice.care.model.dto.InquiryDto;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmailService {

    @Autowired
    InquiryMapper mapper;

    private final JavaMailSender emailSender;
    private final SpringTemplateEngine templateEngine;

    public void sendEmailMessage(InquiryDto inquiryDto) throws Exception {
        MimeMessage message = emailSender.createMimeMessage();

        message.setFrom(inquiryDto.getUserEmail());
        // 보낼 이메일 설정
        message.addRecipients(MimeMessage.RecipientType.TO, "imfo@i-syukan.com");
        message.setSubject("[" + inquiryDto.getInqContent() + "]["+ inquiryDto.getUserName() +"]", "utf-8" ); // 이메일 제목
        message.setText(setContext(inquiryDto), "utf-8", "html"); // 내용 설정(Template Process)
        
        // 보낼 때 이름 설정하고 싶은 경우
        // message.setFrom(new InternetAddress([이메일 계정], [설정할 이름]));
        
        emailSender.send(message); // 이메일 전송
        mapper.insertInquiryDto(inquiryDto);
    }

    private String setContext(InquiryDto inquiryDto) { // 타임리프 설정하는 코드
        Context context = new Context();

        context.setVariable("userName", inquiryDto.getUserName()); // Template에 전달할 데이터 
        context.setVariable("userEmail", inquiryDto.getUserEmail());
        context.setVariable("phone", inquiryDto.getPhone());
        context.setVariable("inqContent", inquiryDto.getInqContent());
        context.setVariable("inqMessage", inquiryDto.getInqMessage());

        return templateEngine.process("sendEmail/mail", context); // mail.html 
    }

    // private String createCode() {
    //     StringBuilder code = new StringBuilder();
    //     Random rnd = new Random();
    //     for (int i = 0; i < 7; i++) {
    //         int rIndex = rnd.nextInt(3);
    //         switch (rIndex) {
    //             case 0:
    //                 code.append((char) (rnd.nextInt(26) + 97));
    //                 break;
    //             case 1:
    //                 code.append((char) (rnd.nextInt(26) + 65));
    //                 break;
    //             case 2:
    //                 code.append((rnd.nextInt(10)));
    //                 break;
    //         }
    //     }
    //     return code.toString();
    // }
}
    