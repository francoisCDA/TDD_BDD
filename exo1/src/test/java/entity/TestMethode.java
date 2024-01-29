package entity;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
public class TestMethode {

    @Test
    void isDivisibleBy400() {
        Tools tools = new Tools();
        boolean bool = tools.isBissextile(400);
        Assertions.assertTrue(bool);
    }

    @Test
    void isDivisibleBy4(){
        Tools tools = new Tools();
        boolean bool = tools.isBissextile(4);
        Assertions.assertTrue(bool);
    }

    @Test
    void isNotDivisibleBy100(){
        Tools tools = new Tools();
        boolean bool = tools.isBissextile(100);
        Assertions.assertFalse(bool);
    }

    @Test
    void isDivisibleBy4000(){
        Tools tools = new Tools();
        boolean bool = tools.isBissextile(4000);
        Assertions.assertTrue(bool);
    }

}
