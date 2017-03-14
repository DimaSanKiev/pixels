package io.dimasan.pixels.service.repoimpl;

import io.dimasan.pixels.model.Image;
import io.dimasan.pixels.repository.ImageRepository;
import io.dimasan.pixels.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ImageServiceRepoImpl implements ImageService {

    private ImageRepository imageRepository;

    @Autowired
    public void setImageRepository(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public List<?> listAll() {
        List<Image> images = new ArrayList<>();
        imageRepository.findAll().forEach(images::add);
        return images;
    }

    @Override
    public Image getById(Long id) {
        return imageRepository.findOne(id);
    }

    @Override
    public Image saveOrUpdate(Image obj) {
        return imageRepository.save(obj);
    }

    @Override
    public void delete(Long id) {
        imageRepository.delete(id);
    }
}
