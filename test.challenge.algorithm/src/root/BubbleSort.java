package root;

import java.util.List;

public class BubbleSort implements ISort{

	@Override
	public void sort(List<Integer> numbers){
		for(int i = numbers.size() - 1; i >= 0; i--){
			for(int j = 0; j < i; j++){
				if(numbers.get(j) > numbers.get(j+1)){
					int oldJ = numbers.get(j);
					numbers.set(j,numbers.get(j+1));
					numbers.set(j+1,oldJ);
				}
			}
		}
	}
}
