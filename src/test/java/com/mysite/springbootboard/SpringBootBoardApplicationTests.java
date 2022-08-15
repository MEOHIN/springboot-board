package com.mysite.springbootboard;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class SpringBootBoardApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;


	/**
	 * 데이터베이스에 저장된 데이터를 조회하는 테스트다.
	 */
	@Test
	void testJpa() {
		List<Question> all = this.questionRepository.findAll();    // question 테이블에 저장된 모드 데이터를 조회
		assertEquals(2, all.size());    // 저장된 데이터는 총 2건이므로 리스트의 사이즈도 2다.

		Question q = all.get(0);    // 리스트의 첫번째 데이터를 조회
		assertEquals("sbb 가 무엇인가요?", q.getSubject());    // 리스트의 첫번째 데이터의 제목을 비교
	}

}
