
public class Ladder {
	
	int ladderId;
	int upStepId;
	int downStepId;
	boolean broken;
	
	public Ladder() {
		ladderId = 0;
		upStepId = 0;
		downStepId = 0;
		broken = false;
	}
	
	public int getLadderId()
	{
		return ladderId;
	}
	
	public int getUpStepId()
	{
		return upStepId;
	}
	
	public int getDownStepId()
	{
		return downStepId;
	}
	
	public boolean getBrokenValue() 
	{
		return broken;
	}
	
	public void setLadderId(int l)
	{
		ladderId = l;
	}
	
	public void setUpStepId(int u)
	{
		upStepId = u;
	}
	
	public void setDownStepId(int d)
	{
		downStepId = d;
	}
	
	public void setBrokenValue(boolean b)
	{
		broken = b;
	}

}
