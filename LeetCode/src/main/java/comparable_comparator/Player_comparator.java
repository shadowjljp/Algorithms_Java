package comparable_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class PlayerRankingComparator implements Comparator<Player_comparator> {
	  
    @Override
    public int compare(Player_comparator firstPlayer, Player_comparator secondPlayer) {
       return (firstPlayer.getRanking() - secondPlayer.getRanking());
    }
}
class PlayerAgeComparator implements Comparator<Player_comparator> {
@Override
public int compare(Player_comparator firstPlayer, Player_comparator secondPlayer) {
   return (firstPlayer.getAge() - secondPlayer.getAge());
}
}
public class Player_comparator{

	private int ranking;
	private String name;
	private int age;
	
	public Player_comparator(int ranking, String name, int age) {
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

	public static void main(String[] args) {
		List<Player_comparator> footballTeam = new ArrayList<>();
	    Player_comparator player1 = new Player_comparator(59, "John", 20);
	    Player_comparator player2 = new Player_comparator(67, "Roger", 22);
	    Player_comparator player3 = new Player_comparator(45, "Steven", 24);
	    footballTeam.add(player1);
	    footballTeam.add(player2);
	    footballTeam.add(player3);
	 
	    System.out.println("Before Sorting : " );
	    for(Player_comparator p : footballTeam) {
	    	System.out.print(p.getName()+" , ");
	    }
	    
	    PlayerRankingComparator playerComparator = new PlayerRankingComparator();
	    Collections.sort(footballTeam, playerComparator);
	    
	    System.out.println();
	    System.out.println("\n After PlayerRankingComparator Sorting : " );
	    for(Player_comparator p : footballTeam) {
	    	System.out.print(p.getName()+" , ");
	    }
	    PlayerAgeComparator playerComparator2 = new PlayerAgeComparator();
	    Collections.sort(footballTeam, playerComparator2);
	    System.out.println("\n \n After PlayerAgeComparator Sorting : " );
	    for(Player_comparator p : footballTeam) {
	    	System.out.print(p.getName()+" , ");
	    }
	}
}


