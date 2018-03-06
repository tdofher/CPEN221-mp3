package ca.ubc.ece.cpen221.mp3.tests;

import static org.junit.Assert.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import ca.ubc.ece.cpen221.mp3.graph.AdjacencyMatrixGraph;
import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class AdjacencyMatrixGraphTest {
	private Graph graph = new AdjacencyMatrixGraph();
	private List<Vertex> origVertList = new LinkedList<Vertex>();
	
	@Before
	public void initialize(){
		origVertList.add(new Vertex("v1"));
		origVertList.add(new Vertex("v2"));
		origVertList.add(new Vertex("v3"));
		origVertList.add(new Vertex("v4"));
		origVertList.add(new Vertex("v5"));
		origVertList.add(new Vertex("v6"));
		origVertList.add(new Vertex("v7"));
		origVertList.add(new Vertex("v8"));
		origVertList.add(new Vertex("v9"));
		origVertList.add(new Vertex("v10"));
		origVertList.add(new Vertex("v11"));
		origVertList.add(new Vertex("v12"));
		origVertList.add(new Vertex("v13"));
		origVertList.add(new Vertex("v14"));
		origVertList.add(new Vertex("v15"));
		
		for (Vertex i : origVertList){
			graph.addVertex(i);
		}
		graph.addEdge(origVertList.get(0), origVertList.get(1));
		graph.addEdge(origVertList.get(0), origVertList.get(2));
		graph.addEdge(origVertList.get(1), origVertList.get(3));
		graph.addEdge(origVertList.get(3), origVertList.get(5));
		graph.addEdge(origVertList.get(10), origVertList.get(0));
		graph.addEdge(origVertList.get(12), origVertList.get(2));
	}
	
	@Test
	public void test0(){
		Graph emptyGraph = new AdjacencyMatrixGraph();
		List<Vertex> emptyList = new LinkedList<Vertex>();
		assertEquals(emptyGraph.getVertices(), emptyList);
	}
	
	@Test
	public void test1(){
		assertEquals(origVertList, graph.getVertices());
	}
	
	@Test
	public void test2() {
		assertTrue(graph.edgeExists(origVertList.get(0), origVertList.get(1)));
	}
	
	@Test
	public void test3() {
		assertTrue(graph.edgeExists(origVertList.get(1), origVertList.get(3)));
	}
	
	@Test
	public void test4() {
		assertTrue(graph.edgeExists(origVertList.get(10), origVertList.get(0)));
	}
	
	@Test
	public void test5() {
		assertTrue(graph.edgeExists(origVertList.get(12), origVertList.get(2)));
	}
	
	@Test
	public void test6() {
		assertFalse(graph.edgeExists(origVertList.get(0), origVertList.get(3)));
	}
	
	@Test
	public void test7() {
		assertFalse(graph.edgeExists(origVertList.get(12), origVertList.get(1)));
	}
	
	@Test
	public void test8() {
		assertFalse(graph.edgeExists(origVertList.get(2), origVertList.get(0)));
	}
	
	@Test
	public void test9() {
		assertFalse(graph.edgeExists(origVertList.get(3), origVertList.get(1)));
	}
	
	@Test
	public void test10() {
		List<Vertex> neighTest = new LinkedList<Vertex>();
		neighTest.add(origVertList.get(1));
		neighTest.add(origVertList.get(2));
		
		assertEquals(neighTest, graph.getDownstreamNeighbors(origVertList.get(0)));
	}
	
	@Test
	public void test11() {
		List<Vertex> neighTest = new LinkedList<Vertex>();
		neighTest.add(origVertList.get(10));
		
		assertEquals(neighTest, graph.getUpstreamNeighbors(origVertList.get(0)));
	}	
}