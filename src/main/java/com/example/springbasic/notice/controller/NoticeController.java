package com.example.springbasic.notice.controller;

import com.example.springbasic.notice.dto.response.NoticeResponse;
import com.example.springbasic.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @RequestMapping(value = "/notice", method = RequestMethod.GET)
    public void selectNoticeList() {
        NoticeResponse noticeResponse = noticeService.selectNoticeList();
        System.out.println("noticeResponse ==> " + noticeResponse);
    }

}
