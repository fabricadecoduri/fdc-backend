package com.fdc.server.repository;

import com.fdc.server.model.News;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {
    List<News> findTop3ByPlatformInfoIdOrderByCreatedAtDesc(Long platformInfoId);
    News findFirstByPlatformInfoIdOrderByCreatedAtAsc(Long platformInfoId);
}
