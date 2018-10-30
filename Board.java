
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

void createBoard()
{
	
	for(int i=0; i<snakes.length; i++)
	{
		do {
			
			snakes[i].setSnakeId(i);
			snakes[i].setHeadId((int)(Math.random() * (N*M) + 1));
			snakes[i].setTailId((int)(Math.random() * (N*M) + 1));
			
		}while(snakes[i].getHeadId() > snakes[i].getTailId());
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
		/*do {
			apples[i].setAppleId(i);
			apples[i].setAppleTileId((int)(Math.random()* (N*M) + 1));
		}while(apples[i].getAppleTileId() != snakes[i].getHeadId());
		*/
		
		apples[i].setAppleId(i);
		apples[i].setAppleTileId((int)(Math.random()* (N*M) + 1));
		
		while(containSnakeHead(apples[i].getAppleTileId()) == false);
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


}