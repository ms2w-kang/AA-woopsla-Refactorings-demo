package dry03.introduce.polymorphic.creation.with.factory.method;

public class SSMobileBolt extends SSMobileProduct
{
	@Override
	public void prepare()
	{
		System.out.println("SSMobileBolt prepare ...");
	}

	@Override
	public void bundle()
	{
		System.out.println("SSMobileBolt bundle ...");
	}

	@Override
	public void label()
	{
		System.out.println("SSMobileBolt label ...");		
	}

}
