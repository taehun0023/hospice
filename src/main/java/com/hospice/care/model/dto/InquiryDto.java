package com.hospice.care.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class InquiryDto {
    private int inqUID;
    private String place;
    private String userName;
    private String userEmail;
    private String phone;
    private String inqContent;
    private String inqMessage;
    private String inqDate;
}
