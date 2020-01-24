package Hangman;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

class RandomPhraseFinder implements Closeable {

    private RandomAccessFile file;

    RandomPhraseFinder() throws FileNotFoundException {
        File f = new File("C:\\Users\\Nicole\\IdeaProjects\\cs2410hw5\\src\\Hangman\\phrases");
        String[] words = input(f);
        file = new RandomAccessFile(f, "r");
    }

    public static String[] input(File file)
    {
        String expression = "";
        try
        {
            //create a new Scanner
            Scanner read = new Scanner(file);

            //scans file and puts into string to convert.
            expression = read.nextLine();
        }
        catch(FileNotFoundException error)
        {
            //will print ONLY if the file is not found. Will print in RED
            System.err.println("Did not find file");
        }
        //put read in string into string array and split
        String[] words = expression.split("\n");

        //return array of integers
        return words;
    }

    String findRandomWord() throws IOException {
        // Search a random position in the file
        movePointerToRandomPosition();

        // Search the beginning of the word
        movePointerToBeginningOfWord();

        // Read and return the random word
        return readWord();
    }

    private String readWord() throws IOException {
        String word = "";
        char key;
        while ((key = (char)file.read()) != '\n') {
            word += key;
        }
        return word;
    }

    private void movePointerToBeginningOfWord() throws IOException {
        long pos = file.getFilePointer();
        char ch = (char)file.read();

        while (ch != '*') {
            file.seek(--pos);
            ch = (char)file.read();
        }

        // Otherwise it is pointing to a *
        file.seek(pos + 1);
    }

    private void movePointerToRandomPosition() throws IOException {
        long pos;
        char ch;
        do {
            pos = (long) (file.length() * Math.random());
            // Put pointer to random position
            file.seek(pos);
            ch = (char) file.read();
        } while (ch == '*');
    }

    @Override
    public void close() throws IOException {
        file.close();
    }
}