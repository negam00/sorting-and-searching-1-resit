package nl.hva.ict.ss;


import java.util.Comparator;

public abstract class CompareHighscores implements Comparator<Player> {

    public int compareTo(Player p1, Player p2) {

        if (p1.getHighScore() > p2.getHighScore()) {
            return 1;
        }
        return 0;
    }

}