package filter;

import java.util.Random;

import org.checkerframework.checker.initialization.qual.UnderInitialization;
import org.checkerframework.checker.initialization.qual.UnknownInitialization;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;

/**
 * A generator of random numbers with normal distribution.
 * Mean and standard deviation can be specified. The seed
 * of the random is fixed and depends on the order in which
 * the {@link NormalDistribution} objects are instantiated.
 * 
 * @author Dominik Skoda <skoda@d3s.mff.cuni.cz>
 *
 */
public class NormalDistribution {

	/**
	 * The initial seed for the {@link NormalDistribution} object.
	 * The seed is changed after new instance of the {@link NormalDistribution}
	 * is created.
	 */
	private static long seed = 75698;
	
	/**
	 * The mean of the normal distribution.
	 */
	private double mean;
	/**
	 * The deviation of the normal distribution.
	 */
	private double deviation;
	/**
	 * {@link Random} number generator.
	 */
	private Random rand;
	
	/**
	 * Create new instance of {@link NormalDistribution} with the mean 0.0
	 * and the standard deviation 1.0.
	 */
	public NormalDistribution() {
		init(0.0, 1.0);
	}
	
	/**
	 * Create new instance of {@link NormalDistribution} with the given mean
	 * and the given standard deviation.
	 * 
	 * @param mean The mean of the normal distribution.
	 * @param deviation The standard deviation of the normal distribution.
	 */
	public NormalDistribution(double mean, double deviation) {
		init(mean, deviation);
	}
	
	/**
	 * Assign the mean, deviation and {@link Random} number generator.
	 * Change the seed for the next instance.
	 * 
	 * @param mean The mean of the normal distribution.
	 * @param deviation The standard deviation of the normal distribution.
	 */
	@EnsuresNonNull({"rand"})
	private void init(@UnderInitialization NormalDistribution this, double mean, double deviation) {
		setDistribution(mean, deviation);
		
		rand = new Random(seed);
		seed += 498349;
	}

	/**
	 * Assign the mean and standard deviation.
	 * 
	 * @param mean The mean of the normal distribution.
	 * @param deviation The standard deviation of the normal distribution.
	 */
	public void setDistribution(@UnknownInitialization NormalDistribution this, double mean, double deviation) {
		this.mean = mean;
		this.deviation = deviation;
	}
	
	/**
	 * Get next random number with normal distribution with predefined
	 * mean and standard deviation.
	 * @return Next random number with normal distribution with predefined
	 * mean and standard deviation.
	 */
	protected double getNext() {
		return mean + rand.nextGaussian()*deviation;
	}

}
