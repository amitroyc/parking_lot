package com.parking;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) throws FileNotFoundException {
        ParkingSpace[] parkingSpaces = null;
        String input = null;
        Scanner fileScanner = null;

        if(args.length != 0) {
            File file = new File(args[0]);
            fileScanner = new Scanner(file);
        }

        while (true) {
            try {
                if(fileScanner != null) {
                    input = fileScanner.nextLine();
                }
                else{
                    Scanner scanner = new Scanner(new InputStreamReader(System.in));
                    input = scanner.nextLine();
                }
                String[] strArrayInput = input.split(" ");
                parkingSpaces = ParkingLot.getParkingSpaces(parkingSpaces, strArrayInput);
            }catch (IndexOutOfBoundsException e){
                System.out.println("Invalid input");
            }catch (NoSuchElementException e){
                System.exit(0);
            }
        }
    }
}
