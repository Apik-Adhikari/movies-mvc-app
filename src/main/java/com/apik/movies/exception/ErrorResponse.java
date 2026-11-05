package com.apik.movies.exception;

public class ErrorResponse {
    private int status;       // जस्तै: 404 वा 400
    private String message;   // एररको विवरण (जस्तै: "Movie not found")
    private long timestamp;   // एरر आएको समय

    // Constructor
    public ErrorResponse(int status, String message, long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    // Getters and Setters
    public int getStatus() { return status; }
    public void setStatus(int status) { this.status = status; }

    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long timestamp) { this.timestamp = timestamp; }
}