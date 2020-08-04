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
 * defines its data consisting of a pair of word and its meaning, and a link to each child (right
 * and left) of the node.
 * 
 * @author rosaliecarrow
 *
 */
public class DictionaryWord {
  private final String word; // word that represents the search key for this dictionary word
  private final String meaning; // The meaning of the word that this dictionary node defines
  private DictionaryWord leftChild; // The leftChild of the the current WebPageNode
  private DictionaryWord rightChild; // The rightChild of the the current WebPageNode


  /**
   * The following should be the only constructor for this class Creates a new dictionary word with
   * the provided word and its meaning pair. Throws IllegalArgumentException when the word or
   * meaning are either references to an empty string or null references. The thrown exception
   * should include a significant error message describing which of these problems was encountred.
   * 
   * @param word    the provided word
   * @param meaning meaning of the word
   */
  public DictionaryWord(String word, String meaning) {
    // Throws IllegalArgumentException when the word or meaning are either references to an empty
    // string or null references
    if (word == null) {
      throw new IllegalArgumentException("Illegal input: word is null");
    }
    if (meaning == null) {
      throw new IllegalArgumentException("Illegal input: meaning is null");
    }
    if (word.equals("")) {
      throw new IllegalArgumentException("Illegal input: word is empty");
    }
    if (meaning.equals("")) {
      throw new IllegalArgumentException("Illegal input: meaning is empty");
    }

    // set field
    this.word = word;
    this.meaning = meaning;
  }



  /**
   * Getter for the left child of this dictionary word
   * 
   * @return left child of this dictionary word
   */
  public DictionaryWord getLeftChild() {
    return this.leftChild;
  }


  /**
   * Setter for the left child of this dictionary word
   * 
   * @param leftChild Set the left child of this dictionary word
   */
  public void setLeftChild(DictionaryWord leftChild) {
    this.leftChild = leftChild;
  }


  /**
   * Getter for the right child of this dictionary word
   * 
   * @return the right child of this dictionary word
   */
  public DictionaryWord getRightChild() {
    return this.rightChild;

  }


  /**
   * Getter for the right child of this dictionary word
   * 
   * @param rightChild the right child of this dictionary word
   */
  public void setRightChild(DictionaryWord rightChild) {
    this.rightChild = rightChild;

  }


  /**
   * Getter for the word of this dictionary word
   * 
   * @return the word of this dictionary word
   */
  public String getWord() {
    return this.word;
  }

  /**
   * Getter for the meaning of the word of this dictionary word
   * 
   * @return the meaning of the word of this dictionary word
   */
  public String getMeaning() {
    return this.meaning;

  }


  /**
   * Returns a String representation of this DictionaryWord. This String is formatted as follows.
   * "word: meaning"
   * 
   * @return String representing a dictionary word and its meaning
   */
  public String toString() {
    return this.word + ": " + this.meaning;
  }
}
