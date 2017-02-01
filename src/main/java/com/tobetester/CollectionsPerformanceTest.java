package com.tobetester;

import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class CollectionsPerformanceTest {

   public static void main(final String[] args) {
      List<Integer> measures;

      measures = new ArrayList<>(); // clear

      System.out.println("\nHashSet test");
      long start = System.nanoTime();
      for (int i = 0; i < 10; i++) {
         hashSetTest();
         measures.add((int) (System.nanoTime() - start));
      }
//            measures.forEach(System.out::println);
      System.out.println("time = " + measures.stream().mapToInt(Integer::intValue).sum() / 10);

      measures = new ArrayList<>(); // clear

      System.out.println("\nArrayList test");
      start = System.nanoTime();
      for (int i = 0; i < 10; i++) {
         arrayListTest();
         measures.add((int) (System.nanoTime() - start));
      }
//            measures.forEach(System.out::println);
      System.out.println("time = " + measures.stream().mapToInt(Integer::intValue).sum() / 10);

      measures = new ArrayList<>(); // clear

      System.out.println("BitSet test");
      start = System.nanoTime();
      for (int i = 0; i < 10; i++) {
         bitSetTest();
         measures.add((int) (System.nanoTime() - start));
      }
//            measures.forEach(System.out::println);
      System.out.println("time = " + measures.stream().mapToInt(Integer::intValue).sum() / 10);
   }

   private static void bitSetTest() {
      BitSet bitSet = new BitSet(100);
      for (int i = 0; i < 1100; i+=10) {
         bitSet.set(i);
      }
      for (int i = 0; i < 10; i++) {
         final int random = Math.abs(new Random().nextInt()) % 11; // random between 0 and 10
         bitSet.get(random);
      }
   }

   private static void hashSetTest() {
      Set<Integer> hashSet = Sets.newHashSet(0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
      for (int i = 0; i < 100; i++) {
         final int random = Math.abs(new Random().nextInt()) % 11; // random between 0 and 10
         hashSet.stream().filter(one -> one.equals(random)).findAny().orElse(null);
      }
   }

   private static void arrayListTest() {
      final List<Integer> list = Arrays.asList(0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100);
      for (int i = 0; i < 100; i++) {
         final int random = Math.abs(new Random().nextInt()) % 11; // random between 0 and 10
         list.get(random);
      }
   }

}
