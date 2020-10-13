package com.stackBuffers.ipl.Models;

public class RecentMatchesModel {

     String rMatchNum,rPicTeamA,rPicTeamB,rStatusResult;

    public RecentMatchesModel(String rMatchNum, String rPicTeamA, String rPicTeamB, String rStatusResult) {
        this.rMatchNum = rMatchNum;
        this.rPicTeamA = rPicTeamA;
        this.rPicTeamB = rPicTeamB;
        this.rStatusResult = rStatusResult;
    }

    public String getrMatchNum() {
        return rMatchNum;
    }

    public void setrMatchNum(String rMatchNum) {
        this.rMatchNum = rMatchNum;
    }

    public String getrPicTeamA() {
        return rPicTeamA;
    }

    public void setrPicTeamA(String rPicTeamA) {
        this.rPicTeamA = rPicTeamA;
    }

    public String getrPicTeamB() {
        return rPicTeamB;
    }

    public void setrPicTeamB(String rPicTeamB) {
        this.rPicTeamB = rPicTeamB;
    }

    public String getrStatusResult() {
        return rStatusResult;
    }

    public void setrStatusResult(String rStatusResult) {
        this.rStatusResult = rStatusResult;
    }
}
