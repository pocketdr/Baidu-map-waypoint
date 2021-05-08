package com.pocketz.project;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.pocketz.project.entity.json.PathPlan;
import com.pocketz.project.entity.json.PathPlan.Step;
import com.pocketz.project.entity.json.Stations;
import com.pocketz.project.entity.json.Stations.StationsRes;


public class WaypointHandler {

	public List<String> getLocations(String responseBody) throws JsonParseException, JsonMappingException, IOException {
		List<String> bufferList = new LinkedList<>();

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

		Stations stations = mapper.readValue(responseBody.getBytes(), Stations.class);

		for (StationsRes result : stations.results) {
			bufferList.add(result.name+result.location.lng + "," + result.location.lat);
		}

		return bufferList;

	}

	public List<String> getWaypoints(String responseBody) throws JsonParseException, JsonMappingException, IOException {
		List<String> bufferList = new LinkedList<>();

		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		PathPlan pathPlan = mapper.readValue(responseBody.getBytes("utf-8"), PathPlan.class);
		
		String[] rJoinPoint = pathPlan.result.routes.get(0).steps.get(0).path.split("\\;");
		String joinPoint = rJoinPoint[0];

		for (Step step : pathPlan.result.routes.get(0).steps) {
			List<String> waypoints = new LinkedList<>(Arrays.asList(step.path.split("\\;")));
			if (joinPoint.equals(waypoints.get(0))) {
				waypoints.remove(0);
				for (String waypoint : waypoints) {
					bufferList.add(waypoint);
					joinPoint = waypoint;
				}
			} else {
				for (String waypoint : waypoints) {
					bufferList.add(waypoint);
					joinPoint = waypoint;
				}
			}

		}
		return bufferList;
	}

}
