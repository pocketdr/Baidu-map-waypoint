package com.pocketz.project;

public class URICreator {
 
	final static String AK = ""; 
	
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
