package com.ll.basic.domain.wiseSaying.wiseSaying.Controller;

import com.ll.basic.domain.wiseSaying.wiseSaying.entity.WiseSaying;
import com.ll.basic.domain.wiseSaying.wiseSaying.service.WiseSayingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/wiseSayings/{id}")
    public WiseSaying getItem(@PathVariable long id) {
        Optional<WiseSaying> opWiseSaying = wiseSayingService.findById(id);

        return opWiseSaying.get();
    }

    @GetMapping("/wiseSayings/{id}/delete")
    public boolean deleteItem(@PathVariable long id) {
        return wiseSayingService.deleteById(id);
    }

    @GetMapping("/wiseSayings/{id}/modify")
    public WiseSaying modifyItem(@PathVariable long id, String content, @RequestParam(defaultValue = "무명") String author) {
        WiseSaying wiseSaying = wiseSayingService.findById(id).get();
        wiseSayingService.modify(wiseSaying, content, author);
        return wiseSaying;
    }
}
