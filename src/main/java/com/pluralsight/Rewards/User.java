package com.pluralsight.Rewards;

public class User {
    private String name;
    private String username;
    private String hashedPassword;
    private String salt;
    private int points;

    public User(String name, String username, String hashedPassword, String salt, int points) {
        this.name = name;
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.salt = salt;
        this.points = points;
    }

    //new user constructor
    public User(String username, String hashedPassword, String salt) {
        this.name = name;
        this.username = username;
        this.hashedPassword = hashedPassword;
        this.salt = salt;
        this.points = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHashedPassword() {
        return hashedPassword;
    }

    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

}
