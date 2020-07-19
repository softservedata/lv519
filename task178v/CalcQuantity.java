package task178v;

import java.util.List;

public class CalcQuantity {
	public int numberFigures(List<Integer> list) {
		if(list==null) {
			throw new IllegalArgumentException("Invalid data");
		}
		int k = 0;
		for (int i = 0; i < list.size(); i++) {
			if (Math.sqrt(list.get(i)) % 2 == 0) {
				k++;
			}
		}
		return k;
	}
}


		