public class Player {

	int playerId;
	String name;
	int score;
	Board board;
	Apple apple;
	
	public Player()
	{
		playerId = 0;
		name = "";
		score = 0;
	
	}
	
	public Player(Board board, Apple apple)
	{
		playerId = 0;
		name = "";
		score = 0;
		this.board = board;
		this.apple = apple;
	
	}
	
	public Player(int playerId, String name, int score)
	{
		this.playerId = playerId;
		this.name = name;
		this.score = score;
	}
	
	public int getPlayerId()
	{
		return playerId;
	}
	
	public int getScore()
	{
		return score;
	}
	
	public String getName()
	{
		return name;
	}
	
	public Board getBoard()
	{
		return board;
	}
	
	public void setPlayerId(int pid)
	{
		playerId = pid;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public void setScore(int s)
	{
		score = s;
	}
	
	public int[] move(int id, int dice)
	{
		int[] nextMove = new int[4];
		int nextMoveId = id + dice;
		int snakeBites = 0;
		int laddersUsed = 0;
		int redApplesEaten = 0;
		int blackApplesEaten = 0;
		int findApple;
		int findLadder;
		
		nextMove[0] = nextMoveId;
		
		if(board.containSnakeHead(nextMoveId) == true)
		{
		snakeBites ++;
		nextMove[1] = snakeBites;
		
		System.out.println("There is a snake in my boot"); // Reference: Toy Story 
		}
		
		if(board.containUpperStep(nextMoveId))
		{
			laddersUsed ++;
			nextMove[2] = laddersUsed;
			
			findLadder = findLadderId(nextMoveId);
			board.ladders[findLadder].setBrokenValue(true);
			
			System.out.println("Hello ladder my old friend"); // Reference: Sound of Silence - Simon & Garfunkel
		}
		
		if(board.containApple(nextMoveId))
		{
			
			findApple = findAppleId(nextMoveId);
			board.apples[findApple].setPoints(0);
			
			
			if(board.apples[findApple].getColor() == "red")
			{
				
				redApplesEaten ++;
				nextMove[3] = redApplesEaten;
				
			}else if(board.apples[findApple].getColor() == "black")
			{
				
				blackApplesEaten ++;
				nextMove[4] = blackApplesEaten;
				
			}
				
			System.out.println("This apple is delicious, it has a strange taste though...");
			
		}
		
		return nextMove;
		
	}
	
	public int findAppleId(int c)
	{
		int appleId = 0;
		
		for(int i=0; i < board.apples.length; i++)
		{
			if(board.apples[i].getAppleId() == c)
			{
				appleId = i;
			}
		}
		
		return appleId;
	}
	
	public int findLadderId(int c)
	{
		int ladderId = 0;
		
		for(int i=0; i < board.ladders.length; i++)
		{
			if(board.ladders[i].getLadderId() == c)
			{
				ladderId = i;
			}
		}
		
		return ladderId;
	}
	
	
}
