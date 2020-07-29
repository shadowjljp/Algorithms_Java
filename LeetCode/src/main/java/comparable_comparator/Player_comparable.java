package comparable_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player_comparable implements Comparable<Player_comparable> {
	private int ranking;
	private String name;
	private int age;

	public Player_comparable(int ranking, String name, int age) {
		super();
		this.ranking = ranking;
		this.name = name;
		this.age = age;
	}

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int compareTo(Player_comparable o) {
		// TODO Auto-generated method stub
		return (this.getRanking() - o.getRanking());
	}

	public static void main(String[] args) {
		List<Player_comparable> footballTeam = new ArrayList<>();
		Player_comparable player1 = new Player_comparable(59, "John", 20);
		Player_comparable player2 = new Player_comparable(67, "Roger", 22);
		Player_comparable player3 = new Player_comparable(45, "Steven", 24);
		footballTeam.add(player1);
		footballTeam.add(player2);
		footballTeam.add(player3);

		System.out.println("Before Sorting : ");
		for (Player_comparable p : footballTeam) {
			System.out.print(p.getName() + " , ");
		}
		Collections.sort(footballTeam);
		System.out.println();
		System.out.println("After Sorting : ");
		for (Player_comparable p : footballTeam) {
			System.out.print(p.getName() + " , ");
		}
	}
}
