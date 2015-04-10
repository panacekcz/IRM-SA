package cz.cuni.mff.d3s.irmsa.strategies;

import java.util.NoSuchElementException;

import cz.cuni.mff.d3s.deeco.model.runtime.api.ComponentInstance;
import cz.cuni.mff.d3s.deeco.task.ProcessContext;

/**
 * Static convenient methods for deeco components.
 */
public final class ComponentHelper {

	/**
	 * Not type-safe method for retrieving objects from component's internal data.
	 * @param key key to search value for
	 * @return typed object from component's internal data
	 * @throws RuntimeException when no, null or wrongly typed data are provided
	 */
	static public <T> T retrieveFromInternalData(final String key) {
		final ComponentInstance instance =
				ProcessContext.getCurrentProcess().getComponentInstance();
		final Object value = instance.getInternalData().get(key);
		try {
			if (value != null) {
				@SuppressWarnings("unchecked")
				final T result = (T) value;
				return result;
			} else {
				throw new NoSuchElementException("No or null data for key " + key);
			}
		} catch (ClassCastException | NoSuchElementException e) {
			throw new RuntimeException(String.format("Could not retrieve %s from internal data.", key), e);
		}
	}

	/**
	 * Utility classes needs no constructor.
	 */
	private ComponentHelper() {
		//nothing
	}
}
