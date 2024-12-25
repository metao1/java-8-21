package com.metao.java8;

// we are going to write a method called reverseSentenceWords that accepts a char array as argument
// Then the goal of this function is to get this argument as param and return reveresed of each word separately
// so something like this is required : void reverseSentenceWords(char[] sentenceInChars)
// To solve this problem  we need to be sure that the amount of space we use is constant. This means we need to
// pass the array as value and change its elements in place. To start, we need some pointers to plac over
// array to operate. We take benefit of characters inside array, and proceed one by one in a for-loop.
// If we only had one word, in an char array, and we wanted to reverse that, it was easy,we know how to reverse a
// the word in place, since we know the start and end of that array and just put two pointers on at first and
// second at the end, and we replace the values they point to each other and we update the pointer positions,
// until the pass each other. For this problem is similar, however a small different exist.
// In this problem we consider each word placed as chars in main char array, we want to find a WINDOW,
// in which contains specific word in that main array. It means we need to first the WINDOW that starts with
// first character of that word and ends with last character of that word. Once we find this WINDOW, we can handle
// as we do if we only had one word. The only complexity is to identify the WINDOW place and slide this WINDOW
// until we reach to the end of the main char array.
// To undentify the WINDOW boundry we can use empty char (' '). This separates words from each other in the main char array.

import java.util.Arrays;

public class ReverseWordsInSentence {
    public static void main(String[] args) {
        //initializing the main char array
        char[] boltMessage = new char[]{'I', ' ', 'd', 'r', 'i', 'v', 'e', ' ', 'w', 'i', 't', 'h', ' ', 'B', 'o', 'l', 't'};
        //pass the main char array as value to method
        reverseSentenceWords(boltMessage);
        //print the updated main char array
        System.out.println(Arrays.toString(boltMessage));
    }

    static void reverseSentenceWords(char[] sentenceInChars) {
        int j = 0; // indicates the start of the WINDOW index
        for (int i = 0; i < sentenceInChars.length; i++) { // slide the WINDOW
            if (sentenceInChars[i] == ' ') {//Identify the start of word in sentence
                // reverse words in place in WINDOW boundry
                for (int k = i - 1; k >= j; k--) {// i now points to the end of the word, we go over to j index
                    char temp = sentenceInChars[j];
                    sentenceInChars[j++] = sentenceInChars[k];
                    sentenceInChars[k] = temp;
                }
                //update j index to end of WINDOW boundry
                j = i + 1;
            }
        }
        //We could not find the last word in main char arra, as the last word does not end with empty char
        //We know that j now points to the beginning of the last word
        //We know the WINDOW ends to where the main char array ends
        //Then we can identify the WINDOW size
        //Reverse the last word in main char array.
        for (int k = sentenceInChars.length - 1; k >= j; k--) {
            char temp = sentenceInChars[j];
            sentenceInChars[j++] = sentenceInChars[k];
            sentenceInChars[k] = temp;
        }
    }


    static void reverse(char[] sentenceInChars) {
        for (int k = sentenceInChars.length - 1; k >= (sentenceInChars.length - 1) / 2; k--) {
            char temp = sentenceInChars[k];
            sentenceInChars[k] = sentenceInChars[sentenceInChars.length - k - 1];
            sentenceInChars[sentenceInChars.length - k - 1] = temp;
        }
        System.out.println(Arrays.toString(sentenceInChars));
    }


    static char[] reverseUsingStringBuilder(char[] sentenceInChars) {
        var sb = new StringBuilder();
        var result = new StringBuilder();
        for (char ch : sentenceInChars) {
            if (ch == ' ') {
                result.append(reverseWord(sb.toString()));
                result.append(" ");
                sb = new StringBuilder();
            } else {
                sb.append(ch);
            }
        }
        result.append(sb.reverse());
        return result.toString().toCharArray();
    }

    static String reverseWord(String word) {
        StringBuilder sb = new StringBuilder(word);
        return sb.reverse().toString();
    }
}
