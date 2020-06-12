package dip02.replace.conditional.logic.with.strategy;

public class ThresholdData
{
	private double thresholdAmount;
	private int discountAmount;

	public ThresholdData(double thresholdAmount, int discountAmount)
	{
		this.thresholdAmount = thresholdAmount;
		this.discountAmount = discountAmount;
	}

	public double getThresholdAmount()
	{
		return thresholdAmount;
	}

	public int getDiscountAmount()
	{
		return discountAmount;
	}
}