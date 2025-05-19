package com.example.model;

public class TeamMember {
    private String name;
    private String role;
    private String team;
    private String photoUrl;

    public TeamMember(String name, String role, String team, String photoUrl) {
        this.name = name;
        this.role = role;
        this.team = team;
        this.photoUrl = photoUrl;
    }

    // For backward compatibility (if needed)
    public TeamMember(String name, String role, String team) {
        this(name, role, team, null);
    }

    public String getName() { return name; }
    public String getRole() { return role; }
    public String getTeam() { return team; }
    public String getPhotoUrl() { return photoUrl; }
}
