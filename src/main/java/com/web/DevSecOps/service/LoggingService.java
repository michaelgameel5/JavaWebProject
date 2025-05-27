package com.web.DevSecOps.service;

import com.web.DevSecOps.model.SystemLog;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class LoggingService {
    private final List<SystemLog> logs = new ArrayList<>();
    private static final String LOG_FILE = "user_activity.log";
    
    public void logUserActivity(String action, String description, String ipAddress, String userAgent, String path, int statusCode) {
        SystemLog log = new SystemLog(action, description, ipAddress, userAgent, path, statusCode);
        logs.add(log);
        writeToLogFile(log);
    }
    
    private void writeToLogFile(SystemLog log) {
        try (PrintWriter out = new PrintWriter(new FileWriter(LOG_FILE, true))) {
            out.println(log.toString());
        } catch (IOException e) {
            System.err.println("Failed to write to log file: " + e.getMessage());
        }
    }
    
    public List<SystemLog> getAllLogs() {
        return Collections.unmodifiableList(logs);
    }
    
    public List<SystemLog> getLogsByAction(String action) {
        return logs.stream()
                .filter(log -> log.getAction().equalsIgnoreCase(action))
                .collect(Collectors.toList());
    }
    
    public List<SystemLog> getLogsByTimeRange(LocalDateTime start, LocalDateTime end) {
        return logs.stream()
                .filter(log -> !log.getTimestamp().isBefore(start) && !log.getTimestamp().isAfter(end))
                .collect(Collectors.toList());
    }
    
    public List<SystemLog> getLogsByIpAddress(String ipAddress) {
        return logs.stream()
                .filter(log -> log.getIpAddress().equals(ipAddress))
                .collect(Collectors.toList());
    }
    
    public String getLogFileContents() {
        try {
            return new String(Files.readAllBytes(Paths.get(LOG_FILE)));
        } catch (IOException e) {
            return "Error reading log file: " + e.getMessage();
        }
    }
}
