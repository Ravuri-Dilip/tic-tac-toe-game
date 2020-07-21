package com.techlabs.tictactoe;

public class ResultAnalyser {

	public static Result checkResult(Board b) {
		Mark[] arr = b.asArray();
		int size = b.getSize();
		if (checkRows(arr, size) || checkColumns(arr, size) || checkDiagonals(arr, size)) {
			return Result.WIN;
		}
		for (Mark mark : arr) {
			if (mark == null) {
				return null;
			}
		}
		return Result.DRAW;
	}

	private static boolean checkRows(Mark[] arr, int size) {
		boolean[] a = new boolean[size];
		for (int i = 0; i < a.length; i++) {
			a[i] = false;
		}
		for (int i = 0; i < size; i++) {
			Mark prev_value = arr[size * i];
			if (prev_value == null) {
				continue;
			}
			for (int j = size * i + 1; j < size * (i + 1); j++) {

				if (prev_value != arr[j]) {
					break;
				}
				if (j == size * (i + 1) - 1) {
					a[i] = true;
				}
			}
		}
		for (boolean b : a) {
			if (b)
				return true;
		}
		return false;

	}

	private static boolean checkColumns(Mark[] arr, int size) {

		boolean[] a = new boolean[size];
		for (int i = 0; i < a.length; i++) {
			a[i] = false;
		}
		for (int i = 0; i < size; i++) {
			Mark prev_value = arr[i];
			if (prev_value == null) {
				continue;
			}
			for (int j = 0 + 1; j < size; j++) {

				if (prev_value != arr[size * j + i]) {
					break;
				}
				if (j == size - 1) {
					a[i] = true;
				}
			}
		}
		for (boolean b : a)
			if (b)
				return true;
		return false;

	}

	private static boolean checkDiagonals(Mark[] arr, int size) {
		boolean a = false;
		Mark prev_value = arr[0];
		if (prev_value == null) {

		} else {
			for (int j = 0; j < size; j++) {

				if (prev_value != arr[(size + 1) * j]) {
					break;
				}
				if (j == size - 1) {
					a = true;
				}
			}
		}
		prev_value = arr[size - 1];
		if (prev_value == null) {

		} else {
			for (int j = 0 + 1; j < size; j++) {

				if (prev_value != arr[(size - 1) * (j + 1)]) {
					break;
				}
				if (j == size - 1) {
					a = true;
				}
			}
		}
		return a;
	}
}