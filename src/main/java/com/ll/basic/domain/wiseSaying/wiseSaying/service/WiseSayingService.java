package com.ll.basic.domain.wiseSaying.wiseSaying.service;

import com.ll.basic.domain.wiseSaying.wiseSaying.entity.WiseSaying;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
public class WiseSayingService {
    private final List<WiseSaying> wiseSayings;
    private long lastId;

    public WiseSayingService() {
        this.wiseSayings = new ArrayList<>() {{
            add(WiseSaying.builder().id(++lastId).content("삶이 있는 한").author("작가1").build());
            add(WiseSaying.builder().id(++lastId).content("니가 있는 한").author("작가2").build());
        }};
    }

    public List<WiseSaying> findAll() {
        return wiseSayings.stream()
                .sorted(Comparator.comparing(WiseSaying::getId).reversed())
                .toList();
    }

    public WiseSaying write(String content, String author) {
        WiseSaying wiseSaying = WiseSaying.builder().id(++lastId).content(content).author(author).build();
        wiseSayings.add(wiseSaying);
        return wiseSaying;
    }

    public Optional<WiseSaying> findById(long id) {
        return wiseSayings
                .stream()
                .filter(wiseSaying -> wiseSaying.getId() == id)
                .findFirst();
    }

    public boolean deleteById(long id) {
        return wiseSayings.removeIf(wiseSaying -> wiseSaying.getId() == id);
    }
}
