
public class Game {
	int round;
	
	public Game() {
		round = 0;
	}
	
	public Game(int r) {
		round = r;
	}
	
	public int getRound() {
		return round;
	}
	
	public void setRound(int r) {
		this.round = r;
	}

	public static void main(String[] args) {
		int N = 20;
		int M = 10;
		Game game = new Game(1);
		Board board = new Board(N, M, 3, 3, 6);
		board.createBorad();
		board.createElementBoard();
		Player[] players = new Player[2];
		players[0] = new Player(0, "player 0", 0, board);
		players[1] = new Player(1, "player 1", 0, board);
		int[] currentPosition = new int[players.length];
		int newPosition = 0;
		String winnerName = null;
		
		for (int i = 0; i < players.length; i++) {
			currentPosition[i] = 0;
		}
		
		System.out.println("*********** The game begins **********");
		System.out.println();
		game.round = 0;
		
		for (;;) {
			game.round++;
			//System.out.println("Round " + game.round);
			for (int i = 0; i < players.length; i++) {
				int die = 1 + (int)(Math.random()*6);
				newPosition = players[i].move(currentPosition[i], die)[0];
				if (newPosition >= N*M) {
					winnerName = players[i].getName();
					break;
				}
				currentPosition[i] = newPosition;
			}
			if (newPosition >= N*M) {
				break;
			}
		}
		
		System.out.println();
		System.out.println("*********** The game is over *********");
		System.out.println();
		System.out.println("Rounds played: "+game.round);
		
		for (int i = 0; i < players.length; i++) {
			System.out.println(players[i].getName()+" gatherd " + players[i].getScore() + " points");
		}
		System.out.println(winnerName +" won the game!!!");
		
	}

}
