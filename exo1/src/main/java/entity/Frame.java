package entity;

import exception.SpeareException;

public class Frame {

    private SpeareGenerator speareGenerator;

    private int score;

    private int spearCount;

    private int frameNumber;

    public Frame(SpeareGenerator speareGenerator, int frameNumber) {
        this.speareGenerator = speareGenerator;
        this.frameNumber = frameNumber;
        spearCount = 0;
    }

    public void getSpeare() throws SpeareException {
        spearCount++;
        if ( frameNumber < 10 && (spearCount > 2 || score == 10 ) ) throw new SpeareException();
        score += speareGenerator.getSpeare();
    }

    public int getScore(){
        return score;
    }

    public void setFrameNumber(int frameNumber) {
        this.frameNumber = frameNumber;
    }


}
