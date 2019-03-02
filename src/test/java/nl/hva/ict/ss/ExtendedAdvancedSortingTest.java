package nl.hva.ict.ss;

import nl.hva.ict.ss.util.ArraySort;
import nl.hva.ict.ss.util.LinkedListSort;
import nl.hva.ict.ss.util.NameReader;
import org.junit.BeforeClass;
import org.junit.Test;

import java.security.SecureRandom;
import java.util.LinkedList;
import java.util.Random;

import static org.junit.Assert.assertTrue;

/**
 * Just measures the time needed that sorting an increasing number of players.
 * The measurements stops if sorting takes more the twenty seconds or when there
 * would be sorted more then 1.048.576 of players.
 *
 * @author Nico Tromp, n.j.tromp@hva.nl
 */
public class ExtendedAdvancedSortingTest {
    static final int MAX_HIGH_SCORE = 100_000;
    static final int TWENTY_SECONDS = 20_000;
    //    static final int UPPER_LIMIT = 1 << 20; // 1.048.576
    static final int UPPER_LIMIT = 1048400; // 1.048.576
    static final Random randomizer = new SecureRandom();
    static LinkedList<Player> unsortedLinkedList = new LinkedList<>();

    @BeforeClass
    public static void setup() {
        System.out.printf("Preparing players...");
        System.out.flush();
        String[] firstNames = new NameReader("/firstnames.txt").getNames();
        String[] lastNames = new NameReader("/lastnames.txt").getNames();
        for (int i = 0; i < UPPER_LIMIT; i++) {
            String firstName = firstNames[randomizer.nextInt(firstNames.length)];
            String lastName = lastNames[randomizer.nextInt(lastNames.length)];
            Player toAdd = (new Player(firstName, lastName, randomizer.nextInt(MAX_HIGH_SCORE)));
            unsortedLinkedList.addLast(toAdd);

        }

        System.out.printf("%nStart measurements.%n%n");
        System.out.flush();
    }

    @Test
    public void checkLinkedListSorter() {
        LinkedListSort.LinkedListSorted(unsortedLinkedList);

        assertTrue(linkedListIsSorted(unsortedLinkedList));
    }

    public boolean linkedListIsSorted(LinkedList<Player> sortedList) {

//        System.out.println(sortedList);
        Player currentIteration = sortedList.getFirst();
        boolean output = true;
        for (Player player : sortedList) {
            if (currentIteration.compareTo(player) > 0) {
                System.out.println("ERROR");
                System.out.println("previous " + currentIteration.getHighScore() + " " + currentIteration.getFirstName() + " " + currentIteration.getLastName());
                System.out.println("current " + player.getHighScore() + " " + player.getFirstName() + " " + player.getLastName());
                output = false;
            } else {
                System.out.println("Linkedlist is sorted");
            }
            currentIteration = player;
        }

        return output;
    }


    @Test
    public void checkArraySorter() {
        Player player1 = new Player("AA", "bb", 100);
        Player player2 = new Player("zz", "aa", 200);
        Player player3 = new Player("zxc", "zz", 300);// Must swap this with next for lastname
        Player player4 = new Player("AA", "aa", 300);
        Player player5 = new Player("AA", "zz", 500);

            ArraySort sorter = new ArraySort();
        Player[] players = {player1, player2, player3, player5, player4};
        players = sorter.sortArray(players);
//        for (Player i: players) {
//            System.out.println( i.getHighScore() + " " +i.getLastName() + " "+ i.getFirstName());
//        }

        boolean returnvalue = true;
        for (int i = 0; i < players.length - 1; i++) {

            if ((players[i].compareTo(players[i + 1])) > 0) {
                System.out.println("1current " + players[i].getHighScore() + " " + players[i].getFirstName() + " " + players[i].getLastName());
                System.out.println("2current " + players[i + 1].getHighScore() + " " + players[i + 1].getFirstName() + " " + players[i + 1].getLastName());
                returnvalue = false;
            }
        }
        assertTrue(returnvalue);
    }


    LinkedList<Player> getSubList(LinkedList<Player> players, int numberOfPlayers) {
        LinkedList<Player> unsortedPlayers = new LinkedList<>();
        int i = 0;
        for (Player player : players) {
            unsortedPlayers.addLast(player);
            if (++i == numberOfPlayers) break;
        }
        return unsortedPlayers;
    }
}
