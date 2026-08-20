package Collections;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class Player {
    private String name;
    private int score;
    private int age;

    public Player(String name, int score, int age) {
        this.name = name;
        this.score = score;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getAge() {
        return age;
    }
}

class PlayerComparatorByScore implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        return Integer.compare(p1.getScore(), p2.getScore());
    }
}

class PlayerComparatorByAge implements Comparator<Player> {
    @Override
    public int compare(Player p1, Player p2) {
        return Integer.compare(p1.getAge(), p2.getAge());
    }
}

public class ComparatorTest {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player("John", 100, 20));
        players.add(new Player("Tom", 80, 30));
        players.add(new Player("Jack", 90, 40));
        players.add(new Player("Bob", 70, 50));
        players.add(new Player("Jim", 60, 60));

        Collections.sort(players, new PlayerComparatorByScore());

        for (Player player : players) {
            System.out.println(player.getName() + " " + player.getScore() + " " + player.getAge());
        }

        Collections.sort(players, new PlayerComparatorByAge());

        for (Player player : players) {
            System.out.println(player.getName() + " " + player.getScore() + " " + player.getAge());
        }
    }
}
