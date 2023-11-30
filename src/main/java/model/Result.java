package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name = "Results")
public class Result implements Serializable {
    @Column(name = "division")
    private String division;
    @Id
    @Column(name = "date")
    private Date date;
    @Column(name = "time")
    private Time time;
    @Id
    @Column(name = "homeTeam")
    private String homeTeam;
    @Id
    @Column(name = "awayTeam")
    private String awayTeam;
    @Column(name = "FTHG")
    private int fullTimeHomeGoals;
    @Column(name = "FTAG")
    private int fullTimeAwayGoals;
    @Column(name = "FTR")
    private Character fullTimeResult;
    @Column(name = "HTHG")
    private int halfTimeHomeGoals;
    @Column(name = "HTAG")
    private int halfTimeAwayGoals;
    @Column(name = "HTR")
    private Character halfTimeResult;
    @Column(name = "referee")
    private String referee;
    @Column(name = "HS")
    private int HS;
    @Column(name = "AWS")
    private int AWS;
    @Column(name = "HST")
    private int HST;
    @Column(name = "AST")
    private int AST;
    @Column(name = "HF")
    private int HF;
    @Column(name = "AF")
    private int AF;
    @Column(name = "HC")
    private int HC;
    @Column(name = "AC")
    private int AC;
    @Column(name = "HY")
    private int HY;
    @Column(name = "AY")
    private int AY;
    @Column(name = "HRC")
    private int HRC;
    @Column(name = "ARC")
    private int ARC;


    public Result(String division, Date date, Time time, String homeTeam, String awayTeam, int fullTimeHomeGoals, int fullTimeAwayGoals, Character fullTimeResult, int halfTimeHomeGoals, int halfTimeAwayGoals, Character
            halfTimeResult, String referee, int hs, int aws, int hst, int ast, int hf, int af, int hc, int ac, int hy, int ay, int hrc, int arc) {
        this.division = division;
        this.date = date;
        this.time = time;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.fullTimeHomeGoals = fullTimeHomeGoals;
        this.fullTimeAwayGoals = fullTimeAwayGoals;
        this.fullTimeResult = fullTimeResult;
        this.halfTimeHomeGoals = halfTimeHomeGoals;
        this.halfTimeAwayGoals = halfTimeAwayGoals;
        this.halfTimeResult = halfTimeResult;
        this.referee = referee;
        this.HS = hs;
        this.AWS = aws;
        this.HST = hst;
        this.AST = ast;
        this.HF = hf;
        this.AF = af;
        this.HC = hc;
        this.AC = ac;
        this.HY = hy;
        this.AY = ay;
        this.HRC = hrc;
        this.ARC = arc;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public java.sql.Date getDate() {
        return (java.sql.Date) date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public int getFullTimeHomeGoals() {
        return fullTimeHomeGoals;
    }

    public void setFullTimeHomeGoals(int fullTimeHomeGoals) {
        this.fullTimeHomeGoals = fullTimeHomeGoals;
    }

    public int getFullTimeAwayGoals() {
        return fullTimeAwayGoals;
    }

    public void setFullTimeAwayGoals(int fullTimeAwayGoals) {
        this.fullTimeAwayGoals = fullTimeAwayGoals;
    }

    public Character getFullTimeResult() {
        return fullTimeResult;
    }

    public void setFullTimeResult(Character fullTimeResult) {
        this.fullTimeResult = fullTimeResult;
    }

    public int getHalfTimeHomeGoals() {
        return halfTimeHomeGoals;
    }

    public void setHalfTimeHomeGoals(int halfTimeHomeGoals) {
        this.halfTimeHomeGoals = halfTimeHomeGoals;
    }

    public int getHalfTimeAwayGoals() {
        return halfTimeAwayGoals;
    }

    public void setHalfTimeAwayGoals(int halfTimeAwayGoals) {
        this.halfTimeAwayGoals = halfTimeAwayGoals;
    }

    public Character getHalfTimeResult() {
        return halfTimeResult;
    }

    public void setHalfTimeResult(Character halfTimeResult) {
        this.halfTimeResult = halfTimeResult;
    }

    public String getReferee() {
        return referee;
    }

    public void setReferee(String referee) {
        this.referee = referee;
    }

    public int getHS() {
        return HS;
    }

    public void setHS(int HS) {
        this.HS = HS;
    }

    public int getAWS() {
        return AWS;
    }

    public void setAWS(int AS) {
        this.AWS = AS;
    }

    public int getHST() {
        return HST;
    }

    public void setHST(int HST) {
        this.HST = HST;
    }

    public int getAST() {
        return AST;
    }

    public void setAST(int AST) {
        this.AST = AST;
    }

    public int getHF() {
        return HF;
    }

    public void setHF(int HF) {
        this.HF = HF;
    }

    public int getAF() {
        return AF;
    }

    public void setAF(int AF) {
        this.AF = AF;
    }

    public int getHC() {
        return HC;
    }

    public void setHC(int HC) {
        this.HC = HC;
    }

    public int getAC() {
        return AC;
    }

    public void setAC(int AC) {
        this.AC = AC;
    }

    public int getHY() {
        return HY;
    }

    public void setHY(int HY) {
        this.HY = HY;
    }

    public int getAY() {
        return AY;
    }

    public void setAY(int AY) {
        this.AY = AY;
    }

    public int getHRC() {
        return HRC;
    }

    public void setHRC(int HRC) {
        this.HRC = HRC;
    }

    public int getARC() {
        return ARC;
    }

    public void setARC(int ARC) {
        this.ARC = ARC;
    }

    public String toString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        return "Match{" +
                "division='" + division + '\'' +
                ", date=" + dateFormat.format(date) +
                ", time=" + time +
                ", homeTeam='" + homeTeam + '\'' +
                ", awayTeam='" + awayTeam + '\'' +
                ", fullTimeHomeGoals=" + fullTimeHomeGoals +
                ", fullTimeAwayGoals=" + fullTimeAwayGoals +
                ", fullTimeResult='" + fullTimeResult + '\'' +
                ", halfTimeHomeGoals=" + halfTimeHomeGoals +
                ", halfTimeAwayGoals=" + halfTimeAwayGoals +
                ", halfTimeResult='" + halfTimeResult + '\'' +
                ", referee='" + referee + '\'' +
                ", HS=" + HS +
                ", AS=" + AWS +
                ", HST=" + HST +
                ", AST=" + AST +
                ", HF=" + HF +
                ", AF=" + AF +
                ", HC=" + HC +
                ", AC=" + AC +
                ", HY=" + HY +
                ", AY=" + AY +
                ", HRC=" + HRC +
                ", ARC=" + ARC +
                '}';
    }
}