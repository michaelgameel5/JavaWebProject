package com.web.DevSecOps.controller;

import com.web.DevSecOps.service.DataService;
import com.web.DevSecOps.service.LoggingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class HomeController {
    private final DataService dataService;
    private final LoggingService loggingService;

    public HomeController(DataService dataService, LoggingService loggingService) {
        this.dataService = dataService;
        this.loggingService = loggingService;
    }

    @GetMapping("/")
    public String index(Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("teamMembers", dataService.getTeamMembers());
        model.addAttribute("comments", dataService.getComments());
        
        logUserActivity(request, response.getStatus(), "PAGE_VIEW", "User visited home page");
        return "index";
    }

    @GetMapping("/security-team")
    public String securityTeam(Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("teamMembers", dataService.getSecurityTeamMembers());
        
        logUserActivity(request, response.getStatus(), "PAGE_VIEW", "User viewed security team");
        return "security-team";
    }

    @GetMapping("/monitoring-team")
    public String monitoringTeam(Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("teamMembers", dataService.getMonitoringTeamMembers());
        
        logUserActivity(request, response.getStatus(), "PAGE_VIEW", "User viewed monitoring team");
        return "monitoring-team";
    }

    @GetMapping("/ai-team")
    public String aiTeam(Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("teamMembers", dataService.getAiTeamMembers());
        
        logUserActivity(request, response.getStatus(), "PAGE_VIEW", "User viewed AI team");
        return "ai-team";
    }
    
    @GetMapping("/presentation")
    public String presentation(Model model, HttpServletRequest request, HttpServletResponse response) {
        logUserActivity(request, response.getStatus(), "PAGE_VIEW", "User viewed presentation");
        return "presentation";
    }

    @GetMapping("/attack")
    public String attack(Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("comments", dataService.getComments());
        
        logUserActivity(request, response.getStatus(), "PAGE_VIEW", "User visited attack page");
        return "attack";
    }

    @PostMapping("/comment")
    public String addComment(@RequestParam("comment") String comment, HttpServletRequest request, HttpServletResponse response) {
        if (comment != null && !comment.trim().isEmpty()) {
            dataService.addComment(comment);
            logUserActivity(request, response.getStatus(), "ADD_COMMENT", "User added comment: " + comment);
        }
        return "redirect:/attack";
    }
    
    @GetMapping("/logs")
    public String viewLogs(Model model, HttpServletRequest request, HttpServletResponse response) {
        model.addAttribute("logs", loggingService.getAllLogs());
        model.addAttribute("logFileContents", loggingService.getLogFileContents());
        
        logUserActivity(request, response.getStatus(), "VIEW_LOGS", "User viewed system logs");
        return "logs";
    }
    
    // Make sure this method is called by all controller endpoints
    private void logUserActivity(HttpServletRequest request, int statusCode, String action, String description) {
        String ipAddress = getClientIpv4Address(request);
        String userAgent = request.getHeader("User-Agent");
        String path = request.getRequestURI();
        
        loggingService.logUserActivity(action, description, ipAddress, userAgent, path, statusCode);
    }
    
    // Helper method to get IPv4 address
    private String getClientIpv4Address(HttpServletRequest request) {
        String ipAddress = request.getRemoteAddr();
        
        // Convert IPv6 localhost to IPv4 localhost
        if ("0:0:0:0:0:0:0:1".equals(ipAddress) || "::1".equals(ipAddress)) {
            ipAddress = "127.0.0.1";
        }
        
        // Handle IPv6 addresses with embedded IPv4 (like "::ffff:192.168.1.1")
        if (ipAddress != null && ipAddress.startsWith("::ffff:")) {
            ipAddress = ipAddress.substring(7);
        }
        
        return ipAddress;
    }
}
