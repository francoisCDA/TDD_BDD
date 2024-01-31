package entity;

import exception.SpeareException;

public class Frame {

    private SpeareGenerator speareGenerator;

    private int frameScore;

    private int spearCount;

    private int frameNumber;

    public Frame(SpeareGenerator speareGenerator, int frameNumber) {
        this.speareGenerator = speareGenerator;
        this.frameNumber = frameNumber;
        spearCount = 0;
    }

    public void getSpeare() throws SpeareException {
        spearCount++;
        if (( frameNumber < 10 && (spearCount > 2 || frameScore == 10 ) )  || ( frameNumber == 10 && spearCount > 2 && frameScore < 10 ) ) throw new SpeareException();

        frameScore += speareGenerator.getSpeare();
    }

    public int getScore(){
        return frameScore;
    }

}
