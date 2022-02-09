package ku.cs.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {

    @Test
    void testGetDuration() {
        Food food = new Food("kitkat", "ของหวาน", 5, "แท่ง");
        food.setBuyIn("09/12/2021");
        assertEquals("62 days", food.getDurationInFridge());
    }
}