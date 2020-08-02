package dry03.introduce.polymorphic.creation.with.factory.method;

/**
 * <h3>Symptom</h3>
 * <ul>
 * <li>Classes in a hierarchy implement a method similarly except for
 * an object creation step.
 * </ul>
 * <h3>Treatment</h3>
 * <ul>
 * <li>Make a single superclass version produceMobile the method that
 * calls a Factory Method to handle the instantiation.
 * </ul>
 */

/*
 * Produces "Thunder" and "Bolt"
 */
public class SeoulMobileFactory
{
	public SSMobileProduct produceMobile(String model)
	{
		SSMobileProduct mobile = null;

		if (model.equalsIgnoreCase("Thunder"))
		{
			mobile = new SSMobileThunder();
			mobile.setPrice(500);
		} else if (model.equalsIgnoreCase("Bolt"))
		{
			mobile = new SSMobileBolt();
			mobile.setPrice(300);
		}

		mobile.prepare();
		mobile.bundle();
		mobile.label();

		return mobile;
	}
}
