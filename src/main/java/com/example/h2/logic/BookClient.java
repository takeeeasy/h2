package com.example.h2.logic;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PutMapping;

@Component
@FeignClient(
    name = "book-service",        // feignClient service name.(not null)
    url = "http://localhost:8080",// 실제 호출할 서비스의 URL, eureka, ribbon 을 사용하지 않고서도 동작.
    decode404 = true,             // bean name.
    qualifiers = {},              // bean name.
    configuration = {},           // customizing configuration.
    fallback = void.class,        // hystrix(서버가 오류응답을 보내는경우, 해당 API 서버로 요청을 보내지않고, 잠시동안 대체(fallback) method 를 실행.) fallback class.
    fallbackFactory = BookClientFallbackFactory.class  // hystrix fallback factory class.
)
public interface BookClient {

  @PutMapping("/api/book")
  List<String> registerBooks();
}
