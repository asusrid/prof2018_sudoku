package es.upm.grise.profundizacion2018.sudokuverifier;

public class SudokuVerifier {

	public SudokuVerifier() {
	}

	public int verify(String candidateSolution) {

		String[] numbers = candidateSolution.split("");
		String[] matrix = new String[9];
		
		// RULE NUMBER 1
		if(rule1(numbers, candidateSolution)) {
			return -1;
		}

		// RULE NUMBER 2
		if (rule2(numbers)) {
			return -2;
		}

		// RULE NUMBER 3
		if(rule3(numbers, matrix)) {
			return -3;
		}
		

		// RULE NUMBER 4
		if(rule4(matrix)) {
			return -4;
		}

		return 0;
	}

	public boolean rule1(String[] numbers, String candidateSolution) {

		boolean res = false;

		if (numbers.length < 81) {
			res = true;
		}
		if (candidateSolution.contains("0") || candidateSolution.contains(".") || candidateSolution.contains("-")
				|| candidateSolution.contains(",")) {
			res = true;
		}

		return res;
	}

	public boolean rule2(String[] numbers) {

		String[] matrixSubgrid = new String[9];
		boolean res = false;

		for (int j = 0; j < numbers.length; j++) {
			if ((j >= 0 && j < 3) || (j >= 9 && j < 12) || (j >= 18 && j < 21)) {
				if (matrixSubgrid[0] == null) {
					matrixSubgrid[0] = numbers[j];
				} else if (!matrixSubgrid[0].contains(numbers[j])) {
					matrixSubgrid[0] += numbers[j];
				} else {
					res = true;
				}

			} else if ((j >= 3 && j < 6) || (j >= 12 && j < 15) || (j >= 21 && j < 24)) {
				if (matrixSubgrid[1] == null) {
					matrixSubgrid[1] = numbers[j];
				} else if (!matrixSubgrid[1].contains(numbers[j])) {
					matrixSubgrid[1] += numbers[j];
				} else {
					res = true;
				}

			} else if ((j >= 6 && j < 9) || (j >= 15 && j < 18) || (j >= 24 && j < 27)) {
				if (matrixSubgrid[2] == null) {
					matrixSubgrid[2] = numbers[j];
				} else if (!matrixSubgrid[2].contains(numbers[j])) {
					matrixSubgrid[2] += numbers[j];
				} else {
					res = true;
				}

			} else if ((j >= 27 && j < 30) || (j >= 36 && j < 39) || (j >= 45 && j < 48)) {
				if (matrixSubgrid[3] == null) {
					matrixSubgrid[3] = numbers[j];
				} else if (!matrixSubgrid[3].contains(numbers[j])) {
					matrixSubgrid[3] += numbers[j];
				} else {
					res = true;
				}

			} else if ((j >= 30 && j < 33) || (j >= 39 && j < 42) || (j >= 48 && j < 51)) {
				if (matrixSubgrid[4] == null) {
					matrixSubgrid[4] = numbers[j];
				} else if (!matrixSubgrid[4].contains(numbers[j])) {
					matrixSubgrid[4] += numbers[j];
				} else {
					return true;
				}

			} else if ((j >= 33 && j < 36) || (j >= 42 && j < 45) || (j >= 51 && j < 54)) {
				if (matrixSubgrid[5] == null) {
					matrixSubgrid[5] = numbers[j];
				} else if (!matrixSubgrid[5].contains(numbers[j])) {
					matrixSubgrid[5] += numbers[j];
				} else {
					res = true;
				}

			} else if ((j >= 54 && j < 57) || (j >= 63 && j < 66) || (j >= 72 && j < 75)) {
				if (matrixSubgrid[6] == null) {
					matrixSubgrid[6] = numbers[j];
				} else if (!matrixSubgrid[6].contains(numbers[j])) {
					matrixSubgrid[6] += numbers[j];
				} else {
					res = true;
				}

			} else if ((j >= 57 && j < 60) || (j >= 66 && j < 69) || (j >= 75 && j < 78)) {
				if (matrixSubgrid[7] == null) {
					matrixSubgrid[7] = numbers[j];
				} else if (!matrixSubgrid[7].contains(numbers[j])) {
					matrixSubgrid[7] += numbers[j];
				} else {
					res = true;
				}

			} else if ((j >= 60 && j < 63) || (j >= 69 && j < 72) || (j >= 78 && j < 81)) {
				if (matrixSubgrid[8] == null) {
					matrixSubgrid[8] = numbers[j];
				} else if (!matrixSubgrid[8].contains(numbers[j])) {
					matrixSubgrid[8] += numbers[j];
				} else {
					res = true;
				}
			}
		}
		return res;
	}

	public boolean rule3(String[] numbers, String[] matrix) {
		
		boolean res = false;
		
		for (int i = 0; i < numbers.length / 9; i++) {
			for (int j = i * 9; j < (i + 1) * 9; j++) {
				if (matrix[i] == null) {
					matrix[i] = numbers[j];
				} else if (!matrix[i].contains(numbers[j])) {
					matrix[i] += numbers[j];
				} else {
					res = true;
				}
			}
		}
		return res;
	}
	
	public boolean rule4(String[] matrix) {
		
		boolean res = false;
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				for (int k = 0; k < matrix.length; k++) {
					if (matrix[j].split("")[i].equals(matrix[k].split("")[i]) && j != k) {
						res = true;
					}
				}
			}
		}
		return res;
	}
	
}
