package com.fdc.server.service;

import com.fdc.server.model.Sponsor;
import com.fdc.server.repository.SponsorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SponsorService {
    @Autowired
    private SponsorRepository sponsorRepository;

    public List<Sponsor> getAllSponsors() {
        return sponsorRepository.findAll();
    }

    public Sponsor saveSponsor(Sponsor sponsor) {
        return sponsorRepository.save(sponsor);
    }

    public void deleteSponsor(Long id) {
        sponsorRepository.deleteById(id);
    }
}
