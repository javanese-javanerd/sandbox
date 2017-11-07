package Quizzes;

import java.util.ArrayList;

import java.util.Collections;

import java.util.List;

public class ListTest{

	/**
	 * What will be printed?
	 * 
	 * @param args
	 */
    public static void main(String[] args) {

        final List<Integer> list = new ArrayList<Integer>();
        Collections.addAll(list, 1, 5, 2, 3, 7, 3, 8, 9);

        // get the position of first 3 in the list.
        final Integer pos = Integer.valueOf(3);

        list.remove(pos);

        System.out.println(list);

    }

}