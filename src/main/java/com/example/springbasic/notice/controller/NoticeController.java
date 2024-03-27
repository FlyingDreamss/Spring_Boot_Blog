package com.example.springbasic.notice.controller;

import com.example.springbasic.notice.dto.request.NoticeRequest;
import com.example.springbasic.notice.dto.response.NoticeResponse;
import com.example.springbasic.notice.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/notice")
public class NoticeController {

    private final NoticeService noticeService;

//    @RequestMapping(value = "/notice", method = RequestMethod.GET)
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String notice(Model model) {

        List<NoticeResponse> noticeResponse = noticeService.selectNoticeList();
//        System.out.println("noticeResponse ==> " + noticeResponse);
        System.out.println("notice noticeResponse ==> " + noticeResponse);
        model.addAttribute("notices", noticeResponse);

        return "notice/notice";
    }

    /** 게시판 상세 */
    @RequestMapping(value = "/notice-detail/{noticeId}", method = RequestMethod.GET)
    public String noticeDetail(@PathVariable("noticeId") int noticeId, Model model) {

        NoticeResponse noticeResponse = noticeService.selectOneNotice(noticeId);
        System.out.println("notice noticeResponse ==> " + noticeResponse);
        model.addAttribute("notice", noticeResponse);

        return "notice/noticeDetail";
    }

    /** 게시판 수정 */
    @RequestMapping(value = "/detail", method = RequestMethod.POST)
    @ResponseBody
    public int updateDetail(@RequestBody NoticeRequest noticeRequest) {
        System.out.println("updateDetail noticeRequest ==> " + noticeRequest);
        return noticeService.updateDetail(noticeRequest);
    }
}
