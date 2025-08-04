package com.fdc.server.model.dto;

public class WhyChooseCard {
    private String icon;
    private String title;
    private String text;

    public WhyChooseCard() {
    }

    public WhyChooseCard(String icon, String title, String text) {
        this.icon = icon;
        this.title = title;
        this.text = text;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
