package com.pocketz.project.entity.json;

import java.util.List;

public class PathPlan {
	public int status;
	public String message;
	public PathPlanRes result;
	public static class PathPlanRes{
		public List<Route> routes;
	}
	
	public static class Route{
		public int distance;
		public int duration;
		
		public List<Step> steps;
	}
	
	public static class Step{
		public int distance;
		public int duration;
		public String instructions;
		public String name;
		
		public String path;
		public StepOriginLocation stepOriginLocation;
		public StepDestinationLocation stepDestinationLocation;
		
	}
	public static class StepOriginLocation{
		public double lng;
		public double lat;
	}
	public static class StepDestinationLocation{
		public double lng;
		public double lat;
	}
}

