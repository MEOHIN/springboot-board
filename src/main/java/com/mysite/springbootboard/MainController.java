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
    @ResponseBody
    public String index() {
        return "index";
    }
}
