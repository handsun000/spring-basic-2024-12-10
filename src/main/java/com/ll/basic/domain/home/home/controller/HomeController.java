package com.ll.basic.domain.home.home.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    private int age = 22;
    StringBuilder s = new StringBuilder("asdf");
    @GetMapping("/")
    @ResponseBody
    public String showMain() {

        return "안녕하세요";
    }
    @GetMapping("/about")
    @ResponseBody
    public String showAbout() {
        return "저는 홍길동입니다.";
    }
    @GetMapping("/int")
    @ResponseBody
    public int getAgeAndUp() {
        return age++;
    }
    @GetMapping("/boolean")
    @ResponseBody
    public boolean getBoolean() {
        return true;
    }
    @GetMapping("/byte")
    @ResponseBody
    public byte getByte() {
        return 127;
    }
    @GetMapping("/short")
    @ResponseBody
    public short getShort() {
        return 32000;
    }
    @GetMapping("/long")
    @ResponseBody
    public long getLong() {
        return 100_000_000_000_000L;
    }
    @GetMapping("/char")
    @ResponseBody
    public char getChar() {
        return '꽉';
    }
    @GetMapping("/float")
    @ResponseBody
    public float getFloat() {
        return 3.14f;
    }
    @GetMapping("/double")
    @ResponseBody
    public double getDouble() {
        return 3.141592;
    }
    @GetMapping("/array")
    @ResponseBody
    public String[] getArray() {
        String[] arr = {"a","b","c"};

        return arr;
    }
    @GetMapping("/list")
    @ResponseBody
    public List<String> getList() {
        return List.of("a","b","c");
    }
    @GetMapping("/map")
    @ResponseBody
    public Map<String,String> getMap() {
        return Map.of("name","paul","hobby","reading");
    }
    @GetMapping("/article")
    @ResponseBody
    public Article getArticle() {
        return new Article(1, "제목", "내용", true);
    }
}

@AllArgsConstructor
@Getter
class Article {
    private long id;
    private String title;
    private String body;
    private boolean published;
}
