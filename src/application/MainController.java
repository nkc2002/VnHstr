package application;

import java.awt.event.InputMethodEvent;
import java.lang.reflect.Method;
import java.util.ArrayList;

import application.data.ReadData;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import object.SuKien;

public class MainController {
	private ReadData<SuKien> reader = new ReadData<SuKien>();

    @FXML
    private BorderPane borderPane;

    @FXML
    private TextField textField;
    
    @FXML
    private Button search;
    
//    private TableView tableView = new TableView();
    
    @FXML
    private Button buttonSuKien;
    
    @FXML
    void pressEnter(KeyEvent event) {

    }

   
    
    @FXML
    void showDataSuKien() throws Exception {
    	TableView tableView = new TableView();
    	String[] suKienStr = { "Historical_Characters", "Title", "ID", "Historical_Places" };
        for (int i = 0; i < suKienStr.length; i++) {
            TableColumn<SuKien, String> ColSuKien = new TableColumn<SuKien, String>(suKienStr[i]);
            ColSuKien.prefWidthProperty().bind(tableView.widthProperty().multiply(0.143));
            ColSuKien.setCellValueFactory(new PropertyValueFactory<SuKien, String>(suKienStr[i]));
            tableView.getColumns().add(ColSuKien);
        }
        
        ObservableList<SuKien> dataSuKien = reader.getData("src/application/data/SuKien.json", new SuKien());
        System.out.println(dataSuKien.get(0).getHistorical_Characters());
        borderPane.setCenter(tableView);
        
        FilteredList<SuKien> filteredData = new FilteredList<>(dataSuKien, b -> true);
        textField.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(SuKien -> {
				
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				ArrayList<String> Historical_Characters = SuKien.getHistorical_Characters();
				for (int i=0; i< Historical_Characters.size(); i++) {
					if(Historical_Characters.get(i).toLowerCase().indexOf(newValue) != -1) {
						return true;
					}
				}
				ArrayList<String> Historical_Places = SuKien.getHistorical_Places();
				for (int i=0; i< Historical_Places.size(); i++) {
					if(Historical_Places.get(i).toLowerCase().indexOf(newValue) != -1) {
						return true;
					}
				}
				if (SuKien.getTitle().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				}
				else  
			    	return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
//		SortedList<SuKien> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
//		sortedData.comparatorProperty().bind(tableView.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tableView.setItems(filteredData);
    }
}
//Method[] methods = SuKien.class.getMethods();
//for (SuKien elm : dataSuKien) {
//	for (Method m : methods) {
//        if (m.getName().startsWith("get")) {
//        	System.out.println(m.getReturnType());
//        	try {
//        		if (m.getReturnType() == Long.class) {
//        			long objField = (long) m.invoke(elm);
//        			if (objField == Long.parseLong(textField.getText())){
//                		newDataSuKien.add(elm);
//                		break;
//                	}
//        		}
//        		else if (m.getReturnType() == ArrayList.class) {
//        			ArrayList<String> objField = (ArrayList<String>) m.invoke(elm);
//        		}
//        		else if (m.getReturnType() == String.class) {
//        			String objField = (String) m.invoke(elm);
//            		Class returnType = m.getReturnType();
//            		if (objField.toLowerCase().indexOf(textField.getText()) != -1){
//                		newDataSuKien.add(elm);
//                		break;
//                	}
//        		}
//        		else {
//        			
//        		}
//        		
//            } catch (ArithmeticException e) {
//            	System.out.println("Error!");
//            }
//        	
//        }
//    }
//}
//
