package com.mysite.springbootboard.question;

import com.mysite.springbootboard.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    /**
     * id 값으로 Question 데이터를 조회한다.
     * @param id Question PK
     * @return 조회한 Question 데이터
     */
    public Question getQuestion(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }
}
