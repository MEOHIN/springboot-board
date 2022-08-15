package com.mysite.springbootboard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringBootBoardApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;


	/**
	 * 데이터베이스에 저장된 데이터를 조회한다.
	 */
	@Test
	void testJpa() {
		/*
		 * findById 의 리턴 타입은 Optional 이다.
		 * Optional 은 null 처리를 유연하게 처리하기 위해 사용하는 클래스다.
		 * isPresent 로 null 이 아닌지를 확인한 후에 get 으로 실제 Question 객체 값을 얻어야 한다.
		 */
		Optional<Question> optionalQuestion = this.questionRepository.findById(1);
		if (optionalQuestion.isPresent()) {    // 엔티티 객체가 not null 인지 확인
			Question q = optionalQuestion.get();    // 실제 Question 엔티티 객체 값을 가져온다
			assertEquals("sbb 가 무엇인가요?", q.getSubject());    // 리스트의 첫번째 데이터의 제목을 비교
		}
	}

}
