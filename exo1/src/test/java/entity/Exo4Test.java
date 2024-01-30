package entity;

import exception.NotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class Exo4Test {

    Towns tools = new Towns();

    @Test
    void throwNoFoundExceptIfOneCharSearch() {
         Assertions.assertThrowsExactly(NotFoundException.class, () -> {
            tools.townSearch("a");
        });
    }

    @Test
    void throwNoFoundExceptIfEmptySearch() {
        Assertions.assertThrowsExactly(NotFoundException.class, () -> {
            tools.townSearch("");
        });
    }

    @Test
    void shoudldNotThrowExceptIfWhenWordSearchIsGT1() {
        Assertions.assertDoesNotThrow(() -> {
            tools.townSearch("ab");
        });
    }

    @Test
    void FindValencienneAndVancoverWhenSearchIsVA(){
        List<String> rep = tools.townSearch("Va");
        Assertions.assertTrue(rep.containsAll(Arrays.asList("Valencienne","Vancouver")));
    }

    @Test
    void FindValencienneAndVancoverWhenSearchIsVAIgnoreCase(){
        List<String> rep = tools.townSearch("vA");
        Assertions.assertTrue(rep.containsAll(Arrays.asList("Valencienne","Vancouver")));
    }

    @Test
    void FindBudapestWhenSearchAPE() {
        List<String> rep = tools.townSearch("ape");
        Assertions.assertEquals(rep,Arrays.asList("Budapest"));
    }

    @Test
    void FindAllTownWhenSearchByAsterisk() {
        List<String> rep = tools.townSearch("*");
        Assertions.assertTrue(rep.containsAll(Arrays.asList("Paris", "Budapest", "Skopje", "Rotterdam", "Valence", "Vancouver", "Amsterdam", "Vienne", "Sydney", "New York", "Londres", "Bangkok", "Hong Kong", "Dubaï", "Rome", "Istanbul")));
    }

}
