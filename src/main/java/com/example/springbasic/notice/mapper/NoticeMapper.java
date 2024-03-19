package com.example.springbasic.notice.mapper;

import com.example.springbasic.notice.dto.response.NoticeResponse;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface NoticeMapper {

    NoticeResponse selectNoticeList();

}
