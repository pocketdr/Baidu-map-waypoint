package com.pocketz.project;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class WaypointHandler {

	String uri;

	// TODO change to setOriginLocation();
	public void setURI(String uri) {
		this.uri = uri;
	}

	public String[] getWaypoints() throws JsonParseException, JsonMappingException, FileNotFoundException, IOException,
			URISyntaxException, InterruptedException {
		HttpClient httpClient = HttpClient.newBuilder().build();
		List<String> bufferList = new LinkedList<>();

		HttpRequest request = HttpRequest.newBuilder(new URI(uri)).header("User-Agent", "Java HttpClient")
				.header("Accept", "*/*").timeout(Duration.ofSeconds(5)).version(Version.HTTP_2).build();
		
		HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PathPlan pathPlan = mapper.readValue(response.body().getBytes(), PathPlan.class);
		String[] rJoinPoint = pathPlan.result.routes.get(0).steps.get(0).path.split("\\;");
		String joinPoint = rJoinPoint[0];
		
		for (Step step : pathPlan.result.routes.get(0).steps) {
			List<String> waypoints = new LinkedList<>(Arrays.asList(step.path.split("\\;")));
			if (joinPoint.equals(waypoints.get(0))) {
				waypoints.remove(0);
				for (String waypoint : waypoints) {
//					System.out.println(waypoint);
					bufferList.add(waypoint);
					joinPoint = waypoint;
				}
			} else {
				for (String waypoint : waypoints) {
//					System.out.println(waypoint);
					bufferList.add(waypoint);
					joinPoint = waypoint;
				}
			}
			
		}
		int arraySize = bufferList.size();
		String[] outputArray = new String[arraySize];
		int i = 0;
		for (String string : bufferList) {
			outputArray[i] = string;
			i++;
		}
		return outputArray;
	}

}
