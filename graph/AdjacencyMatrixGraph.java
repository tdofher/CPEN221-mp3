package ca.ubc.ece.cpen221.mp3.graph;
import java.util.List;
import java.util.LinkedList;

import ca.ubc.ece.cpen221.mp3.staff.Graph;
import ca.ubc.ece.cpen221.mp3.staff.Vertex;

/**
 * Implementation of a graph using an adjacency matrix
 */
public class AdjacencyMatrixGraph implements Graph {
	private final LinkedList<LinkedList<Boolean>> adjMat;
	private final LinkedList<Vertex> vertList;
	
	public AdjacencyMatrixGraph(){
		adjMat = new LinkedList<LinkedList<Boolean>>();
		vertList = new LinkedList<Vertex>();
	}
	
	/**
	 * Adds a vertex to the graph.
	 * v can not already a vertex in the graph
	 * 
	 * @param v the vertex to be added
	 */
	public void addVertex(Vertex v){
		vertList.add(v);
		
		LinkedList<Boolean> newRow = new LinkedList<Boolean>();
		
		for (LinkedList<Boolean> row : adjMat){
			row.add(false);
			newRow.add(false);			
		}
		newRow.add(false);
		adjMat.add(newRow);
	}

	/**
	 * Adds an edge from v1 to v2.
	 * v1 and v2 must be a part of the graph
	 * @param v1 the vertex that the edge will start at
	 * @param v2 the vertex that the edge will end at
	 */
	public void addEdge(Vertex v1, Vertex v2){
		adjMat.get(vertList.indexOf(v1)).set(vertList.indexOf(v2), true);
	}

	/**
	 * Check if there is an edge from v1 to v2.
	 * v1 and v2 must be a part of the graph
	 * 
	 * @param v1 the starting vertex of the edge
	 * @param v2 the ending index of the edge
	 */
	public boolean edgeExists(Vertex v1, Vertex v2){
		return adjMat.get(vertList.indexOf(v1)).get(vertList.indexOf(v2));
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
		LinkedList<Vertex> down = new LinkedList<Vertex>();
		int index = vertList.indexOf(v);
		int size = adjMat.size();
		
		for (int i = 0; i < size; i++){
			if (adjMat.get(index).get(i)){
				down.add(vertList.get(i));
			}
		}
		return down;
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
		LinkedList<Vertex> up = new LinkedList<Vertex>();
		int index = vertList.indexOf(v);
		int size = adjMat.size();
		
		for (int i = 0; i < size; i++){
			if (adjMat.get(i).get(index)){
				up.add(vertList.get(i));
			}
		}
		return up;
	}

	/**
	 * Get all vertices in the graph.
	 *
	 * @returns a list containing all vertices in the graph. Returns
	 * a list of size 0 if the graph has no vertices.
	 */
	public List<Vertex> getVertices(){
		return vertList;
	}
}
