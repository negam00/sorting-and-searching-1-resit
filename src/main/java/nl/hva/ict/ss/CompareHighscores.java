package nl.hva.ict.ss;


import java.util.Comparator;

public abstract class CompareHighscores implements Comparator<Player> {

    public int compareTo(Player p1, Player p2) {

        if (p1.getHighScore() > p2.getHighScore()) {
            return 1;
        }
        else if(p1.getHighScore() < p2.getHighScore()){
            return -1;
        }
        else{
            if(p1.getLastName() != p2.getLastName()){
                return p1.getLastName().compareTo(p2.getLastName());

            } else{
                return p1.getFirstName().compareTo(p2.getFirstName());
            }

        }

    }

}