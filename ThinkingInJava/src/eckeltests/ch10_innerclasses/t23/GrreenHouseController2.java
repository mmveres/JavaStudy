package eckeltests.ch10_innerclasses.t23;

import eckeltests.ch10_innerclasses.t23.controller.Event;

public class GrreenHouseController2 {
	public static void main(String[] args) {
		GreenhouseControls2 gc = new GreenhouseControls2();
		// Instead of hard-wiring, you could parse
		// configuration information from a text file here:
		gc.addEvent(gc.new Bell(900));
		Event[] eventList = { gc.new ThermostatNight(0),
				gc.new LightOn(200),
				gc.new LightOff(400),
				gc.new MoisturizeOn(500),
				gc.new WaterOn(600),
				gc.new MoisturizeOff(700),
				gc.new WaterOff(800),
				gc.new ThermostatDay(1400) };
		gc.addEvent(gc.new Restart(2000, eventList));
		if (args.length == 1)
			gc.addEvent(new GreenhouseControls.Terminate(new Integer(args[0])));
		gc.run();
	}
} /*
	 * Output: Bing! Thermostat on night setting Light is on Light is off
	 * Greenhouse water is on Greenhouse water is off Thermostat on day setting
	 * Restarting system Terminating
	 */// :~
