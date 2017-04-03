package filter;

import combined.Position;

public class PositionNoise extends Filter<Position> {

	/**
	 * Generator of random numbers with the normal distribution.
	 */
	private NormalDistribution noise;
	
	/**
	 * Create new instance of {@link PositionNoise} with the normal
	 * distribution with specified mean and standard deviation.
	 * 
	 * @param mean The mean of the normal distribution.
	 * @param deviation The standard deviation of the normal distribution.
	 */
	public PositionNoise(String name, double mean, double deviation) {
		super(name);
		noise = new NormalDistribution(mean, deviation);
	}
	
	/**
	 * Create new instance of {@link PositionNoise} with the normal
	 * distribution with specified mean and standard deviation.
	 * The innerFilter specifies the chain of filters inside this instance.
	 * 
	 * @param mean The mean of the normal distribution.
	 * @param deviation The standard deviation of the normal distribution.
	 * @param innerFilter The chain of filters inside this instance.
	 */
	public PositionNoise(String name, double mean, double deviation, Filter<Position> innerFilter) {
		super(name, innerFilter);
		noise = new NormalDistribution(mean, deviation);
	}

	/**
	 * Apply noise defined by this instance to the given data.
	 * 
	 * @param data The data to apply the filter at.
	 * @return The given data with applied noise.
	 */
	@Override
	protected Position applyNoise(final Position data) {
		// horizontal noise
		double h = noise.getNext();
		// vertical noise
		double v = noise.getNext();

		if(filterWriter != null)
			filterWriter.println(String.format("%s\t%.3f\t%.3f", name, h, v));
		
		return new Position(data.x + h, data.y + v);
	}
}
