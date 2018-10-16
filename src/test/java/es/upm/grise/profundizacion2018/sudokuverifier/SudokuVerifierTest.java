package es.upm.grise.profundizacion2018.sudokuverifier;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class SudokuVerifierTest {

	private SudokuVerifier sudokuVerify;


	@Before
	public void sudoku() {
		this.sudokuVerify = new SudokuVerifier();
    }
	
	
	@Test
	public void test9x9() {
		int res = sudokuVerify.verify("152489376"
				+ "79256841"
				+ "468371295"
				+ "387124659"
				+ "591723428"
				+ "246895713"
				+ "914637582"
				+ "525948137"
				+ "873512964");
		
		assertTrue(res == -1);
	}
	
	@Test
	public void testNum0() {
		int res = sudokuVerify.verify("052489376"
				+ "79256841"
				+ "468371295"
				+ "387124659"
				+ "591723428"
				+ "246895713"
				+ "914637582"
				+ "525948137"
				+ "873512964");
		
		assertTrue(res == -1);
	}
	
	@Test
	public void testNumNeg() {
		int res = sudokuVerify.verify("152489376"
				+ "-7739256841"
				+ "468371295"
				+ "387124659"
				+ "591723428"
				+ "246895713"
				+ "914637582"
				+ "525948137"
				+ "873512964");
		
		assertTrue(res == -1);
	}
	
	@Test
	public void testNumDec() {
		int res = sudokuVerify.verify("152489376"
				+ "7.39256841"
				+ "468371295"
				+ "387124659"
				+ "591723428"
				+ "246895713"
				+ "914637582"
				+ "525948137"
				+ "873512964");
		
		assertTrue(res == -1);
	}
	
	@Test
	public void testNumDec2() {
		int res = sudokuVerify.verify("152489376"
				+ "7,7739256841"
				+ "468371295"
				+ "387124659"
				+ "591723428"
				+ "246895713"
				+ "914637582"
				+ "525948137"
				+ "873512964");
		
		assertTrue(res == -1);
	}
	
	@Test
	public void testSubgrid() {
		int res = sudokuVerify.verify("152489376"
				+ "759256841"
				+ "468371295"
				+ "387124659"
				+ "591723428"
				+ "246895713"
				+ "914637582"
				+ "525948137"
				+ "873512964");
		
		assertTrue(res == -2);
	}
	
	@Test
	public void testRow() {
		int res = sudokuVerify.verify("123123123"
				+ "456456456"
				+ "789789789"
				+ "312312312"
				+ "645645645"
				+ "978978978"
				+ "231231231"
				+ "564564564"
				+ "897897897");
		
		assertTrue(res == -3);
	}
	
	@Test
	public void testColumn() {
		int res = sudokuVerify.verify("147369258"
				+ "258147369"
				+ "369258147"
				+ "147369258"
				+ "258147369"
				+ "369258147"
				+ "147369258"
				+ "258147369"
				+ "369258147");
		
		assertTrue(res == -4);
	}
	
	@Test
	public void testSudokuOK() {
		int res = sudokuVerify.verify( "152489376"
				+ "739256841"
				+ "468371295"
				+ "387124659"
				+ "591763428"
				+ "246895713"
				+ "914637582"
				+ "625948137"
				+ "873512964");
		
		assertTrue(res == 0);
	}
	
	
		
}
