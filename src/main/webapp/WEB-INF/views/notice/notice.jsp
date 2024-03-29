<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>게시판 목록</title>

    <div>
        <button type="button" onclick="insertNoticeMove();">등록</button>
    </div>
</head>
<style>
    table { border: 1px solid black; }
    th { border: 1px solid black; width: 5%; }
    td { border: 1px solid black; width: 5%; }
</style>
<body>
<h1>게시판 목록</h1>

<table border="1">
    <tr>
        <th>순번</th>
        <th>제목</th>
        <th>작성자</th>
        <th>등록일</th>
    </tr>
    <c:forEach var = "list" items = "${notices}">
        <tr>
            <td>${list.rankNo}</td>
            <td onclick="detailMove('${list.noticeId}');">${list.title}</td>
            <td>${list.createId}</td>
            <td>${list.createAt}</td>
        </tr>
    </c:forEach>

</table>

</body>
</html>
<script>

    // 상세화면 이동
    function detailMove(noticeId) {
        location.href = "notice/notice-detail/" + noticeId;
    }

    // 등록화면 이동
    function insertNoticeMove() {
        location.href = "notice/insert-view";
    }

</script>