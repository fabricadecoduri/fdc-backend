package com.fdc.server.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class News {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @Lob
    private String content;
    private String imageUrl;
    private LocalDateTime createdAt;
    @ManyToOne
    @JoinColumn(name = "platform_info_id")
    @JsonBackReference
    private PlatformInfo platformInfo;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
    }

    public News() {
    }

    public News(long id, String title, String content, String imageUrl, LocalDateTime createdAt, PlatformInfo platformInfo) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imageUrl = imageUrl;
        this.createdAt = createdAt;
        this.platformInfo = platformInfo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public PlatformInfo getPlatformInfo() {
        return platformInfo;
    }

    public void setPlatformInfo(PlatformInfo platformInfo) {
        this.platformInfo = platformInfo;
    }
}
