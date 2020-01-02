package com.parking;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestParkingLot {

    private Car car1;
    private Car car2;
    private Car car3;
    private ParkingSpace[] parkingSpace;

    @Before
    public void intializeTestEnvironment() throws Exception {

        this.parkingSpace = new ParkingSpace[4];

        ParkingLot.parkCar(parkingSpace, "1234", "White");
        ParkingLot.parkCar(parkingSpace, "4567", "Black");
        ParkingLot.parkCar(parkingSpace, "0000", "Red");
    }

    @Test
    public void testParkCar(){
        Car newCar = ParkingLot.parkCar(parkingSpace, "1235", "Red");
        Assert.assertEquals("Red", newCar.getColour());
        Assert.assertEquals("1235" , newCar.getStrRegistrationNo());
    }

    @Test
    public void testGetCarsWithColor(){
       // ParkingLot.getCarsWithColor(parkingSpace, "Black", true, false);
    }

    @Test
    public void testSlotForRegistration(){
        int slot = ParkingLot.slotForRegistrationNo(parkingSpace,"4567");
        Assert.assertEquals(2, slot);
    }
}
