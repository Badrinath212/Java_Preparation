package Collections;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Player implements Comparable<Player> {
    private String name;
    private int score;
    private int age;

    public Player(String name, int score, int age) {
        this.name = name;
        this.score = score;
        this.age = age;
    }

    @Override
    public int compareTo(Player other) {
        return Integer.compare(this.getScore(), other.getScore());
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
public class ComparableTest {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>();
        players.add(new Player("John", 100, 20));
        players.add(new Player("Tom", 80, 30));
        players.add(new Player("Jack", 90, 40));
        players.add(new Player("Bob", 70, 50));
        players.add(new Player("Jim", 60, 60));

        Collections.sort(players);

        for (Player player : players) {
            System.out.println(player.getName() + " " + player.getScore() + " " + player.getAge());
        }
    }
}
