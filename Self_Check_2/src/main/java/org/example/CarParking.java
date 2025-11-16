package org.example;

import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class CarParking {
    private Stack<Car> cars = new Stack();
    private final int CAPACITY = 10;

    public void input() {
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

    public void process(String command, String plateNumber) {
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
                Stack<Car> temp = new Stack();
                int counter = 0;
                for (int i = 0; i < CAPACITY; i++) {
                    Car car = cars.pop();
                    temp.push(car);
                    counter++;
                    if (car.getPlateNumber().equals(plateNumber)) {
                        temp.pop();
                        break;
                    }
                }
                System.out.printf("Departure %s -> %d cars moved out.\n", plateNumber, counter);
                int loopSize = temp.size();
                for (int i = 0; i < loopSize; i++) {
                    Car car = temp.pop();
                    cars.push(car);
                    System.out.printf("Arrival %s -> There is room.\n", car.getPlateNumber());
                }
            } else {
                System.out.printf("Departure %s -> This car not in the garage.\n", plateNumber);
            }
        }
    }

    public void output() {
        cars.forEach(System.out::println);
    }

    public boolean isParked(String plateNumber) {
        for (Car car : cars) {
            if (plateNumber.equals(car.getPlateNumber())) {
                return true;
            }
        }
        return false;
    }
}
