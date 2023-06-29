package JavaLearnings;

public class TwoDimensionalArray {
	public static void main(String[] args) {
		int num = 1;
		int[][] numbers = new int[11][11];

		for (int i = 1; i < 11; i++) {
			for (int j = 1; j < 11; j++) {
				numbers[i][j] = i * j;

			}
		}

		for (int i = 1; i < 11; i++) {
			for (int j = 1; j < 11; j++) {
				System.out.print(numbers[i][j] + " ");
			}
			System.out.println();

		}
	}

}
