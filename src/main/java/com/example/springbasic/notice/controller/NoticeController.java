package com.example.springbasic.notice.controller;

import com.example.springbasic.notice.dto.response.NoticeResponse;
import com.example.springbasic.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class NoticeController {

    private final NoticeService noticeService;

    @RequestMapping(value = "/notice", method = RequestMethod.GET)
    public String selectNoticeList(Model model) {

        List<NoticeResponse> noticeResponse = noticeService.selectNoticeList();
        System.out.println("noticeResponse ==> " + noticeResponse);
        model.addAttribute("notices", noticeResponse);

        return "notice/notice";
    }

}
