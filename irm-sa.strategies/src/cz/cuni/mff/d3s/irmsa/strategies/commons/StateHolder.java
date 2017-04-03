package cz.cuni.mff.d3s.irmsa.strategies.commons;

import java.io.Serializable;

import org.checkerframework.checker.initialization.qual.UnderInitialization;
import org.checkerframework.checker.initialization.qual.UnknownInitialization;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

import cz.cuni.mff.d3s.irm.model.design.impl.KnowledgeImpl;

public abstract class StateHolder<T extends @NonNull Backup> extends KnowledgeImpl implements Serializable {

	private static final long serialVersionUID = 9124252960213765211L;

	/** State of the method adaptPeriods. */
	public State state;

	/** Fitness of the previous configuration. */
	public double oldFitness;

	/** Backup to restore the previous configuration. */
	public T backup;

	/** Observing last at least until this time. */
	public long observeTime;

	/**
	 * Only constructor.
	 */
	public StateHolder() {
		this.name = createStateHolderName();
		this.type = createStateHolderType();
		reset();
	}

	/**
	 * Returns name of the state holder. Called in constructor!
	 * @return name of the state holder
	 */
	protected abstract String createStateHolderName(@UnderInitialization StateHolder<T> this);

	/**
	 * Returns type of the state holder. Called in constructor!
	 * @return type of the state holder
	 */
	protected abstract String createStateHolderType(@UnderInitialization StateHolder<T> this);

	/**
	 * Resets the state.
	 */
	@EnsuresNonNull({"state", "backup"})
	public final void reset(@UnknownInitialization StateHolder<T> this) {
		state = State.STARTED;
		oldFitness = 0.0;
		backup = resetBackup(backup);
		observeTime = 0;
	}

	/**
	 * Resets backup. Called in constructor!
	 * @param backup previous backup, may be null, reuse encouraged
	 * @return new backup
	 */
	protected abstract @NonNull T resetBackup(@UnknownInitialization StateHolder<T> this, @Nullable T backup);
}
