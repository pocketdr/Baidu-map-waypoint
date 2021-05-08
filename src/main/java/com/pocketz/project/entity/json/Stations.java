package com.pocketz.project.entity.json;

import java.util.List;

public class Stations {
	public List<StationsRes> results;
	public class StationsRes{
		public String name;
		public Location location;
	}
	
	public class Location{
		public String lat;
		public String lng;
	}

}	
