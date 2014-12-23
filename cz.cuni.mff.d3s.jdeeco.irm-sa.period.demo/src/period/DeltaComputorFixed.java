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

/**
 * Delta computor returning always the same value if possible.
 */
public class DeltaComputorFixed implements DeltaComputor {

	/** Default delta in ms. */
	static final long DEFAULT_DELTA = 1000;

	/** Fixed delta. */
	public final long delta;

	/**
	 * Default constructor.
	 */
	public DeltaComputorFixed() {
		this(DEFAULT_DELTA);
	}

	/**
	 * Sets fixed delta.
	 * @param delta fixed delta
	 */
	public DeltaComputorFixed(final long delta) {
		this.delta = delta;
	}

	@Override
	public void computeDelta(final InvariantInfo<?> info) {
		info.delta = delta;
	}
}