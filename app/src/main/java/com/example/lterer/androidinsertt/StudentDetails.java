package com.example.lterer.androidinsertt;

public class StudentDetails {


    private String home;
    private String away;
    private String pick;

    public StudentDetails() {
        // This is default constructor.
    }
    public StudentDetails(String home, String away, String pick) {
        this.home =home;
        this.away = away;
        this.pick = pick;

    }

    public String getHomeGame() {

        return home;
    }

    public void setHomeGame(String home) {

        this.home = home;
    }

    public String getAwayGame() {

        return away;
    }

    public void setAwayGame(String away) {

        this.away = away;
    }
    public String getPick() {

        return pick;
    }

    public void setPick(String pick) {

        this.pick = pick;
    }
}