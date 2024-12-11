package com.ll.basic.domain.wiseSaying.wiseSaying.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

@Builder
@Getter
@Setter
public class WiseSaying {
    private long id;
    private String content;
    private String author;

    public boolean isNew() {
        return id == 0;
    }
}
