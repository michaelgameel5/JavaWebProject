package com.web.DevSecOps.service;

import com.web.DevSecOps.model.TeamMember;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataService {

    private static final String MEMBER = "Member";
    private static final String SUPERVISOR = "Supervisor";
    private static final String SUPERVISION = "Supervision";
    private static final String SECURITY_TEAM = "Security Team";
    private static final String MONITORING_TEAM = "Monitoring Team";
    private static final String AI_TEAM = "AI Team";

    private final List<TeamMember> teamMembers = new ArrayList<>();
    private final List<String> comments = new ArrayList<>();

    public DataService() {
        // Supervisor
        teamMembers.add(new TeamMember("Maryam Adel", SUPERVISOR, SUPERVISION, "/images/maryam.jpg"));

        // Security Team
        teamMembers.add(new TeamMember("Michael Gameel", MEMBER, SECURITY_TEAM, "/images/michael.jpg"));
        teamMembers.add(new TeamMember("Omar Abduh", MEMBER, SECURITY_TEAM, "/images/omar.jpg"));
        teamMembers.add(new TeamMember("Mohamed Hesham", MEMBER, SECURITY_TEAM, "/images/mohamedhesham.jpeg"));

        // Monitoring Team
        teamMembers.add(new TeamMember("Seif Waheed", MEMBER, MONITORING_TEAM, "/images/seif.jpg"));
        teamMembers.add(new TeamMember("Mohamed Hany", MEMBER, MONITORING_TEAM, "/images/hany.jpg"));
        teamMembers.add(new TeamMember("Dalia Ali", MEMBER, MONITORING_TEAM, "/images/dalia.jpg"));

        // AI Team
        teamMembers.add(new TeamMember("Kamel Ahmed", MEMBER, AI_TEAM, "/images/kamel.jpg"));
        teamMembers.add(new TeamMember("Yassin Shaher", MEMBER, AI_TEAM, "/images/yassin.jpg"));
        teamMembers.add(new TeamMember("Ahmed Essam", MEMBER, AI_TEAM, "/images/ahmed.jpg"));
    }

    public List<TeamMember> getTeamMembers() {
        return Collections.unmodifiableList(teamMembers);
    }

    public List<String> getComments() {
        return comments;
    }

    public void addComment(String comment) {
        comments.add(comment);
    }
    
    public List<TeamMember> getSecurityTeamMembers() {
        return getTeamMembers().stream()
                .filter(member -> member.getTeam().toLowerCase().contains("security team"))
                .collect(Collectors.toList());
    }

    public List<TeamMember> getMonitoringTeamMembers() {
        return getTeamMembers().stream()
                .filter(member -> member.getTeam().toLowerCase().contains("monitoring team"))
                .collect(Collectors.toList());
    }

    public List<TeamMember> getAiTeamMembers() {
        return getTeamMembers().stream()
                .filter(member -> member.getTeam().toLowerCase().contains("ai team"))
                .collect(Collectors.toList());
    }
}