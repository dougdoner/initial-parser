package org.dougdoner;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(System.in);

            System.out.print("Enter csv filename: ");
            String fileName = sc.nextLine();

            var nameList = new CSVParser(new BufferedReader(new FileReader(fileName)), CSVFormat.EXCEL);

            var personList = new ArrayList<Person>();

            for (CSVRecord csvRecord : nameList) {
                String firstName = csvRecord.get(1);
                String lastName = csvRecord.get(2);

                personList.add(new Person(firstName, lastName));
            }

            nameList.close();

            String inputString;

            do {
                System.out.print("Enter initials or type 'quit': ");
                String inputInitials = sc.nextLine();
                inputString = inputInitials;

                System.out.println();

                List<Person> filteredList = personList.stream()
                        .filter(item -> item.equalsInitials(inputInitials))
                        .collect(Collectors.toList());

                if(!inputString.toLowerCase().equals("quit"))
                    System.out.println("Possible names: ");

                filteredList.forEach(System.out::println);
                System.out.println();
            } while(!inputString.toLowerCase().equals("quit"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
