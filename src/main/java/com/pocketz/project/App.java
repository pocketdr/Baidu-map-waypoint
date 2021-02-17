package com.pocketz.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Hello world!
 *
 */
public class App {
	static String URI = "http://api.map.baidu.com/direction/v2/riding?origin=39.806717,116.48806&destination=39.80957,116.49471&ak=9gXOVbtuir0Di1cw75BEhHtxIHkuQHRH";

	static String ak = "&ak=9gXOVbtuir0Di1cw75BEhHtxIHkuQHRH"; 
	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		WaypointsInput waypointsInput =new WaypointsInput();
		WaypointHandler waypointHandler = new WaypointHandler();

		waypointHandler.setURI(URI);
		String[] waypointStrings = waypointHandler.getWaypoints();
		
		for (String string : waypointStrings) {
			System.out.println(string);
		}
	}
}
