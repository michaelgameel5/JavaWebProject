package com.web.DevSecOps.service;

import com.web.DevSecOps.model.TeamMember;
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
        teamMembers.add(new TeamMember("Kamel Ahmed", "Member", "AI Team", "/images/kamel.jpeg"));
        teamMembers.add(new TeamMember("Yassin Shaher", "Member", "AI Team", "/images/yassin.jpeg"));
        teamMembers.add(new TeamMember("Ahmed Essam", "Member", "AI Team", "/images/essam.jpeg"));
        // Monitoring Team
        teamMembers.add(new TeamMember("Mohamed Hany", "Member", "Monitoring Team", "/images/hany.jpeg"));
        teamMembers.add(new TeamMember("Seif Waheed", "Member", "Monitoring Team", "/images/seif.jpeg"));
        teamMembers.add(new TeamMember("Dalia Ali", "Member", "Monitoring Team", "/images/dalia.jpeg"));
        // Security Team
        teamMembers.add(new TeamMember("Omar Abdo", "Member", "Security Team", "/images/omar.jpeg"));
        teamMembers.add(new TeamMember("Mohamed Hesham", "Member", "Security Team", "/images/hesham.jpeg"));
        teamMembers.add(new TeamMember("Michael Gameel", "Member", "Security Team", "/images/michael.jpeg"));
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
