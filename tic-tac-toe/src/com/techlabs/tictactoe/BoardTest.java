package com.techlabs.tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BoardTest {

	@Test
	void testBoard() {
		int expectedsize = 4;
		int expectedarr_len = 16;

		Board b = new Board(4);
		int size = b.getSize();
		int arr_len = b.asArray().length;

		assertEquals(expectedsize, size);
		assertEquals(expectedarr_len, arr_len);
	}

	@Test
	void testFill() throws CellIsAlreadyFilled {
		Mark[] expected_arr = { null, Mark.O, null, null, null, null, null, null, null };

		Board b = new Board(3);
		b.fill(1, Mark.O);
		Mark[] arr = b.asArray();

		for (int i = 0; i < expected_arr.length; i++) {
			assertEquals(expected_arr[i], arr[i]);
		}
	}

}
