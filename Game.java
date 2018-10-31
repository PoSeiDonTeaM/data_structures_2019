
public class Game {

	int round = 0;
	
	public Game()
	{
		round = 0;
	}
	
	public int getRound()
	{
		return round;
	}
	
	public void setRound(int r)
	{
		round = r;
	}
	
	public static void main(String args[])
	{
		int currentId1 = 0;
		int currentId2 = 0;
		int round = 0;
		int[] player1Matrix = new int[4];
		int[] player2Matrix = new int[4];
		int score1 = 0;
		int score2 = 0;
		
		Board newBoard = new Board(20,10,3,3,6);
		Player player1 = new Player(1, "John", 0);
		Player player2 = new Player(2, "Kostas", 0);
		
		newBoard.createBoard();
		
		do {
			
		
		player1Matrix = player1.move(currentId1, (int)Math.random()*6+1);
		currentId1 = player1Matrix[0];
		
		score1 = player1.getScore();
		player1.setScore(score1 + player1Matrix[3]*10 - player1Matrix[4]*10);
		
		player2Matrix = player2.move(currentId2, (int)Math.random()*6+1);
		currentId2 = player2Matrix[0];
		
		score2 = player2.getScore();
		player2.setScore(score2 + player2Matrix[3]*10 - player2Matrix[4]*10);
		
			
		round++;
		
		}while(currentId1 != 200 || currentId2 != 200);
		
		System.out.println("Number of rounds:" + round);
		
	}
}
