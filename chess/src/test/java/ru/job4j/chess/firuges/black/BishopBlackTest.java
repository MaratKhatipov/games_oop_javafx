package ru.job4j.chess.firuges.black;

import junit.framework.TestCase;
import org.junit.Test;
import ru.job4j.chess.ImpossibleMoveException;
import ru.job4j.chess.firuges.*;
import static ru.job4j.chess.firuges.Cell.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BishopBlackTest {

	@Test
	public void testPosition() {
		BishopBlack bishop = new BishopBlack(A1);
		bishop.position();
		assertThat(bishop.position(), is(A1));
	}

	@Test
	public void testWayUpRight() {
		BishopBlack bishop = new BishopBlack(C1);
		Cell[] wayBishop = bishop.way(G5);
		Cell[] destBishop = {D2, E3, F4, G5};
		assertThat(wayBishop, is(destBishop));
	}

	@Test
	public void testWayUpLeft() {
		BishopBlack bishop = new BishopBlack(C1);
		Cell[] wayBishop = bishop.way(A3);
		Cell[] destBishop = {B2, A3};
		assertThat(wayBishop, is(destBishop));
	}

	@Test
	public void testWayDownRight() {
		BishopBlack bishop = new BishopBlack(A8);
		Cell[] wayBishop = bishop.way(H1);
		Cell[] destBishop = {B7, C6, D5, E4, F3, G2, H1};
		assertThat(wayBishop, is(destBishop));
	}

	@Test
	public void testWayDownLeft() {
		BishopBlack bishop = new BishopBlack(H1);
		Cell[] wayBishop = bishop.way(A8);
		Cell[] destBishop = {G2, F3, E4, D5, C6, B7, A8};
		assertThat(wayBishop, is(destBishop));
	}

	@Test (expected = ImpossibleMoveException.class)
	public void testWayException() {
			BishopBlack bishop = new BishopBlack(A1);
			Cell[] wayBishop = bishop.way(H1);

	}

	@Test
	public void testCopy() {
		BishopBlack bishop = new BishopBlack(A1);
		bishop.copy(B2);
		assertThat(bishop.copy(B2).position(), is(B2));
	}

	@Test
	public void isDiagonalTrue() {
		BishopBlack bishop = new BishopBlack(A1);
		assertThat(bishop.isDiagonal(A1, B2), is(true));
	}

	@Test
	public void isDiagonalFalse() {
		BishopBlack bishop = new BishopBlack(A1);
		assertThat(bishop.isDiagonal(A1, B1), is(false));
	}
}