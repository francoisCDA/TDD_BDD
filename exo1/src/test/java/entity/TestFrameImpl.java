package entity;


import exception.SpeareException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;

@ExtendWith(MockitoExtension.class)
public class TestFrameImpl {

    @Mock
    private SpeareGenerator spearelGen;

    private FrameImpl frameImpl;

    @Test
    void testStandardFrameOneSpeareIncreaseScore() throws SpeareException {
        Mockito.when(spearelGen.getSpeare()).thenReturn(5);
        frameImpl = new FrameImpl(spearelGen,2);

        frameImpl.getSpeare();

        Assertions.assertEquals(5, frameImpl.getScore());
    }

    @Test
    void testStandardFrameTwoSpeareIncreaseScore() throws SpeareException {
        Mockito.when(spearelGen.getSpeare()).thenReturn(5);
        frameImpl = new FrameImpl(spearelGen,2);

        frameImpl.getSpeare();
        frameImpl.getSpeare();

        Assertions.assertEquals(10, frameImpl.getScore());
    }

    @Test
    void testStandardFrameThreeSpeareThrowSpeareException() throws SpeareException {
        Mockito.when(spearelGen.getSpeare()).thenReturn(5);
        frameImpl = new FrameImpl(spearelGen,2);

        frameImpl.getSpeare();
        Mockito.when(spearelGen.getSpeare()).thenReturn(4);
        frameImpl.getSpeare();

        Assertions.assertEquals(9, frameImpl.getScore());
    }

    @Test
    void testStandard3SpeareThrowSpareException() throws SpeareException {
        Mockito.when(spearelGen.getSpeare()).thenReturn(2);
        frameImpl = new FrameImpl(spearelGen,2);

        frameImpl.getSpeare();
        frameImpl.getSpeare();

        Assertions.assertThrowsExactly(SpeareException.class,() -> frameImpl.getSpeare());
    }

    @Test
    void testStandardSpeareStrikeThrowException() throws SpeareException {
        Mockito.when(spearelGen.getSpeare()).thenReturn(10);
        frameImpl = new FrameImpl(spearelGen,2);

        frameImpl.getSpeare();

        Assertions.assertThrowsExactly(SpeareException.class,() -> frameImpl.getSpeare());
    }

    ///   Finale frame

    @Test
    void testFinaleSpeareStrikeDontThrowExeption() throws SpeareException {
        Mockito.when(spearelGen.getSpeare()).thenReturn(10);
        frameImpl = new FrameImpl(spearelGen,10);

        frameImpl.getSpeare();

        Assertions.assertDoesNotThrow(() -> frameImpl.getSpeare());
    }

    @Test
    void testFinaleSpeareStrikeIncreaseScore() throws SpeareException {
        Mockito.when(spearelGen.getSpeare()).thenReturn(10);
        frameImpl = new FrameImpl(spearelGen,10);

        frameImpl.getSpeare();
        frameImpl.getSpeare();

        Assertions.assertEquals(20, frameImpl.getScore());
    }

    @Test
    void testFinaleSpeareTwoMoreSpeareAfterStrokeDontThrowExeption() throws SpeareException {
        Mockito.when(spearelGen.getSpeare()).thenReturn(10);
        frameImpl = new FrameImpl(spearelGen,10);

        frameImpl.getSpeare();
        frameImpl.getSpeare();

        Assertions.assertDoesNotThrow(() -> frameImpl.getSpeare());
    }

    @Test
    void testFinaleSpeareTwoMoreSpeareAfterStrokeIncreaseScore() throws SpeareException {
        Mockito.when(spearelGen.getSpeare()).thenReturn(10);
        frameImpl = new FrameImpl(spearelGen,10);

        frameImpl.getSpeare();
        frameImpl.getSpeare();
        frameImpl.getSpeare();

        Assertions.assertEquals(30, frameImpl.getScore());
    }

    @Test
    void testFinaleSpeareOneMoreSpeareAfterSpareIncreaseScore() throws SpeareException {
        Mockito.when(spearelGen.getSpeare()).thenReturn(5);
        frameImpl = new FrameImpl(spearelGen,10);

        frameImpl.getSpeare();
        frameImpl.getSpeare();
        Mockito.when(spearelGen.getSpeare()).thenReturn(2);
        frameImpl.getSpeare();

        Assertions.assertEquals(12, frameImpl.getScore());
    }

    @Test
    void testFinaleSpeareOneMoreSpeareAfterSpareDontThrowException() throws SpeareException {

        frameImpl = new FrameImpl(spearelGen,10);
        Mockito.when(spearelGen.getSpeare()).thenReturn(3);
        frameImpl.getSpeare();
        Mockito.when(spearelGen.getSpeare()).thenReturn(7);
        frameImpl.getSpeare();

        Assertions.assertDoesNotThrow(() -> frameImpl.getSpeare());
    }

    @Test
    void testFinaleSpeareMoreTwoRegularSpeareThrowSpareException() throws SpeareException {
        Mockito.when(spearelGen.getSpeare()).thenReturn(3);
        frameImpl = new FrameImpl(spearelGen,10);

        frameImpl.getSpeare();
        frameImpl.getSpeare();

        Assertions.assertThrowsExactly(SpeareException.class,() -> frameImpl.getSpeare());
    }


    /// Bonus Frame

    @Test
    void testAddBonusShouldNotIncreaseScoreAfterTwoRegularSpear() throws SpeareException {

        Mockito.when(spearelGen.getSpeare()).thenReturn(3);
        frameImpl = new FrameImpl(spearelGen,3);
        frameImpl.getSpeare();
        frameImpl.getSpeare();

        frameImpl.addBonus(Arrays.asList(5,3));

        Assertions.assertEquals(6,frameImpl.getScore());
    }

    @Test
    void testAddBonusShouldIncreaseScoreAfterSpareWithTheOneNextSpear() throws SpeareException {

        Mockito.when(spearelGen.getSpeare()).thenReturn(5);
        frameImpl = new FrameImpl(spearelGen,3);
        frameImpl.getSpeare();
        frameImpl.getSpeare();

        frameImpl.addBonus(Arrays.asList(7,2));

        Assertions.assertEquals(17,frameImpl.getScore());
    }

    @Test
    void testAddBonusShouldIncreaseScoreAfterStrikeWithTheTwoNextSpear() throws SpeareException {

        Mockito.when(spearelGen.getSpeare()).thenReturn(10);
        frameImpl = new FrameImpl(spearelGen,3);
        frameImpl.getSpeare();

        frameImpl.addBonus(Arrays.asList(5,3));

        Assertions.assertEquals(18,frameImpl.getScore());
    }

    @Test
    void testAddBonusShouldIncreaseScoreAfterTwoStrikeWithTheOneNextSpear() throws SpeareException {

        Mockito.when(spearelGen.getSpeare()).thenReturn(10);
        frameImpl = new FrameImpl(spearelGen,3);
        frameImpl.getSpeare();

        frameImpl.addBonus(Arrays.asList(10));
        frameImpl.addBonus(Arrays.asList(7,0));


        Assertions.assertEquals(27,frameImpl.getScore());
    }

}
