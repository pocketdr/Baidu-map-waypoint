package com.pocketz.project;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;

public class App {
	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		
		PointsFileInput pFileInput =new PointsFileInput();
		WaypointHandler waypointHandler = new WaypointHandler();
		APIHandler apiHandler = new APIHandler();
		URICreator uriCreator = new URICreator();
		WaypointsOutput output = new WaypointsOutput();
		String uri = "";
		String ak = "";
		String testURI = "http://api.map.baidu.com/direction/v2/riding?origin=40.01116,116.339303&destination=39.936404,116.452562&ak=";
		
		pFileInput.setFilename();
		
		Scanner scanner = new Scanner(System.in);
		do{
			System.out.println("请输入 AK ，以回车键结束：");
			ak = scanner.nextLine();
			uri = testURI + ak;
			apiHandler.setURI(uri);
			if (apiHandler.sendRequest().length()<100) {
				System.err.println("错误的 ak ！");
			}else {
				URICreator.setAk(ak);
				uri = "";
				break;
			}			
		}while(true);
		for (String[] ss : pFileInput.getWaypoints()) {
			uri = uriCreator.clearURI()
			.setType(1)
			.setAttribute("?", "origin", ss[0])
			.setAttribute("destination", ss[1])
			.getURI();
			System.out.println(uriCreator.getURI());
			apiHandler.setURI(uri);
			List<String> waypointList =waypointHandler.getWaypoints(apiHandler.sendRequest());
			waypointList.add(0,"origin:"+ss[0]+";destination:"+ss[1]);
			output.addList(waypointList);
//			for (String s : waypointList) {
//				System.out.println(s);
//			}
//			System.out.println();
		}
		output.exportToFile();

	}
}

