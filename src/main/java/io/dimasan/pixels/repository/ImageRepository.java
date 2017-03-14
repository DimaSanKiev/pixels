package io.dimasan.pixels.repository;

import io.dimasan.pixels.model.Image;
import org.springframework.data.repository.CrudRepository;

public interface ImageRepository extends CrudRepository<Image, Long> {
}
