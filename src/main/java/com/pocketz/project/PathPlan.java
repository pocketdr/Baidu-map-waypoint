package com.pocketz.project;

import java.util.List;

public class PathPlan {
	public Result result;
	class Result{
		public List<Route> routes;
	}
	
	class Route{
		public int distance;
		public int duration;
		
		public List<Step> steps;
	}
	
	class Step{
		public int distance;
		public int duration;
		public String instructions;
		public String name;
		
		public String path;
		public StepOriginLocation stepOriginLocation;
		public StepDestinationLocation stepDestinationLocation;
		
	}
	class StepOriginLocation{
		public double lng;
		public double lat;
	}
	class StepDestinationLocation{
		public double lng;
		public double lat;
	}
}

