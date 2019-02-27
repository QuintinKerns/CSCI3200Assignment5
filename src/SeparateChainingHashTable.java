import java.math.BigInteger;
import java.util.LinkedList;

public class SeparateChainingHashTable<E> {
	private LinkedList<E>[] table;
	private int defaultSize = 13;
	private int currentCount = 0;
	public SeparateChainingHashTable(int defaultSize) {
		buildTable(nextPrime(defaultSize));//ensure users number is a prime
	}
	public SeparateChainingHashTable() {
		buildTable(defaultSize);
	}
	public void printTable()
	{
		for(int i = 0; i < table.length; i++)
		{
			if(table[i].size() > 0)
			{
				System.out.print("Index "+i+":");
				for(E item : table[i])
				{
					System.out.print(item+",");
				}
				System.out.println();
			}
		}
	}
	public void makeEmpty()
	{
		for(int i = 0; i < table.length; i++)
		{
			table[i].clear();//empty each linked list
		}
	}
	public void insert(E obj)//about O(1) because linked list should be much less than N
	{
		int index = myHash(obj);//O(1)
		System.out.println(obj.hashCode()+":"+index);
		if(table[index].remove(obj))//O(L)
		{
			currentCount--;
		}
		table[index].add(obj);//O(1)
		currentCount++;
		/*
		 * long way to think about what top lines are doing
		if(table[index].contains(obj))//list already has value//O(L) where L is size of list
		{
			table[index].remove(obj);//O(L)
			table[index].add(obj);//O(1)
		}
		else//list does not have value
		{
			table[index].add(obj);//O(1)
		}
		*/
	}
	public boolean remove(E obj)//about O(1) because linked list should be much less than N
	{
		int index = myHash(obj);//O(1)
		boolean success = table[index].remove(obj);//O(L)
		if(success)
		{
			currentCount--;
		}
		return success;
	}
	public boolean contains(E obj)//about O(1) because linked list should be much less than N
	{
		int index = myHash(obj);//O(1)
		return table[index].contains(obj);//O(L)
	}
	private int myHash(E obj)
	{
		return obj.hashCode() % table.length;//return value from 0 to length-1
	}
	private void buildTable(int size)
	{
		table = new LinkedList[size];
		for(int i = 0; i < table.length; i++)
		{
			table[i] = new LinkedList<>();//create each linked list
		}
	}
	private int nextPrime(int n)
	{
		BigInteger bi = new BigInteger(""+n);
		return bi.nextProbablePrime().intValue();
	}
}







