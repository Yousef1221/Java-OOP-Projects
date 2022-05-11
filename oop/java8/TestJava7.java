/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javase.oop.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;

/**
 *
 * @author CC-Student
 */
public class TestJava7 {

    public static void main(String[] args) {

        ArrayList<Person> personsList = new ArrayList();
        Person p1 = new Person(101, "P1_vorName", "P1_nachName", 30);
        Person p2 = new Person(102, "P2_vorName", "P2_nachName", 31);
        Person p3 = new Person(103, "P3_vorName", "P3_nachName", 25);
        Person p4 = new Person(104, "P4_vorName", "P4_nachName", 40);

        personsList.add(p1);
        personsList.add(p2);
        personsList.add(p3);
        personsList.add(p4);
        System.out.println("------ sort persons ----");
        /// Anonymous class  
        SortPersons sp = new SortPersons();
        Collections.sort(personsList, new Comparator<Person>() {
            @Override
            public int compare(Person per1, Person per2) {
                if (per1.getPersonLastName().
                        compareTo(per2.getPersonLastName()) == 1) {
                    return 1;
                } else if (per1.getPersonLastName().
                        compareTo(per2.getPersonLastName()) == -1) {
                    return -1;
                } else {
                    return 0;
                }
            }

        });

        // printing all persons
        System.out.println("------ printing all persons --------");
        printAllPersons(personsList);

        System.out.println("------ Filter Search by persons with letter A ----");
        filter(personsList, new Conditional() {

            @Override
            public boolean search(Person p) {
                return p.getPersonFirstName().startsWith("A");
            }
        });
        System.out.println("+++++ foreach with new style ++++++");
        personsList.forEach(new Consumer<Person>() {
            @Override
            public void accept(Person p) {
                System.out.println("p id = " + p.getPersonId());
            }

        });
    }

    public static void printAllPersons(ArrayList<Person> personsList) {
        for (Person p : personsList) {
            System.out.print("\nPeson id : " + p.getPersonId());
            System.out.print(", Person f name : " + p.getPersonFirstName());
            System.out.print(", Person l name : " + p.getPersonLastName());
            System.out.print(", Person Age : " + p.getPersonAge());
        }
        System.out.println("");
    }

    public static void printPersonsStartA(ArrayList<Person> personsList) {
        for (Person p : personsList) {
            if (p.getPersonFirstName().startsWith("A")) {
                System.out.print("\nPeson id : " + p.getPersonId());
                System.out.print(", Person f name : " + p.getPersonFirstName());
                System.out.print(", Person l name : " + p.getPersonLastName());
                System.out.print(", Person Age : " + p.getPersonAge());
            }
        }
        System.out.println("");
    }

    /// like sort method 
    public static void filter(ArrayList<Person> personsList,
            Conditional condition) {
        for (Person p : personsList) {
            if (condition.search(p) == true) {
                System.out.print("\nPeson id : " + p.getPersonId());
                System.out.print(", Person f name : " + p.getPersonFirstName());
                System.out.print(", Person l name : " + p.getPersonLastName());
                System.out.print(", Person Age : " + p.getPersonAge());
            }
        }
        System.out.println("");
    }

    interface Conditional {

        public abstract boolean search(Person p);
    }

}
