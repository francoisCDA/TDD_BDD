package entity;

import exception.SpeareException;

import java.util.ArrayList;
import java.util.List;

public class FrameImpl implements Frame {

    private SpeareGenerator speareGenerator;

    private List<Integer> frameScores;

    private int frameNumber;

    public FrameImpl(SpeareGenerator speareGenerator, int frameNumber) {
        this.speareGenerator = speareGenerator;
        this.frameNumber = frameNumber;
        frameScores = new ArrayList<>();
    }

    public void getSpeare() throws SpeareException {
        int spearCount = frameScores.size();
        int frameScore = getScore();
        if (( frameNumber < 10 && (spearCount >= 2 || frameScore == 10 ) )  || ( frameNumber == 10 && spearCount >= 2 && frameScore < 10 ) ) throw new SpeareException();
        frameScores.add(speareGenerator.getSpeare());
    }

    public int getScore(){
        int ret = 0;
        for (Integer sc:frameScores) {
            ret+=sc;
        }
        return ret;
    }

    public List<Integer> getFrameScores(){
        return frameScores;
    }

    public void addBonus(List<Integer> nextFrameScores) {

        if (frameScores.get(0) == 10 && frameScores.size() == 1 ) {
            frameScores.addAll(nextFrameScores);
            return;
        }

        if ((frameScores.get(0) == 10 && frameScores.size() == 2) || (frameScores.size() == 2 && frameScores.get(0) + frameScores.get(1) == 10 ) ) {
            frameScores.add(nextFrameScores.get(0));
        }

    }

}
