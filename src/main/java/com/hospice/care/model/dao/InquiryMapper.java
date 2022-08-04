package com.hospice.care.model.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.hospice.care.model.dto.InquiryDto;

@Repository
@Mapper
public interface InquiryMapper {
    void insertInquiryDto(InquiryDto inquiryDto);
}
