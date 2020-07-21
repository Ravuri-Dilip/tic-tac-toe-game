package com.techlabs.tictactoe;

public class CellIsAlreadyFilled extends Exception {
	CellIsAlreadyFilled(String s) {
		super(s);
	}
}
