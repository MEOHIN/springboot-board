package com.mysite.springbootboard;

import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    /**
     * subject 값으로 데이터를 조회한다.
     * @param subject Question 엔티티의 속성
     * @return 입력받은 값으로 식별디는 엔티티를 반환한다.
     */
    Question findBySubject(String subject);
}
