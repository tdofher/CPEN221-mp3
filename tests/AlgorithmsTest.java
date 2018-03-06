package ca.ubc.ece.cpen221.mp3.tests;

import static org.junit.Assert.*;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import ca.ubc.ece.cpen221.mp3.graph.AdjacencyListGraph;
import ca.ubc.ece.cpen221.mp3.graph.Algorithms;
import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class AlgorithmsTest {
	private Graph graph = new AdjacencyListGraph();
	private List<Vertex> origVertList = new LinkedList<Vertex>();
	
	@Before
    public void initialize() {
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
		graph.addEdge(origVertList.get(1), origVertList.get(0));
		
	}
	//shortestDistance() tests
	@Test
	public void test0(){
		assertEquals(Algorithms.shortestDistance(graph, origVertList.get(0), origVertList.get(0)), 0);
	}
	
	@Test
	public void test1(){
		assertEquals(Algorithms.shortestDistance(graph, origVertList.get(0), origVertList.get(1)), 1);
	}
	
	@Test
	public void test2(){
		assertEquals(Algorithms.shortestDistance(graph, origVertList.get(0), origVertList.get(10)), -1);
	}
	
	@Test
	public void test3(){
		assertEquals(Algorithms.shortestDistance(graph, origVertList.get(0), origVertList.get(5)), 3);
	}
	
	//breadthFirstSearch() tests
	@Test
	public void test4(){
		Graph graph1 = new AdjacencyListGraph();
		List<Vertex> VertList = new LinkedList<Vertex>();
		
		VertList.add(new Vertex("0"));
		VertList.add(new Vertex("1"));
		VertList.add(new Vertex("2"));
		VertList.add(new Vertex("3"));
		VertList.add(new Vertex("4"));
		VertList.add(new Vertex("5"));
		VertList.add(new Vertex("6"));
		VertList.add(new Vertex("7"));
		
		for (Vertex i : VertList){
			graph1.addVertex(i);
		}
		
		graph1.addEdge(VertList.get(0), VertList.get(1));
		graph1.addEdge(VertList.get(0), VertList.get(2));
		graph1.addEdge(VertList.get(1), VertList.get(3));
		graph1.addEdge(VertList.get(1), VertList.get(4));
		graph1.addEdge(VertList.get(2), VertList.get(5));
		graph1.addEdge(VertList.get(5), VertList.get(7));
		graph1.addEdge(VertList.get(3), VertList.get(6));
		graph1.addEdge(VertList.get(7), VertList.get(6));
		
		Set<List<Vertex>> expected = new LinkedHashSet<List<Vertex>>();
		
		LinkedList<Vertex> toAdd1 = new LinkedList<Vertex>();
		LinkedList<Vertex> toAdd2 = new LinkedList<Vertex>();
		LinkedList<Vertex> toAdd3 = new LinkedList<Vertex>();
		LinkedList<Vertex> toAdd4 = new LinkedList<Vertex>();
		LinkedList<Vertex> toAdd5 = new LinkedList<Vertex>();
		LinkedList<Vertex> toAdd6 = new LinkedList<Vertex>();
		LinkedList<Vertex> toAdd7 = new LinkedList<Vertex>();
		LinkedList<Vertex> toAdd8 = new LinkedList<Vertex>();
		
		toAdd1.add(VertList.get(0));
		toAdd1.add(VertList.get(1));
		toAdd1.add(VertList.get(2));
		toAdd1.add(VertList.get(3));
		toAdd1.add(VertList.get(4));
		toAdd1.add(VertList.get(5));
		toAdd1.add(VertList.get(6));
		toAdd1.add(VertList.get(7));
		
		expected.add(toAdd1);
		
		toAdd2.add(VertList.get(1));
		toAdd2.add(VertList.get(3));
		toAdd2.add(VertList.get(4));
		toAdd2.add(VertList.get(6));
		
		expected.add(toAdd2);
		
		toAdd3.add(VertList.get(2));
		toAdd3.add(VertList.get(5));
		toAdd3.add(VertList.get(7));
		toAdd3.add(VertList.get(6));
						
		expected.add(toAdd3);
		
		toAdd4.add(VertList.get(3));
		toAdd4.add(VertList.get(6));

		expected.add(toAdd4);
		
		toAdd5.add(VertList.get(4));
		
		expected.add(toAdd5);
		
		toAdd6.add(VertList.get(5));
		toAdd6.add(VertList.get(7));
		toAdd6.add(VertList.get(6));
		
		expected.add(toAdd6);
		
		toAdd7.add(VertList.get(6));
		
		expected.add(toAdd7);
		
		toAdd8.add(VertList.get(7));
		toAdd8.add(VertList.get(6));
		
		expected.add(toAdd8);
		

		assertEquals(expected, Algorithms.breadthFirstSearch(graph1));
	}
	
	//depthFirstSearch() tests
	@Test
	public void test5(){
		Graph graph1 = new AdjacencyListGraph();
		List<Vertex> VertList = new LinkedList<Vertex>();
		
		VertList.add(new Vertex("0"));
		VertList.add(new Vertex("1"));
		VertList.add(new Vertex("2"));
		VertList.add(new Vertex("3"));
		VertList.add(new Vertex("4"));
		VertList.add(new Vertex("5"));
		VertList.add(new Vertex("6"));
		VertList.add(new Vertex("7"));
		
		for (Vertex i : VertList){
			graph1.addVertex(i);
		}
		
		graph1.addEdge(VertList.get(0), VertList.get(1));
		graph1.addEdge(VertList.get(0), VertList.get(5));
		graph1.addEdge(VertList.get(1), VertList.get(2));
		graph1.addEdge(VertList.get(1), VertList.get(4));
		graph1.addEdge(VertList.get(2), VertList.get(3));
		graph1.addEdge(VertList.get(5), VertList.get(6));
		graph1.addEdge(VertList.get(6), VertList.get(7));
		graph1.addEdge(VertList.get(7), VertList.get(6));
		
		Set<List<Vertex>> expected = new LinkedHashSet<List<Vertex>>();
		
		LinkedList<Vertex> toAdd1 = new LinkedList<Vertex>();
		LinkedList<Vertex> toAdd2 = new LinkedList<Vertex>();
		LinkedList<Vertex> toAdd3 = new LinkedList<Vertex>();
		LinkedList<Vertex> toAdd4 = new LinkedList<Vertex>();
		LinkedList<Vertex> toAdd5 = new LinkedList<Vertex>();
		LinkedList<Vertex> toAdd6 = new LinkedList<Vertex>();
		LinkedList<Vertex> toAdd7 = new LinkedList<Vertex>();
		LinkedList<Vertex> toAdd8 = new LinkedList<Vertex>();
		
		toAdd1.add(VertList.get(0));
		toAdd1.add(VertList.get(1));
		toAdd1.add(VertList.get(2));
		toAdd1.add(VertList.get(3));
		toAdd1.add(VertList.get(4));
		toAdd1.add(VertList.get(5));
		toAdd1.add(VertList.get(6));
		toAdd1.add(VertList.get(7));
		
		expected.add(toAdd1);
		
		toAdd2.add(VertList.get(1));
		toAdd2.add(VertList.get(2));
		toAdd2.add(VertList.get(3));
		toAdd2.add(VertList.get(4));
		
		expected.add(toAdd2);
		
		toAdd3.add(VertList.get(2));
		toAdd3.add(VertList.get(3));
						
		expected.add(toAdd3);
		
		toAdd4.add(VertList.get(3));

		expected.add(toAdd4);
		
		toAdd5.add(VertList.get(4));
		
		expected.add(toAdd5);
		
		toAdd6.add(VertList.get(5));
		toAdd6.add(VertList.get(6));
		toAdd6.add(VertList.get(7));
		
		expected.add(toAdd6);
		
		toAdd7.add(VertList.get(6));
		toAdd7.add(VertList.get(7));
		
		expected.add(toAdd7);
		
		toAdd8.add(VertList.get(7));
		toAdd8.add(VertList.get(6));
		
		expected.add(toAdd8);
		

		assertEquals(expected, Algorithms.depthFirstSearch(graph1));
	}
	
	@Test
	public void test6(){
		List<Vertex> expected = new LinkedList<Vertex>();
		expected.add(origVertList.get(0));
		
		assertEquals(expected, Algorithms.commonUpstreamVertices(graph, origVertList.get(1), origVertList.get(2)));
	}
	
	@Test
	public void test7(){
		List<Vertex> expected = new LinkedList<Vertex>();
		
		assertEquals(expected, Algorithms.commonUpstreamVertices(graph, origVertList.get(3), origVertList.get(2)));
	}
	
	@Test
	public void test8(){
		List<Vertex> expected = new LinkedList<Vertex>();
		expected.add(origVertList.get(2));
		
		assertEquals(expected, Algorithms.commonDownstreamVertices(graph, origVertList.get(0), origVertList.get(12)));
	}
	
	@Test
	public void test9(){
		List<Vertex> expected = new LinkedList<Vertex>();
		
		assertEquals(expected, Algorithms.commonDownstreamVertices(graph, origVertList.get(1), origVertList.get(3)));
	}
}






