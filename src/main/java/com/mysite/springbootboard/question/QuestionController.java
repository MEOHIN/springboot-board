package com.mysite.springbootboard.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    /**
     * 질문 상세 페이지에 대한 URL 을 매핑한다.
     *
     * http://localhost:8080/question/detail/2의 숫자 2처럼 변하는 id 값을 얻을 때에는 @PathVariable 어노테이션을 사용해야 한다.
     * RequestMapping(value="/question/detail/{매개변수}") 와 PathVariable("매개변수") 의 매개변수명이 동일해야 한다.
     *
     * @param model 모델 객체 생성
     * @param id 변하는 id 값
     * @return 질문 상세 페이지
     */
    @RequestMapping(value = "/question/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        return "question_detail";
    }
}
