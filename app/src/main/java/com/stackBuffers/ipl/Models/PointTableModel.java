package com.stackBuffers.ipl.Models;

public class PointTableModel {
    String matches,win,loss,tie,runrate,points,position,image;

    public PointTableModel(String matches, String win, String loss, String tie, String runrate, String points, String position, String image) {
        this.matches = matches;
        this.win = win;
        this.loss = loss;
        this.tie = tie;
        this.runrate = runrate;
        this.points = points;
        this.position = position;
        this.image = image;
    }

    public String getMatches() {
        return matches;
    }

    public String getWin() {
        return win;
    }

    public String getLoss() {
        return loss;
    }

    public String getTie() {
        return tie;
    }

    public String getRunrate() {
        return runrate;
    }

    public String getPoints() {
        return points;
    }

    public String getPosition() {
        return position;
    }

    public String getImage() {
        return image;
    }
}
