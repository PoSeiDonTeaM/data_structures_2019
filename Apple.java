
public class Apple {

	int appleId;
	int appleTileId;
	int points;
	String color;
	
	public Apple() {
		appleId = 0;
		appleTileId = 0;
		points = 10;
	}
	
	// Getters
	public int getAppleId()
	{
		return appleId;
	}
	
	public int getAppleTileId()
	{
		return appleTileId;
	}
	
	public int getPoints()
	{
		return points;
	}
	
	public String getColor() {
		return color;
	}
	
	
	// Setters
	public void setAppleId(int a)
	{
		appleId = a;
	}
	
	public void setAppleTileId(int at)
	{
		appleTileId = at;
	}
	
	public void setPoints(int p)
	{
		points = p;
	}
	
	public void setColor(String c)
	{
		color = c;
	}
	
}
