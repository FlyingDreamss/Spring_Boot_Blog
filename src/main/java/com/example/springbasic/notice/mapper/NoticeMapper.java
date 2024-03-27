package com.example.springbasic.notice.mapper;

import com.example.springbasic.notice.dto.request.NoticeRequest;
import com.example.springbasic.notice.dto.response.NoticeResponse;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NoticeMapper {

    List<NoticeResponse> selectNoticeList();
    NoticeResponse selectOneNotice(int noticeId);

    int updateDetail(NoticeRequest request);
}
