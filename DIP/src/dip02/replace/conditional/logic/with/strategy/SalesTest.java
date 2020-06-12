package dip02.replace.conditional.logic.with.strategy;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SalesTest
{
	private Sale sale;

	@Before
	public void setup()
	{
		sale = new Sale();
	}
	
	@Test
	public void should_return_zero_when_no_items_in_sale() throws Exception
	{
		sale = new Sale();
		double total = sale.getTotalWithDiscount();
		
		assertEquals(0, total, 0.1);
	}
	
	@Test
	public void should_return_total_without_deduction_when_default_discount_policy() throws Exception
	{
		sale = new Sale();
		sale.addItem(new Item(1, 100));
		sale.addItem(new Item(2, 50));
		double total = sale.getTotalWithDiscount();
		
		assertEquals(200, total, 0.1);
	}
	
	@Test
	public void should_always_return_total_with_deduction_when_percent_discount_policy() throws Exception
	{
		sale = new Sale();
		sale.setDiscountCode(Sale.Percent_Discount);
		sale.setPercentage(0.1);
		sale.addItem(new Item(1, 100));
		sale.addItem(new Item(2, 50));
		double total = sale.getTotalWithDiscount();
		
		assertEquals(180, total, 0.1);
	}
	
	@Test
	public void should_return_total_without_deduction_if_total_is_below_threshold_when_threshold_policy() throws Exception
	{
		sale = new Sale();
		sale.setDiscountCode(Sale.Threshold_Discount);
		sale.setThresholdData(new ThresholdData(300, 20));
		sale.addItem(new Item(1, 100));
		sale.addItem(new Item(2, 50));
		double total = sale.getTotalWithDiscount();
		
		assertEquals(200, total, 0.1);
	}
	
	@Test
	public void should_return_total_with_deduction_if_total_is_above_threshold_when_threshold_policy() throws Exception
	{
		sale = new Sale();
		sale.setDiscountCode(Sale.Threshold_Discount);
		sale.setThresholdData(new ThresholdData(300, 20));
		sale.addItem(new Item(1, 100));
		sale.addItem(new Item(2, 50));
		sale.addItem(new Item(1, 120));
		double total = sale.getTotalWithDiscount();
		
		assertEquals(300, total, 0.1);
	}
}
