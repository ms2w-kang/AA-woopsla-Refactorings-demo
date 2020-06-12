package dry03.introduce.polymorphic.creation.with.factory.method;

abstract class SSMobileProduct
{
	protected double price;
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double price)
	{
		this.price = price;
	}
	
	public abstract void prepare();
	public abstract void bundle();
	public abstract void label();
}
