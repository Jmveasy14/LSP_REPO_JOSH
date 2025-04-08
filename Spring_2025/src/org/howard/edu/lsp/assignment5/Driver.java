package org.howard.edu.lsp.assignment5;

import java.util.ArrayList;
import java.util.List;

public class Driver {
    public static void main(String[] args) {
        // Create IntegerSet objects
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();

        // Add some elements to set1
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);

        // Add some elements to set2
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);

        // Print the sets
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);

        // Union operation
        set1.union(set2);
        System.out.println("Union of Set 1 and Set 2: " + set1);

        // Intersection operation
        set1.intersect(set2);
        System.out.println("Intersection of Set 1 and Set 2: " + set1);

        // Difference operation
        set1.diff(set2);
        System.out.println("Difference of Set 1 and Set 2: " + set1);

        // Complement operation
        set1.complement(set2);
        System.out.println("Complement of Set 1 relative to Set 2: " + set1);

        // Largest and smallest values
        System.out.println("Largest value in Set 2: " + set2.largest());
        System.out.println("Smallest value in Set 2: " + set2.smallest());
    }
}
