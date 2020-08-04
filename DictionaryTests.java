//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title: (Dictionary using BST)
// Files: (Dictionary.java DictionaryWord.java DictionaryBST.java DictionaryDriver.java
//////////////////// DictionaryTests.java)
// Course: (001 SUMMER 2019)
//
// Author: (Rosalie CAI)
// Email: (rcai25@wisc.edu)
// Lecturer's Name: (Mouna KACEM)
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name: (NONE)
// Partner Email: (email address of your programming partner)
// Partner Lecturer's Name: (name of your partner's lecturer)
//
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
// ___ Write-up states that pair programming is allowed for this assignment.
// ___ We have both read and understand the course Pair Programming Policy.
// ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully
// acknowledge and credit those sources of help here. Instructors and TAs do
// not need to be credited here, but tutors, friends, relatives, room mates,
// strangers, and others do. If you received no outside help from either type
// of source, then please explicitly indicate NONE.
//
// Persons: (NONE)
// Online Sources: (NONE)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////
import java.util.NoSuchElementException;

/**
 * Tests for dictionary
 * 
 * @author rosaliecarrow
 *
 */
public class DictionaryTests {
  /**
   * Checks whether the behavior of DictionaryWord methods is correctly implemented
   * 
   * @return the result of the test
   */
  public static boolean testDictionaryWord() {
    boolean passed = true;
    try {
      DictionaryWord w1 = new DictionaryWord(null, "1");
    } catch (IllegalArgumentException e) {
      // should be caught here
    } catch (RuntimeException e) {
      passed = false;
      System.out.println("testDictionaryWord: null word fails.");
    }
    return passed;
  }

  /**
   * Checks whether the behavior of DictionaryBST basic add, size, and height methods is correctly
   * implemented
   * 
   * @return the result of the test
   */
  public static boolean testDictionaryBST1() {
    boolean passed = true;
    // create dictionaryBST
    DictionaryBST dic = new DictionaryBST();
    if (!dic.isEmpty()) {
      passed = false;
      System.out.println("testDictionaryBST1:isEmpty():fails.");
    }
    // add Word
    dic.addWord("cat", "3");
    dic.addWord("apple", "1");
    dic.addWord("bee", "2");
    dic.addWord("dog", "4");
    dic.addWord("egg", "5");
    // test size
    if (dic.size() != 5) {
      passed = false;
      System.out.println("testDictionaryBST1:size() fails.");
    }
    // test height
    if (dic.height() != 3) {
      passed = false;
      System.out.println("testDictionaryBST1:height() fails.");
    }
    // test if words are added correctly
    if (!(dic.getAllWords().get(0).equals("apple") && dic.getAllWords().get(1).equals("bee")
        && dic.getAllWords().get(2).equals("cat") && dic.getAllWords().get(3).equals("dog")
        && dic.getAllWords().get(4).equals("egg"))) {
      passed = false;
      System.out.println("testDictionaryBST1:words in wrong order.");
    }

    return passed;
  }

  /**
   * Checks whether the behavior of DictionaryBST more complex methods is correctly implemented
   * 
   * @return the result of the test
   */
  public static boolean testDictionaryBST2() {
    boolean passed = true;
    // create dictionaryBST
    DictionaryBST dic = new DictionaryBST();

    // add Word
    dic.addWord("apple", "1");
    dic.addWord("bee", "2");
    dic.addWord("cat", "3");
    dic.addWord("dog", "4");
    dic.addWord("egg", "5");

    // test add duplicate word
    if (dic.addWord("egg", "5")) {
      passed = false;
      System.out.println("testDictionaryBST2: adding duplicate word fails.");
    }

    // test if looking up existing words is correct
    if (!(dic.lookup("apple").equals("1") && dic.lookup("bee").equals("2")
        && dic.lookup("cat").equals("3") && dic.lookup("dog").equals("4")
        && dic.lookup("egg").equals("5"))) {
      passed = false;
      System.out.println("testDictionaryBST2:looking up existing word fails.");
    }

    // test if looking up non-existing words is correct
    try {
      dic.lookup("zebra");
    } catch (NoSuchElementException e) {
      // should be caught here
    } catch (RuntimeException e) {
      passed = false;
      System.out.println("testDictionaryBST2:looking up non-existing word fails.");
    }
    return passed;
  }

  /**
   * runs DictionaryTests program as a PApplet client
   * 
   * @param args command-line argument
   */
  public static void main(String[] args) {
    System.out.println("------------------testDictionaryWord(): " + testDictionaryWord());
    System.out.println("------------------testDictionaryBST1(): " + testDictionaryBST1());
    System.out.println("------------------testDictionaryBST2(): " + testDictionaryBST2());
  }

}
