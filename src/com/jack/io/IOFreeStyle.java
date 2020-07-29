package com.jack.io;

public class IOFreeStyle {
	
	private volatile static IOFreeStyle ioFreeStyle;
	
	private IOFreeStyle() {}
	
	
	
	
	
	public static class IOFreeStyleFactory{
		
		public static IOFreeStyle getInstance() {
			synchronized(IOFreeStyle.class) {
				if(ioFreeStyle != null) {
					return ioFreeStyle;
				}else {
					ioFreeStyle = new IOFreeStyle();
					return ioFreeStyle;
				}
			}
		}
		
	}
	
	
	
}
