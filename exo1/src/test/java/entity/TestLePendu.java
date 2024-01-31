package entity;

import exception.MoreNineMistakeException;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class TestLePendu {


    private LePendu lePendu;

    @Mock
    private WordGenerator wordGenerator;

    private List<String> wordsTest = Arrays.asList("ordinateur","processeur","stagiaire");


    @Test
    void testCheckMasqueWhenCharIsInWord() throws MoreNineMistakeException {
        Mockito.when(wordGenerator.getWord()).thenReturn("table");
        lePendu = new LePendu(wordGenerator);
        lePendu.tryChar('a');
        Assertions.assertEquals("_a___",lePendu.getMasque());
    }

    @Test
    void testCheckMasqueWhenNewCharIsInWord() throws MoreNineMistakeException {
        Mockito.when(wordGenerator.getWord()).thenReturn("table");
        lePendu = new LePendu(wordGenerator);
        lePendu.setChars(Arrays.asList('a'));
        lePendu.tryChar('b');
        Assertions.assertEquals("_ab__",lePendu.getMasque());
    }

    @Test
    void testCheckMasqueWhen2CharIsInWord() throws MoreNineMistakeException {
        Mockito.when(wordGenerator.getWord()).thenReturn("tabula");
        lePendu = new LePendu(wordGenerator);
        lePendu.tryChar('a');
        Assertions.assertEquals("_a___a",lePendu.getMasque());
    }

    @Test
    void testCheckMasqueWhenCharIsntInWord() throws MoreNineMistakeException {
        Mockito.when(wordGenerator.getWord()).thenReturn("table");
        lePendu = new LePendu(wordGenerator);
        lePendu.tryChar('z');
        Assertions.assertEquals("_____",lePendu.getMasque());
    }

    @Test
    void testCheckMasqueWhenSecondCharIsntInWord() throws MoreNineMistakeException {
        Mockito.when(wordGenerator.getWord()).thenReturn("table");
        lePendu = new LePendu(wordGenerator);
        lePendu.setChars(Arrays.asList('a'));
        lePendu.tryChar('z');
        Assertions.assertEquals("_a___",lePendu.getMasque());
    }

    @Test
    void testPlayerWinWhenAllCharAreFind(){
        Mockito.when(wordGenerator.getWord()).thenReturn("table");
        lePendu = new LePendu(wordGenerator);
        lePendu.setChars(Arrays.asList('a','e','b','l','t'));
        Assertions.assertTrue(lePendu.isPlayerWin());
    }

    @Test
    void testTryCharIncreaseTryCounter() throws MoreNineMistakeException {
        Mockito.when(wordGenerator.getWord()).thenReturn("table");
        lePendu = new LePendu(wordGenerator);
        lePendu.tryChar('z');
        Assertions.assertEquals(1,lePendu.getMistakeCount());
    }

    @Test
    void testTryCharThrowsMoreNineMistakeExceptionWhenMistakeCountEgals9(){
        Mockito.when(wordGenerator.getWord()).thenReturn("table");
        lePendu = new LePendu(wordGenerator);
        lePendu.setMistakeCount(9);
        Assertions.assertThrows(MoreNineMistakeException.class,() -> lePendu.tryChar('z') );
    }



}
