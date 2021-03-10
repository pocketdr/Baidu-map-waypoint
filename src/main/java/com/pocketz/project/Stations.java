package com.pocketz.project;

import java.util.List;

public class Stations {
	public List<Result> results;
	class Result{	
		public Location location;
	}
	
	class Location{
		public String lat;
		public String lng;
	}

}	
