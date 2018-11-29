package com.utils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import com.exception.InitializationException;
//配置文件读取的工具类
public class PropertieUtil {
	private static String filePath = "";
	private static boolean readInJar = false;
	private static String[] drivers = new String[] { "K", "J", "I", "H", "G", "F", "E", "D", "C", "B", "A" };
	private static Properties props;
	static {
		String path = PropertieUtil.class.getProtectionDomain().getCodeSource().getLocation().getFile();
		//从new File(path).getParentFile().getAbsolutePath()得到"otl.properties"。
		File tmpFile = new File(new File(path).getParentFile().getAbsolutePath(), "otl.properties");
		for (String driver : drivers) {
			if (new File(driver + ":\\zhibei\\otl\\otl.properties").exists())
				filePath = driver + ":\\zhibei\\otl\\otl.properties";
		}
		if (new File("/home/otl/otl.properties").exists())
			filePath = "/home/otl/otl.properties";
		if (tmpFile.exists()) {
			filePath = tmpFile.getAbsolutePath();
		}
		if (filePath.length() == 0) {
			readInJar = true;
		}

		props = new Properties();
		try {
			// 注意路径以 / 开始，没有则处理
			if (!filePath.startsWith("/"))
				filePath = "/" + filePath;
			InputStream in;
			if (readInJar) {
				in = PropertieUtil.class.getResourceAsStream("/otl.properties");
			} else {
				in = new FileInputStream(filePath);
			}
			props.load(in);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getFilePath() {
		return filePath;
	}

	/**
	 * 读取配置文件某属性
	 */
	public static String readValue(String key) {
		String value = props.getProperty(key);
		return value;
	}

	/**
	 * 读取配置文件某属性
	 */
	public static boolean readBooleanValue(String key, boolean def) {
		// return true;
		String value = readValue(key);
		if (value.toLowerCase().equals("true") || value.toLowerCase().equals("on") || value.toLowerCase().equals("open")) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 读取配置文件某属性
	 */
	public static int readIntValue(String key, int def) {
		try {
			String value = readValue(key);
			return Integer.parseInt(value);
		} catch (Exception e) {
			return def;
		}
	}

	/**
	 * 打印配置文件全部内容（filePath，配置文件名，如果有路径，props/test.properties）
	 */
	// public static void readProperties(String filePath) {
	// Properties props = new Properties();
	// try {
	// // 注意路径以 / 开始，没有则处理
	// if (!filePath.startsWith("/"))
	// filePath = "/" + filePath;
	// InputStream in = new FileInputStream(filePath);
	// props.load(in);
	// Enumeration<?> en = props.propertyNames();
	// // 遍历打印
	// while (en.hasMoreElements()) {
	// String key = (String) en.nextElement();
	// props.getProperty(key);
	// }
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }

	/**
	 * 将值写入配置文件
	 */
	public static void writeProperties(String parameterName, String parameterValue) {
		// 获取配置文件
		try {
			SafeProperties pps = new SafeProperties();
			InputStream in = new BufferedInputStream(new FileInputStream(filePath));
			pps.load(in);
			in.close();
			OutputStream out = new FileOutputStream(filePath);
			// 设置配置名称和值
			pps.setProperty(parameterName, parameterValue);
			// comments 等于配置文件的注释
			pps.store(out, null);
			out.flush();
			out.close();
		} catch (Exception e) {
		}

	}

	public static String readProperties(String key) throws InitializationException {
		String value = PropertieUtil.readValue(key);
		if (value == null) {
			throw new InitializationException("读取配置文件", key + " 配置项不存在");
		}
		return value;
	}
	
	public static String readStringProperties(String key,String defaultStr){
		String value = PropertieUtil.readValue(key);
		if (value == null) {
			value = defaultStr;
		}
		return value;
	}

	public static int readIntProperties(String key) throws InitializationException {
		String value = PropertieUtil.readValue(key);
		if (value == null) {
			throw new InitializationException("读取配置文件", key + " 配置项不存在");
		}
		return Integer.parseInt(value);
	}

	public static void main(String[] args) {
		PropertieUtil.getFilePath();
	}
}