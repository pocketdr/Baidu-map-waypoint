package com.pocketz.project;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class WaypointsInput {
	static String filePathOpen = "E:\\Project\\baidu-map-waypoint\\src\\resources";

	String fileName;
	String filePath;

	
	public void setFileName(String fileName) {
		this.fileName = fileName;
		this.filePath = filePathOpen + "\\" + this.fileName;
	}

	public List<String[]> getWaypoints() throws FileNotFoundException, IOException {
		
		List<String[]> waypoints = new ArrayList<>();
		try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
			String line = reader.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String[] waypoint = new String[] {fields[3],fields[4],fields[5],fields[6]};
				waypoints.add(waypoint);
				line = reader.readLine();
			}
		}
		
		return waypoints;
	}
}
