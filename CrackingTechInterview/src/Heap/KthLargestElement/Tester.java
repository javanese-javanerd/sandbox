package Heap.KthLargestElement;

import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Tester {
    public static void main(String args[]) {
        int k1 = 3;
        int[] arr1 = {4,5,8,2};

        int k2 = 1;
        int[] arr2 = {};

        Instant start = Instant.now();
        KthLargest kthLargest = new KthLargest(k1, arr1);
        kthLargest.add(3);
        kthLargest.add(5);
        kthLargest.add(10);
        kthLargest.add(9);
        kthLargest.add(4);
        Instant finish = Instant.now();
        System.out.println("Execution time of test case #1 (efficient solution): " + Duration.between(start, finish).toMillis() + " millisecond");

        start = Instant.now();
        KthLargestInefficient kthLargestInefficient = new KthLargestInefficient(k1, arr1);
        kthLargestInefficient.add(3);
        kthLargestInefficient.add(5);
        kthLargestInefficient.add(10);
        kthLargestInefficient.add(9);
        kthLargestInefficient.add(4);
        finish = Instant.now();
        System.out.println("Execution time of test case #1 (brute-force solution): " + Duration.between(start, finish).toMillis() + " millisecond");

        start = Instant.now();
        kthLargest = new KthLargest(k2, arr2);
        kthLargest.add(-3);
        kthLargest.add(-2);
        kthLargest.add(-4);
        kthLargest.add(0);
        kthLargest.add(4);
        finish = Instant.now();
        System.out.println("Execution time of test case #2 (efficient solution): " + Duration.between(start, finish).toMillis() + " millisecond");

        start = Instant.now();
        kthLargestInefficient = new KthLargestInefficient(k2, arr2);
        kthLargestInefficient.add(-3);
        kthLargestInefficient.add(-2);
        kthLargestInefficient.add(-4);
        kthLargestInefficient.add(0);
        kthLargestInefficient.add(4);
        finish = Instant.now();
        System.out.println("Execution time of test case #2 (brute-force solution): " + Duration.between(start, finish).toMillis() + " millisecond");

        // Runtime: ~54 milliseconds
        try {
            List<Integer> initialValues = readFile("ArrayData.txt");
            List<Integer> toBeAddedValues = readFile("AddData.txt");

            int[] initialArrays = initialValues.stream().mapToInt(Integer::valueOf).toArray();
            start = Instant.now();
            KthLargest kthLargest2 = new KthLargest(9999, initialArrays);
            toBeAddedValues.forEach(e -> {
                kthLargest2.add(e);
            });
            finish = Instant.now();
            System.out.println("Execution time of test case #3 (efficient solution): " + Duration.between(start, finish).toMillis() + " millisecond");
        }
        catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

        // Runtime: ~9 minutes
//        try {
//            List<Integer> initialValues = readFile("ArrayData.txt");
//            List<Integer> toBeAddedValues = readFile("AddData.txt");
//
//            int[] initialArrays = initialValues.stream().mapToInt(Integer::valueOf).toArray();
//            start = Instant.now();
//            KthLargestInefficient kthLargestInefficient2 = new KthLargestInefficient(9999, initialArrays);
//            toBeAddedValues.forEach(e -> {
//                kthLargestInefficient2.add(e);
//            });
//            finish = Instant.now();
//            System.out.println("Execution time of test case #3 (brute-force solution): " + Duration.between(start, finish).toMillis() + " millisecond");
//        }
//        catch (IOException ioe) {
//            System.err.println(ioe.getMessage());
//        }
    }

    private static List<Integer> readFile(String filename) throws IOException {
        List<Integer> retCollection = new ArrayList<>();
        String currentDirectory = System.getProperty("user.dir") + File.separator
                + "src" + File.separator + "Heap/KthLargestElement" + File.separator;

        StreamTokenizer arrayDataTokenizer = new StreamTokenizer(new FileReader(currentDirectory + filename));
        int currentToken = arrayDataTokenizer.nextToken();
        while (currentToken != StreamTokenizer.TT_EOF) {
            if (arrayDataTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                retCollection.add((int)arrayDataTokenizer.nval);
            }
            currentToken = arrayDataTokenizer.nextToken();
        }
//        System.out.println("retCollection size: " + retCollection.size());

        return retCollection;
    }
}
