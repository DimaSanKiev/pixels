package io.dimasan.pixels.bootstrap;

import io.dimasan.pixels.model.Album;
import io.dimasan.pixels.model.Image;
import io.dimasan.pixels.service.AlbumService;
import io.dimasan.pixels.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AlbumService albumService;
    private ImageService imageService;

    @Autowired
    public void setAlbumService(AlbumService albumService) {
        this.albumService = albumService;
    }

    @Autowired
    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        loadAlbums();
        loadImages();
        assignImagesToAlbums();
    }

    private void loadAlbums() {
        Album album1 = new Album();
        album1.setName("Test Album 1");
        albumService.saveOrUpdate(album1);
        Album album2 = new Album();
        album2.setName("Test Album 2");
        albumService.saveOrUpdate(album2);
    }

    private void loadImages() {
        Image image1 = new Image();
        image1.setDateUploaded(LocalDateTime.now());
        image1.setUsername("User 1");
        image1.setDescription("Description 1");
        image1.setAlbum(albumService.getById(1L));
        imageService.saveOrUpdate(image1);

        Image image2 = new Image();
        image2.setDateUploaded(LocalDateTime.now());
        image2.setUsername("User 2");
        image2.setDescription("Description 2");
        image2.setAlbum(albumService.getById(1L));
        imageService.saveOrUpdate(image2);

        Image image3 = new Image();
        image3.setDateUploaded(LocalDateTime.now());
        image3.setDescription("Description 3");
        image3.setAlbum(albumService.getById(2L));
        imageService.saveOrUpdate(image3);

        Image image4 = new Image();
        image4.setDateUploaded(LocalDateTime.now());
        image4.setDescription("Description 4");
        imageService.saveOrUpdate(image4);

        Image image5 = new Image();
        image4.setDateUploaded(LocalDateTime.now());
        image4.setDescription("Description 5");
        imageService.saveOrUpdate(image4);
    }

    private void assignImagesToAlbums() {
    }
}
