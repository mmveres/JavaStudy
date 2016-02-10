package decorator.beverages;

public abstract class Beverage {
	public static final int SIZE_SMALL=1;
	public static final int SIZE_MID=2;
	public static final int SIZE_BIG=3;
	
	protected String description="Unknown beverage";
	
	public String getDescription() {
		
		return description;
	}
	public abstract float getCost();
	public abstract int getSize();
	public abstract void setSize(int size);
	

}
