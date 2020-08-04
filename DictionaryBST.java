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
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * implement the interface Dictionary defined earlier in this assignment, as a Binary Search Tree of
 * DictionaryWord nodes
 * 
 * @author rosaliecarrow
 *
 */
public class DictionaryBST implements Dictionary {

  private DictionaryWord root;// the root of the BST

  /**
   * This should be the only constructor of this class. Creates an empty dictionaryBST.
   */
  public DictionaryBST() {
  }

  /**
   * checks whether the dictionary is empty or not
   * 
   * @return true if this dictionary is empty, false otherwise
   */
  @Override
  public boolean isEmpty() {
    return root == null;
  }

  /**
   * adds a word definition (word and meaning provided) to this dictionary
   * 
   * @param word    of the word definition to be added to this dictionary
   * @param meaning of the word definition to be added to this dictionary
   * @return true if the word was successfully added to the dictionary and false if the word was
   *         already in this dictionary
   * @throws IllegalArgumentException if either word or meaning is null or an empty String
   */
  @Override
  public boolean addWord(String word, String meaning) {
    if (root == null) {
      root = new DictionaryWord(word, meaning);
      return true;
    } else {
      return addWordHelper(new DictionaryWord(word, meaning), root);

    }

  }

  /**
   * Looks up for a meaning of a given word s if present in this dictionary
   * 
   * @param s a word
   * @return meaning of the provided string s if present in this dictionary
   * @throws NoSuchElementException if the word s was not found in this dictionary
   */
  @Override
  public String lookup(String s) {
    return lookupHelper(s, root);
  }


  /**
   * Gets the size of this dictionary in terms of words
   * 
   * @return the number of word defintions stored in the dictionary
   */
  @Override
  public int size() {
    return sizeHelper(root);
  }

  // Public methods not defined in the Dictionary interface
  /**
   * Computes and returns the height of this dictionaryBST, as the number of nodes from root to the
   * deepest leaf DictionaryWord node.
   * 
   * @return the height of this Binary Search Tree counting the number of DictionaryWord nodes
   */
  public int height() {
    return heightHelper(root);
  }

  /**
   * Returns all the words within this dictionary sorted from A to Z
   * 
   * @return an ArrayList that contains all the words within this dictionary sorted in the ascendant
   *         order
   */
  public ArrayList<String> getAllWords() {
    return getAllWordsHelper(root);
  }

  // Recursive private helper methods
  // Each public method should make call to the recursive helper method with the
  // corresponding name

  /**
   * Recursive helper method to add newWord in the subtree rooted at node
   * 
   * @param newWordNode a new DictionaryWord to be added to this dictionaryBST
   * @param current     the current DictionaryWord that is the root of the subtree where newWord
   *                    will be inserted
   * @return true if the newWordNode is successfully added to this dictionary, false otherwise
   */
  private static boolean addWordHelper(DictionaryWord newWordNode, DictionaryWord current) {

    if (current.getWord().compareToIgnoreCase(newWordNode.getWord()) > 0) {
      if (current.getLeftChild() == null) {
        current.setLeftChild(newWordNode);
        return true;
      } // base of recursion
      return addWordHelper(newWordNode, current.getLeftChild());

    } // go to left if s is smaller
    else if (current.getWord().compareToIgnoreCase(newWordNode.getWord()) < 0) {
      if (current.getRightChild() == null) {
        current.setRightChild(newWordNode);
        return true;
      }
      return addWordHelper(newWordNode, current.getRightChild());

    } // go to right if s is larger

    return false;// if fails to add

  }


  /**
   * Recursive helper method to lookup a word s in the subtree rooted at current
   * 
   * @param s       String that represents a word
   * @param current pointer to the current DictionaryWord within this dictionary
   * @return the meaning of the word s if it is present in this dictionary
   * @throws NoSuchElementException if s is not found in this dictionary
   */
  private static String lookupHelper(String s, DictionaryWord current) {
    if (current == null) {
      throw new NoSuchElementException("Not found");
    } // base of recursion if not found

    if (current.getWord().compareToIgnoreCase(s) > 0) {
      return lookupHelper(s, current.getLeftChild());
    } // go to left if s is smaller
    else if (current.getWord().compareToIgnoreCase(s) < 0) {
      return lookupHelper(s, current.getRightChild());
    } // go to right if s is larger

    return current.getMeaning();// if found
  }



  /**
   * Recursive helper method that returns the number of dictionary words stored in the subtree
   * rooted at current
   * 
   * @param current current DictionaryWord within this dictionaryBST
   * @return the size of the subtree rooted at current
   */
  private static int sizeHelper(DictionaryWord current) {
    if (current == null) {
      return 0;
    } // base of recursion

    return sizeHelper(current.getLeftChild()) + sizeHelper(current.getRightChild()) + 1;

  }


  /**
   * Recursive helper method that computes the height of the subtree rooted at current
   * 
   * @param current pointer to the current DictionaryWord within this DictionaryBST
   * @return height of the subtree rooted at current counting the number of DictionaryWord nodes
   *         from the current node to the deepest leaf in the subtree rooted at current
   */
  private static int heightHelper(DictionaryWord current) {
    if (current == null) {
      return 0;
    } // base of recursion

    return Math.max(heightHelper(current.getLeftChild()), heightHelper(current.getRightChild()))
        + 1;
  }



  /**
   * Recursive Helper method that returns a list of all the words stored in the subtree rooted at
   * current sorted alphabetically from A to Z
   * 
   * @param current pointer to the current DictionaryWord within this dictionaryBST
   * @return an ArrayList of all the words stored in the subtree rooted at current
   */
  private static ArrayList<String> getAllWordsHelper(DictionaryWord current) {
    if (current == null) {
      return new ArrayList<String>();
    } // base of recursion
    else {
      ArrayList<String> words = getAllWordsHelper(current.getLeftChild());
      words.add(current.getWord());
      words.addAll(getAllWordsHelper(current.getRightChild()));

      return words;
    }
  }


}
