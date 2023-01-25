package com.S2t.ConsommiTounsi.exception;

  import lombok.Data;
  import org.springframework.http.HttpStatus;

import java.util.Date;
@Data
public class Response {
    private Date date;
    private HttpStatus status;
    private String message;
}
