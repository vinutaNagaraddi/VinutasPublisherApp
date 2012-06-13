package main.java.com.vinuta.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.apache.struts2.StrutsStatics;

import com.opensymphony.xwork2.conversion.TypeConversionException;

import ognl.DefaultTypeConverter;

public class MyDateConverter extends DefaultTypeConverter {
	private Logger logger = Logger.getLogger(this.getClass());
	
	 public Object convertValue(Map context, Object value, Class toType) {
	        if (toType == Date.class) {
	            DateFormat format = DateFormat.getDateInstance(DateFormat.MEDIUM);
	            format.setLenient(false);
	            try {
	                String[] s = (String[]) value;
	                Date date = format.parse(s[0]);
	                return date;
	            } catch (ParseException e) {
	                logger.warn("Error:" + e);
	                throw new TypeConversionException("Invalid conversion");
	            }
	        }
	        return null;
	    }
}
