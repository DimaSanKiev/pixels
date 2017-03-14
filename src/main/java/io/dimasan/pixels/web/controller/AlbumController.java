package io.dimasan.pixels.web.controller;

import io.dimasan.pixels.model.Album;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class AlbumController {

    private SessionFactory sessionFactory;

    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @SuppressWarnings("unchecked")
    @RequestMapping("/albums")
    public String listAlbums(Model model) {
        Session session = sessionFactory.openSession();
        List<Album> albums = session.createCriteria(Album.class).list();
        model.addAttribute("albums", albums);
        return "album/index";
    }
}
