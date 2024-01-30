package entity;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class TestLePendu {

    @Mock
    private LePenduImpl lePendu;

    @Mock
    private WordGeneratorImpl wordGenerator;

    private List<String> wordsTest = Arrays.asList("ordinateur","processeur","stagiaire");


    @BeforeEach
    void setUp(){
        wordGenerator = new WordGeneratorImpl(wordsTest);
    }

    @Test
    void testCheckStarIsTrueWhenCharIsInWord(){
        lePendu = new LePenduImpl(wordGenerator);
        Mockito.when(wordGenerator.getWord()).thenReturn("table");
        lePendu.tryChar('a');
        Assertions.assertEquals(lePendu.getMasque(),"_a___");
    }

    @Test
    void testCheckStarIsFalseWhenCharIsntInWord(){
        lePendu = new LePenduImpl(wordGenerator);
        Mockito.when(wordGenerator.getWord()).thenReturn("table");
        lePendu.tryChar('z');
        Assertions.assertEquals(lePendu.getMasque(),"_z___");
    }

    @Test
    void testPlayerWinWhenAllCharAreFind(){
        lePendu = new LePenduImpl(wordGenerator);
        Mockito.when(wordGenerator.getWord()).thenReturn("table");
        Mockito.when(lePendu.getChars()).thenReturn(Arrays.asList('a','e','b','l','t'));
        Assertions.assertTrue(lePendu.isPlayerWin());
    }



}
