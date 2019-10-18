package com.miaotu;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.mapping.MappedStatement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.springframework.stereotype.Service;


public class GenMain {
	 private static final Logger log = LogManager.getLogger("GenMain");
	 public static void main(String[] args) throws Exception{  
		 
		 List<String> warnings = new ArrayList<String>();
		   boolean overwrite = true;
		   log.debug("begin");
		   String genCfg = "/generatorConfig.xml";  
	        File configFile = new File(GenMain.class.getResource(genCfg).getFile()); 
		   ConfigurationParser cp = new ConfigurationParser(warnings);
		   Configuration config = cp.parseConfiguration(configFile);
		   DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		   MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
		   myBatisGenerator.generate(null);
		   System.out.println("generate sucess!");
	    }  

	
}
