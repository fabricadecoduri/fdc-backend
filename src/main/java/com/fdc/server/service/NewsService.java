package com.fdc.server.service;

import com.fdc.server.model.News;
import com.fdc.server.model.PlatformInfo;
import com.fdc.server.repository.NewsRepository;
import com.fdc.server.repository.PlatformInfoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {
    private final NewsRepository newsRepository;
    private final PlatformInfoRepository platformInfoRepository;

    public NewsService(NewsRepository newsRepository, PlatformInfoRepository platformInfoRepository) {
        this.newsRepository = newsRepository;
        this.platformInfoRepository = platformInfoRepository;
    }

    public List<News> getLatestNews(Long platformInfoId) {
        return newsRepository.findTop3ByPlatformInfoIdOrderByCreatedAtDesc(platformInfoId);
    }

    public News addNews(News news) {
        PlatformInfo platformInfo = platformInfoRepository.findTopByOrderByIdAsc();
        if (platformInfo == null) {
            throw new IllegalStateException("No PlatformInfo found.");
        }

        news.setPlatformInfo(platformInfo);

        if (newsRepository.count() >= 3) {
            News oldestNews = newsRepository.findFirstByPlatformInfoIdOrderByCreatedAtAsc(platformInfo.getId());
            if (oldestNews != null) {
                newsRepository.delete(oldestNews);
            }
        }

        return newsRepository.save(news);
    }
}
