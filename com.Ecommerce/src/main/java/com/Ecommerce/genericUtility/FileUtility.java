package com.Ecommerce.genericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.InvalidArgumentException;

public class FileUtility {

	public String retrieveDataFromProperty(String filePath, String key) {
		try {
			FileInputStream file = new FileInputStream(filePath);
			Properties p = new Properties();
			p.load(file);
			return p.getProperty(key);
		} catch (Exception e) {
			throw new InvalidArgumentException("Data is wrong" + e.getMessage());
		}
	}

}
