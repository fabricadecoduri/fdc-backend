package com.fdc.server.controller;

import com.fdc.server.model.Topic;
import com.fdc.server.repository.TopicRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

    @Autowired
    private TopicRepository topicRepository;

    @Operation(summary = "List all Topics")
    @GetMapping
    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    @Operation(summary = "List Topic by id")
    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopicById(@PathVariable Long id) {
        Optional<Topic> topic = topicRepository.findById(id);
        return topic.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create new Topic")
    @PostMapping
    public Topic createTopic(@RequestBody Topic topic) {
        return topicRepository.save(topic);
    }

    @Operation(summary = "Update Topic by id")
    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(@PathVariable Long id, @RequestBody Topic updatedTopic) {
        return topicRepository.findById(id)
                .map(existingTopic -> {
                    existingTopic.setName(updatedTopic.getName());
                    existingTopic.setDescription(updatedTopic.getDescription());
                    existingTopic.setCodeSnippet(updatedTopic.getCodeSnippet());
                    Topic savedTopic = topicRepository.save(existingTopic);
                    return ResponseEntity.ok(savedTopic);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete Topic by id")
    @DeleteMapping("/{id}")
    public void deleteTopic(@PathVariable Long id) {
        topicRepository.deleteById(id);
    }

}