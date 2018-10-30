
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