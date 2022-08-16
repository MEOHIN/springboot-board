package com.mysite.springbootboard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
		Question q = this.questionRepository
				.findBySubjectAndContent("sbb 가 무엇인가요?", "sbb 에 대해서 알고 싶습니다.");
		assertEquals(1, q.getId());
	}
}
