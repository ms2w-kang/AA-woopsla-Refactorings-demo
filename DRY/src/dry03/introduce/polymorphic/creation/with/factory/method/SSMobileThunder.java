package dry03.introduce.polymorphic.creation.with.factory.method;

public class SSMobileThunder extends SSMobileProduct
{
	@Override
	public void prepare()
	{
		System.out.println("SSMobileThunder prepare ...");
	}

	@Override
	public void bundle()
	{
		System.out.println("SSMobileThunder bundle ...");
	}

	@Override
	public void label()
	{
		System.out.println("SSMobileThunder label ...");		
	}

}
