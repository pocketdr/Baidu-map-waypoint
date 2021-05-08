package com.pocketz.project;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class WaypointsOutput {
	
	private List<List<String>> waypointList = new LinkedList<>();
	
	public void addList(List<String> list) {
		waypointList.add(list);
	}
	
	public void exportToFile() throws IOException {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("waypoints.txt"))){
			for (List<String> list : waypointList) {
				for (String string : list) {
					writer.write(string+"\n");
				}
				writer.write("\n");
			}
			writer.flush();
		}
	}

}
