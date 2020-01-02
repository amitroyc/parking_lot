package com.parking;

public class ParkingLot {

    public static ParkingSpace[] getParkingSpaces(ParkingSpace[] parkingSpaces, String[] strArrayInput) {

        if (strArrayInput[0].toLowerCase().equalsIgnoreCase(CommandConstants.CREATE_PARKING_LOT) && strArrayInput[1] != null) {
            parkingSpaces = new ParkingSpace[Integer.parseInt(strArrayInput[1])];
            System.out.println("Created a parking lot with " + strArrayInput[1] + " slots");
        } else if (strArrayInput[0].toLowerCase().equals(CommandConstants.PARK) && strArrayInput[1] != null && strArrayInput[2] != null) {
            String registrationNo = strArrayInput[1];
            String colour = strArrayInput[2];
            parkCar(parkingSpaces, registrationNo, colour);
        } else if (strArrayInput[0].toLowerCase().equals(CommandConstants.LEAVE) && strArrayInput[1] != null) {
            parkingSpaces[Integer.parseInt(strArrayInput[1]) -1 ] = null;
            System.out.println("Slot number " + strArrayInput[1] + " is free");
        } else if (strArrayInput[0].toLowerCase().equals(CommandConstants.STATUS)) {
            printStatus(parkingSpaces);
        } else if (strArrayInput[0].toLowerCase().equals(CommandConstants.REGISTRATION_NUMBERS_FOR_CARS_WITH_COLOUR)
                && strArrayInput[1] != null) {
            String colour = strArrayInput[1];
            getCarsWithColor(parkingSpaces, colour,true,false);
        } else if (strArrayInput[0].toLowerCase().equals(CommandConstants.SLOT_NUMBERS_FOR_CARS_WITH_COLOUR)
                && strArrayInput[1] != null) {
            String colour = strArrayInput[1];
            getCarsWithColor(parkingSpaces, colour,false,true);
        } else if (strArrayInput[0].toLowerCase().equals(CommandConstants.SLOT_NUMBER_FOR_REGISTRATION_NUMBER)
                && strArrayInput[1] != null) {
            String registrationNo = strArrayInput[1];
            slotForRegistrationNo(parkingSpaces, registrationNo);
        } else
            System.exit(0);
        return parkingSpaces;
    }

    public static int slotForRegistrationNo(ParkingSpace[] parkingSpaces, String registrationNo) {
        char flag = 'N';
        for (int i = 0; i < parkingSpaces.length; i++) {
            if (parkingSpaces[i].getCar().strRegistrationNo.equalsIgnoreCase(registrationNo)) {
                System.out.println(i+1);
                flag = 'Y';
                return i+1;
            }
        }
        if (flag == 'N')
            System.out.println("Not found");
        return 0;
    }

    public static void getCarsWithColor(ParkingSpace[] parkingSpaces, String colour,boolean isRegistrationNo, boolean isSlot) {
        for (int i = 0; i < parkingSpaces.length; i++) {
            if (parkingSpaces[i].getCar().colour.equalsIgnoreCase(colour)) {
                if(isRegistrationNo)
                    System.out.print(parkingSpaces[i].getCar().strRegistrationNo + ", ");
                if(isSlot)
                    System.out.print((i+1) + ", ");
            }
        }
        System.out.println();
    }

    public static Car parkCar(ParkingSpace[] parkingSpaces, String registrationNo, String colour) {
        Car newCar = new Car(registrationNo, colour);
        char flag = 'N';
        for (int i = 0; i < parkingSpaces.length; i++) {
            if (parkingSpaces[i] == null) {
                parkingSpaces[i] = new ParkingSpace(newCar, i+1);
                flag = 'Y';
                break;
            }
        }
        if (flag == 'N') {
            System.out.println("Sorry, parking lot is full");
            return null;
        }
        return newCar;
    }

    public static void printStatus(ParkingSpace[] parkingSpaces) {
        System.out.println("Slot No. \t\t Registration No \t\t Colour");
        for (int i = 0; i < parkingSpaces.length; i++) {
            if (parkingSpaces[i] != null) {
                System.out.println("" + (i+1) + "\t\t" + parkingSpaces[i].getCar());
            }
        }
    }

}
