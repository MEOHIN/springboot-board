package com.mysite.springbootboard.question;

import com.mysite.springbootboard.DataNotFoundException;
import com.mysite.springbootboard.answer.Answer;
import com.mysite.springbootboard.user.SiteUser;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    /**
     * 검색어(keyword) 를 입력받아 쿼리의 조인문과 where 문을 생성해서 리턴하는 메서드다.
     * @param keyword 검색어
     * @return join 문, where 문
     */
    private Specification<Question> search(String keyword) {
        return new Specification<>() {
            private static final long serialVersionUID = 1L;
            @Override
            public Predicate toPredicate(Root<Question> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                query.distinct(true);   // 중복을 제거
                Join<Question, SiteUser> u1 = root.join("author", JoinType.LEFT);
                Join<Question, Answer> a = root.join("answerList", JoinType.LEFT);
                Join<Answer, SiteUser> u2 = a.join("author", JoinType.LEFT);
                return criteriaBuilder.or(criteriaBuilder.like(root.get("subject"), "%" + keyword + "%"), // 제목
                        criteriaBuilder.like(root.get("content"), "%" + keyword + "%"),      // 내용
                        criteriaBuilder.like(u1.get("username"), "%" + keyword + "%"),    // 질문 작성자
                        criteriaBuilder.like(a.get("content"), "%" + keyword + "%"),      // 답변 내용
                        criteriaBuilder.like(u2.get("username"), "%" + keyword + "%"));   // 답변 작성자
            }
        };
    }

    public Page<Question> getList(int page) {
        List<Sort.Order> sorts = new ArrayList<>();
        sorts.add(Sort.Order.desc("createDate"));
        Pageable pageable = PageRequest.of(page, 10, Sort.by(sorts));
        return this.questionRepository.findAll(pageable);
    }

    public Question getQuestion(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }

    public void create(String subject, String content, SiteUser siteUser) {
        Question q = new Question();
        q.setSubject(subject);
        q.setContent(content);
        q.setCreateDate(LocalDateTime.now());
        q.setAuthor(siteUser);
        this.questionRepository.save(q);
    }

    public void modify(Question question, String subject, String content) {
        question.setSubject(subject);
        question.setContent(content);
        question.setModifyDate(LocalDateTime.now());
        this.questionRepository.save(question);
    }

    public void delete(Question question) {
        this.questionRepository.delete(question);
    }

    public void vote(Question question, SiteUser siteUser) {
        question.getVoter().add(siteUser);
        this.questionRepository.save(question);
    }
}
