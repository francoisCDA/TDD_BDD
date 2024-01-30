package entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    }

}
