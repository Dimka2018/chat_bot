package com.dimka.telegram.core;

import com.dimka.telegram.dto.Response;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(value = "core")
public interface CoreService {

    @PostMapping("/command")
    Response dispatchMessage(@RequestBody String message);
}
