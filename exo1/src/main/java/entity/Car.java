package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {

    private int rentDueIn;
    private int condition;
    private boolean isLuxuryCar;
    private int year;

    public void dailyRoutine(){
        rentDueIn--;
        int conditionChange;

        if (isLuxuryCar) {
            conditionChange = 1;
        } else {
            conditionChange= -1;
            if (rentDueIn < 0 ) conditionChange *= 2 ;
            if (LocalDate.now().getYear() - year  > 2 ) conditionChange *=2;
        }

        condition+=conditionChange;

        if (condition <0) condition = 0;
        if (condition > 100) condition = 100;


    }

}
