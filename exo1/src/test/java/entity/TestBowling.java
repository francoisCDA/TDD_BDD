package entity;


import exception.SpeareException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class TestBowling {

    @Mock
    private SpeareGenerator spearelGen;

    private Frame frame;

    @Test
    void testStandardFrameOneSpeareIncreaseScore() throws SpeareException {
        Mockito.when(spearelGen.getSpeare()).thenReturn(5);
        frame = new Frame(spearelGen,2);

        frame.getSpeare();

        Assertions.assertEquals(5,frame.getScore());
    }

    @Test
    void testStandardFrameTwoSpeareIncreaseScore() throws SpeareException {
        Mockito.when(spearelGen.getSpeare()).thenReturn(5);
        frame = new Frame(spearelGen,2);

        frame.getSpeare();
        frame.getSpeare();

        Assertions.assertEquals(10,frame.getScore());
    }

    @Test
    void testStandardFrameThreeSpeareThrowSpeareException() throws SpeareException {
        Mockito.when(spearelGen.getSpeare()).thenReturn(5);
        frame = new Frame(spearelGen,2);

        frame.getSpeare();
        Mockito.when(spearelGen.getSpeare()).thenReturn(4);
        frame.getSpeare();

        Assertions.assertEquals(9,frame.getScore());
    }

    @Test
    void testStandard3SpeareThrowSpareException() throws SpeareException {
        Mockito.when(spearelGen.getSpeare()).thenReturn(2);
        frame = new Frame(spearelGen,2);

        frame.getSpeare();
        frame.getSpeare();

        Assertions.assertThrowsExactly(SpeareException.class,() -> frame.getSpeare());
    }

    @Test
    void testStandardSpeareStrikeThrowException() throws SpeareException {
        Mockito.when(spearelGen.getSpeare()).thenReturn(10);
        frame = new Frame(spearelGen,2);

        frame.getSpeare();

        Assertions.assertThrowsExactly(SpeareException.class,() -> frame.getSpeare());
    }

    ///   Finale frame

    @Test
    void testFinaleSpeareStrikeDontThrowExeption() throws SpeareException {
        Mockito.when(spearelGen.getSpeare()).thenReturn(10);
        frame = new Frame(spearelGen,10);

        frame.getSpeare();

        Assertions.assertDoesNotThrow(() -> frame.getSpeare());
    }

    @Test
    void testFinaleSpeareStrikeIncreaseScore() throws SpeareException {
        Mockito.when(spearelGen.getSpeare()).thenReturn(10);
        frame = new Frame(spearelGen,10);

        frame.getSpeare();
        frame.getSpeare();

        Assertions.assertEquals(20,frame.getScore());
    }

    @Test
    void testFinaleSpeareTwoMoreSpeareAfterStrokeDontThrowExeption() throws SpeareException {
        Mockito.when(spearelGen.getSpeare()).thenReturn(10);
        frame = new Frame(spearelGen,10);

        frame.getSpeare();
        frame.getSpeare();

        Assertions.assertDoesNotThrow(() -> frame.getSpeare());
    }

    @Test
    void testFinaleSpeareTwoMoreSpeareAfterStrokeIncreaseScore() throws SpeareException {
        Mockito.when(spearelGen.getSpeare()).thenReturn(10);
        frame = new Frame(spearelGen,10);

        frame.getSpeare();
        frame.getSpeare();
        frame.getSpeare();

        Assertions.assertEquals(30,frame.getScore());
    }

    @Test
    void testFinaleSpeareOneMoreSpeareAfterSpareIncreaseScore() throws SpeareException {
        Mockito.when(spearelGen.getSpeare()).thenReturn(5);
        frame = new Frame(spearelGen,10);

        frame.getSpeare();
        frame.getSpeare();
        frame.getSpeare();

        Assertions.assertEquals(15,frame.getScore());
    }

    @Test
    void testFinaleSpeareOneMoreSpeareAfterSpareDontThrowException() throws SpeareException {
        Mockito.when(spearelGen.getSpeare()).thenReturn(5);
        frame = new Frame(spearelGen,10);

        frame.getSpeare();
        frame.getSpeare();

        Assertions.assertDoesNotThrow(() -> frame.getSpeare());
    }

    @Test
    void testFinaleSpeareMoreTwoRegularSpareThrowSpareException() throws SpeareException {
        Mockito.when(spearelGen.getSpeare()).thenReturn(3);
        frame = new Frame(spearelGen,10);

        frame.getSpeare();
        frame.getSpeare();

        Assertions.assertThrowsExactly(SpeareException.class,() -> frame.getSpeare());
    }

}
