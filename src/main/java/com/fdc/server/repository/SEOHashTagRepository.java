package com.fdc.server.repository;

import com.fdc.server.model.SEOHashTag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SEOHashTagRepository extends JpaRepository<SEOHashTag,Long> {
    List<SEOHashTag> findByPlatformInfoId(Long platformInfoId);
}
