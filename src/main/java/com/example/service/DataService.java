package com.example.service;

import com.example.model.TeamMember;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DataService {
    private final List<TeamMember> teamMembers = new ArrayList<>();
    private final List<String> comments = new ArrayList<>();

    public DataService() {
        // AI Team
        teamMembers.add(new TeamMember("Kamel Ahmed", "Member", "AI Team", "/photos/kamel.jpg"));
        teamMembers.add(new TeamMember("Yassin Shaher", "Member", "AI Team", "/photos/yassin.jpg"));
        teamMembers.add(new TeamMember("Ahmed Essam", "Member", "AI Team", "/photos/essam.jpg"));
        // Monitoring Team
        teamMembers.add(new TeamMember("Mohamed Hany", "Member", "Monitoring Team", "/photos/hany.jpg"));
        teamMembers.add(new TeamMember("Seif Waheed", "Member", "Monitoring Team", "/photos/seif.jpg"));
        teamMembers.add(new TeamMember("Dalia Ali", "Member", "Monitoring Team", "/photos/dalia.jpg"));
        // Security Team
        teamMembers.add(new TeamMember("Omar Abdo", "Member", "Security Team", "/photos/omar.jpg"));
        teamMembers.add(new TeamMember("Mohamed Hesham", "Member", "Security Team", "/photos/hesham.jpg"));
        teamMembers.add(new TeamMember("Michael Gameel", "Member", "Security Team", "/photos/michael.jpg"));
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
