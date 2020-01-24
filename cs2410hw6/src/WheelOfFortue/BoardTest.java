package WheelOfFortue;

public class BoardTest {

    public static void main(String[] args) {

        String sentence = "The answer is forty-two!";
        Board board = new Board(sentence);
        System.out.printf("Sentence %8s%n", board.sentence());
        System.out.printf("Board    %8s%n", board);

        System.out.printf("t? %-5b %s%n", board.reveal('t'), board);
        System.out.printf("x? %-5b %s%n", board.reveal('x'), board);
        System.out.printf("e? %-5b %s%n", board.reveal('e'), board);
        System.out.printf("u? %-5b %s%n", board.reveal('u'), board);
    }

} // BoardTest
