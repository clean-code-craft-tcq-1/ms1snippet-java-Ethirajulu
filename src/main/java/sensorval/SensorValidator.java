package sensorval;

import java.util.List;

public class SensorValidator {
	public static boolean noSuddenJumpCheck(double value, double nextValue, double maxDelta) {
		if (nextValue - value > maxDelta) {
			return false;
		}
		return true;
	}

	public static boolean validateReadings(List<Double> values) {
		if (null != values) {
			int lastButOneIndex = values.size() - 1;
			for (int i = 0; i < lastButOneIndex; i++) {
				if (!noSuddenJumpCheck(values.get(i), values.get(i + 1), 0.05)) {
					return false;
				}
			}
		} else {
			return false;
		}
		return true;
	}

}
