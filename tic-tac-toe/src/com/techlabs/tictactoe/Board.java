package com.techlabs.tictactoe;

public class Board {

	private Mark[] arr;
	private int size;

	public Board(int size) {
		this.size = size;
		arr = new Mark[size * size];
	}

	public void fill(int a, Mark m) throws CellIsAlreadyFilled {
		if (arr[a] == null) {
			arr[a] = m;
		} else {
			throw new CellIsAlreadyFilled("Cell is filled");
		}
	}

	public Mark[] asArray() {
		return arr;
	}

	public int getSize() {
		return size;
	}

}
