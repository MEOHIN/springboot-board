package com.mysite.springbootboard.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @RequiredArgsConstructor
 * 롬복이 제공하는 어노테이션
 * final 이 붙은 속성을 포함하는 생성자를 자동으로 생성
 *
 * 스프링 의존성 주입 규칙에 의해 questionRepository 객체가 자동으로 주입된다.
 * questionRepository 속성을 포함하는 생성자 생성한다.
 */
@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionRepository questionRepository;

    @RequestMapping("/question/list")
    public String list(Model model) {
        List<Question> questionList = this.questionRepository.findAll();    // 질문 목록 데이터 list 생성
        model.addAttribute("questionList", questionList);    // Model 객체에 값을 저장
       return "question_list";    // 템플릿 파일명을 반환
    }
}
