import static org.junit.Assert.*;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


// Make the Olympics class is in a package called "code" 
import code.Olympics;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class TestOlympics {
	String grid5 = "5,5;1,2;3,2;0,3,2,1,3,4,4,0,4,3;0,1,0,2,3,1,3,3,4,2";
	String grid6 = "6,6;5,5;4,4;2,0,3,3,5,2,1,0;3,4,2,5,3,1,4,0,4,2,0,3";
	String grid7 = "7,7;4,0;0,3;0,5,5,0,4,1,4,3,5,2,5,4,4,2;2,0,0,1,6,3,6,2,1,2,2,3,1,6,2,1,1,1,1,5,3,0,2,2,6,1,3,1";
	String grid8 = "8,8;2,7;1,1;3,2,0,4,3,7,4,4;2,0,7,6,5,0,7,1,3,5";
	String grid9 = "9,9;1,2;5,2;7,4,8,6,6,7,5,5,3,6,4,3,6,6,2,6,5,1;3,8,4,7,7,1,8,4,1,0,6,8,3,7,2,2";
	String grid10 = "10,10;6,7;9,9;2,2,9,2;0,8,3,1,1,8,1,1,4,5,0,9,0,3,4,2,2,0,3,9,4,4,1,7,8,8,3,4";
	String grid11 = "11,11;3,4;0,8;1,2,3,5,4,6,6,0;5,0,5,6,6,9,2,9,9,2,9,6,4,7,0,1,2,0,7,10";
	String grid12 = "12,12;8,9;2,3;9,6,0,5,8,10,0,7,6,7,2,5,1,8,6,11,0,6,3,7,1,11,0,1,1,5,7,1;8,8,7,0,11,7,0,3,3,3,1,6,3,5,2,6,10,10,8,2,10,9,10,2";
	String grid13 = "13,13;8,12;7,12;8,1,10,9,8,7,8,5,8,4,5,4,5,3,5,5,5,6,7,8,9,11,2,3;10,5,11,6,5,1,10,2,12,2,11,8,9,0,7,3,0,10,3,10";
	String grid14 = "14,14;1,13;2,1;0,11,1,11,6,9,1,1,8,11,7,1,8,5,10,7,7,0,7,9,4,7,3,3,13,11,7,4;10,8,13,7,3,6,12,3,6,0,11,1,9,12,0,6,12,7,4,6,11,2,5,1,13,2";
	String grid15 = "15,15;5,1;14,1;3,14,11,11,12,12,4,8,8,14,5,0,13,6,0,6,5,11,11,0,7,0,12,11,6,2;6,1,14,10,6,5,6,11,4,2,9,1,2,12,2,6,1,7,2,7,2,3,2,5,8,11,4,3,2,0,5,10";

	@Test(timeout = 70000)
	public void testa1() throws Exception {
		String solution = Olympics.solve(grid5, "BF", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid5, solution));
	}
	
	@Test(timeout = 70000)
	public void testa2() throws Exception {
		String solution = Olympics.solve(grid6, "BF", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid6, solution));
	}
	
	@Test(timeout = 70000)
	public void testa3() throws Exception {
		String solution = Olympics.solve(grid7, "BF", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid7, solution));
	}
	
	@Test(timeout = 70000)
	public void testa4() throws Exception {
		String solution = Olympics.solve(grid7, "BF", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid7, solution));
	}
	
	@Test(timeout = 70000)
	public void testa5() throws Exception {
		String solution = Olympics.solve(grid8, "BF", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid8, solution));
	}
	
	@Test(timeout = 70000)
	public void testa6() throws Exception {
		String solution = Olympics.solve(grid9, "BF", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid9, solution));
	}
	
	@Test(timeout = 70000)
	public void testa7() throws Exception {
		String solution = Olympics.solve(grid10, "BF", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid10, solution));
	}
	
	@Test(timeout = 70000)
	public void testa8() throws Exception {
		String solution = Olympics.solve(grid11, "BF", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid11, solution));
	}
	
	@Test(timeout = 70000)
	public void testa9() throws Exception {
		String solution = Olympics.solve(grid12, "BF", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid12, solution));
	}
	
	@Test(timeout = 70000)
	public void testa10() throws Exception {
		String solution = Olympics.solve(grid13, "BF", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid13, solution));
	}
	
	@Test(timeout = 70000)
	public void testa11() throws Exception {
		String solution = Olympics.solve(grid14, "BF", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid14, solution));
	}
	
	@Test(timeout = 70000)
	public void testa12() throws Exception {
		String solution = Olympics.solve(grid15, "BF", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid15, solution));
	}
	
	@Test(timeout = 70000)
	public void testb1() throws Exception {
		String solution = Olympics.solve(grid5, "DF", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid5, solution));
	}
	
	@Test(timeout = 70000)
	public void testb2() throws Exception {
		String solution = Olympics.solve(grid6, "DF", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid6, solution));
	}
	
	@Test(timeout = 70000)
	public void testb3() throws Exception {
		String solution = Olympics.solve(grid7, "DF", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid7, solution));
	}
	
	@Test(timeout = 70000)
	public void testb4() throws Exception {
		String solution = Olympics.solve(grid7, "DF", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid7, solution));
	}
	
	@Test(timeout = 70000)
	public void testb5() throws Exception {
		String solution = Olympics.solve(grid8, "DF", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid8, solution));
	}
	
	@Test(timeout = 70000)
	public void testb6() throws Exception {
		String solution = Olympics.solve(grid9, "DF", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid9, solution));
	}
	
	@Test(timeout = 70000)
	public void testb7() throws Exception {
		String solution = Olympics.solve(grid10, "DF", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid10, solution));
	}
	
	@Test(timeout = 70000)
	public void testb8() throws Exception {
		String solution = Olympics.solve(grid11, "DF", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid11, solution));
	}
	
	@Test(timeout = 70000)
	public void testb9() throws Exception {
		String solution = Olympics.solve(grid12, "DF", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid12, solution));
	}
	
	@Test(timeout = 70000)
	public void testb10() throws Exception {
		String solution = Olympics.solve(grid13, "DF", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid13, solution));
	}
	
	@Test(timeout = 70000)
	public void testb11() throws Exception {
		String solution = Olympics.solve(grid14, "DF", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid14, solution));
	}
	
	@Test(timeout = 70000)
	public void testb12() throws Exception {
		String solution = Olympics.solve(grid15, "DF", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid15, solution));
	}
	
	@Test(timeout = 70000)
	public void testc1() throws Exception {
		String solution = Olympics.solve(grid5, "UC", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid5, solution));
	}
	
	@Test(timeout = 70000)
	public void testc2() throws Exception {
		String solution = Olympics.solve(grid6, "UC", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid6, solution));
	}
	
	@Test(timeout = 70000)
	public void testc3() throws Exception {
		String solution = Olympics.solve(grid7, "UC", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid7, solution));
	}
	
	@Test(timeout = 70000)
	public void testc4() throws Exception {
		String solution = Olympics.solve(grid7, "UC", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid7, solution));
	}
	
	@Test(timeout = 70000)
	public void testc5() throws Exception {
		String solution = Olympics.solve(grid8, "UC", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid8, solution));
	}
	
	@Test(timeout = 70000)
	public void testc6() throws Exception {
		String solution = Olympics.solve(grid9, "UC", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid9, solution));
	}
	
	@Test(timeout = 70000)
	public void testc7() throws Exception {
		String solution = Olympics.solve(grid10, "UC", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid10, solution));
	}
	
	@Test(timeout = 70000)
	public void testc8() throws Exception {
		String solution = Olympics.solve(grid11, "UC", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid11, solution));
	}
	
	@Test(timeout = 70000)
	public void testc9() throws Exception {
		String solution = Olympics.solve(grid12, "UC", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid12, solution));
	}
	
	@Test(timeout = 70000)
	public void testc10() throws Exception {
		String solution = Olympics.solve(grid13, "UC", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid13, solution));
	}
	
	@Test(timeout = 70000)
	public void testc11() throws Exception {
		String solution = Olympics.solve(grid14, "UC", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid14, solution));
	}
	
	@Test(timeout = 70000)
	public void testc12() throws Exception {
		String solution = Olympics.solve(grid15, "UC", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid15, solution));
	}
	
	@Test(timeout = 70000)
	public void teste1() throws Exception {
		String solution = Olympics.solve(grid5, "GR1", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid5, solution));
	}
	
	@Test(timeout = 70000)
	public void teste2() throws Exception {
		String solution = Olympics.solve(grid6, "GR1", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid6, solution));
	}
	
	@Test(timeout = 70000)
	public void teste3() throws Exception {
		String solution = Olympics.solve(grid7, "GR1", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid7, solution));
	}
	
	@Test(timeout = 70000)
	public void teste4() throws Exception {
		String solution = Olympics.solve(grid7, "GR1", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid7, solution));
	}
	
	@Test(timeout = 70000)
	public void teste5() throws Exception {
		String solution = Olympics.solve(grid8, "GR1", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid8, solution));
	}
	
	@Test(timeout = 70000)
	public void teste6() throws Exception {
		String solution = Olympics.solve(grid9, "GR1", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid9, solution));
	}
	
	@Test(timeout = 70000)
	public void teste7() throws Exception {
		String solution = Olympics.solve(grid10, "GR1", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid10, solution));
	}
	
	@Test(timeout = 70000)
	public void teste8() throws Exception {
		String solution = Olympics.solve(grid11, "GR1", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid11, solution));
	}
	
	@Test(timeout = 70000)
	public void teste9() throws Exception {
		String solution = Olympics.solve(grid12, "GR1", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid12, solution));
	}
	
	@Test(timeout = 70000)
	public void teste10() throws Exception {
		String solution = Olympics.solve(grid13, "GR1", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid13, solution));
	}
	
	@Test(timeout = 70000)
	public void teste11() throws Exception {
		String solution = Olympics.solve(grid14, "GR1", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid14, solution));
	}
	
	@Test(timeout = 70000)
	public void teste12() throws Exception {
		String solution = Olympics.solve(grid15, "GR1", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid15, solution));
	}
	
	@Test(timeout = 70000)
	public void testf1() throws Exception {
		String solution = Olympics.solve(grid5, "GR2", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid5, solution));
	}
	
	@Test(timeout = 70000)
	public void testf2() throws Exception {
		String solution = Olympics.solve(grid6, "GR2", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid6, solution));
	}
	
	@Test(timeout = 70000)
	public void testf3() throws Exception {
		String solution = Olympics.solve(grid7, "GR2", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid7, solution));
	}
	
	@Test(timeout = 70000)
	public void testf4() throws Exception {
		String solution = Olympics.solve(grid7, "GR2", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid7, solution));
	}
	
	@Test(timeout = 70000)
	public void testf5() throws Exception {
		String solution = Olympics.solve(grid8, "GR2", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid8, solution));
	}
	
	@Test(timeout = 70000)
	public void testf6() throws Exception {
		String solution = Olympics.solve(grid9, "GR2", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid9, solution));
	}
	
	@Test(timeout = 70000)
	public void testf7() throws Exception {
		String solution = Olympics.solve(grid10, "GR2", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid10, solution));
	}
	
	@Test(timeout = 70000)
	public void testf8() throws Exception {
		String solution = Olympics.solve(grid11, "GR2", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid11, solution));
	}
	
	@Test(timeout = 70000)
	public void testf9() throws Exception {
		String solution = Olympics.solve(grid12, "GR2", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid12, solution));
	}
	
	@Test(timeout = 70000)
	public void testf10() throws Exception {
		String solution = Olympics.solve(grid13, "GR2", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid13, solution));
	}
	
	@Test(timeout = 70000)
	public void testf11() throws Exception {
		String solution = Olympics.solve(grid14, "GR2", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid14, solution));
	}
	
	@Test(timeout = 70000)
	public void testf12() throws Exception {
		String solution = Olympics.solve(grid15, "GR2", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid15, solution));
	}
	
	@Test(timeout = 70000)
	public void testg1() throws Exception {
		String solution = Olympics.solve(grid5, "AS1", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid5, solution));
	}
	
	@Test(timeout = 70000)
	public void testg2() throws Exception {
		String solution = Olympics.solve(grid6, "AS1", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid6, solution));
	}
	
	@Test(timeout = 70000)
	public void testg3() throws Exception {
		String solution = Olympics.solve(grid7, "AS1", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid7, solution));
	}
	
	@Test(timeout = 70000)
	public void testg4() throws Exception {
		String solution = Olympics.solve(grid7, "AS1", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid7, solution));
	}
	
	@Test(timeout = 70000)
	public void testg5() throws Exception {
		String solution = Olympics.solve(grid8, "AS1", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid8, solution));
	}
	
	@Test(timeout = 70000)
	public void testg6() throws Exception {
		String solution = Olympics.solve(grid9, "AS1", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid9, solution));
	}
	
	@Test(timeout = 70000)
	public void testg7() throws Exception {
		String solution = Olympics.solve(grid10, "AS1", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid10, solution));
	}
	
	@Test(timeout = 70000)
	public void testg8() throws Exception {
		String solution = Olympics.solve(grid11, "AS1", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid11, solution));
	}
	
	@Test(timeout = 70000)
	public void testg9() throws Exception {
		String solution = Olympics.solve(grid12, "AS1", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid12, solution));
	}
	
	@Test(timeout = 70000)
	public void testg10() throws Exception {
		String solution = Olympics.solve(grid13, "AS1", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid13, solution));
	}
	
	@Test(timeout = 70000)
	public void testg11() throws Exception {
		String solution = Olympics.solve(grid14, "AS1", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid14, solution));
	}
	
	@Test(timeout = 70000)
	public void testg12() throws Exception {
		String solution = Olympics.solve(grid15, "AS1", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid15, solution));
	}
	
	@Test(timeout = 70000)
	public void testh1() throws Exception {
		String solution = Olympics.solve(grid5, "AS2", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid5, solution));
	}
	
	@Test(timeout = 70000)
	public void testh2() throws Exception {
		String solution = Olympics.solve(grid6, "AS2", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid6, solution));
	}
	
	@Test(timeout = 70000)
	public void testh3() throws Exception {
		String solution = Olympics.solve(grid7, "AS2", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid7, solution));
	}
	
	@Test(timeout = 70000)
	public void testh4() throws Exception {
		String solution = Olympics.solve(grid7, "AS2", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid7, solution));
	}
	
	@Test(timeout = 70000)
	public void testh5() throws Exception {
		String solution = Olympics.solve(grid8, "AS2", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid8, solution));
	}
	
	@Test(timeout = 70000)
	public void testh6() throws Exception {
		String solution = Olympics.solve(grid9, "AS2", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid9, solution));
	}
	
	@Test(timeout = 70000)
	public void testh7() throws Exception {
		String solution = Olympics.solve(grid10, "AS2", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid10, solution));
	}
	
	@Test(timeout = 70000)
	public void testh8() throws Exception {
		String solution = Olympics.solve(grid11, "AS2", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid11, solution));
	}
	
	@Test(timeout = 70000)
	public void testh9() throws Exception {
		String solution = Olympics.solve(grid12, "AS2", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid12, solution));
	}
	
	@Test(timeout = 70000)
	public void testh10() throws Exception {
		String solution = Olympics.solve(grid13, "AS2", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid13, solution));
	}
	
	@Test(timeout = 70000)
	public void testh11() throws Exception {
		String solution = Olympics.solve(grid14, "AS2", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid14, solution));
	}
	
	@Test(timeout = 70000)
	public void testh12() throws Exception {
		String solution = Olympics.solve(grid15, "AS2", false);
		solution = solution.replace(" ", "");
		assertTrue("The output actions do not lead to a goal state.", applyPlan(grid15, solution));
	}
	

	private boolean applyPlan(String grid, String solution) {
		char[][] g = convertToGrid(grid);
		String plan = solution.split(";")[0];
		plan.replace(" ", "");
		plan.replace("\n", "");
		plan.replace("\r", "");
		plan.replace("\n\r", "");
		plan.replace("\t", "");
		String[] actions = plan.split(",");
		String[] gridArray=  grid.split(";");
		String[] jarvis = gridArray[1].split(",");

		int componentsNum  = (gridArray[3].split(",").length)/2;
		int[] result = new int[3];
		result[0] = Integer.parseInt(jarvis[0]);
		result[1] = Integer.parseInt(jarvis[1]);
		result[2] = componentsNum;
		for (int i = 0; i < actions.length; i++) {
			switch (actions[i]) {
			case "up":
				applyUp(g, result);
				break;
			case "down":
				applyDown(g, result);
				break;
			case "right":
				applyRight(g, result);
				break;
			case "left":
				applyLeft(g, result);
				break;
			case "pick":
				applyPick(g, result);
				break;
			case "light":
				applyLight(g, result);
				break;
			}
		}
		return done(result);
	}
	
	private boolean done(int[] result) {
		return result[2]==-1;
	}

	private void applyLight(char[][] g, int[] result) {
		if (g[result[0]][result[1]] == 'F' && result[2]==0) {
			result[2]=-1;
		}
	}


	private void applyPick(char[][] g, int[] result) {
		if (g[result[0]][result[1]] == 'C' && result[2]>0) {
			g[result[0]][result[1]] = '\u0000';
			result[2]--;
		}
	}
	
	private boolean isPoisonous(char[][] g, int x, int y) {
		return g[x][y]=='P';
	}
	private void applyLeft(char[][] g, int[] result) {
		if (!isPoisonous(g, result[0],result[1] - 1) && result[1] - 1 >= 0)
			result[1]--;
	}
	


	private void applyRight(char[][] g, int[] result) {
		int n = g[0].length;
		if (!isPoisonous(g, result[0], result[1]+1) && result[1] + 1 < n)
			result[1]++;
	}

	private void applyDown(char[][] g, int[] result) {
		int m = g.length;
		if (!isPoisonous(g, result[0]+1, result[1]) && result[0] + 1 < m)
			result[0]++;

	}

	private void applyUp(char[][] g, int[] result) {
		if (!isPoisonous(g, result[0]-1, result[1]) && result[0] - 1 >= 0)
			result[0]--;
	}

	private char[][] convertToGrid(String input) {
		String[] s = input.split(";");

		String[] dimensions = s[0].split(",");
		String[] flame = s[2].split(",");
		String[] components = s[3].split(",");
		String[] poisonous = s[4].split(",");

		char[][] grid = new char[Integer.parseInt(dimensions[0])][Integer.parseInt(dimensions[1])];
		grid[Integer.parseInt(flame[0])][Integer.parseInt(flame[1])] = 'F';

		for (int i = 0; i < components.length - 1; i += 2)
			grid[Integer.parseInt(components[i])][Integer.parseInt(components[i + 1])] = 'C';
		
		for (int i = 0; i < poisonous.length - 1; i += 2)
			grid[Integer.parseInt(poisonous[i])][Integer.parseInt(poisonous[i + 1])] = 'P';

		return grid;
	}

}

