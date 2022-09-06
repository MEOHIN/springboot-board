package com.mysite.springbootboard.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionRepository questionRepository;

    private final QuestionService questionService;

    @RequestMapping("/list")
    public String list(Model model) {
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
       return "question_list";
    }

    @RequestMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    /**
     * question_form 템플릿을 렌더링하여 출력한다.
     */
    @GetMapping("/create")
    public String questionCreate() {
        return "question_form";
    }

    /**
     * POST 방식으로 요청한 /question/create URL을 처리하기 위해 메서드 오버로딩
     *
     * @param subject 화면에서 입력한 제목
     * @param content 화면에서 입력한 내용
     * 질문 등록 템플릿에서 필드 항목으로 사용했던 subject,content 이름과 동일하게 해야한다.
     *
     * @return 질문이 저장되면 질문 목록 페이지로 이동
     */
    @PostMapping("/create")
    public String questionCreate(@Valid QuestionForm questionForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "question_form";
        }
        this.questionService.create(questionForm.getSubject(), questionForm.getContent());
        return "redirect:/question/list";
    }
}
