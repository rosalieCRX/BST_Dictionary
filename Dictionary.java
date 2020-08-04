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
/**
 * This interface models and abstract data type for a dictionary
 * 
 * @author rosaliecarrow
 *
 */
public interface Dictionary {
  /**
   * checks whether the dictionary is empty or not
   * 
   * @return true if this dictionary is empty, false otherwise
   */
  public boolean isEmpty();

  /**
   * adds a word definition (word and meaning provided) to this dictionary
   * 
   * @param word    of the word definition to be added to this dictionary
   * @param meaning of the word definition to be added to this dictionary
   * @return true if the word was successfully added to the dictionary and false if the word was
   *         already in this dictionary
   * @throws IllegalArgumentException if either word or meaning is null or an empty String
   */
  public boolean addWord(String word, String meaning);

  /**
   * Looks up for a meaning of a given word s if present in this dictionary
   * 
   * @param s a word
   * @return meaning of the provided string s if present in this dictionary
   * @throws NoSuchElementException if the word s was not found in this dictionary
   */
  public String lookup(String s);

  /**
   * Gets the size of this dictionary in terms of words
   * 
   * @return the number of word defintions stored in the dictionary
   */
  public int size();
}
