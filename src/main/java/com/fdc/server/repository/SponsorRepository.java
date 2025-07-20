package com.fdc.server.repository;

import com.fdc.server.model.Sponsor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SponsorRepository extends JpaRepository<Sponsor,Long> {
}
