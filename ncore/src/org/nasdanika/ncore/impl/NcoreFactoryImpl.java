/**
 */
package org.nasdanika.ncore.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.nasdanika.ncore.Array;
import org.nasdanika.ncore.Entry;
import org.nasdanika.ncore.Function;
import org.nasdanika.ncore.Html;
import org.nasdanika.ncore.HttpCall;
import org.nasdanika.ncore.HttpMethod;
import org.nasdanika.ncore.List;
import org.nasdanika.ncore.Map;
import org.nasdanika.ncore.NcoreFactory;
import org.nasdanika.ncore.NcorePackage;
import org.nasdanika.ncore.Null;
import org.nasdanika.ncore.Operation;
import org.nasdanika.ncore.Property;
import org.nasdanika.ncore.Reference;
import org.nasdanika.ncore.Resource;
import org.nasdanika.ncore.ScriptResource;
import org.nasdanika.ncore.ScriptText;
import org.nasdanika.ncore.Service;
import org.nasdanika.ncore.Supplier;
import org.nasdanika.ncore.Value;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class NcoreFactoryImpl extends EFactoryImpl implements NcoreFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static NcoreFactory init() {
		try {
			NcoreFactory theNcoreFactory = (NcoreFactory)EPackage.Registry.INSTANCE.getEFactory(NcorePackage.eNS_URI);
			if (theNcoreFactory != null) {
				return theNcoreFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new NcoreFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NcoreFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case NcorePackage.SERVICE: return createService();
			case NcorePackage.SUPPLIER: return createSupplier();
			case NcorePackage.RESOURCE: return createResource();
			case NcorePackage.REFERENCE: return createReference();
			case NcorePackage.VALUE: return createValue();
			case NcorePackage.NULL: return createNull();
			case NcorePackage.OPERATION: return createOperation();
			case NcorePackage.ARRAY: return createArray();
			case NcorePackage.MAP: return createMap();
			case NcorePackage.PROPERTY: return createProperty();
			case NcorePackage.FUNCTION: return createFunction();
			case NcorePackage.LIST: return createList();
			case NcorePackage.OBJECT: return createObject();
			case NcorePackage.HTTP_CALL: return createHttpCall();
			case NcorePackage.HTML: return createHtml();
			case NcorePackage.SCRIPT_TEXT: return createScriptText();
			case NcorePackage.SCRIPT_RESOURCE: return createScriptResource();
			case NcorePackage.ENTRY: return createEntry();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case NcorePackage.HTTP_METHOD:
				return createHttpMethodFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case NcorePackage.HTTP_METHOD:
				return convertHttpMethodToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Service createService() {
		ServiceImpl service = new ServiceImpl();
		return service;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Supplier createSupplier() {
		SupplierImpl supplier = new SupplierImpl();
		return supplier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Resource createResource() {
		ResourceImpl resource = new ResourceImpl();
		return resource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Reference createReference() {
		ReferenceImpl reference = new ReferenceImpl();
		return reference;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Value createValue() {
		ValueImpl value = new ValueImpl();
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Null createNull() {
		NullImpl null_ = new NullImpl();
		return null_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Operation createOperation() {
		OperationImpl operation = new OperationImpl();
		return operation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Array createArray() {
		ArrayImpl array = new ArrayImpl();
		return array;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Map createMap() {
		MapImpl map = new MapImpl();
		return map;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Property createProperty() {
		PropertyImpl property = new PropertyImpl();
		return property;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Function createFunction() {
		FunctionImpl function = new FunctionImpl();
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public List createList() {
		ListImpl list = new ListImpl();
		return list;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public org.nasdanika.ncore.Object createObject() {
		ObjectImpl object = new ObjectImpl();
		return object;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HttpCall createHttpCall() {
		HttpCallImpl httpCall = new HttpCallImpl();
		return httpCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Html createHtml() {
		HtmlImpl html = new HtmlImpl();
		return html;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ScriptText createScriptText() {
		ScriptTextImpl scriptText = new ScriptTextImpl();
		return scriptText;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ScriptResource createScriptResource() {
		ScriptResourceImpl scriptResource = new ScriptResourceImpl();
		return scriptResource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Entry createEntry() {
		EntryImpl entry = new EntryImpl();
		return entry;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public HttpMethod createHttpMethodFromString(EDataType eDataType, String initialValue) {
		HttpMethod result = HttpMethod.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertHttpMethodToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NcorePackage getNcorePackage() {
		return (NcorePackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static NcorePackage getPackage() {
		return NcorePackage.eINSTANCE;
	}

} //NcoreFactoryImpl
