package com.clearsolutions.demotask.validator;

import java.time.LocalDate;
import java.time.Period;

public class AgeValidator {

    public static boolean isValidAge(LocalDate date,int systemAge){
        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(date,currentDate);
        int age = period.getYears();
        return age >= systemAge;
    }

}
