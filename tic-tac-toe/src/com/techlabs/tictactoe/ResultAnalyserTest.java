package com.techlabs.tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ResultAnalyserTest {

	@Test
	void testCheckResult() throws CellIsAlreadyFilled {
		//
		Result expectedResult1 = null;
		Result expectedResult2 = Result.WIN;

		//
		Board b = new Board(4);
		Result r1 = ResultAnalyser.checkResult(b);
		for (int i = 0; i < b.getSize(); i++) {
			b.fill(i, Mark.O);
		}
		Result r2 = ResultAnalyser.checkResult(b);
		Board b2 = new Board(4);
		for (int i = 0; i < b2.getSize(); i++) {
			b2.fill(b2.getSize() * i, Mark.X);
		}
		Result r3 = ResultAnalyser.checkResult(b2);
		Board b3 = new Board(4);
		for (int i = 0; i < b3.getSize(); i++) {
			b3.fill(b3.getSize() * i + i, Mark.X);
		}
		Result r4 = ResultAnalyser.checkResult(b3);

		//
		assertEquals(expectedResult1, r1);
		assertEquals(expectedResult2, r2);
		assertEquals(expectedResult2, r3);
		assertEquals(expectedResult2, r4);

	}

}
