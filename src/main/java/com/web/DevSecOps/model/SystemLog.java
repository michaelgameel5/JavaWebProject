package com.web.DevSecOps.model;

import java.time.LocalDateTime;

public class SystemLog {
    private LocalDateTime timestamp;
    private String action;
    private String description;
    private String ipAddress;
    private String userAgent;
    private String path;
    private int statusCode; // Added status code field
    
    public SystemLog(String action, String description, String ipAddress, String userAgent, String path, int statusCode) {
        this.timestamp = LocalDateTime.now();
        this.action = action;
        this.description = description;
        this.ipAddress = ipAddress;
        this.userAgent = userAgent;
        this.path = path;
        this.statusCode = statusCode;
    }
    

    
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
    
    public String getAction() {
        return action;
    }
    
    public String getDescription() {
        return description;
    }
    
    public String getIpAddress() {
        return ipAddress;
    }
    
    public String getUserAgent() {
        return userAgent;
    }
    
    public String getPath() {
        return path;
    }
    
    public int getStatusCode() {
        return statusCode;
    }
    
    @Override
    public String toString() {
        return String.format("[%s] %s - %s (IP: %s, Path: %s, Status: %d, Agent: %s)",
                timestamp, action, description, ipAddress, path, statusCode, userAgent);
    }
}
