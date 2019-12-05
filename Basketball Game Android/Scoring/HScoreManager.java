package com.example.assignmentseven.assignmenteight.Scoring;

import java.util.*;
import java.io.*;

public class HScoreManager {
    private ArrayList<Score> scores;

   public HScoreManager(){
       scores = new ArrayList<Score>();
   }

   public ArrayList<Score> getScores(){
       sort();
       return scores;
   }

    private void sort() {
        ScoreComparer comparator = new ScoreComparer();
        Collections.sort(scores, comparator);
    }

    public void addScore(String name, int score) {
        scores.add(new Score(name, score));
    }

    public String getHighscoreString() {
        String highscoreString = "";
        //Set this to whatever value should be the max score
        int max = 10;

        ArrayList<Score> scores;
        scores = getScores();

        int i = 0;
        int x = scores.size();
        if (x > max) {
            x = max;
        }
        while (i < x) {
            highscoreString += (i + 1) + ".\t" + scores.get(i).getName() + "\t\t" + scores.get(i).getScore() + "\n";
            i++;
        }
        return highscoreString;
    }
}
