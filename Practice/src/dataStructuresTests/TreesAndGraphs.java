package dataStructuresTests;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class TreesAndGraphs {
	
	private dataStructuresPractice.TreesAndGraphs sample = new dataStructuresPractice.TreesAndGraphs();
	
	@Ignore
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testInsert(){
		sample.tree.insert(sample.root, 10);
		sample.tree.insert(sample.root, 15);
		sample.tree.insert(sample.root, 5);
		sample.tree.insert(sample.root, 6);
		sample.tree.insert(sample.root, 4);
		
		sample.tree.insert(sample.root, 60);
		sample.tree.insert(sample.root, 65);
		sample.tree.insert(sample.root, 55);
		sample.tree.insert(sample.root, 54);
		sample.tree.insert(sample.root, 56);
		
		assertEquals(10, sample.tree.size());
//		sample.tree.printValues(sample.root);
	}
	
	@Test
	public void testTrackEachDepth(){
		sample.tree.insert(sample.root, 10);
		sample.tree.insert(sample.root, 15);
		sample.tree.insert(sample.root, 5);
		sample.tree.insert(sample.root, 6);
		sample.tree.insert(sample.root, 4);
		
		sample.tree.insert(sample.root, 60);
		sample.tree.insert(sample.root, 65);
		sample.tree.insert(sample.root, 55);
		sample.tree.insert(sample.root, 54);
		sample.tree.insert(sample.root, 56);
		
		sample.tree.trackEachDepth(sample.root);
		sample.tree.printDepthValues(sample.root);
		sample.tree.printValues(sample.root);
	}
	

}
