package com.pocketz.project;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public class App {
	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
//		WaypointsInput waypointsInput =new WaypointsInput();
		WaypointHandler waypointHandler = new WaypointHandler();
		APIHandler apiHandler = new APIHandler();
		URICreator uriCreator = new URICreator();
		
		String uri = uriCreator.setType(1)
				.setAttribute("?", "origin", "39.806717,116.48806")
				.setAttribute("&", "destination", "39.80957,116.49471")
				.setAk()
				.getURI();
		

		apiHandler.setURI(uri);
//		String[] waypointStrings = waypointHandler.getWaypoints(apiHandler.sendRequest());
		
		String locations = apiHandler.sendRequest();
//		System.out.println(locations);
		
		List<String> locationList = waypointHandler.getLocations(locations);
		String[] bfSArray = null;
		for (String s : locationList) {
			bfSArray = s.split(",");
			double[] points = CoordinateTransformUtil.gcj02towgs84(Double.parseDouble(bfSArray[0]), Double.parseDouble(bfSArray[1]));
			System.out.println(points[0]+","+points[1]);
		}
//		for (String string : waypointStrings) {
//			System.out.println(string);
//		}
	}
}

