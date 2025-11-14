package org.example;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class CarParking {
    private static Stack<Car> cars = new Stack();
    private static final int CAPACITY = 10;

    static void main() {
        input();
    }

    public static void input() {
        try (BufferedReader br = new BufferedReader(new FileReader("src/main/resources/cars.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String command = line.split("\\s+")[0];
                String plateNumber = line.split("\\s+")[1];
                process(command, plateNumber);
                output();
                System.out.println();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void process(String command, String plateNumber) {
        if (command.equals("A")) {
            if (cars.size() < CAPACITY) {
                Car car = new Car(plateNumber);
                cars.add(car);
                System.out.printf("Arrival %s -> There is room.\n", plateNumber);
            } else {
                System.out.printf("Arrival %s -> Garage full, this car cannot enter.\n", plateNumber);
            }
        } else if (command.equals("D")) {
            if (isParked(plateNumber)) {
                int counter = 0;
                for (int i = 0; i < CAPACITY; i++) {
                    Car car = cars.pop();
                    counter++;
                    if (car.getPlateNumber().equals(plateNumber)) {
                        break;
                    }
                }
                System.out.printf("Departure %s -> %d cars moved out.\n", plateNumber, counter);
            } else {
                System.out.printf("Departure %s -> This car not in the garage.\n", plateNumber);
            }
        }
    }

    public static void output() {
        cars.forEach(System.out::println);
    }

    public static boolean isParked(String plateNumber) {
        for (Car car : cars) {
            if (plateNumber.equals(car.getPlateNumber())) {
                return true;
            }
        }
        return false;
    }
}
