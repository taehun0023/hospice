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
    private String name;
    private String phone;
    private String email;
    private String message;
    private String inqDate;
}
