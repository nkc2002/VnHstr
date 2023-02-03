package application.data;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import object.SuKien;

public class ReadData<T> {
	private ObservableList<T> dataJsonList = FXCollections.observableArrayList();
	
	public ObservableList<T> getData(String path, Object demo) throws Exception {
		JSONParser jsonParser = new JSONParser();
        JSONArray dataList = null;
        try (FileReader reader = new FileReader(path)) {
            // Read JSON file
            Object obj = jsonParser.parse(reader);
            dataList = (JSONArray) obj;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (demo.getClass() == SuKien.class) {
        	for (int i = 0; i < dataList.size(); i++) {
            	JSONObject newJsonObj =(JSONObject) dataList.get(i);
            	ArrayList<String> Historical_Characters =(ArrayList<String>) newJsonObj.get("Historical_Characters");
        		String Title = (String) newJsonObj.get("Title");
        		long ID = (long) newJsonObj.get("ID");
        		ArrayList<String> Historical_Places =(ArrayList<String>) newJsonObj.get("Historical_Places");
        		T newData = (T) new SuKien(Historical_Characters, Title, ID, Historical_Places);
            	dataJsonList.add(newData);
            }
        }
        
        return dataJsonList;
    }
}
