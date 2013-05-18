package com.EasyCab;


import java.util.HashMap;

public class ActivatedObjects {
	public static HashMap<String, CustomerBean> customer;
	public static HashMap<String, DriverBean> driver;
	public ActivatedObjects(){
		ActivatedObjects.customer = new HashMap<String, CustomerBean>();
		ActivatedObjects.driver = new HashMap<String, DriverBean>();
	}
	
	
	public static HashMap<String, CustomerBean> getCustomer() {
		return customer;
	}

	public static void setCustomer(HashMap<String, CustomerBean> customer) {
		ActivatedObjects.customer = customer;
	}

	public static HashMap<String, DriverBean> getDriver() {
		return driver;
	}

	public static void setDriver(HashMap<String, DriverBean> driver) {
		ActivatedObjects.driver = driver;
	}

	public static void addCustomer(HashMap<String, CustomerBean> customer, String userName, double lat, double longt){
		if (!customer.containsKey(userName)){
			CustomerBean cb = new CustomerBean(userName, lat, longt);
			customer.put(userName, cb);
		}
		else{
			CustomerBean cb = customer.get(userName);
			cb.setLat(lat);
			cb.setLongt(longt);
		    customer.put(userName,cb);
		}
	}
	
	public static void removeCustomer(HashMap<String, CustomerBean> customer, String userName){
		if (customer.containsKey(userName)){
           Object obj = customer.remove(userName);
           System.out.println(obj + " Removed from HashMap");
		}
		
	}
	
	public static void addDriver(HashMap<String, DriverBean> driver, String userName, double lat, double longt){
		if (!driver.containsKey(userName)){
			DriverBean db = new DriverBean(userName, lat, longt);
			driver.put(userName, db);
		}
		else{
			DriverBean db = driver.get(userName);
			db.setLat(lat);
			db.setLongt(longt);
		    driver.put(userName,db);
		}
			
	}
	
	public static void removeDriver(HashMap<String, DriverBean> driver, String userName){
		if (driver.containsKey(userName)){
	           Object obj = driver.remove(userName);
	           System.out.println(obj + " Removed from HashMap");
			}
	}
}
