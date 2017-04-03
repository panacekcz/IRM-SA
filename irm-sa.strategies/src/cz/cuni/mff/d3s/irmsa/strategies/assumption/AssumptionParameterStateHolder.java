package cz.cuni.mff.d3s.irmsa.strategies.assumption;

import org.checkerframework.checker.initialization.qual.UnknownInitialization;
import org.checkerframework.checker.nullness.qual.Nullable;

import cz.cuni.mff.d3s.irmsa.strategies.commons.StateHolder;

public class AssumptionParameterStateHolder extends StateHolder<AssumptionParameterBackup> {

	private static final long serialVersionUID = 6690959333951508186L;

	@Override
	protected String createStateHolderName(@UnknownInitialization AssumptionParameterStateHolder this) {
		return "AssumptionParameterStateHolder";
	}

	@Override
	protected String createStateHolderType(@UnknownInitialization AssumptionParameterStateHolder this) {
		return "AssumptionParameterStateHolderType";
	}

	@Override
	protected AssumptionParameterBackup resetBackup(@UnknownInitialization AssumptionParameterStateHolder this, final @Nullable AssumptionParameterBackup backup) {
		if (backup == null) {
			return new AssumptionParameterBackup();
		}
		backup.parameters.clear();
		return backup;
	}
}
