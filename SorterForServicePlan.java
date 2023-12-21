package sortingCriteria;

import java.util.Comparator;

import core.Customer;

public class SorterForServicePlan implements Comparator<Customer>{
	
	
	@Override
	public int compare(Customer obj1, Customer obj2)
	{
		return obj1.getPlan().toString().compareTo(obj2.getPlan().toString());
	}
	
}
