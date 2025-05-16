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
        teamMembers.add(new TeamMember("Kamel Ahmed", "Member", "AI Team"));
        teamMembers.add(new TeamMember("Ahmed Essam", "Member", "AI Team"));
        teamMembers.add(new TeamMember("Yassin Shaher", "Member", "AI Team"));
        // Monitoring Team
        teamMembers.add(new TeamMember("Seif Waheed", "Member", "Monitoring Team"));
        teamMembers.add(new TeamMember("Dalia Ali", "Member", "Monitoring Team"));
        teamMembers.add(new TeamMember("Mohamed Hany", "Member", "Monitoring Team"));
        // Security Team
        teamMembers.add(new TeamMember("Omar Abdo", "Member", "Security Team"));
        teamMembers.add(new TeamMember("Mohamed Hesham", "Member", "Security Team"));
        teamMembers.add(new TeamMember("Michael Gameel", "Member", "Security Team"));
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
