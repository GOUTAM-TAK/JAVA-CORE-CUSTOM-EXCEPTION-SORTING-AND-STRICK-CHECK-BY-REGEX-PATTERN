package sortingCriteria;

import java.util.Comparator;

import core.Customer;

public class SorterForFirstName implements Comparator<Customer>{

	@Override
	public int compare(Customer obj1, Customer obj2)
	{
		return obj1.getFirstName().compareTo(obj2.getFirstName());
	}
	
}
