package com.fdc.server.controller;

import com.fdc.server.model.Chapter;
import com.fdc.server.repository.ChapterRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/chapters")
public class ChapterController {

    @Autowired
    private ChapterRepository chapterRepository;


    @Operation(summary = "List all Chapters")
    @GetMapping
    public List<Chapter> getAllChapters() {
        return chapterRepository.findAll();
    }

    @Operation(summary = "Get Chapter by id")
    @GetMapping("/{id}")
    public ResponseEntity<Chapter> getChapterById(@PathVariable Long id) {
        Optional<Chapter> chapter = chapterRepository.findById(id);
        return chapter.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create new Chapter")
    @PostMapping
    public Chapter createChapter(@RequestBody Chapter chapter) {
        return chapterRepository.save(chapter);
    }

    @Operation(summary = "Update Chapter by id")
    @PutMapping("/{id}")
    public ResponseEntity<Chapter> updateChapter(@PathVariable Long id, @RequestBody Chapter updatedChapter) {
        return chapterRepository.findById(id)
                .map(existingChapter -> {
                    existingChapter.setTitle(updatedChapter.getTitle());
                    existingChapter.setOrderNumber(updatedChapter.getOrderNumber());
                    Chapter savedChapter = chapterRepository.save(existingChapter);
                    return ResponseEntity.ok(savedChapter);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete Chapter by id")
    @DeleteMapping("/{id}")
    public void deleteChapter(@PathVariable Long id) {
        chapterRepository.deleteById(id);
    }

}