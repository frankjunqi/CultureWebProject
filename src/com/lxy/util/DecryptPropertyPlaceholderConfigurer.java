package com.lxy.util;

import java.io.IOException;   
import java.io.InputStream;     
import java.security.Key;   
import java.util.Properties;   
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;   
import org.springframework.core.io.Resource;   
import org.springframework.util.DefaultPropertiesPersister;   
import org.springframework.util.PropertiesPersister;  

public class DecryptPropertyPlaceholderConfigurer extends PropertyPlaceholderConfigurer{   
	private Resource[] locations;   //重新定义父类中的这个同名属性
	private Resource keyLocation; //用于指定密钥文件
	public void setKeyLocation(Resource keyLocation){   
		this.keyLocation = keyLocation;   
	}   
	public void setLocations(Resource[] locations){   
		this.locations = locations;   
	}   
	public void loadProperties(Properties props) throws IOException{   
		if (this.locations != null){   
			PropertiesPersister propertiesPersister = new DefaultPropertiesPersister();   
			for (int i = 0; i < this.locations.length; i++){   
				Resource location = this.locations[i];   
				if (logger.isInfoEnabled()){   
					logger.info("Loading properties file from " + location);   
				}   
				InputStream is = null;   
				try{   
					is = location.getInputStream();
					//加载密钥   
					Key key = DESEncryptUtil.getKey(keyLocation.getInputStream());   
					//对属性文件进行解密
					is = DESEncryptUtil.doDecrypt(key, is);   
					//将解密后的属性流装载到props
					propertiesPersister.load(props ,is);   
				} finally{   
					if (is != null)   
						is.close();
				}   
			}   
		}   
	}  
}  
