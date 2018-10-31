
public class Snake {

	int snakeId;
	int headId;
	int tailId;
	
	public Snake() {
		snakeId = 0;
		headId = 0;
		tailId = 0;
	}
	
	
	public int getSnakeId()
	{
		return snakeId;
	}
	
	public int getHeadId()
	{
		return headId;
	}
	
	public int getTailId()
	{
		return tailId;
	}
	
	public void setSnakeId(int s)
	{
		snakeId = s;
	}
	
	public void setHeadId(int h)
	{
		headId = h;
	}
	
	public void setTailId(int t)
	{
		tailId = t;
	}
	
}
