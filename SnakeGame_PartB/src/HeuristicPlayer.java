import java.util.*;

public class HeuristicPlayer extends Player{
	
	ArrayList<Integer> path=new ArrayList<Integer>(); 
	
	public HeuristicPlayer()
	{
		super();
		
		for(int k=0; k<6; k++)
		{
			path.set(k,0);
		}
	}
	
	public HeuristicPlayer(int[] path, int playerId, String name, int score, Board board) {
		super(playerId, name, score, board);
		
		for(int k=0; k<6; k++)
		{
			this.path.set(k, path[k]);
		}
	}


	public double evaluate(int currentPos, int dice)
	{
		double evaluation = 0;
		int numberOfSteps = 0;
		int[] check_move = new int[4];
		
		
		for(int i=0; i<5; i++)
		{
			check_move[i] = 0;
		}
		
		if(dice == 1)
		{
			numberOfSteps = dice;
			check_move = virtual_move(currentPos, numberOfSteps);
		}
		else if(dice == 2)
		{
			numberOfSteps = 3;
			check_move = virtual_move(currentPos, numberOfSteps);
		}
		else if(dice == 3)
		{
			numberOfSteps = 10;
			check_move = virtual_move(currentPos, numberOfSteps);
		}
		else if(dice == 4)
		{
			numberOfSteps = 5;
			check_move = virtual_move(currentPos, numberOfSteps);
		}
		else if(dice == 5)
		{
			numberOfSteps = 7;
			check_move = virtual_move(currentPos, numberOfSteps);
		}
		else if(dice == 6)
		{
			numberOfSteps = 11;
			check_move = virtual_move(currentPos, numberOfSteps);
		}
		
		evaluation = numberOfSteps * 1.25 + check_move[2] * 6.5 + check_move[3] * 0.5 * 5  - check_move[4] * 0.5 * 5;  
		
		if(check_move[1] > 0)
		{
		evaluation = Math.random()*1;
		}
		
		return evaluation;
	}
	
	
	public int getNextMove(int currentPos) 
	{
		double[] evaluated_moves = new double[5];
		double max_evaluation = 0;
		int index_max = 0;
		int[] numberOfSteps = {1,3,10,5,7,11};
		int[] bestMove = new int[5];
		int i;
		
		for(i=1; i<7; i++)
		{
			evaluated_moves[i] = evaluate(currentPos, i);
			
			if(evaluated_moves[i] > max_evaluation)
			{
				max_evaluation = evaluated_moves[i];
				index_max = i;
			}
		}
		
		bestMove = move(currentPos, numberOfSteps[index_max]);
		
		path.set(0,numberOfSteps[index_max]);
		path.set(1,index_max);
		path.set(2,bestMove[1]);
		path.set(3,bestMove[2]);
		path.set(4,bestMove[3] + bestMove[4]);
		
		//TODO: We need to get somehow the red and black apple points.
		path.set(5,bestMove[3] * 10 - bestMove[4] * 10);
		
		
		return currentPos + numberOfSteps[index_max];
	}
	
	void statistics()
	{
		System.out.println("Number of snakes that ate me:" + path.get(1));
		
		System.out.println("Number of ladders I climbed:" + path.get(2));
		
		System.out.println("Number of red apples I ate:" + path.get(3));
		
		System.out.println("Number of black apples I ate:" + path.get(4));
	}
	
	
	public int[] virtual_move(int id, int die) {
		int newPosition = id + die;
		boolean flag;
		int[] result = new int[5];
		for (int i = 0; i < result.length; i++) {
			result[i] = 0;
		}
		
		do {
			flag = false;
			// check for snake' s head
			for (int j = 0; j < board.getSnakes().length ; j++) {
				 if (board.getSnakes()[j].getHeadId() == newPosition) {
					 flag = true;
					 newPosition = board.getSnakes()[j].getTailId();
					 result[1]++;
					 //System.out.println(name + " was bitten by a snake");
					 break;
				 }
			 }
			
			// check for ladder's downstep 
			for (int j = 0; j < board.getLadders().length ; j++) {
				 if (board.getLadders()[j].getDownStepId() == newPosition) {
					 if (board.getLadders()[j].getBroken() == false) {
						 flag = true;
						 newPosition = board.getLadders()[j].getUpStepId();
						 result[2]++;
						// System.out.println(name + " climped a ladder");
						 board.getLadders()[j].setBroken(true);
						 break;
					 }
				 }
			 }
			
			// check for apple
			for (int j = 0; j < board.getApples().length ; j++) {
				 if (board.getApples()[j].getAppleTileId() == newPosition) {
					 if (board.getApples()[j].getColor() == "red"){
					     score += board.getApples()[j].getPoints(); 
					     result[3]++;
					 }else {
						 score -= board.getApples()[j].getPoints();
						 result[4]++;
					 }
					 board.getApples()[j].setPoint(0); 
					 //System.out.println(name + " ate a " + board.getApples()[j].getColor() + " apple");
					 break;
				 }
			 }
		} while(flag);

		result[0] = newPosition;
		return(result);
	}
	
}
