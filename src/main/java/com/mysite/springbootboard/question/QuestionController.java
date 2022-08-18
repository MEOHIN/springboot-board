package com.mysite.springbootboard.question;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class QuestionController {

    @RequestMapping("/question/list")
    public String list() {
        return "question_list";    // 템플릿 파일명을 반환
    }
}
