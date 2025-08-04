package com.fdc.server.controller;

import com.fdc.server.model.PlatformInfo;
import com.fdc.server.model.dto.WhyChooseCard;
import com.fdc.server.repository.PlatformInfoRepository;
import com.fdc.server.repository.TopicRepository;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HomeController {
    @Autowired
    private TopicRepository topicRepo;

    @Autowired
    private PlatformInfoRepository platformInfoRepository;

    @Operation(summary = "Get homepage content")
    @GetMapping("/")
    public ResponseEntity<Map<String, Object>> home() {
        Map<String, Object> response = new HashMap<>();

        response.put("topics", topicRepo.findAll());

        PlatformInfo platformInfo = platformInfoRepository.findById(1L).orElse(null);
        response.put("platformInfo", platformInfo);

        response.put("whyChooseFdc", getWhyChooseCards());

        return ResponseEntity.ok(response);
    }

    private List<WhyChooseCard> getWhyChooseCards() {
        return List.of(
                new WhyChooseCard("FaBookOpen", "De la zero la expert", "Acoperim totul de la bazele programării până la concepte avansate, pentru o educație completă."),
                new WhyChooseCard("FaUserTie", "Instructori experți", "Înveți de la profesioniști cu experiență în companii tech de top din România și internațional."),
                new WhyChooseCard("FaAward", "Recunoaștere în industrie", "Certificatele noastre sunt recunoscute de companii IT importante din România și Europa."),
                new WhyChooseCard("FaBriefcase", "Sprijin pentru angajare", "95% dintre absolvenți se angajează în primele 6 luni. Oferim consiliere și pregătire pentru interviuri."),
                new WhyChooseCard("FaClock", "Flexibilitate în învățare", "Înveți în ritmul tău, cu opțiuni de seară și weekend pentru profesioniști."),
                new WhyChooseCard("FaGlobe", "Standard internațional", "Urmăm cele mai bune practici globale, adaptate pieței IT din România.")
        );
    }
}