package com.app.gadget;
import java.util.Calendar;

import com.app.interfaces.Device;

public class Tv implements Device{

//	int deviceID;
	String deviceName;
	String button;
	Calendar runtime;
	
	public Tv() {
//		this.deviceID=01;
		this.button = "OFF";
		this.runtime = Calendar.getInstance();
		this.deviceName="sony";
	}
	public Tv(String name) {
//		this.deviceID=1;
		this.button = "OFF";
		this.runtime = Calendar.getInstance();
		this.deviceName=name;
	}
	public String getDeviceName() {
		return deviceName;
	}

	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	public String getSwtich() {
		return button;
	}

	public void setSwtich(String swtich) {
		this.button = swtich;
		
	}

	public Calendar getRuntime() {
		return runtime;
	}

	public void setRuntime() {
		this.runtime = Calendar.getInstance();
	}

	public void onDevice() {
		
		this.button="ON";
		System.out.println("|device is on|");
		setRuntime();
		
	}
	public void offDevice() {
		
		this.button="OFF";
		System.out.println("|device is off|");
		setRuntime();
	}
	public void deviceStatus() {
		
		Calendar now=Calendar.getInstance();
		int time=now.get(Calendar.MINUTE)-runtime.get(Calendar.MINUTE);
		System.out.println("the device is "+this.button+" from last "+time+" min");
	}
	public void displayDevice() {
		
		System.out.println(" tv            "+this.deviceName );
		
	}
	

}
