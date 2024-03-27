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

    /** 게시판 상세 화면*/
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

    /** 게시판 삭제 */
    @DeleteMapping("/delete/{noticeId}")
    @ResponseBody
    public int deleteNotice(@PathVariable("noticeId") int noticeId) {
        System.out.println("deleteNotice noticeId ==> " + noticeId);
        return noticeService.deleteNotice(noticeId);
    }

    /** 게시판 등록 화면 */
    @RequestMapping(value = "/insert-view", method = RequestMethod.GET)
    public String noticeInsertView() {
        return "notice/noticeInsert";
    }

    /** 게시판 등록 */
    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    @ResponseBody
    public int insertNotice(@RequestBody NoticeRequest noticeRequest) {
        System.out.println("insertNotice noticeRequest ==> " + noticeRequest);
        return noticeService.insertNotice(noticeRequest);
    }
}
