package task178b;

import java.util.List;

public class CalcQuantity {
	public int numberFigures(List<Integer> list) {
		if(list==null) {
			throw new IllegalArgumentException("Invalid data");
		}
		int k = 0;
		for (int i = 0; i < list.size(); i++) {
			if ((list.get(i) % 3 == 0) && (list.get(i) % 5 != 0)) {
				k++;
			}
		}
		return k;
	}
}
