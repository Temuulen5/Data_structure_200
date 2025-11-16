package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarParkingTest {
    @Test
    void testArrival() {
        CarParking carParking = new CarParking();
        carParking.process("A", "UB11-11");
        assertTrue(carParking.isParked("UB11-11"));
    }

    @Test
    void testGarageFull() {
        CarParking carParking = new CarParking();
        for (int i = 0; i < 10; i++)
            carParking.process("A", "CAR-" + i);

        carParking.process("A", "CAR-11");
        assertFalse(carParking.isParked("CAR-11"));
    }

    @Test
    void testDeparture() {
        CarParking carParking = new CarParking();
        carParking.process("D", "UB11-11");
        assertFalse(carParking.isParked("UB11-11"));
    }

    @Test
    void testDepartureFail() {
        CarParking carParking = new CarParking();
        carParking.process("D", "ZZ99-99");
        assertFalse(carParking.isParked("ZZ99-99"));
    }

    @Test
    void testIsParked() {
        CarParking carParking = new CarParking();
        carParking.process("A", "AA11-11");
        assertTrue(carParking.isParked("AA11-11"));
        assertFalse(carParking.isParked("BB22-22"));
    }с

    @Test
    void testOutput() {
        CarParking carParking = new CarParking();
        carParking.process("A", "UB11-11");
        carParking.process("A", "UB22-22");
        carParking.output();
    }
}
