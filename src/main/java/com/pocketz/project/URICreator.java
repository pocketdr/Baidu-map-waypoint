package com.pocketz.project;

public class URICreator {
 
	final static String AK = "&"; 
	
	final static String BASE_URI = "http://api.map.baidu.com/";
	
	StringBuffer ansURI ;
	
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
	public URICreator setAttribute(String saparator,String name, String value) {
		ansURI.append(saparator)
		.append(name)
		.append(value);
		return this;
	}
	
	public URICreator setAk() {
		ansURI.append(AK);
		return this;
	}
	
	public URICreator setAk(String ak) {
		ansURI.append("&")
		.append(ak);
		return this;
	}
	
	public String getURI() {
		return ansURI.toString();
	}

}
