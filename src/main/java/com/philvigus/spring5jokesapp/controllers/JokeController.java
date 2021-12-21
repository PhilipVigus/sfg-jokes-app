package com.philvigus.spring5jokesapp.controllers;

import com.philvigus.spring5jokesapp.services.JokeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JokeController {
    private final JokeService jokeService;

    /**
     * We don't need @Autowired here, as there's only
     * a single constructor on the class and Spring
     * will automatically do the DI for us
     */
    public JokeController(JokeService jokeService) {
        this.jokeService = jokeService;
    }

    @RequestMapping({"/", ""})
    public String showJoke(Model model) {
        model.addAttribute("joke", jokeService.getJoke());

        return "index";
    }
}
