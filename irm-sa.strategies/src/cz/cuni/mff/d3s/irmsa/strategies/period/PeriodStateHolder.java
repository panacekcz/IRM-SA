package cz.cuni.mff.d3s.irmsa.strategies.period;

import org.checkerframework.checker.initialization.qual.UnknownInitialization;
import org.checkerframework.checker.nullness.qual.Nullable;

import cz.cuni.mff.d3s.irmsa.strategies.commons.EvolutionaryAdaptationPlugin;
import cz.cuni.mff.d3s.irmsa.strategies.commons.StateHolder;


public class PeriodStateHolder extends StateHolder<PeriodBackup> {

	private static final long serialVersionUID = 8934463139475027143L;

	@Override
	protected String createStateHolderName(@UnknownInitialization PeriodStateHolder this) {
		return "PeriodStateHolder";
	}

	@Override
	protected String createStateHolderType(@UnknownInitialization PeriodStateHolder this) {
		return "PeriodStateHolderType";
	}

	@Override
	protected PeriodBackup resetBackup(@UnknownInitialization PeriodStateHolder this, final @Nullable PeriodBackup backup) {
		if (backup == null) {
			return new PeriodBackup();
		}
		backup.exchanges.clear();
		backup.processes.clear();
		return backup;
	}
}
