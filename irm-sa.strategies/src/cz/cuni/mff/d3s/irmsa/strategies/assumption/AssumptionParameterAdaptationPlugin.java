package cz.cuni.mff.d3s.irmsa.strategies.assumption;

import org.checkerframework.checker.initialization.qual.UnknownInitialization;
import org.eclipse.emf.common.util.EMap;

import cz.cuni.mff.d3s.deeco.model.runtime.api.RuntimeMetadata;
import cz.cuni.mff.d3s.irm.model.design.IRM;
import cz.cuni.mff.d3s.irm.model.trace.api.TraceModel;
import cz.cuni.mff.d3s.irmsa.strategies.MetaAdaptationPlugin;
import cz.cuni.mff.d3s.irmsa.strategies.commons.EvolutionaryAdaptationManager;
import cz.cuni.mff.d3s.irmsa.strategies.commons.EvolutionaryAdaptationPlugin;
import cz.cuni.mff.d3s.irmsa.strategies.commons.variations.AdapteeSelector;
import cz.cuni.mff.d3s.irmsa.strategies.commons.variations.DeltaComputor;
import cz.cuni.mff.d3s.irmsa.strategies.commons.variations.DirectionSelector;
import cz.cuni.mff.d3s.irmsa.strategies.commons.variations.InvariantFitnessCombiner;

/**
 * Plugin for period adaptation strategy.
 */
public class AssumptionParameterAdaptationPlugin extends EvolutionaryAdaptationPlugin<AssumptionParameterAdaptationPlugin, AssumptionParameterBackup> {

	/** Observe time. */
	protected long observeTime = 5000;

	/**
	 * Only constructor.
	 * @param metaAdaptationPlugin plugin managing this plugin
	 * @param model model
	 * @param design design
	 * @param trace trace
	 */
	public AssumptionParameterAdaptationPlugin(final MetaAdaptationPlugin metaAdaptationPlugin,
			final RuntimeMetadata model, final IRM design, final TraceModel trace) {
		super(new AssumptionParameterAdaptationManagerDelegate(),
				metaAdaptationPlugin, model, design, trace);
	}

	public AssumptionParameterAdaptationPlugin withObserveTime(final long observeTime) {
		this.observeTime = observeTime;
		return self();
	}

	@Override
	protected AssumptionParameterAdaptationPlugin self() {
		return this;
	}

	@Override
	protected InvariantFitnessCombiner createDefaultInvariantFitnessCombiner(@UnknownInitialization AssumptionParameterAdaptationPlugin this) {
		return new InvariantFitnessCombinerAverage();
	}

	@Override
	protected AdapteeSelector createDefaultAdapteeSelector(@UnknownInitialization AssumptionParameterAdaptationPlugin this) {
		return new AdapteeSelectorFitness();
	}

	@Override
	protected DirectionSelector createDefaultDirectionSelector(@UnknownInitialization AssumptionParameterAdaptationPlugin this) {
		return new DirectionSelectorImpl();
	}

	@Override
	protected DeltaComputor createDefaultDeltaComputor(@UnknownInitialization AssumptionParameterAdaptationPlugin this) {
		return new DeltaComputorFixed();
	}

	@Override
	protected EvolutionaryAdaptationManager createAdaptationManager(@UnknownInitialization AssumptionParameterAdaptationPlugin this) {
		return new AssumptionParameterAdaptationManager(maximumTries);
	}

	@Override
	protected void provideDataToManager(final EMap<String, Object> data) {
		data.put(AssumptionParameterAdaptationManager.OBSERVE_TIME, observeTime);
	}
}
