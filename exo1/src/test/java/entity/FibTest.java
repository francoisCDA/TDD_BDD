package entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

public class FibTest {

    private Fib fib;

    //Le résultat n’est pas vide
    @Test
    void givenFibSeriesRange1ExpectSize0() {

        fib = new Fib(1);
        List<Integer> list = fib.getFibSeries();
        Assertions.assertNotEquals(0, list.size());

    }

    // mal lu la consigne
    @Test
    void givenFibSerieRange1ExpectNotNull() {

        fib = new Fib(1);
        List<Integer> list = fib.getFibSeries();
        Assertions.assertNotEquals(null, list);
    }

    //Le résultat correspond à une liste qui contient {0}
    @Test
    void givenFibSerieRange1ExpectOneValueEqual0() {
        fib = new Fib(1);
        List<Integer> list = fib.getFibSeries();
        Assertions.assertEquals(Arrays.asList(0), list);
    }

    //Le résultat contient le chiffre 3
    @Test
    void givenFibSerieRange6ExpectContaint3() {
        fib = new Fib(6);
        List<Integer> list = fib.getFibSeries();
        Assertions.assertTrue(list.contains(3));
    }

    //Le résultat contient 6 éléments
    @Test
    void givenFibSerieRange6ExpectListSize6() {
        fib = new Fib(6);
        List<Integer> list = fib.getFibSeries();
        Assertions.assertEquals(6, list.size());
    }

    // Le résultat n’a pas le chiffre 4 en son sein
    @Test
    void givenFibSerieRange6ExpectContainsNot4() {
        fib = new Fib(6);
        List<Integer> list = fib.getFibSeries();
        Assertions.assertFalse(list.contains(4));
    }

    // Le résultat correspond à une liste qui contient {0, 1, 1, 2, 3, 5}
    // doit contenir peu import l'ordre
    @Test
    void givenFibSerieRange6Is0_1_1_2_3_5() {
        fib = new Fib(6);
        List<Integer> list = fib.getFibSeries();
        Assertions.assertTrue(list.containsAll(Arrays.asList(0,1,1,2,3,5)));
    }

    // Le résultat est trié de façon ascendance
    // la sortie attendue est connue
    @Test
    void givenFibSerieRange6ExpectIsAscending() {
        fib = new Fib(6);
        List<Integer> list = fib.getFibSeries();
        //List<Integer> listTriee = fib.getFibSeries();
        //Collections.sort(listTriee);
        //Assertions.assertEquals(list, listTriee);
        Assertions.assertEquals(list, Arrays.asList(0,1,1,2,3,5));
    }



}
