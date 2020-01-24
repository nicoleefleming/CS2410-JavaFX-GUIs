package WheelOfFortue;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Host {
    private Board board;

    public Host(Board board)
    {
        this.board = board;
    }

    public void doWhatsNeccessaryWith(Player player, Wheel.SpinResult spinResult)
    {
        //TODO Process Spin Result here
        switch (spinResult.type())
        {
            case CASH:
                player.account().credit(spinResult.amount());
                break;
            case LOSE_A_TURN:
            //TODO Lose

                break;
            case BANKRUPT:
            //TODO BANKRUPT

                break;
            case SOLVE_PUZZLE:
            //TODO SOLVE_PUZZLE

                break;
        }
        // ... or externalize it to a SpinResultProcessor and supply the Host with it in the constructor
        // processor.process(Player player, SpinResult spinResult);
    }

    public boolean uncoverConsonant(char consonant)
    {
        boolean isConsonant = false;

        //TODO check if really consonant

        isConsonant = true;
        //-----------------
        if (isConsonant)
        {
            return board.reveal(consonant);
        }
        else
        {
            return false;
        }
    }

    public boolean solveWith(CharSequence solution)
    {
        return solution.equals(board.sentence());
    }

    public List<Integer> getCharacterOccurences(Character chars)
    {
        List<Integer> hi = new List<Integer>() {
            //TODO Logic below
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<Integer> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(Integer integer) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends Integer> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends Integer> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public Integer get(int index) {
                return null;
            }

            @Override
            public Integer set(int index, Integer element) {
                return null;
            }

            @Override
            public void add(int index, Integer element) {

            }

            @Override
            public Integer remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<Integer> listIterator() {
                return null;
            }

            @Override
            public ListIterator<Integer> listIterator(int index) {
                return null;
            }

            @Override
            public List<Integer> subList(int fromIndex, int toIndex) {
                return null;
            }
        };
        //TODO Convert the characters to ASCII values and return in the List<Integers>
        return hi;
    }

    public char uncoverConsonent(List<Integer> occurances)
    {
        return 'e';
    }

    public void giveVowel()
    {
        //TODO calculate vowel
        board.reveal('e');
    }

}//Host
