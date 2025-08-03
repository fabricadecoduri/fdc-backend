package com.fdc.server.controller;

import com.fdc.server.model.News;
import com.fdc.server.repository.NewsRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/news")
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;

    @Operation(summary = "List all News")
    @GetMapping
    public List<News> getAllNewss() {
        return newsRepository.findAll();
    }

    @Operation(summary = "List News by id")
    @GetMapping("/{id}")
    public ResponseEntity<News> getNewsById(@PathVariable Long id) {
        Optional<News> news = newsRepository.findById(id);
        return news.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create new News")
    @PostMapping
    public News createNews(@RequestBody News news) {
        return newsRepository.save(news);
    }

    @Operation(summary = "Update News by id")
    @PutMapping("/{id}")
    public ResponseEntity<News> updateNews(@PathVariable Long id, @RequestBody News updatedNews) {
        return newsRepository.findById(id)
                .map(existingNews -> {
                    existingNews.setTitle(updatedNews.getTitle());
                    existingNews.setContent(updatedNews.getContent());
                    existingNews.setImageUrl(updatedNews.getImageUrl());
                    existingNews.setCreatedAt(LocalDateTime.now());
                    News savedNews = newsRepository.save(existingNews);
                    return ResponseEntity.ok(savedNews);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete News by id")
    @DeleteMapping("/{id}")
    public void deleteNews(@PathVariable Long id) {
        newsRepository.deleteById(id);
    }

}