package com.stackBuffers.ipl.Models;

public class SechduleModel {

    String sMatchNum, s_imgTeamA, s_imgTeamB, sDate, s_StadiumName, sTime;

    public SechduleModel(String sMatchNum, String s_imgTeamA, String s_imgTeamB, String sDate, String s_StadiumName, String sTime) {
        this.sMatchNum = sMatchNum;
        this.s_imgTeamA = s_imgTeamA;
        this.s_imgTeamB = s_imgTeamB;
        this.sDate = sDate;
        this.s_StadiumName = s_StadiumName;
        this.sTime = sTime;
    }

    public String getsMatchNum() {
        return sMatchNum;
    }

    public void setsMatchNum(String sMatchNum) {
        this.sMatchNum = sMatchNum;
    }

    public String getS_imgTeamA() {
        return s_imgTeamA;
    }

    public void setS_imgTeamA(String s_imgTeamA) {
        this.s_imgTeamA = s_imgTeamA;
    }

    public String getS_imgTeamB() {
        return s_imgTeamB;
    }

    public void setS_imgTeamB(String s_imgTeamB) {
        this.s_imgTeamB = s_imgTeamB;
    }

    public String getsDate() {
        return sDate;
    }

    public void setsDate(String sDate) {
        this.sDate = sDate;
    }

    public String getS_StadiumName() {
        return s_StadiumName;
    }

    public void setS_StadiumName(String s_StadiumName) {
        this.s_StadiumName = s_StadiumName;
    }

    public String getsTime() {
        return sTime;
    }

    public void setsTime(String sTime) {
        this.sTime = sTime;
    }
}
