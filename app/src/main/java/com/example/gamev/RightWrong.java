package com.example.gamev;

public class RightWrong {
    private int question;
    private boolean isTrueQuest;

    public RightWrong(int question, boolean isTrueQuest) {
        this.question = question;
        this.isTrueQuest = isTrueQuest;
    }

    public int getQuestion() {
        return question;
    }

    public void setQuestion(int question) {
        this.question = question;
    }

    public boolean isTrueQuest() {
        return isTrueQuest;
    }

    public void setTrueQuest(boolean trueQuest) {
        isTrueQuest = trueQuest;
    }
}

