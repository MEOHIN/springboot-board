package com.mysite.springbootboard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class SpringBootBoardApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Autowired
	private AnswerRepository answerRepository;

	/**
	 * Answer 엔티티 객체를 생성하고 AnswerRepository 를 이용하여 그 값을 데이터베이스에 저장한다.
	 */
	@Test
	void testJpa() {
		Optional<Question> oq = this.questionRepository.findById(2);    // id 가 2인 질문 데이터
		assertTrue(oq.isPresent());
		Question q = oq.get();

		Answer a = new Answer();
		a.setContent("네 자동으로 생성됩니다.");
		a.setQuestion(q);    // 답변을 하려는 질문과 연결
		a.setCreateDate(LocalDateTime.now());
		this.answerRepository.save(a);
	}
}
