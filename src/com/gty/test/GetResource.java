package com.gty.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class GetResource {
	private String getResource(String path) throws IOException {
		// 返回读取指定资源的输入流
		StringBuffer sb = new StringBuffer();
		InputStream is = this.getClass().getResourceAsStream(path);
		BufferedReader br = new BufferedReader(new InputStreamReader(is, "utf-8"));
		String s = "";
		while ((s = br.readLine()) != null) {
			sb.append(s + "\n");
		}
		br.close();
		is.close();
		return sb.toString();
	}

	public static void main(String[] args) {
		String pathA ="testGetResource.txt";
		GetResource resource = new GetResource();
		try {
			String str = resource.getResource(pathA);
			String str1=new String(str.getBytes(),"utf-8");
			System.out.println(str1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
