package entity;

import exception.GameEndException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestBowlingGame {

    private BowlingGame bowlingGame;

    @Mock
    private Frame frame;


    @Test
    void NextFrameThrowsGameEndExceptionWhenGT10() throws GameEndException {

        bowlingGame = new BowlingGame();

        bowlingGame.nextFrame(new FrameImpl( new SpeareGeneratorImpl(), bowlingGame.indCurrentFrame() ));
        bowlingGame.nextFrame(new FrameImpl( new SpeareGeneratorImpl(), bowlingGame.indCurrentFrame() ));
        bowlingGame.nextFrame(new FrameImpl( new SpeareGeneratorImpl(), bowlingGame.indCurrentFrame() ));
        bowlingGame.nextFrame(new FrameImpl( new SpeareGeneratorImpl(), bowlingGame.indCurrentFrame() ));
        bowlingGame.nextFrame(new FrameImpl( new SpeareGeneratorImpl(), bowlingGame.indCurrentFrame() ));
        bowlingGame.nextFrame(new FrameImpl( new SpeareGeneratorImpl(), bowlingGame.indCurrentFrame() ));
        bowlingGame.nextFrame(new FrameImpl( new SpeareGeneratorImpl(), bowlingGame.indCurrentFrame() ));
        bowlingGame.nextFrame(new FrameImpl( new SpeareGeneratorImpl(), bowlingGame.indCurrentFrame() ));
        bowlingGame.nextFrame(new FrameImpl( new SpeareGeneratorImpl(), bowlingGame.indCurrentFrame() ));
        bowlingGame.nextFrame(new FrameImpl( new SpeareGeneratorImpl(), bowlingGame.indCurrentFrame() ));

        Assertions.assertThrowsExactly(GameEndException.class, () -> bowlingGame.nextFrame(new FrameImpl( new SpeareGeneratorImpl(), bowlingGame.indCurrentFrame() )));

    }

    @Test
    void nextFrameShouldIncreaseTotalScoreWithScoreFrame() throws GameEndException {
        Mockito.when(frame.getScore()).thenReturn(7);
        bowlingGame = new BowlingGame();
        bowlingGame.nextFrame(frame);
        bowlingGame.nextFrame(frame);

        Assertions.assertEquals(14,bowlingGame.getTotalScore());

    }

    @Test
    void nextFrameShouldUpdateFrameAfterStrike() throws GameEndException {

        bowlingGame = new BowlingGame();
        Mockito.when(frame.getScore()).thenReturn(10);
        bowlingGame.nextFrame(frame);
        Mockito.when(frame.getScore()).thenReturn(7);
        bowlingGame.nextFrame(frame);

        Assertions.assertEquals(24,bowlingGame.getTotalScore());

    }

    @Test
    void nextFrameShouldUpdateFrameAfterTwoStrike() throws GameEndException {

        bowlingGame = new BowlingGame();
        Mockito.when(frame.getScore()).thenReturn(10);
        bowlingGame.nextFrame(frame);
        Mockito.when(frame.getScore()).thenReturn(10);
        bowlingGame.nextFrame(frame);
        Mockito.when(frame.getScore()).thenReturn(7);
        bowlingGame.nextFrame(frame);

        Assertions.assertEquals(51,bowlingGame.getTotalScore());

    }

    



}
