package com.example.springbasic.notice.mapper;

import com.example.springbasic.notice.dto.response.NoticeResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    List<NoticeResponse> selectNoticeList();

}
