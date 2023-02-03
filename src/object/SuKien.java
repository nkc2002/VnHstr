package object;

import java.util.ArrayList;

public class SuKien {
	
	private String listProperty[] = {"Historical_Characters", "Title", "ID", "Historical_Places"};
	private ArrayList<String> Historical_Characters;
	private String Title;
	private long ID;
	private ArrayList<String> Historical_Places;
	
	public SuKien( ArrayList<String> historical_Characters, String title, long iD2,
			ArrayList<String> historical_Places) {
		Historical_Characters = historical_Characters;
		Title = title;
		ID = iD2;
		Historical_Places = historical_Places;
	}
	
	public SuKien(String title, long iD) {
		Title = title;
		ID = iD;
	}
	public SuKien() {
		
	}
	public void setListProperty(String[] listProperty) {
		this.listProperty = listProperty;
	}
	public ArrayList<String> getHistorical_Characters() {
		return Historical_Characters;
	}
	public void setHistorical_Characters(ArrayList<String> historical_Characters) {
		Historical_Characters = historical_Characters;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public long getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public ArrayList<String> getHistorical_Places() {
		return Historical_Places;
	}
	public void setHistorical_Places(ArrayList<String> historical_Places) {
		Historical_Places = historical_Places;
	}
	
	
}
