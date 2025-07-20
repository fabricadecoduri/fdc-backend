package com.fdc.server.repository;

import com.fdc.server.model.PlatformInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatformInfoRepository extends JpaRepository<PlatformInfo,Long> {
    PlatformInfo findTopByOrderByIdAsc();
}
