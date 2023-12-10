package Ronak_Vala.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	public List<HashMap<String, String>> getJsonDataToMap() throws IOException 
	{
		//read Json to String
		String JsonContent = FileUtils.readFileToString(new File("C://Users//ronak//OneDrive//Desktop//Software testing excelr course material, assignments,etc//java practice//SeleniumFramework//src//test//java//Ronak_Vala//data//PurchaseOrder.json"),StandardCharsets.UTF_8);
		
		//String to HashMap Jackson Databind
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(JsonContent,new TypeReference<List<HashMap<String,String>>>(){});
		return data;
	}
}
