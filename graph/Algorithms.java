package ca.ubc.ece.cpen221.mp3.graph;

import java.util.List;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.Set;
import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

public class Algorithms {

	/**
	 * finds the shortest path distance from one vertex to another
	 * the distance from a vertex to itself is 0 and all other edge lengths
	 * are 1
	 *
	 * @param graph the graph containing the two vertices
	 * @param a the start vertex
	 * @param b the end vertex
	 * @return the shortest path length from a to b, returns 0 if a is b,
	 * 			returns -1 if there is no path from a to b
	 */
	public static int shortestDistance(Graph graph, Vertex a, Vertex b) {
		if (a.equals(b)){
			return 0; 
		}
		else if (graph.edgeExists(a, b)){
			return 1;
		}
		
		LinkedList<Vertex> verticesVisited = new LinkedList<Vertex>();		
		LinkedList<Vertex> adjacentToCurrent = new LinkedList<Vertex>();
		
		int count = 0;

		adjacentToCurrent.addAll(graph.getDownstreamNeighbors(a));
		verticesVisited.add(a);
		verticesVisited.addAll(adjacentToCurrent);
		
		while(adjacentToCurrent.size() != 0){
			count++;
			for(Vertex v: graph.getDownstreamNeighbors(adjacentToCurrent.remove())){
				if (v.equals(b)){
					return count;
				}
				if(adjacentToCurrent.contains(v) == false && verticesVisited.contains(v) == false){
					verticesVisited.addLast(v);
					adjacentToCurrent.add(v);
				}
			}	
		}
		return -1;
	}
		

	/**
	 * Perform a complete depth first search of the given
	 * graph. Start with the search at each vertex of the
	 * graph and create a list of the vertices visited.
	 * Return a set where each element of the set is a list
	 * of elements seen by starting a DFS at a specific
	 * vertex of the graph (the number of elements in the
	 * returned set should correspond to the number of graph
	 * vertices).
	 *
	 * @param graph the graph to search
	 * @return a set of lists containing each vertex visited by starting at a specific vertex
	 */
	public static Set<List<Vertex>> depthFirstSearch(Graph graph) {
		Set<List<Vertex>> setOfListsOfVertices = new LinkedHashSet<List<Vertex>>();
		
		for(Vertex i: graph.getVertices()){
			LinkedList<Vertex> verticesVisited = new LinkedList<Vertex>();
			
			verticesVisited.add(i);
			
			depthHelp(graph, i, verticesVisited);
		
			setOfListsOfVertices.add(verticesVisited);
		}
		
		return setOfListsOfVertices;
	}
	
	/**
	 * Helper to depthFirstSearch
	 * recursively finds all the vertices connected to the vertex passed
	 * adds them to a list
	 * 
	 * @param graph the graph containing the vertices
	 * @param toSearch the vertex that a depth first search is being performed on
	 * @param visited a list of all vertices visited
	 * @return null to the calling method 
	 */
	private static Vertex depthHelp(Graph graph, Vertex toSearch, LinkedList<Vertex> visited){
		if (graph.getDownstreamNeighbors(toSearch).isEmpty() || (graph.getDownstreamNeighbors(toSearch).size() == 1 &&
				visited.contains(graph.getDownstreamNeighbors(toSearch).get(0)))){
			return toSearch;
		}
		
		for (Vertex v : graph.getDownstreamNeighbors(toSearch)){
			if (!visited.contains(v)) {
				visited.add(v);
				depthHelp(graph, v , visited);
			}
		}
		return null;
	}
	
	
	/**
	 * Perform a complete breadth first search of the given
	 * graph. Start with the search at each vertex of the
	 * graph and create a list of the vertices visited.
	 * Return a set where each element of the set is a list
	 * of elements seen by starting a BFS at a specific
	 * vertex of the graph (the number of elements in the
	 * returned set should correspond to the number of graph
	 * vertices).
	 *
	 * @param graph the graph to search
	 * @return a set of lists containing each vertex visited by starting at a specific vertex
	 */
	public static Set<List<Vertex>> breadthFirstSearch(Graph graph) {
		Set<List<Vertex>> setOfListsOfVertexes = new LinkedHashSet<List<Vertex>>();
		
		for(Vertex i: graph.getVertices()){
			
			LinkedList<Vertex> vertexesVisited = new LinkedList<Vertex>();
			LinkedList<Vertex> adjacentToCurrent = new LinkedList<Vertex>();
			
			adjacentToCurrent.addAll(graph.getDownstreamNeighbors(i));
			vertexesVisited.add(i);
			vertexesVisited.addAll(adjacentToCurrent);
			
			while(adjacentToCurrent.size() != 0){
				
				for(Vertex v: graph.getDownstreamNeighbors(adjacentToCurrent.remove())){
					if( adjacentToCurrent.contains(v) == false && vertexesVisited.contains(v) == false){
						vertexesVisited.addLast(v);
						adjacentToCurrent.add(v);
					}
				}	
			}
			
			setOfListsOfVertexes.add(vertexesVisited);
		}
		return setOfListsOfVertexes;
	}

	/**
	 * finds all the common upstream neighbours of any two vertices in the graph
	 * 
	 * @param graph the graph of vertices to be searched
	 * @param a the first vertex
	 * @param b the second vertex
	 * @returns a list of common upstream neighbours between a and b and an empty list if none exist
	 */
	 public static List<Vertex> commonUpstreamVertices(Graph graph, Vertex a, Vertex b) {
		 List<Vertex> upStreamA = graph.getUpstreamNeighbors(a);
		 List<Vertex> upStreamB = graph.getUpstreamNeighbors(b);
		 List<Vertex> common = new LinkedList<Vertex>();
		 
		 for (Vertex i : upStreamA){
			 for (Vertex j : upStreamB){
				 if (i.equals(j)){
					 common.add(i);
				 }
			 }
		 }
		 return common;
	 }

		/**
		 * finds all the common downstream neighbours of any two vertices in the graph
		 * 
		 * @param graph the graph of vertices to be searched
		 * @param a the first vertex
		 * @param b the second vertex
		 * @returns a list of common downstream neighbours between a and b and an empty list if none exist
		 */
 	 public static List<Vertex> commonDownstreamVertices(Graph graph, Vertex a, Vertex b) {
 		 List<Vertex> downStreamA = graph.getDownstreamNeighbors(a);
		 List<Vertex> downStreamB = graph.getDownstreamNeighbors(b);
		 List<Vertex> common = new LinkedList<Vertex>();
		 
		 for (Vertex i : downStreamA){
			 for (Vertex j : downStreamB){
				 if (i.equals(j)){
					 common.add(i);
				 }
			 }
		 }
		 return common;
 	 }


}
