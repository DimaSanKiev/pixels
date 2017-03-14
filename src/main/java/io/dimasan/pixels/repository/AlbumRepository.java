package io.dimasan.pixels.repository;

import io.dimasan.pixels.model.Album;
import org.springframework.data.repository.CrudRepository;

public interface AlbumRepository extends CrudRepository<Album, Long> {
}
