/**
 * Copyright 2014 Charles University in Prague
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package cz.cuni.mff.d3s.irm.model.trace.api;

import cz.cuni.mff.d3s.deeco.model.runtime.api.ComponentInstance;

import cz.cuni.mff.d3s.irm.model.design.Component;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component Trace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link cz.cuni.mff.d3s.irm.model.trace.api.ComponentTrace#getFrom <em>From</em>}</li>
 *   <li>{@link cz.cuni.mff.d3s.irm.model.trace.api.ComponentTrace#getTo <em>To</em>}</li>
 * </ul>
 * </p>
 *
 * @see cz.cuni.mff.d3s.irm.model.trace.meta.TracePackage#getComponentTrace()
 * @model
 * @generated
 */
public interface ComponentTrace extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright 2014 Charles University in Prague\n\nLicensed under the Apache License, Version 2.0 (the \"License\");\nyou may not use this file except in compliance with the License.\nYou may obtain a copy of the License at\n\nhttp://www.apache.org/licenses/LICENSE-2.0\n\nUnless required by applicable law or agreed to in writing, software\ndistributed under the License is distributed on an \"AS IS\" BASIS,\nWITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\nSee the License for the specific language governing permissions and\nlimitations under the License.";

	/**
	 * Returns the value of the '<em><b>From</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From</em>' attribute.
	 * @see #setFrom(ComponentInstance)
	 * @see cz.cuni.mff.d3s.irm.model.trace.meta.TracePackage#getComponentTrace_From()
	 * @model dataType="cz.cuni.mff.d3s.irm.model.trace.api.ComponentInstanceType" required="true"
	 * @generated
	 */
	ComponentInstance getFrom();

	/**
	 * Sets the value of the '{@link cz.cuni.mff.d3s.irm.model.trace.api.ComponentTrace#getFrom <em>From</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From</em>' attribute.
	 * @see #getFrom()
	 * @generated
	 */
	void setFrom(ComponentInstance value);

	/**
	 * Returns the value of the '<em><b>To</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To</em>' attribute.
	 * @see #setTo(Component)
	 * @see cz.cuni.mff.d3s.irm.model.trace.meta.TracePackage#getComponentTrace_To()
	 * @model dataType="cz.cuni.mff.d3s.irm.model.trace.api.ComponentType" required="true"
	 * @generated
	 */
	Component getTo();

	/**
	 * Sets the value of the '{@link cz.cuni.mff.d3s.irm.model.trace.api.ComponentTrace#getTo <em>To</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To</em>' attribute.
	 * @see #getTo()
	 * @generated
	 */
	void setTo(Component value);

} // ComponentTrace
