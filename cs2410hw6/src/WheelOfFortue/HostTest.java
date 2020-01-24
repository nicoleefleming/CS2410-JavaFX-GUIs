package WheelOfFortue;

public class HostTest {

    public static void main(String[] args) {

        String sentence = "The answer is forty-two!";
        Board board = new Board(sentence);
        Host host = new Host(board);

        String notTheSolution = "This is not the solution";
        System.out.printf("Is '%s' the solution of '%s'? %b%n", notTheSolution, board.solution(), host.solveWith(notTheSolution));
        System.out.printf("Is '%s' the solution of '%s'? %b%n", sentence, board.solution(), host.solveWith(sentence));

    }

} // HostTest
