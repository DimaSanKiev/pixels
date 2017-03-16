package io.dimasan.pixels.controller;

import io.dimasan.pixels.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AlbumController {

    private AlbumService albumService;

    @Autowired
    public void setAlbumService(AlbumService albumService) {
        this.albumService = albumService;
    }

    @RequestMapping("/albums")
    public String listAlbums(Model model) {
        model.addAttribute("albums", albumService.listAll());
        return "albums";
    }
}
