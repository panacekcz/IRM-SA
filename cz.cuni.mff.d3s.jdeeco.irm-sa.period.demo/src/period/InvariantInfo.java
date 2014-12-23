/*******************************************************************************
 * Copyright 2014 Charles University in Prague
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
package period;

import cz.cuni.mff.d3s.irm.model.runtime.api.ExchangeInvariantInstance;
import cz.cuni.mff.d3s.irm.model.runtime.api.InvariantInstance;
import cz.cuni.mff.d3s.irm.model.runtime.api.ProcessInvariantInstance;

/**
 * Common holder of information about invariants.
 * @param <T> either ProcessInvariantInstance or ExchangeInvariantInstance
 */
public class InvariantInfo<T extends InvariantInstance> {

	/**
	 * Factory method to wrap given ProcessInvariantInstance.
	 * @param processInvariant ProcessInvariantInstance to wrap
	 * @return newly created InvariantInfo wrapping given ProcessInvariantInstance
	 */
	static InvariantInfo<ProcessInvariantInstance> create(final ProcessInvariantInstance processInvariant) {
		return new InvariantInfo<ProcessInvariantInstance>(processInvariant, ProcessInvariantInstance.class);
	}

	/**
	 * Factory method to wrap given EnsembleDefinitionTrace.
	 * @param processTrace EnsembleDefinitionTrace to wrap
	 * @return newly created InvariantInfo wrapping given EnsembleDefinitionTrace
	 */
	static InvariantInfo<ExchangeInvariantInstance> create(final ExchangeInvariantInstance exchangeInvariant) {
		return new InvariantInfo<ExchangeInvariantInstance>(exchangeInvariant, ExchangeInvariantInstance.class);
	}

	/** Class of the trace or supertype. */
	public final Class<T> clazz;

	/** Wrapped invariant. */
	public final T invariant;

	/** Invariant fitness. */
	public double fitness;

	/** Invariant weight. */
	public double weight;

	/**
	 * Invariant level.
	 * Integer.MIN_VALUE if uninitialized, call computeInvariantLevel.
	 * Otherwise nulls have 0, roots have 1, etc.
	 */
	public int level = Integer.MIN_VALUE;

	/** Direction of the adaptation. */
	public Direction direction;

	/** Change to the invariant period. Should be always non-negative. */
	public long delta;

	/**
	 * Only and private constructor.
	 * @param invariant InvariantInstance to wrap
	 * @param clazz class of trace
	 */
	private InvariantInfo(final T invariant, final Class<T> clazz) {
		this.invariant = invariant;
		this.clazz = clazz;
	}

	/**
	 * Convenient method to cast invariant.
	 * Check clazz before to know the actual class
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public <X> X getInvariant() {
		return (X) invariant;
	}

	@Override
	public int hashCode() {
		return invariant == null ? 0 : invariant.hashCode();
	}

	/**
	 * Computes level of the given invariant.
	 * Nulls have level 0, roots have level 1.
	 * @param invariant given invariant
	 * @return level of the invariant
	 */
	public int computeInvariantLevel() {
		InvariantInstance loop = invariant;
		int level = 0;
		while (loop != null) {
			++level;
			loop = loop.getParent();
		}
		return this.level = level;
	}
}