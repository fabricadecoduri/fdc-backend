package com.fdc.server.controller;

import com.fdc.server.model.Sponsor;
import com.fdc.server.repository.SponsorRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/sponsors")
public class SponsorController {

    @Autowired
    private SponsorRepository sponsorRepository;

    @Operation(summary = "List all Sponsor")
    @GetMapping
    public List<Sponsor> getAllSponsors() {
        return sponsorRepository.findAll();
    }

    @Operation(summary = "List Sponsor by id")
    @GetMapping("/{id}")
    public ResponseEntity<Sponsor> getSponsorById(@PathVariable Long id) {
        Optional<Sponsor> Sponsor = sponsorRepository.findById(id);
        return Sponsor.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Create new Sponsor")
    @PostMapping
    public Sponsor createSponsor(@RequestBody Sponsor sponsor) {
        return sponsorRepository.save(sponsor);
    }

    @Operation(summary = "Update Sponsor by id")
    @PutMapping("/{id}")
    public ResponseEntity<Sponsor> updateSponsor(@PathVariable Long id, @RequestBody Sponsor updatedSponsor) {
        return sponsorRepository.findById(id)
                .map(existingSponsor -> {
                    existingSponsor.setName(updatedSponsor.getName());
                    existingSponsor.setInstagramHandle(updatedSponsor.getInstagramHandle());
                    existingSponsor.setInstagramUrl(updatedSponsor.getInstagramUrl());
                    Sponsor savedSponsor = sponsorRepository.save(existingSponsor);
                    return ResponseEntity.ok(savedSponsor);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Delete Sponsor by id")
    @DeleteMapping("/{id}")
    public void deleteSponsor(@PathVariable Long id) {
        sponsorRepository.deleteById(id);
    }

}