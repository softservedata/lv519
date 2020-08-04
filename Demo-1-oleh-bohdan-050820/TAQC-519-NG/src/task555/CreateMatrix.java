package task555;
public class CreateMatrix {

	public int[][] matrix(int nM) {
		if (nM < 1) {
			throw new IllegalArgumentException("Invalid argument");
		}
		int[][] a = new int[nM][];
		for (int i = 0; i <= nM - 1; i++) {
			a[i] = new int[i + 1];
		}

		a[0][0] = 1;
		for (int i = 1; i < nM; i++) {
			int j = 0;
			a[i][j] = 1;
			while (j < i - 1) {
				j++;
				a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
			}
			a[i][i] = 1;
		}
		return a;
	}

	public int[][] matrix(OneNumber numberN) {
		return matrix(numberN.getN());
	}
}
