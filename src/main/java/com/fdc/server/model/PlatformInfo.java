package com.fdc.server.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class PlatformInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String bannerContent;
    private String donateMessage;
    private String donateTitle;
    @OneToMany(mappedBy = "platformInfo", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<SEOHashTag> seoHashTags;
    @OneToMany(mappedBy = "platformInfo", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<News> news;
    private String tiktokLink;
    private String instagramLink;
    private String youTubeLink;
    private String discordLink;
    private String linkedinLink;
    private String email;

    @OneToMany(mappedBy = "platformInfo", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Sponsor> sponsors;

    public PlatformInfo() {
    }

    public PlatformInfo(long id, String bannerContent, String donateMessage, List<News> news, List<SEOHashTag> seoHashTags, String donateTitle, String tiktokLink, String instagramLink, String youTubeLink, String discordLink, String linkedinLink, String email, List<Sponsor> sponsors) {
        this.id = id;
        this.bannerContent = bannerContent;
        this.donateMessage = donateMessage;
        this.news = news;
        this.seoHashTags = seoHashTags;
        this.donateTitle = donateTitle;
        this.tiktokLink = tiktokLink;
        this.instagramLink = instagramLink;
        this.youTubeLink = youTubeLink;
        this.discordLink = discordLink;
        this.linkedinLink = linkedinLink;
        this.email = email;
        this.sponsors = sponsors;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBannerContent() {
        return bannerContent;
    }

    public void setBannerContent(String bannerContent) {
        this.bannerContent = bannerContent;
    }

    public String getDonateMessage() {
        return donateMessage;
    }

    public void setDonateMessage(String donateMessage) {
        this.donateMessage = donateMessage;
    }

    public List<SEOHashTag> getSeoHashTags() {
        return seoHashTags;
    }

    public void setSeoHashTags(List<SEOHashTag> seoHashTags) {
        this.seoHashTags = seoHashTags;
    }

    public String getDonateTitle() {
        return donateTitle;
    }

    public void setDonateTitle(String donateTitle) {
        this.donateTitle = donateTitle;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public String getTiktokLink() {
        return tiktokLink;
    }

    public void setTiktokLink(String tiktokLink) {
        this.tiktokLink = tiktokLink;
    }

    public String getInstagramLink() {
        return instagramLink;
    }

    public void setInstagramLink(String instagramLink) {
        this.instagramLink = instagramLink;
    }

    public String getYouTubeLink() {
        return youTubeLink;
    }

    public void setYouTubeLink(String youTubeLink) {
        this.youTubeLink = youTubeLink;
    }

    public String getDiscordLink() {
        return discordLink;
    }

    public void setDiscordLink(String discordLink) {
        this.discordLink = discordLink;
    }

    public String getLinkedinLink() {
        return linkedinLink;
    }

    public void setLinkedinLink(String linkedinLink) {
        this.linkedinLink = linkedinLink;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Sponsor> getSponsors() {
        return sponsors;
    }

    public void setSponsors(List<Sponsor> sponsors) {
        this.sponsors = sponsors;
    }
}
