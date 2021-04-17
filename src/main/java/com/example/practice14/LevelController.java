package com.example.practice14;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("/home/Level")
public class LevelController {

    ArrayList<Level> levels = new ArrayList<>();
    boolean state = false;
    @GetMapping("/add")
    public String addGame(@RequestParam String c,
                          @RequestParam String l,
                          Model model) {
        levels.add(new Level(c, l));
        model.addAttribute("action","Added:");
        model.addAttribute("complexity", c);
        model.addAttribute("levelName", l);
        return "Level";
    }

    @GetMapping("/del")
    public String delGame(@RequestParam String c,
                          @RequestParam String l,
                          Model model) {
        for (Level ls: levels) {
            if (ls.getComplexity().equals(c)
                    && ls.getLevelName().equals(l)) {
                levels.remove(ls);
                model.addAttribute("action","Removed:");
                model.addAttribute("complexity", c);
                model.addAttribute("levelName", l);
                state = true;
                break;
            }

        }
        if(!state) model.addAttribute("action","This level was not found");
        return "Level";
    }

    @GetMapping("/get")
    public String getGame(@RequestParam String c,
                          @RequestParam String l,
                          Model model) {
        for (Level ls: levels) {
            if (ls.getComplexity().equals(c)
                    && ls.getLevelName().equals(l)) {
                model.addAttribute("action","Found:");
                model.addAttribute("complexity", c);
                model.addAttribute("levelName", l);
                state = true;
                break;
            }
        }
        if(!state)
            model.addAttribute("action", "This level was not found");

        return "Level";
    }
    @GetMapping("/getAll")
    public String get(Model model) {
        if (levels.isEmpty()) {
            model.addAttribute("action", "Level list is empty");
        } else {
            model.addAttribute("action", levels.toString());
        }
        return "Level";
    }
}
