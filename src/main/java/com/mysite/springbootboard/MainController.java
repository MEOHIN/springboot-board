package com.mysite.springbootboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// @Controller 어노테이션을 적용한 클래스는 스프링부트의 컨트롤러가 된다.
@Controller
public class MainController {

    /* 메서드의 @RequestMapping 어노테이션은 요청된 URL 과 매핑한다.
    * @RequestMapping 에 http://localhost:8080 과 같은 도메인명과 포트는 적지 않는다.
    * 도메인명과 포트는 서버 설정에 따라 변하기 때문이다.*/
    @RequestMapping("/sbb")
    /* @ResponseBody 어노테이션은 URL 요청에 대한 응답으로 문자열을 리턴하라는 의미이다.
    * @ResponseBody 어노테이션을 생략하면 스프링부트는 "index"라는 이름의 템플릿 파일을 찾는다. */
    @ResponseBody
    public String index() {
        return "안녕하세요 SBB 에 오신것을 환영합니다.";
    }

    /**
     * ROOT URL 인 "/" URL 을 매핑한다.
     * @return question/list URL 페이지를 리다이렉트한다.
     */
    @RequestMapping("/")
    public String root() {
        // redirect:/question/list 는 /question/list URL 로 페이지를 리다이렉트 하라는 명령어
        return "redirect:/question/list";
    }
}
