package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CarParkingTest {

    @Test
    void testArrival() {
        CarParking.process("A", "UB11-11");
        assertTrue(CarParking.isParked("UB11-11"));
    }

    @Test
    void testGarageFull() {
        for (int i = 0; i < 10; i++)
            CarParking.process("A", "CAR-" + i);

        CarParking.process("A", "CAR-11");
        assertFalse(CarParking.isParked("CAR-11"));
    }

    @Test
    void testDeparture() {
        CarParking.process("D", "UB11-11");
        assertFalse(CarParking.isParked("UB11-11"));
    }

    @Test
    void testDepartureFail() {
        CarParking.process("D", "ZZ99-99");
        assertFalse(CarParking.isParked("ZZ99-99"));
    }

    @Test
    void testIsParked() {
        CarParking.process("A", "AA11-11");
        assertTrue(CarParking.isParked("AA11-11"));
        assertFalse(CarParking.isParked("BB22-22"));
    }

    @Test
    void testOutput() {
        CarParking.process("A", "UB11-11");
        CarParking.process("A", "UB22-22");
        CarParking.output();
    }
}
