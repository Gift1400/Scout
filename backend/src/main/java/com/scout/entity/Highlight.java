package com.scout.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class Highlight {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "highlightId", columnDefinition = "BINARY(16)")
    private UUID highlightId;

    @ManyToOne
    private Player player;
    private String videoUrl;
    private String title;
    private String thumbnailUrl;
    private LocalDateTime uploadedAt;

    protected Highlight(){}
    public Highlight(Builder builder){
        this.highlightId = builder.highlightId;
        this.player = builder.player;
        this.videoUrl = builder.videoUrl;
        this.title = builder.title;
        this.thumbnailUrl = builder.thumbnailUrl;
        this.uploadedAt = builder.uploadedAt;
    }

    public UUID getHighlightId() {
        return highlightId;
    }

    public Player getPlayer() {
        return player;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public LocalDateTime getUploadedAt() {
        return uploadedAt;
    }

    @Override
    public String toString() {
        return "Hightlight{" +
                "hightlightId=" + highlightId +
                ", player=" + player +
                ", videoUrl='" + videoUrl + '\'' +
                ", title='" + title + '\'' +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", uploadedAt=" + uploadedAt +
                '}';
    }

    public static class Builder{
        private UUID highlightId;
        private Player player;
        private String videoUrl;
        private String title;
        private String thumbnailUrl;
        private LocalDateTime uploadedAt;

        public Builder copy(Highlight hightlight){
            this.highlightId = hightlight.highlightId;
            this.player = hightlight.player;
            this.videoUrl = hightlight.videoUrl;
            this.title = hightlight.title;
            this.thumbnailUrl = hightlight.thumbnailUrl;
            this.uploadedAt = hightlight.uploadedAt;
            return this;
        }

        public Builder setHighlightId(UUID highlightId) {
            this.highlightId = highlightId;
            return this;
        }

        public Builder setPlayer(Player player) {
            this.player = player;
            return this;
        }

        public Builder setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
            return this;
        }

        public Builder setTitle(String title) {
            this.title = title;
            return this;
        }

        public Builder setThumbnailUrl(String thumbnailUrl) {
            this.thumbnailUrl = thumbnailUrl;
            return this;
        }

        public Builder setUploadedAt(LocalDateTime uploadedAt) {
            this.uploadedAt = uploadedAt;
            return this;
        }

        public Highlight build(){
            return new Highlight(this);
        }
    }
}
