package com.mysite.springbootboard.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionRepository questionRepository;

    private final QuestionService questionService;

    @RequestMapping("/question/list")
    public String list(Model model) {
        List<Question> questionList = this.questionService.getList();    // 리파지토리대신 서비스를 사용
        model.addAttribute("questionList", questionList);    // Model 객체에 값을 저장
       return "question_list";    // 템플릿 파일명을 반환
    }
}
