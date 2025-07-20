package com.fdc.server.model;

import jakarta.persistence.*;

@Entity
public class Sponsor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String instagramHandle;
    private String instagramUrl;

    @ManyToOne
    @JoinColumn(name = "platform_info_id")
    private PlatformInfo platformInfo;

    public Sponsor() {
    }

    public Sponsor(Long id, String name, String instagramHandle, PlatformInfo platformInfo, String instagramUrl) {
        this.id = id;
        this.name = name;
        this.instagramHandle = instagramHandle;
        this.platformInfo = platformInfo;
        this.instagramUrl = instagramUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstagramHandle() {
        return instagramHandle;
    }

    public void setInstagramHandle(String instagramHandle) {
        this.instagramHandle = instagramHandle;
    }

    public String getInstagramUrl() {
        return instagramUrl;
    }

    public void setInstagramUrl(String instagramUrl) {
        this.instagramUrl = instagramUrl;
    }

    public PlatformInfo getPlatformInfo() {
        return platformInfo;
    }

    public void setPlatformInfo(PlatformInfo platformInfo) {
        this.platformInfo = platformInfo;
    }
}
