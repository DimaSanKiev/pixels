package io.dimasan.pixels.service.repoimpl;

import io.dimasan.pixels.model.Album;
import io.dimasan.pixels.repository.AlbumRepository;
import io.dimasan.pixels.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlbumServiceRepoImpl implements AlbumService {

    private AlbumRepository albumRepository;

    @Autowired
    public void setAlbumRepository(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Override
    public List<?> listAll() {
        List<Album> albums = new ArrayList<>();
        albumRepository.findAll().forEach(albums::add);
        return albums;
    }

    @Override
    public Album getById(Long id) {
        return albumRepository.findOne(id);
    }

    @Override
    public Album saveOrUpdate(Album obj) {
        return albumRepository.save(obj);
    }

    @Override
    public void delete(Long id) {
        albumRepository.delete(id);
    }
}
