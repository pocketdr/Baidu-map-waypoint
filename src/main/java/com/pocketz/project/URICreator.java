package com.pocketz.project;

public class URICreator {
//	static String URI1 = "http://api.map.baidu.com/direction/v2/riding"
//			+ "?origin=39.806717,116.48806"
//			+ "&destination=39.80957,116.49471"
//			+ "&ak=9gXOVbtuir0Di1cw75BEhHtxIHkuQHRH";
//	static String URI2 = "http://api.map.baidu.com/place/v2/search"
//			+ "?query=公交车站"
//			+ "&location=38.298948,116.836093"
//			+ "&radius=3000"
//			+ "&radius_limit=false"
//			+ "&output=json"
//			+ "&page_size=20"
//			+ "&page_num=3"
//			+ "&coord_type=1"
//			+ "&ak=9gXOVbtuir0Di1cw75BEhHtxIHkuQHRH";

	final static String AK = "&ak=9gXOVbtuir0Di1cw75BEhHtxIHkuQHRH"; 
	
	final static String BASE_URI = "http://api.map.baidu.com/";
	
	String ansURI = "";
	
	public URICreator clearURI() {
		ansURI = "";
		return this;
	}
	
	public URICreator setType(int i ) {
		if (i == 1 ) {
			ansURI += (BASE_URI + "direction/v2/riding");
			return this;
		} else {
			ansURI += (BASE_URI + "place/v2/search");
			return this;
		}
		
	}
	public URICreator setAttribute(String saparator,String name, String value) {
		ansURI += (saparator + name + value);
		return this;
	}
	
	public URICreator setAk() {
		ansURI += AK;
		return this;
	}
	
	public URICreator setAk(String ak) {
		ansURI += ("&" + ak);
		return this;
	}
	
	public String getURI() {
		return ansURI;
	}

}
