package com.pocketz.project;

public class URICreator {
	private static String AK = ""; 
	
	private final static String BASE_URI = "http://api.map.baidu.com/";
	
	private StringBuffer ansURI ;
	
	public URICreator clearURI() {
		ansURI = new StringBuffer();
		return this;
	}
	
	public URICreator setType(int i ) {
		if (i == 1 ) {
			ansURI.append(BASE_URI)
			.append("direction/v2/riding");
			return this;
		} else {			
			ansURI.append(BASE_URI)
			.append("place/v2/search");
			return this;
		}
		
	}
	public URICreator setAttribute(String name, String value) {
		ansURI.append("&")
		.append(name)
		.append("=")
		.append(value);
		return this;
	}
	public URICreator setAttribute(String saparator,String name, String value) {
		ansURI.append(saparator)
		.append(name)
		.append("=")
		.append(value);
		return this;
	}
	
	public String getURI() {
		ansURI.append(AK);
		return ansURI.toString();
	}

	public static void setAk(String ak) {
		URICreator.AK += "&ak="+ak;
	}
}
