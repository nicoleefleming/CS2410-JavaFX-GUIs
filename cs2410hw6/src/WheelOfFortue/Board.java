package WheelOfFortue;

import java.util.ArrayList;

public class Board extends ArrayList<Character> {

    private String sentence;
    private boolean[] visibility; // the sentence characters' visibility

    public Board(CharSequence sentence) {
        initializeWith(sentence);
    } // Board(...)

    public Board initializeWith(CharSequence sentence) {
        this.sentence = sentence.toString().toUpperCase();
        visibility = new boolean[sentence.length()];
        char c;
        for (int i = 0; i < visibility.length; i++) {
            visibility[i] = false;
            c = Character.toUpperCase(sentence.charAt(i));
            add(Character.isLetter(c) ? ' ' : c);
        }
        return this;
    }

    public boolean reveal(char character) {
        Character c = Character.toUpperCase(character);
        boolean sentenceContainsChar = false;
        for (int i = 0; i < sentence.length(); i++) {
            if (sentence.charAt(i) == c) {
                sentenceContainsChar = true;
                visibility[i] = true;
                set(i, c);
            }
        }
        return sentenceContainsChar;
    }

    public static char[] phraseToArray(String newPhrase)
    {
        char[] array = new char [newPhrase.length()];
        for (int index = 0; index < newPhrase.length(); index++)
        {
            array[index] = newPhrase.charAt(index);
        }
        return array;

    }

    public static char[] phraseArrayToBlank (char[] phraseArray)
    {
        char[] hiddenArray = new char [phraseArray.length];
        for (int index = 0; index < phraseArray.length; index++)
        {
            if ("ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(Character.toUpperCase(phraseArray[index])) >= 0)
                hiddenArray[index] = '*';

            else
                hiddenArray[index] = phraseArray[index];
        }
        return hiddenArray;
    }

    public String sentence() {
        return sentence;
    }
    public String solution()
    {
        return sentence;
    }

} // Board
