package com.mysite.springbootboard.question;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    /**
     * 질문목록을 조회하고 반환한다.
     * @return 조회한 질문 목록
     */
    public List<Question> getList() {
        return this.questionRepository.findAll();
    }
}
