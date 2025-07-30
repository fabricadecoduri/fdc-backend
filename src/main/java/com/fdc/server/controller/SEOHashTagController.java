package com.fdc.server.controller;

import com.fdc.server.model.SEOHashTag;
import com.fdc.server.repository.SEOHashTagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/SEOHashTags")
public class SEOHashTagController {

    @Autowired
    private SEOHashTagRepository SEOHashTagRepository;

    @GetMapping
    public List<SEOHashTag> getAllSEOHashTags() {
        return SEOHashTagRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SEOHashTag> getSEOHashTagById(@PathVariable Long id) {
        Optional<SEOHashTag> SEOHashTag = SEOHashTagRepository.findById(id);
        return SEOHashTag.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public SEOHashTag createSEOHashTag(@RequestBody SEOHashTag SEOHashTag) {
        return SEOHashTagRepository.save(SEOHashTag);
    }

    @PutMapping("/{id}")
    public ResponseEntity<SEOHashTag> updateSEOHashTag(@PathVariable Long id, @RequestBody SEOHashTag updatedSEOHashTag) {
        return SEOHashTagRepository.findById(id)
                .map(existingSEOHashTag -> {
                    existingSEOHashTag.setText(updatedSEOHashTag.getText());
                    existingSEOHashTag.setRedirectLink(updatedSEOHashTag.getRedirectLink());
                    SEOHashTag savedSEOHashTag = SEOHashTagRepository.save(existingSEOHashTag);
                    return ResponseEntity.ok(savedSEOHashTag);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public void deleteSEOHashTag(@PathVariable Long id) {
        SEOHashTagRepository.deleteById(id);
    }

}