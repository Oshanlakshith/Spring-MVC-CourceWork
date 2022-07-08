package lk.ijse.spring.advisor;

import lk.ijse.spring.util.ResponceUtil;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

public class appwideWxceptionHandler {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({Exception.class})
    public ResponceUtil exceptionHandler(Exception e) {
        return new ResponceUtil(500, e.getMessage(), null);
    }
}
