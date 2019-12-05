package com.example.assignmentseven.assignmenteight.Scoring;

import java.util.Scanner;
import java.io.Serializable;

public class Score implements Serializable {

    private int uScore;
    private String uName;

    public int getScore(){
        return uScore;
    }

    public String getName(){
        return uName;
    }

    public Score(String name, int score) {
        this.uScore = score;
        this.uName = name;
    }
}
