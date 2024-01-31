package entity;

import exception.GameEndException;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {


    private List<Frame> frameList;

    public BowlingGame(){
        frameList = new ArrayList<>();
    }

    public void nextFrame(Frame nextFrame) throws GameEndException {
        if (frameList.size()>=10) throw new GameEndException();




        frameList.add(nextFrame);
    }

    public int getTotalScore() {

        int totalScore = 0;

        for (Frame f:frameList) {
            totalScore += f.getScore();
        }

        return totalScore;

    }


    // for the test

    public int indCurrentFrame() {
        return frameList.size();
    }

}
