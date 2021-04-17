package com.example.practice14;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.ArrayList;

@Controller
@RequestMapping("/home/Game")
public class GameController {

    ArrayList<Game> games = new ArrayList<>();
    LocalDate creationDate;
    boolean state = false;
    @GetMapping("/add")
    public String addGame(@RequestParam String name,
                          @RequestParam int y,
                          @RequestParam int m,
                          @RequestParam int d,
                          Model model) {
        creationDate = LocalDate.of(y, m, d);
        games.add(new Game(name, creationDate));
        model.addAttribute("action","Added:");
        model.addAttribute("name", name);
        model.addAttribute("creationDate", creationDate);
        return "Game";
    }

    @GetMapping("/del")
    public String delGame(@RequestParam String name,
                          @RequestParam int y,
                          @RequestParam int m,
                          @RequestParam int d,
                          Model model) {
        creationDate = LocalDate.of(y, m, d);
        for (Game g: games) {
            if (g.getName().equals(name) && g.getCreationDate().equals(creationDate)) {
                games.remove(g);
                model.addAttribute("action","Removed:");
                model.addAttribute("name", name);
                model.addAttribute("creationDate", creationDate);
                state = true;
                break;
            }

        }
        if(!state) model.addAttribute("action","This game was not found");
        return "Game";
    }

    @GetMapping("/get")
    public String getGame(@RequestParam String name,
                          @RequestParam int y,
                          @RequestParam int m,
                          @RequestParam int d,
                          Model model) {
        creationDate = LocalDate.of(y, m, d);
        for (Game g: games) {
            if (g.getName().equals(name) && g.getCreationDate().equals(creationDate)) {
                model.addAttribute("action","Found:");
                model.addAttribute("name", name);
                model.addAttribute("creationDate", creationDate);
                state = true;
                break;
            }
        }
        if(!state)
            model.addAttribute("action", "This game was not found");

        return "Game";
    }
    @GetMapping("/getAll")
    public String get(Model model) {
        if (games.isEmpty()) {
            model.addAttribute("action", "Game list is empty");
        } else {
            model.addAttribute("action", games.toString());
        }
        return "Game";
    }
}
