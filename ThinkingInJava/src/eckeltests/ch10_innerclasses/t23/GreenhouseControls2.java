package eckeltests.ch10_innerclasses.t23;

import eckeltests.ch10_innerclasses.t23.controller.Event;

public class GreenhouseControls2 extends GreenhouseControls{
	private String moisturize = "off";
	public class MoisturizeOn extends Event {
	    public MoisturizeOn(long delayTime) {
	      super(delayTime);
	    }
	    public void action() {
	      // Put hardware control code here.
	    	moisturize = "on";
	    }
	    public String toString() {
	      return "Moisturize is on";
	    }
	  }
	public class MoisturizeOff extends Event {
	    public MoisturizeOff(long delayTime) {
	      super(delayTime);
	    }
	    public void action() {
	      // Put hardware control code here.
	    	moisturize = "off";
	    }
	    public String toString() {
	      return "Moisturize is off";
	    }
	  }	
}
