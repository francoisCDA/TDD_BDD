package entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GradingCalculatorTest {


    @Test
    void getGradeTestA() {
        GradingCalculator gradingCalculator = new GradingCalculator();

        gradingCalculator.setScore(95);
        gradingCalculator.setAttendancePercentage(90);
        char grade = gradingCalculator.getGrade();

        Assertions.assertEquals('A',grade);
    }

    @Test
    void getGradeTestB1() {
        GradingCalculator gradingCalculator = new GradingCalculator();

        gradingCalculator.setScore(85);
        gradingCalculator.setAttendancePercentage(90);
        char grade = gradingCalculator.getGrade();

        Assertions.assertEquals('B',grade);
    }

    @Test
    void getGradeTestC1() {
        GradingCalculator gradingCalculator = new GradingCalculator();

        gradingCalculator.setScore(65);
        gradingCalculator.setAttendancePercentage(90);
        char grade = gradingCalculator.getGrade();

        Assertions.assertEquals('C',grade);
    }

    @Test
    void getGradeTestB2() {
        GradingCalculator gradingCalculator = new GradingCalculator();

        gradingCalculator.setScore(95);
        gradingCalculator.setAttendancePercentage(65);
        char grade = gradingCalculator.getGrade();

        Assertions.assertEquals('B',grade);
    }

    @Test
    void getGradeTestF1() {
        GradingCalculator gradingCalculator = new GradingCalculator();

        gradingCalculator.setScore(95);
        gradingCalculator.setAttendancePercentage(55);
        char grade = gradingCalculator.getGrade();

        Assertions.assertEquals('F',grade);
    }

    @Test
    void getGradeTestF2() {
        GradingCalculator gradingCalculator = new GradingCalculator();

        gradingCalculator.setScore(65);
        gradingCalculator.setAttendancePercentage(55);
        char grade = gradingCalculator.getGrade();

        Assertions.assertEquals('F',grade);
    }

    @Test
    void getGradeTestF3() {
        GradingCalculator gradingCalculator = new GradingCalculator();

        gradingCalculator.setScore(50);
        gradingCalculator.setAttendancePercentage(90);
        char grade = gradingCalculator.getGrade();

        Assertions.assertEquals('F',grade);
    }

}
