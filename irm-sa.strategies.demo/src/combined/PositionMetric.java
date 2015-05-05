package combined;

import cz.cuni.mff.d3s.irmsa.strategies.correlation.metric.Metric;

public class PositionMetric implements Metric {

	static public double distance(final Position pos1, final Position pos2) {
		return CoordinateMetric.distance(pos1.toPositionComponent(), pos2.toPositionComponent());
	}

	@Override
	public double distance(Object value1, Object value2) {
		if(!(value1 instanceof Position) || !(value2 instanceof Position))
			throw new IllegalArgumentException("Can't compute a distance of anything else than Positions.");

		final Position pos1 = (Position) value1;
		final Position pos2 = (Position) value2;
		return distance(pos1, pos2);
	}
}
