package com.mysite.springbootboard;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * RuntimeException 을 상속한다.
 * DataNotFoundException 이 발생하면 @ResponseStatus 어노테이션에 의해 404오류(HttpStatus.NOT_FOUND)가 나타난다.
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found")
public class DataNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DataNotFoundException(String message) {
        super(message);
    }
}
