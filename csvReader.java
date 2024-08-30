// File path: src/com/example/csvreader/CSVReader.java

package com.example.csvreader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Person {
    private String name;
    private int age;
    private String email;

    public Person(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }

    // Getters and setters can be added here if needed
}

public class CSVReader {
    public static void main(String[] args) {
        String csvFile = "path/to/your/file.csv";
        String line;
        String csvSplitBy = ",";

        List<Person> persons = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] data = line.split(csvSplitBy);

                // Assuming CSV has format: name, age, email
                String name = data[0];
                int age = Integer.parseInt(data[1]);
                String email = data[2];

                Person person = new Person(name, age, email);
                persons.add(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Output all persons
        for (Person person : persons) {
            System.out.println(person);
        }
    }
}
