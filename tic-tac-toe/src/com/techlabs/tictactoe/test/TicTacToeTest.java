package com.techlabs.tictactoe.test;

import java.util.Scanner;

import com.techlabs.tictactoe.Board;
import com.techlabs.tictactoe.CellIsAlreadyFilled;
import com.techlabs.tictactoe.Mark;
import com.techlabs.tictactoe.Result;
import com.techlabs.tictactoe.ResultAnalyser;

public class TicTacToeTest {
	
	public static void main(String[] args) throws CellIsAlreadyFilled {
		Board board = new Board(4);
		showBoard(board);
		Scanner in = new Scanner(System.in);
		int counter = 0;
		Mark currentMark;
		while (true) {
			if (counter % 2 == 0) {
				currentMark = Mark.X;
			} else {
				currentMark = Mark.O;
			}
			System.out.print("Enter Player name:- ");
			String name = in.nextLine();
			while (true) {
				try {
					System.out.print(name + " enter cell no:-");
					String numStr = in.nextLine();
					int num = Integer.parseInt(numStr);
					board.fill(num, currentMark);
					break;
				} catch (CellIsAlreadyFilled e) {
					System.err.println("The cell is filled. Give another cell no.");
				}
			}
			showBoard(board);
			Result currentResult = ResultAnalyser.checkResult(board);
			if (currentResult == Result.WIN) {
				System.out.println(name + " is the winner");
				break;
			} else if (currentResult == Result.DRAW) {
				System.out.println("The game is ended as a draw");
				break;
			}
			counter++;
		}
		in.close();
	}

	public static void showBoard(Board b) {
		Mark[] arr = b.asArray();
		int size = b.getSize();
		System.out.println();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(arr[size * i + j]);
				if (j < size - 1) {
					System.out.print("  |  ");
				}
			}
			System.out.println();
			if (i < size - 1) {
				for (int j = 0; j < size; j++) {
					System.out.print("--------");
				}
				System.out.println();
			}
		}
//		System.out.println(arr[0] + "  |  " + arr[1] + "  |  " + arr[2]);
//		System.out.println("-----------------------");
//		System.out.println(arr[3] + "  |  " + arr[4] + "  |  " + arr[5]);
//		System.out.println("-----------------------");
//		System.out.println(arr[6] + "  |  " + arr[7] + "  |  " + arr[8]);
		System.out.println();
	}

}
