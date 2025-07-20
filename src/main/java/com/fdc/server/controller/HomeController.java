package com.fdc.server.controller;

import com.fdc.server.model.PlatformInfo;
import com.fdc.server.repository.PlatformInfoRepository;
import com.fdc.server.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HomeController {
    @Autowired
    private TopicRepository topicRepo;

    @Autowired
    private PlatformInfoRepository platformInfoRepository;

    @GetMapping("/")
    public Map<String, Object> home() {
        Map<String, Object> response = new HashMap<>();
        response.put("topics", topicRepo.findAll());

        PlatformInfo platformInfo = platformInfoRepository.findById(1L).orElse(null);
        response.put("platformInfo", platformInfo);

        return response;
    }
}
