package io.dimasan.pixels.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String description;

    private String url;

    @ManyToOne
    private Album album;

    private LocalDateTime dateUploaded = LocalDateTime.now();

    private String username = "Dima";

    private boolean favorite;

    private boolean privateImage = false;

    private String hash;

    public Image() {
    }

    public String getTimeSinceUploaded() {
        String unit = "";
        LocalDateTime now = LocalDateTime.now();
        long diff;
        if ((diff = ChronoUnit.SECONDS.between(dateUploaded, now)) < 60) {
            unit = "secs";
        } else if ((diff = ChronoUnit.MINUTES.between(dateUploaded, now)) < 60) {
            unit = "mins";
        } else if ((diff = ChronoUnit.HOURS.between(dateUploaded, now)) < 24) {
            unit = "hours";
        } else if ((diff = ChronoUnit.DAYS.between(dateUploaded, now)) < 30) {
            unit = "days";
        } else if ((diff = ChronoUnit.MONTHS.between(dateUploaded, now)) < 12) {
            unit = "months";
        } else {
            diff = ChronoUnit.YEARS.between(dateUploaded, now);
        }
        return String.format("%d %s", diff, unit);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public LocalDateTime getDateUploaded() {
        return dateUploaded;
    }

    public void setDateUploaded(LocalDateTime dateUploaded) {
        this.dateUploaded = dateUploaded;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public void setFavorite(boolean favorite) {
        this.favorite = favorite;
    }

    public boolean isPrivateImage() {
        return privateImage;
    }

    public void setPrivateImage(boolean privateImage) {
        this.privateImage = privateImage;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }
}
