package com.utils;

import java.io.File;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class Log{
	

	public Logger logger;
	FileHandler handler;
	
	public Log(String fName){
		logger = Logger.getLogger("test");
		File f = new File(fName);
		if(!f.exists()){
			try {
				f.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		try {
			handler = new FileHandler(fName,8096,1,true);
			logger.addHandler(handler);
			SimpleFormatter formatter = new SimpleFormatter();
			handler.setFormatter(formatter);
		} catch (SecurityException | IOException e) {
			e.printStackTrace();
		}

	}

	}
