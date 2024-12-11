package com.ll.basic.domain.wiseSaying.wiseSaying.Controller;

import com.ll.basic.domain.wiseSaying.wiseSaying.entity.WiseSaying;
import com.ll.basic.domain.wiseSaying.wiseSaying.service.WiseSayingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class WiseSayingController {

    private final WiseSayingService wiseSayingService;

    @GetMapping("/wiseSayings")
    public List<WiseSaying> findAll() {
        return wiseSayingService.findAll();
    }

    @GetMapping("/wiseSayings/write")
    public WiseSaying write(String content, @RequestParam(name = "author") String author) {
        return wiseSayingService.write(content, author);
    }

    @GetMapping("/wiseSayings/1")
    public WiseSaying getItem1() {
        Optional<WiseSaying> opWiseSaing = wiseSayingService.findById(1L);

        return opWiseSaing.get();
    }
    @GetMapping("/wiseSayings/2")
    public WiseSaying getItem2() {
        Optional<WiseSaying> opWiseSaing = wiseSayingService.findById(2L);

        return opWiseSaing.get();
    }
}
