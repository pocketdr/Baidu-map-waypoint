package com.pocketz.project;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class PointsFileInput {

	private String fileName;
	private File srcFile;

	public void setFilename() {
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("请输入文件名，如 a.txt ，以回车键结束：");
			fileName = scanner.nextLine();
			srcFile = new File("." + File.separator + fileName);
			if (srcFile.exists()) {
				break;
			} else {
				System.err.println("文件不存在！");
			}

		} while (true);
	}

	public List<String[]> getWaypoints() throws IOException {

		List<String[]> waypoints = new LinkedList<>();

		try (BufferedReader reader = new BufferedReader(new FileReader(srcFile))) {
			String line = reader.readLine();
			while (line != null) {
				String[] fields = line.split(",");
				String[] waypoint = new String[] { fields[3] + "," + fields[4], fields[5] + "," + fields[6] };
				waypoints.add(waypoint);
				line = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return waypoints;

	}
}
