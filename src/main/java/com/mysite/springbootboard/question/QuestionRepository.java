package com.mysite.springbootboard.question;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
    /**
     * subject 값으로 데이터를 조회한다.
     * @param subject Question 엔티티의 속성
     * @return 입력받은 값으로 식별되는 엔티티를 반환한다.
     */
    Question findBySubject(String subject);

    /**
     * subject 값과 content 값으로 데이터를 조회한다.
     * @param subject Question 엔티티의 속성 중 제목
     * @param content Question 엔티티의 속성 중 내용
     * @return 입력받은 값으로 식별되는 엔티티를 반환한다.
     */
    Question findBySubjectAndContent(String subject, String content);

    /**
     * subject 에 특정 문자열이 포함된 데이터를 조회한다.
     * @param subject Question 엔티티의 속성 중 제목
     * @return 입력받은 값으로 식별되는 엔티티 List 를 반환한다.
     */
    List<Question> findBySubjectLike(String subject);
    Page<Question> findAll(Pageable pageable);
    Page<Question> findAll(Specification<Question> spec, Pageable pageable);
}
