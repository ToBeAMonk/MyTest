package com.gty.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
/**
 *主要讲的是java的getResourceAsStream()的用法，一个简单的例子。
 * @date 2018年11月29日 下午6:50:43
 */
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
