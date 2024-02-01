package entity;

import java.util.List;

public interface Frame {

    public int getScore();

    public List<Integer> getFrameScores();

    public void addBonus(List<Integer> nextFrameScores);


}
