package com.mysite.springbootboard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class SpringBootBoardApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;


	/**
	 * Question 엔티티 객체를 생성하고 QuestionRepository 를 이용하여 그 값을 데이터베이스에 저장하는 테스트다.
	 */
	@Test
	void testJpa() {
		Question q1 = new Question();    // Question 엔티티 객세 생성
		q1.setSubject("sbb 가 무엇인가요?");
		q1.setContent("sbb 에 대해서 알고 싶습니다.");
		q1.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q1);    // 첫 번째 질문 저장
		
		Question q2 = new Question();
		q2.setSubject("스프링부트 모델 질문입니다.");
		q2.setContent("id 는 자동으로 생성되나요?");
		q2.setCreateDate(LocalDateTime.now());
		this.questionRepository.save(q2);    // 두 번째 질문 저장
	}

}
