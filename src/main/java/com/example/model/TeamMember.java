package com.example.model;

public class TeamMember {
    private String name;
    private String role;
    private String team;

    public TeamMember(String name, String role, String team) {
        this.name = name;
        this.role = role;
        this.team = team;
    }

    public String getName() { return name; }
    public String getRole() { return role; }
    public String getTeam() { return team; }
}
