package entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Exo6Test {

    private Car car;

    @BeforeEach
    void initTest(){
        car = new Car();
    }

    @Test
    void dailyRountineDecreaseRentDueIn(){
        car.setRentDueIn(20);
        car.setCondition(50);
        car.dailyRoutine();

        Assertions.assertEquals(19,car.getRentDueIn());
    }

    @Test
    void dailyRountineDecreaseCondition(){
        car = Car.builder().rentDueIn(20).condition(50).isLuxuryCar(false).year(2023).build();

        car.dailyRoutine();

        Assertions.assertEquals(49,car.getCondition());
    }

    @Test
    void dailyRountineDecreaseOldCarConditionFaster(){
        car.setRentDueIn(20);
        car.setCondition(50);
        car.setYear(2015);
        car.dailyRoutine();

        Assertions.assertEquals(48,car.getCondition());
    }

    @Test
    void dailyRountineIncreaseLuxuryCarCondition(){
        car.setRentDueIn(20);
        car.setCondition(50);
        car.setLuxuryCar(true);
        car.dailyRoutine();

        Assertions.assertEquals(51,car.getCondition());
    }

    @Test
    void dailyRountineDecreaseConditionFasterWhenRentDueInIsNegative(){
        car = Car.builder().rentDueIn(-1).condition(50).isLuxuryCar(false).year(2023).build();
        car.dailyRoutine();

        Assertions.assertEquals(48,car.getCondition());
    }

    @Test
    void dailyRoutineConditionCantBeNegative(){
        car.setRentDueIn(20);
        car.setCondition(0);
        car.dailyRoutine();

        Assertions.assertEquals(0,car.getCondition());
    }

    @Test
    void dailyRoutineConditionCantBeGT100(){
        car.setRentDueIn(20);
        car.setCondition(100);
        car.setLuxuryCar(true);
        car.dailyRoutine();

        Assertions.assertEquals(100,car.getCondition());
    }







}
