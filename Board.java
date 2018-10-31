
public class Board {
	
	int N;
	int M;
	int[][] tiles;
	Snake[] snakes;
	Ladder[] ladders;
	Apple[] apples;
	



public Board(int nLength, int mLength, int s, int l, int a)
{
	
	N = nLength;
	M = mLength;
	tiles = new int[N][M];
	snakes = new Snake[s];
	ladders = new Ladder[l];
	apples = new Apple[a];
	
}

public Board(Board b)
{
	
}

//Getters
public Snake getSnakesMatrix(int s)
{
	return snakes[s];
}

public int getSnakesMatrixLength()
{
	return snakes.length;
}

public Ladder getLaddersMatrix(int l)
{
	return ladders[l];
}

public int getLaddersMatrixLength()
{
	return ladders.length;
}

public Apple getApplesMatrix(int a)
{
	return apples[a];
}

public int getApplesMatrixLength()
{
	return apples.length;
}

//Setters
public void setApplesMatrix(Apple a, int aPos) {
	   apples[aPos] = a;
	}

public void setLaddersMatrix(Ladder l, int lPos) {
	ladders[lPos] = l;
}

public void setSnakesMatrix(Snake s, int sPos) {
	snakes[sPos] = s;
}


void createBoard()
{
	/* Inserting values of Snake Object at random IDs*/
	for(int i=0; i<snakes.length; i++)
	{
		do {
			
			snakes[i].setSnakeId(i);
			snakes[i].setHeadId((int)(Math.random() * (N*M) + 1)); // (N*M) + 1 means that our range will be 1 ~ (N*M)
			snakes[i].setTailId((int)(Math.random() * (N*M) + 1));
			
		}while(snakes[i].getHeadId() > snakes[i].getTailId()); // Ensuring that the head of the snake is above of the tail.
	}
	
	for(int i=0; i<ladders.length; i++)
	{
		do {
			
			ladders[i].setLadderId(i);
			ladders[i].setUpStepId((int)(Math.random() * (N*M) + 1));
			ladders[i].setDownStepId((int)(Math.random() * (N*M) + 1));
			
		}while(ladders[i].getUpStepId() > ladders[i].getDownStepId());
	}
	
	for(int i=0; i<apples.length; i++)
	{
		
		apples[i].setAppleId(i);
		apples[i].setAppleTileId((int)(Math.random()* (N*M) + 1));
		
		while(containSnakeHead(apples[i].getAppleTileId()) == false); // Using this function we make sure that there is no head of a snake on this tile.
	}
}

public void createElementBoard() {
	String[][] elementBoardSnakes = new String[N][M];
	String[][] elementBoardLadders = new String[N][M];
	String[][] elementBoardApples = new String[N][M];
	
	for(int i=1; i < N+1; i++)
	{
		for(int j=1; j < M+1; j++)
		{
			
			for(int k=0; k < snakes.length; k++)
			{
				if(snakes[k].getHeadId() == i*j)
				{
					elementBoardSnakes[i][j] = "SH" + snakes[k].snakeId;
				}
				
				else if(snakes[k].getTailId() == i*j)
				{
					elementBoardSnakes[i][j] = "ST" + snakes[k].snakeId;
				}
				
				else
				{
					elementBoardSnakes[i][j] = "___";
				}
			}
			
			for(int k=0; k < ladders.length; k++)
			{
				if(ladders[k].getUpStepId() == i*j)
				{
					elementBoardLadders[i][j] = "LU" + ladders[k].ladderId;
				}
				
				else if(ladders[k].getDownStepId() == i*j)
				{
					elementBoardLadders[i][j] = "LD" + ladders[k].ladderId;
				}
				
				else
				{
					elementBoardLadders[i][j] = "___";
				}
			
			}
			
			
			for(int k=0; k < apples.length; k++)
			{
				
				if(apples[k].getAppleTileId() == i*j)
				{
					if(apples[k].getColor() == "red")
					{
						elementBoardApples[i][j] = "AR" + apples[k].getAppleId();
					}
					else if(apples[k].getColor() == "black")
					{
						elementBoardApples[i][j] = "AB" + apples[k].getAppleId();
					}
				}
				else
				{
						elementBoardApples[i][j] = "___";
				}
				
			}
			
		}
	}
		
}


public boolean containSnakeHead(int c)
{
	int flag=0;
	
	for(int i=0; i<snakes.length; i++)
	{
		if(c == snakes[i].getHeadId())
		{
			flag ++;
		}
	
	}
	
	if(flag != 0) {
		return true;
	}
	else {
		return false;
	}
	
}	

public boolean containUpperStep(int c)
{
	int flag=0;
	
	for(int i=0; i<ladders.length; i++)
	{
		if(c == ladders[i].getUpStepId())
		{
			flag ++;
		}
	
	}
	
	if(flag != 0) {
		return true;
	}
	else {
		return false;
	}
	
}	

public boolean containApple(int c)
{
	int flag=0;
	
	for(int i=0; i<apples.length; i++)
	{
		if(c == apples[i].getAppleTileId())
		{
			flag ++;
		}
	
	}
	
	if(flag != 0) {
		return true;
	}
	else {
		return false;
	}
	
}	




}