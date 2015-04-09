package com.lxy.util;

import java.util.Collection;
import java.util.Map;

public class ValidateUtil {
	
	/**
	 * validate the object is not empty
	 * @param o
	 * @return
	 */
	public static boolean isNotEmpty(Object o){
		return !(isEmpty(o));
	}
	
	/**
	 * validate the Object is enpty
	 * @param o
	 * @return
	 */
	public static boolean isEmpty(Object o){
		if(null == o){
			return true;
		}else if(o instanceof String && ((String) o).trim().length() == 0){
			return true;
		}else if( o instanceof Collection<?> && ((Collection<?>) o).size() == 0){
			return true;
		}else if( o instanceof Map<?, ?> && ((Map<?, ?>) o).size() == 0){
			return true;
		}else{
			return false;
		}
	}

}
