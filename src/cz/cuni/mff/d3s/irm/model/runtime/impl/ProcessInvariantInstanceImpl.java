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
package cz.cuni.mff.d3s.irm.model.runtime.impl;

import cz.cuni.mff.d3s.deeco.model.runtime.api.ComponentProcess;

import cz.cuni.mff.d3s.irm.model.runtime.api.ProcessInvariantInstance;

import cz.cuni.mff.d3s.irm.model.runtime.meta.IRMRuntimePackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Process Invariant Instance</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link cz.cuni.mff.d3s.irm.model.runtime.impl.ProcessInvariantInstanceImpl#getComponentProcess <em>Component Process</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ProcessInvariantInstanceImpl extends PresentInvariantInstanceImpl implements ProcessInvariantInstance {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright 2014 Charles University in Prague\n\nLicensed under the Apache License, Version 2.0 (the \"License\");\nyou may not use this file except in compliance with the License.\nYou may obtain a copy of the License at\n\nhttp://www.apache.org/licenses/LICENSE-2.0\n\nUnless required by applicable law or agreed to in writing, software\ndistributed under the License is distributed on an \"AS IS\" BASIS,\nWITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\nSee the License for the specific language governing permissions and\nlimitations under the License.";

	/**
	 * The default value of the '{@link #getComponentProcess() <em>Component Process</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentProcess()
	 * @generated
	 * @ordered
	 */
	protected static final ComponentProcess COMPONENT_PROCESS_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getComponentProcess() <em>Component Process</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponentProcess()
	 * @generated
	 * @ordered
	 */
	protected ComponentProcess componentProcess = COMPONENT_PROCESS_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ProcessInvariantInstanceImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return IRMRuntimePackage.Literals.PROCESS_INVARIANT_INSTANCE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComponentProcess getComponentProcess() {
		return componentProcess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setComponentProcess(ComponentProcess newComponentProcess) {
		ComponentProcess oldComponentProcess = componentProcess;
		componentProcess = newComponentProcess;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, IRMRuntimePackage.PROCESS_INVARIANT_INSTANCE__COMPONENT_PROCESS, oldComponentProcess, componentProcess));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case IRMRuntimePackage.PROCESS_INVARIANT_INSTANCE__COMPONENT_PROCESS:
				return getComponentProcess();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case IRMRuntimePackage.PROCESS_INVARIANT_INSTANCE__COMPONENT_PROCESS:
				setComponentProcess((ComponentProcess)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case IRMRuntimePackage.PROCESS_INVARIANT_INSTANCE__COMPONENT_PROCESS:
				setComponentProcess(COMPONENT_PROCESS_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case IRMRuntimePackage.PROCESS_INVARIANT_INSTANCE__COMPONENT_PROCESS:
				return COMPONENT_PROCESS_EDEFAULT == null ? componentProcess != null : !COMPONENT_PROCESS_EDEFAULT.equals(componentProcess);
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (componentProcess: ");
		result.append(componentProcess);
		result.append(')');
		return result.toString();
	}

} //ProcessInvariantInstanceImpl
