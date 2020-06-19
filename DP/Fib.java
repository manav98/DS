//FIBNACCI SERIES
public class Fib
{
	private static int fib(int[] arr, int num)	//MEMOIZATION
	{
		if(arr[num] > Integer.MAX_VALUE)
		{
			return arr[num];
		}
		else
		{
			int value;
			if(num == 0 || num == 1)
			{
				value = num;
			}
			else
			{
				value = fib(arr, num-1) + fib(arr, num-2);
			}
			arr[num] = value;
			return value;
		}
	}
	
	private static int fibonacci(int num)	//MEMOIZATION APPROACH
	{
		int[] arr = new int[num+1];
		for(int i=0;i<arr.length; i++)
		{
			arr[i] = Integer.MAX_VALUE;
		}
		return fib(arr,num);
	}
	
	private static int findFib(int num)	//DYNAMIC PROGRAMMING APPROACH		SOLVED IN TOPOLOGICAL ORDER
	{
		if(num < 2)
		{
			return num;
		}
		int[] fibtable = new int[num+1];
		fibtable[0] = 0;
		fibtable[1] = 1;
		for(int i=2; i <= num; i++)
		{
			fibtable[i] = fibtable[i-1] + fibtable[i-2];
		}
		return fibtable[num];
	}
	
	public static void main(String[] args)
	{
		for(int i=0;i<11;i++)
		{
			System.out.println(findFib(i));
		}
	}
}
