import java.math.BigInteger;

public class LinearProbingHashTable<E> {
	private E[] table;
	private int defaultSize = 13;
	private int currentCount = 0;
	private double load = 0.5;

	public LinearProbingHashTable(int size)
	{
		table = (E[])new Object[nextPrime(size)];
	}
	public LinearProbingHashTable()
	{
		table = (E[])new Object[defaultSize];
	}
	public void makeEmpty()
	{
		table = (E[])new Object[table.length];
	}
	public void printTable()
	{
		for(int i = 0; i < table.length; i++)
		{
			if(table[i] != null)
			{
				System.out.print("Index "+i+":");
				System.out.print(table[i]+":expected index:"+myHash(table[i]));
				System.out.println();
			}
		}
	}
	public int tableSize()
	{
		return table.length;
	}
	private void rehash()
	{
		E[] temp = table;
		table = (E[])new Object[nextPrime(table.length*2)];
		for(int i = 0; i < temp.length; i++)
		{
			if(temp[i] != null)
			{
				insert(temp[i]);
			}
		}
	}
	public void insert(E obj)//about O(1)
	{
		if((currentCount+1)/(double)table.length > load)
		{
			rehash();
		}

		int index = myHash(obj);//O(1)
		if(table[index] == null)//expected location is empty
		{
			table[index] = obj;
			currentCount++;
			return;
		}
		else//position taken
		{
			while(index < table.length && table[index] != null)
			{
				index++;
			}
			if(index < table.length && table[index] == null)
			{
				table[index] = obj;
				currentCount++;
				return;
			}
		}
		rehash();
		insert(obj);
	}
	public boolean contains(E obj)//about O(1)
	{
		int index = myHash(obj);//O(1)
		while(index < table.length && table[index] != null && !table[index].equals(obj))
		{
			index++;
		}
		if(index < table.length && table[index] != null && table[index].equals(obj))
		{
			return true;
		}
		return false;
	}
	public void remove(E obj)
	{
		int index = myHash(obj);//O(1)
		while(index < table.length && table[index] != null && !table[index].equals(obj))
		{
			index++;
		}
		if(index < table.length && table[index] != null && table[index].equals(obj))
		{
			table[index] = null;
			currentCount--;
			shift(index);
		}
	}
	private void shift(int pos)
	{
		int temp = pos+1;
		while(temp < table.length && table[temp] != null && myHash(table[temp]) > pos)
		{
			temp++;
		}
		if(temp < table.length && table[temp] != null && myHash(table[temp]) <= pos)
		{
			table[pos] = table[temp];
			table[temp] = null;
			shift(temp);
		}
	}
	private int myHash(E obj)
	{
		return obj.hashCode() % table.length;//return value from 0 to length-1
	}
	private int nextPrime(int n)
	{
		BigInteger bi = new BigInteger(""+n);
		return bi.nextProbablePrime().intValue();
	}
}
