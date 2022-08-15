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
		Question q = this.questionRepository.findBySubject("sbb 가 무엇인가요?");    // 제목으로 테이블 데이터 조회
		assertEquals("sbb 가 무엇인가요?", q.getSubject());
	}

}
