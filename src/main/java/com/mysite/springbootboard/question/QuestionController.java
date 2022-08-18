package com.mysite.springbootboard.question;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuestionController {

    @RequestMapping("/question/list")
    /* @ResponseBody 어노테이션
     * URL 요청에 대한 응답으로 문자열을 리턴하라는 의미이다.
     * @ResponseBody 어노테이션을 생략하면 스프링부트는 "index"라는 이름의 템플릿 파일을 찾는다.*/
    @ResponseBody
    public String list() {
        return "question list";
    }
}
