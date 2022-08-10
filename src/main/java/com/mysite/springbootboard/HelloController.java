package com.mysite.springbootboard;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// @Controller 어노테이션은 HelloController 클래스가 컨트롤러 기능을 수행한다는 의미다.
@Controller
public class HelloController {
    /*
    @RequestMapping("/hello") 어노테이션은 http://localhost:8080/hello URL 요청이 발생하면 hello 메서드가 실행된다는 의미다.
    /hello URL 과 hello 메서드를 매핑하는 역할을 한다.
    URL 명과 메서드명은 동일할 필요는 없다.
    */
    @RequestMapping("/hello")
    // @ResponseBody 어노테이션은 hello 메서드의 응답 결과가 문자열 그 자체라는 의미다.
    @ResponseBody
    public String hello() {
        return "Hello World";
    }
}
