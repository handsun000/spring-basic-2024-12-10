package com.ll.basic.domain.home.home.controller;

import lombok.Builder;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class HomeController {
    private int age = 22;

    @GetMapping("/")
    @ResponseBody
    public String showMain() {
        return "안녕하세요.";
    }

    @GetMapping("/about")
    @ResponseBody
    public String showAbout() {
        return "저는 홍길동입니다.";
    }

    @GetMapping("/ageUp")
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
        return '꽑';
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
        String[] arr = {"a", "b", "c"};

        return arr;
    }

    @GetMapping("/list")
    @ResponseBody
    public List<String> getList() {
        return List.of("a", "b", "c");
    }

    @GetMapping("/map")
    @ResponseBody
    public Map<String, String> getMap() {
        return Map.of("name", "Paul", "hobby", "reading");
    }

    @GetMapping("/article")
    @ResponseBody
    public Article getArticle() {
        return Article
                .builder()
                .title("제목")
                .body("내용")
                .build();
    }

    @GetMapping("/articleList")
    @ResponseBody
    public List<Article> getArticles() {
        return List.of(
                Article.builder().id(1).title("제목1").body("내용1").build(),
                Article.builder().id(2).title("제목2").body("내용2").build()
        );
    }

    @GetMapping("/articleMap")
    @ResponseBody
    public Map<String, Article> articleMap() {
        return Map.of(
                "article1", Article.builder().id(1).title("제목1").body("내용1").build(),
                "article2", Article.builder().id(2).title("제목2").body("내용2").build()
        );
    }

    @GetMapping("/articleList.html")
    @ResponseBody
    public String getArticlesDotHtml() {
        Article article1 = new Article(1, "제목1","내용1",true);
        Article article2 = new Article(2, "제목2","내용2",true);
        Article article3 = new Article(3, "제목3","내용3",true);
        Article article4 = new Article(4, "제목4","내용4",true);

        List<Article> list = List.of(article1, article2, article3, article4);

        String str = list.stream()
                .map(article ->"<li>%d번 / %s</li>".formatted(article.getId(), article.getTitle()))
                .collect(Collectors.joining("\n"));

        return "<ul>\n" + str + "\n</ul>";
    }
}


@Builder
@Getter
class Article {
    @Builder.Default
    private long id = 1L;
    private String title;
    private String body;
    @Builder.Default
    private boolean published = true;
}