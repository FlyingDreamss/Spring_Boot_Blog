package com.example.springbasic.notice.service;

import com.example.springbasic.notice.dto.response.NoticeResponse;
import com.example.springbasic.notice.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NoticeService {

    private final NoticeMapper noticeMapper;


    public List<NoticeResponse> selectNoticeList() {
        return noticeMapper.selectNoticeList();
    }

}
