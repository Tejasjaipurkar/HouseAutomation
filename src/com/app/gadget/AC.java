package com.app.gadget;

import java.util.Calendar;

import com.app.interfaces.Device;

public class AC implements Device{

	String deviceName;
	String button;
	Calendar runtime;
	int temp;
	public AC() {
		this.button = "OFF";
		this.runtime = Calendar.getInstance();
		this.deviceName="sony";
		this.temp=0;
	}
	public AC(String name) {
		this.button = "OFF";
		this.runtime = Calendar.getInstance();
		this.deviceName=name;
		this.temp=0;
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
	
	public int getTemp() {
		return temp;
	}
	public void setTemp(int temp) {
		this.temp = temp;
	}
	public Calendar getRuntime() {
		return runtime;
	}
	public void increaseTemp(int t)
	{
		this.temp=t;
	}
	public void decreaseTemp(int t)
	{
		this.temp=t;
	}
	public void setRuntime() {
		this.runtime = Calendar.getInstance();
	}

	public void onDevice() {
		
		this.button="ON";
		System.out.println("|device is ON|");
		setRuntime();
		
	}
	public void offDevice() {
		
		this.button="OFF";
		System.out.println("|device is OFF|");
		setRuntime();
	}
	public void deviceStatus() {
		
		Calendar now=Calendar.getInstance();
		int time=now.get(Calendar.MINUTE)-runtime.get(Calendar.MINUTE);
		System.out.println("the device is "+this.button+" from last "+time+" min");
	}
	public void displayDevice() {
		
		System.out.println(" AC            "+this.deviceName );
		
	}

}
