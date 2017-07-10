package osgi.enroute.iot.pi.provider;

import osgi.enroute.dto.api.DTOs;
import osgi.enroute.iot.gpio.api.CircuitBoard;
import osgi.enroute.iot.gpio.util.Analog;
import osgi.enroute.iot.gpio.util.ICAdapter;

public class I2C extends ICAdapter<Analog, Void> implements Analog {
	/**
	 * An I2C input
	 * 
	 * @param name
	 *            the name of the IC
	 * @param board
	 *            the circuit board
	 * @param dtos
	 *            TODO
	 */
	
	private static double values[] = {0, 0, 0, 0};
	private static double value;
	
	public I2C(String name, CircuitBoard board, DTOs dtos) {
		super(name,dtos,board);
	}

	@Override
	public void set(double value) {
		I2C.value = value;
	}
	
	public void set(double value, int pin) {
		values[pin] = value;
	}
	
	public static double getValue() {
		return value;
	}
	
	public static double getValue(int i) {
		if(i < values.length)
			return values[i];
		
		return Double.NaN;
	}
}
