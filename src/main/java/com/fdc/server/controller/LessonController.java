package com.fdc.server.controller;

import com.fdc.server.model.Lesson;
import com.fdc.server.repository.LessonRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lessons")
public class LessonController {

    @Autowired
    private LessonRepository lessonRepository;

    @Operation(summary = "List all Lessons")
    @GetMapping
    public List<Lesson> getAllLessons() {
        return lessonRepository.findAll();
    }

    @Operation(summary = "List Chapter by id")
    @GetMapping("/{id}")
    public ResponseEntity<Lesson> getLessonById(@PathVariable Long id) {
        Optional<Lesson> lesson = lessonRepository.findById(id);
        return lesson.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @Operation(summary = "Create Lesson")
    @PostMapping
    public Lesson createLesson(@RequestBody Lesson lesson) {
        return lessonRepository.save(lesson);
    }

    @Operation(summary = "Update Lesson by id")
    @PutMapping("/{id}")
    public ResponseEntity<Lesson> updateLesson(@PathVariable Long id, @RequestBody Lesson updatedLesson) {
        return lessonRepository.findById(id)
                .map(existingLesson -> {
                    existingLesson.setTitle(updatedLesson.getTitle());
                    existingLesson.setOrderNumber(updatedLesson.getOrderNumber());
                    existingLesson.setHtmlPath(updatedLesson.getHtmlPath());
                    Lesson savedLesson = lessonRepository.save(existingLesson);
                    return ResponseEntity.ok(savedLesson);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete Lesson by id")
    @DeleteMapping("/{id}")
    public void deleteLesson(@PathVariable Long id) {
        lessonRepository.deleteById(id);
    }

}