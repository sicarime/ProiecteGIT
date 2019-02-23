package P3_RevesePolishNotation_RadixSort;

import java.util.LinkedList;
import java.util.Queue;


public class RadixSort 
{
	
	public static void radixSortAsc(int[] arr) 
	{
		int radix;
		int digits = maxDigits(getMax(arr));
		Queue<Integer>[] digitQueues = new LinkedList[10]; 
		
		for (int q = 0; q < 10; q++) 
		{
			digitQueues[q] = new LinkedList<>();
		}

		for (int it = 1; it <= digits; it++)
		{
			for (int i = 0; i<arr.length; i++) 
			{
				radix = getRadix(arr[i], it);
				digitQueues[radix].offer(arr[i]);
			}

			int i = 0;
			for (int k = 0; k < digitQueues.length; k++)
			{
				while (digitQueues[k].peek() != null) 
				{
					arr[i] = (int) digitQueues[k].poll(); 
					i++;
				}
			}
		}
		System.out.print("Array sortat ascendent: "); 
		printArray(arr);
		System.out.println();
	}
	
	public static void radixSortDesc(int[] arr) 
	{
		int radix;
		int it = maxDigits(getMax(arr));
		Queue<Integer>[] digitQueues = new LinkedList[10];

		for (int q = 0; q < 10; q++) 
		{
			digitQueues[q] = new LinkedList<Integer>();
		}

		for (int digits = 1; digits <= it; digits++)
		{
			for (int i = 0; i<arr.length; i++) 
			{
				radix = getRadix(arr[i], digits);
				digitQueues[radix].offer(arr[i]);
			}
			
			int i=0;
			for (int k = digitQueues.length - 1; k >= 0; k--)
			{
				while (digitQueues[k].peek() != null) 
				{
					arr[i] = (int) digitQueues[k].poll(); 
					i++;
				}
			}
		}
		System.out.print("Array sortat descendent: "); 
		printArray(arr);
		System.out.println();
	}
	
    public static int getMax(int[] arr) 
    { 
        int max = arr[0]; 
        for (int i = 1; i < arr.length; i++) 
            if (arr[i] > max) 
                max = arr[i]; 
        return max; 
    }
    
    public static int maxDigits(int number) 
    { 
    	number = Math.abs(number); 
    	if (number < 10) 
    	{
    		return 1;
    	} else if (number < 100) 
    	{
    		return 2;
    	} else if (number < 1000) 
    	{
    		return 3;
    	} else if (number < 10_000) 
    	{
    		return 4;
    	} else if (number < 100_000)
    	{
    		return 5;
    	} else if (number < 1_000_000)
    	{
    		return 6;
    	} else if (number < 10_000_000)
    	{
    		return 7;
    	} else if (number < 100_000_000)
    	{
    		return 8;
    	} else 
    	{
    		return 9;
    	}
    }
    
    public static int getRadix(int number, int radix)
    {
      return (int)(number / Math.pow(10,radix-1)) % 10;
    }
    
    public static void printArray(int[] arr)  
    {
    	for(int i = 0; i<arr.length; i++) 
    	{
    		System.out.print(arr[i] + " ");
    	}
    }
     
	public static void main(String[] args) 
	{
		int[] arr = {170, 45, 75, 90, 02, 802, 2, 66};
		int[] arr2 = {1000, 4, 25, 319, 88, 51, 3430, 8471, 701, 1, 1252252989, 657, 713, 0};
		printArray(arr);
		System.out.println();
		radixSortAsc(arr);
		radixSortDesc(arr);
		
		printArray(arr2);
		System.out.println();
		radixSortAsc(arr2);
		radixSortDesc(arr2);
		
	}

}
