package entity;

import java.util.ArrayList;
import java.util.List;

public class Tools {



    public boolean isBissextile(int year){

        return year%400 == 0 || (year%4 == 0 && year%100 != 0);
//
//        if (year%400 == 0 ) return true;
//        if (year%100 == 0) return false;
//        if (year%4 == 0) return true;
//        return false;
    }



}
