package org.howard.edu.lsp.assignment5;

import java.util.List;
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        // Create two sets
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);

        List<Integer> list2 = new ArrayList<>();
        list2.add(3);
        list2.add(4);
        list2.add(5);
        list2.add(6);

        IntegerSet set1 = new IntegerSet(list1);
        IntegerSet set2 = new IntegerSet(list2);

        // Print the sets
        System.out.println("Set 1: " + set1);
        System.out.println("Set 2: " + set2);

        // Union of set1 and set2
        set1.union(set2);
        System.out.println("Union of Set 1 and Set 2: " + set1);

        // Intersection of set1 and set2
        set1.intersect(new IntegerSet(list2)); // Reset set1 to original list1
        System.out.println("Intersection of Set 1 and Set 2: " + set1);

        // Difference of set1 and set2
        set1.diff(new IntegerSet(list2)); // Reset set1 to original list1
        System.out.println("Difference of Set 1 and Set 2: " + set1);

        // Complement of set1 relative to set2
        set1.complement(new IntegerSet(list2)); // Reset set1 to original list1
        System.out.println("Complement of Set 1 relative to Set 2: " + set1);

        // Find largest and smallest elements in set2
        System.out.println("Largest value in Set 2: " + set2.largest());
        System.out.println("Smallest value in Set 2: " + set2.smallest());
    }
}
