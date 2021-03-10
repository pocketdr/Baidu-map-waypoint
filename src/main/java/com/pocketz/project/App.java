package com.pocketz.project;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
//	static String URI1 = "http://api.map.baidu.com/direction/v2/riding?origin=39.806717,116.48806&destination=39.80957,116.49471&ak=9gXOVbtuir0Di1cw75BEhHtxIHkuQHRH";
//	static String URI2 = "http://api.map.baidu.com/place/v2/search?query=公交车站&location=38.309737,116.858596&radius=10000000&radius_limit=true&output=json&page_size=20&page_num=4&ret_coordtype=gcj02ll&ak=9gXOVbtuir0Di1cw75BEhHtxIHkuQHRH";
//
//	static String ak = "&ak=9gXOVbtuir0Di1cw75BEhHtxIHkuQHRH"; 
//	
	//116.844079,38.307981
//	116.836093,38.298948
//	116.858596,38.309737
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

