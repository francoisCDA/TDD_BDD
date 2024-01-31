package entity;

import java.util.Random;

public class SpeareGeneratorImpl implements SpeareGenerator {

    private Random random;

    private int pin;

    public SpeareGeneratorImpl(){
        random = new Random();
        pin = 10;
    }

    @Override
    public int getSpeare() {
        int pinFall = random.nextInt(pin +1);
        pin -= pinFall;
        if (pin == 0) pin = 10;
        return pinFall;
    }
}
