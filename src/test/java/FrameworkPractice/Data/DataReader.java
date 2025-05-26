package FrameworkPractice.Data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	public List<HashMap<String, String>> getJasonDataToMap() throws IOException
	{
		//read json to string
		String jasonContent=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\FrameworkPractice\\Data\\PurchaseOrder.jason"),
				StandardCharsets.UTF_8);
		
		//String to hashmap
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data= mapper.readValue(jasonContent,new TypeReference<List<HashMap<String, String>>>()
		{
		});
		return data;
		}
		
	}


