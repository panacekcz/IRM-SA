package cz.cuni.mff.d3s.irmsa.strategies.period;

import cz.cuni.mff.d3s.deeco.annotations.Component;
import cz.cuni.mff.d3s.deeco.annotations.SystemComponent;
import cz.cuni.mff.d3s.irmsa.strategies.commons.EvolutionaryAdaptationManager;

@Component
@SystemComponent
public class PeriodAdaptationManager extends EvolutionaryAdaptationManager {

	/** Flag indicating whether assumptions should be considered is stored in internal data under this key. */
	static final String CONSIDER_ASSUMPTIONS = "considerAssumptions";

	/**
	 * Only constructor.
	 * @param maximumTries maximal number of tries for adaptation, -1 for unbounded
	 */
	protected PeriodAdaptationManager(final int maximumTries) {
		super(new PeriodStateHolder(), maximumTries);
	}
}
