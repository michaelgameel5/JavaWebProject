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
        // Supervisor
        teamMembers.add(new TeamMember("Maryam Adel", "Supervisor", "Supervision", "https://randomuser.me/api/portraits/women/43.jpg"));
        
        // Security Team
        teamMembers.add(new TeamMember("Omar Abdo", "Member", "Security Team", "https://randomuser.me/api/portraits/men/68.jpg"));
        teamMembers.add(new TeamMember("Mohamed Hesham", "Member", "Security Team", "https://randomuser.me/api/portraits/men/72.jpg"));
        teamMembers.add(new TeamMember("Michael Gameel", "Member", "Security Team", "https://randomuser.me/api/portraits/men/17.jpg"));
        
        // Monitoring Team
        teamMembers.add(new TeamMember("Mohamed Hany", "Member", "Monitoring Team", "https://randomuser.me/api/portraits/men/22.jpg"));
        teamMembers.add(new TeamMember("Seif Waheed", "Member", "Monitoring Team", "https://randomuser.me/api/portraits/men/36.jpg"));
        teamMembers.add(new TeamMember("Dalia Ali", "Member", "Monitoring Team", "https://randomuser.me/api/portraits/women/65.jpg"));
        
        // AI Team
        teamMembers.add(new TeamMember("Kamel Ahmed", "Member", "AI Team", "https://randomuser.me/api/portraits/men/41.jpg"));
        teamMembers.add(new TeamMember("Yassin Shaher", "Member", "AI Team", "https://randomuser.me/api/portraits/men/32.jpg"));
        teamMembers.add(new TeamMember("Ahmed Essam", "Member", "AI Team", "https://randomuser.me/api/portraits/men/55.jpg"));
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
