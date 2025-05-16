package com.example.controller;

import com.example.service.DataService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class HomeController {
    private final DataService dataService;

    public HomeController(DataService dataService) {
        this.dataService = dataService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("teamMembers", dataService.getTeamMembers());
        model.addAttribute("comments", dataService.getComments());
        return "index";
    }

    @PostMapping("/comment")
    public String addComment(@RequestParam("comment") String comment) {
        if (comment != null && !comment.trim().isEmpty()) {
            dataService.addComment(comment);
        }
        return "redirect:/";
    }
}
