package com.web.DevSecOps.service;

import com.web.DevSecOps.model.TeamMember;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        teamMembers.add(new TeamMember("Maryam Adel", SUPERVISOR, SUPERVISION, "https://randomuser.me/api/portraits/women/43.jpg"));

        // Security Team
        teamMembers.add(new TeamMember("Omar Abduh", MEMBER, SECURITY_TEAM, "https://randomuser.me/api/portraits/men/68.jpg"));
        teamMembers.add(new TeamMember("Mohamed Hesham", MEMBER, SECURITY_TEAM, "https://randomuser.me/api/portraits/men/72.jpg"));
        teamMembers.add(new TeamMember("Michael Gameel", MEMBER, SECURITY_TEAM, "https://randomuser.me/api/portraits/men/17.jpg"));

        // Monitoring Team
        teamMembers.add(new TeamMember("Mohamed Hany", MEMBER, MONITORING_TEAM, "https://randomuser.me/api/portraits/men/22.jpg"));
        teamMembers.add(new TeamMember("Seif Waheed", MEMBER, MONITORING_TEAM, "https://randomuser.me/api/portraits/men/36.jpg"));
        teamMembers.add(new TeamMember("Dalia Ali", MEMBER, MONITORING_TEAM, "https://randomuser.me/api/portraits/women/65.jpg"));

        // AI Team
        teamMembers.add(new TeamMember("Kamel Ahmed", MEMBER, AI_TEAM, "https://randomuser.me/api/portraits/men/41.jpg"));
        teamMembers.add(new TeamMember("Yassin Shaher", MEMBER, AI_TEAM, "https://randomuser.me/api/portraits/men/32.jpg"));
        teamMembers.add(new TeamMember("Ahmed Essam", MEMBER, AI_TEAM, "https://randomuser.me/api/portraits/men/55.jpg"));
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
}