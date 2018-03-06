package ca.ubc.ece.cpen221.mp3.graph;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

/**
 * Implementation of a graph using an adjacency list
 */
public class AdjacencyListGraph implements Graph {
	private final Map<Vertex, Set<Vertex>> adjList;
	
	public AdjacencyListGraph(){
		adjList = new LinkedHashMap <Vertex, Set <Vertex>>();
	}
	
	/**
	 * Adds a vertex to the graph.
	 * v can not already a vertex in the graph
	 * 
	 * @param v the vertex to be added
	 */
	public void addVertex(Vertex v){
		adjList.put(v, new HashSet<Vertex>());
	}

	/**
	 * Adds an edge from v1 to v2.
	 * v1 and v2 must be a part of the graph
	 * @param v1 the vertex that the edge will start at
	 * @param v2 the vertex that the edge will end at
	 */
	public void addEdge(Vertex v1, Vertex v2){
		adjList.get(v1).add(v2);
	}

	/**
	 * Check if there is an edge from v1 to v2.
	 * v1 and v2 must be a part of the graph
	 * 
	 * @param v1 the starting vertex of the edge
	 * @param v2 the ending index of the edge
	 */
	public boolean edgeExists(Vertex v1, Vertex v2){
		return adjList.get(v1).contains(v2);
	}

	/**
	 * Get an array containing all downstream vertices adjacent to v.
	 * v must be a vertex in the graph
	 * 
	 * @param v the vertex whose neighbors are wanted
	 * @returns a list containing each vertex w such that there is
	 * an edge from v to w. Returns a list of size 0 if there are no
	 * downstream neighbors
	 */
	public List<Vertex> getDownstreamNeighbors(Vertex v){
		List<Vertex> retList= new LinkedList<Vertex>();
		
		retList.addAll(adjList.get(v));
		
		return retList;
	}

	/**
	 * Get an array containing all upstream vertices adjacent to v.
	 * v must be a vertex in the graph
	 * 
	 * @param v the vertex whose upstream neighbors are wanted
	 * @returns a list containing each vertex u such that there is
	 * an edge from u to v. Returns a list of size 0
	 * if v has no upstream neighbors.
	 */
	public List<Vertex> getUpstreamNeighbors(Vertex v){
		List<Vertex> upList = new LinkedList<Vertex>();
		for (Vertex i : adjList.keySet()){
			if (adjList.get(i).contains(v)){
				upList.add(i);
			}
		}
		return upList;
	}

	/**
	 * Get all vertices in the graph.
	 *
	 * @returns a list containing all vertices in the graph. Returns
	 * a list of size 0 if the graph has no vertices.
	 */
	public List<Vertex> getVertices(){
		return new LinkedList<Vertex>(adjList.keySet());
	}
}
