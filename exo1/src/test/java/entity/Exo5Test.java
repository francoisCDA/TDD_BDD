package entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class Exo5Test {

    ProductExo5 product;

    @BeforeEach
    void initTest(){
        product = new ProductExo5();
    }

    @Test
    void updateProductDecreaseSellin() {
        product.setSellin(20);
        product.setQuality(20);
        product.update();
        Assertions.assertEquals(19,product.getSellin());
    }

    @Test
    void updateProductDecreaseQuality() {
        product.setSellin(20);
        product.setQuality(20);
        product.update();
        Assertions.assertEquals(19,product.getQuality());
    }

    @Test
    void updateProductgetQualityDegradeTwiceWhenSellinNegative() {
        product.setSellin(-1);
        product.setQuality(20);
        product.update();
        Assertions.assertEquals(18,product.getQuality());
    }

    @Test
    void productUpdateQualityCantBeNegative(){
        product.setSellin(10);
        product.setQuality(0);
        product.update();
        Assertions.assertEquals(0,product.getQuality());
    }

    @Test
    void productUpdateBrieVielliQualityIncreaseWhenGetOlder(){
        product.setSellin(20);
        product.setQuality(25);
        product.setLabel("brie vieilli");
        product.update();
        Assertions.assertEquals(26,product.getQuality());
    }

    @Test
    void productUpdateQualityCantGeGT50(){
        product.setSellin(20);
        product.setQuality(50);
        product.setLabel("brie vieilli");
        product.update();
        Assertions.assertEquals(50,product.getQuality());
    }

    @Test
    void productUpdateDecreaseDairyProductQualityTwiceFaster(){
        product.setSellin(20);
        product.setQuality(20);
        product.setIsDairyProduct(true);
        product.update();
        Assertions.assertEquals(18,product.getQuality());
    }



}
