package root;

import java.util.ArrayList;
import java.util.List;

import root.aux.CountedNumber;


public class BucketSort implements ISort{

	@Override
	public void sort(List<Integer> numbers) {
		
		// Computing the max number in the list
		int max = -1;
		for (Integer integer : numbers) {
			if(integer > max)
				max = integer.intValue();
		}
		
		// Creating the auxiliary array with numbers in their position.
		CountedNumber[] auxiliary = new CountedNumber[max + 1];
		for (int i = 0; i < numbers.size(); i++) {
			if(auxiliary[numbers.get(i)] == null){
				CountedNumber number = new CountedNumber(numbers.get(i));
				auxiliary[numbers.get(i)] = number;
			}else{
				auxiliary[numbers.get(i)].increaseCount();
			}
		}
		
		// Building the sorted list
		List<Integer> sorted = new ArrayList<Integer>();
		for (int i = 0; i < auxiliary.length; i++) {
			CountedNumber current = auxiliary[i];
			if(current != null){
				for (int j = 0; j < current.getCount(); j++) {
					sorted.add(current.getNumber());
				}
			}
		}
		
		numbers.clear();
		numbers.addAll(sorted);
	}
}
