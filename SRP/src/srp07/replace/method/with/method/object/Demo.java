package srp07.replace.method.with.method.object;

public class Demo
{
	private int state = 3;
	
	public int getTripleState()
	{
		return state * 3;
	}
	
	public int foo(int firstParam, int secondParam)
	{
		int value1 = firstParam * secondParam;
		int value2 = firstParam * getTripleState();
		
		if ((value1 - value2) % 2 == 0) 
		{
			return value1 - 2;
		}
		return value2 + 4;
	}
}

