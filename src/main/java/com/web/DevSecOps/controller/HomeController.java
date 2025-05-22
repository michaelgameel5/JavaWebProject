package com.web.DevSecOps.controller;

import com.web.DevSecOps.service.DataService;
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

     @GetMapping("/security-team")
    public String securityTeam(Model model) {
        model.addAttribute("teamMembers", dataService.getSecurityTeamMembers());
        return "security-team";
    }

    @GetMapping("/monitoring-team")
    public String monitoringTeam(Model model) {
        model.addAttribute("teamMembers", dataService.getMonitoringTeamMembers());
        return "monitoring-team";
    }

    @GetMapping("/ai-team")
    public String aiTeam(Model model) {
        model.addAttribute("teamMembers", dataService.getAiTeamMembers());
        return "ai-team";
    }


    @PostMapping("/comment")
    public String addComment(@RequestParam("comment") String comment) {
        if (comment != null && !comment.trim().isEmpty()) {
            dataService.addComment(comment);
        }
        return "redirect:/";
    }
}
