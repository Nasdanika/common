/**
 */
package org.nasdanika.ncore.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Object;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.InternalEList;
import org.nasdanika.common.Command;
import org.nasdanika.common.CompoundCommand;
import org.nasdanika.common.Context;
import org.nasdanika.common.Converter;
import org.nasdanika.common.DefaultConverter;
import org.nasdanika.common.NasdanikaException;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.ncore.Entry;
import org.nasdanika.ncore.HttpCall;
import org.nasdanika.ncore.HttpMethod;
import org.nasdanika.ncore.NcorePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Http Call</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.nasdanika.ncore.impl.HttpCallImpl#getUrl <em>Url</em>}</li>
 *   <li>{@link org.nasdanika.ncore.impl.HttpCallImpl#getMethod <em>Method</em>}</li>
 *   <li>{@link org.nasdanika.ncore.impl.HttpCallImpl#getHeaders <em>Headers</em>}</li>
 *   <li>{@link org.nasdanika.ncore.impl.HttpCallImpl#getConnectTimeout <em>Connect Timeout</em>}</li>
 *   <li>{@link org.nasdanika.ncore.impl.HttpCallImpl#getReadTimeout <em>Read Timeout</em>}</li>
 *   <li>{@link org.nasdanika.ncore.impl.HttpCallImpl#getSuccessCode <em>Success Code</em>}</li>
 * </ul>
 *
 * @generated
 */
public class HttpCallImpl extends MinimalEObjectImpl.Container implements HttpCall {
	/**
	 * The default value of the '{@link #getUrl() <em>Url</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUrl()
	 * @generated
	 * @ordered
	 */
	protected static final String URL_EDEFAULT = null;

	/**
	 * The default value of the '{@link #getMethod() <em>Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMethod()
	 * @generated
	 * @ordered
	 */
	protected static final HttpMethod METHOD_EDEFAULT = HttpMethod.GET;

	/**
	 * The default value of the '{@link #getConnectTimeout() <em>Connect Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConnectTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final int CONNECT_TIMEOUT_EDEFAULT = 60;

	/**
	 * The default value of the '{@link #getReadTimeout() <em>Read Timeout</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReadTimeout()
	 * @generated
	 * @ordered
	 */
	protected static final int READ_TIMEOUT_EDEFAULT = 60;

	/**
	 * The default value of the '{@link #getSuccessCode() <em>Success Code</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuccessCode()
	 * @generated
	 * @ordered
	 */
	protected static final int SUCCESS_CODE_EDEFAULT = 200;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HttpCallImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return NcorePackage.Literals.HTTP_CALL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected int eStaticFeatureCount() {
		return 0;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String getUrl() {
		return (String)eDynamicGet(NcorePackage.HTTP_CALL__URL, NcorePackage.Literals.HTTP_CALL__URL, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setUrl(String newUrl) {
		eDynamicSet(NcorePackage.HTTP_CALL__URL, NcorePackage.Literals.HTTP_CALL__URL, newUrl);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HttpMethod getMethod() {
		return (HttpMethod)eDynamicGet(NcorePackage.HTTP_CALL__METHOD, NcorePackage.Literals.HTTP_CALL__METHOD, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setMethod(HttpMethod newMethod) {
		eDynamicSet(NcorePackage.HTTP_CALL__METHOD, NcorePackage.Literals.HTTP_CALL__METHOD, newMethod);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public EList<Entry<Object>> getHeaders() {
		return (EList<Entry<Object>>)eDynamicGet(NcorePackage.HTTP_CALL__HEADERS, NcorePackage.Literals.HTTP_CALL__HEADERS, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getConnectTimeout() {
		return (Integer)eDynamicGet(NcorePackage.HTTP_CALL__CONNECT_TIMEOUT, NcorePackage.Literals.HTTP_CALL__CONNECT_TIMEOUT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setConnectTimeout(int newConnectTimeout) {
		eDynamicSet(NcorePackage.HTTP_CALL__CONNECT_TIMEOUT, NcorePackage.Literals.HTTP_CALL__CONNECT_TIMEOUT, newConnectTimeout);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getReadTimeout() {
		return (Integer)eDynamicGet(NcorePackage.HTTP_CALL__READ_TIMEOUT, NcorePackage.Literals.HTTP_CALL__READ_TIMEOUT, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReadTimeout(int newReadTimeout) {
		eDynamicSet(NcorePackage.HTTP_CALL__READ_TIMEOUT, NcorePackage.Literals.HTTP_CALL__READ_TIMEOUT, newReadTimeout);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int getSuccessCode() {
		return (Integer)eDynamicGet(NcorePackage.HTTP_CALL__SUCCESS_CODE, NcorePackage.Literals.HTTP_CALL__SUCCESS_CODE, true, true);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setSuccessCode(int newSuccessCode) {
		eDynamicSet(NcorePackage.HTTP_CALL__SUCCESS_CODE, NcorePackage.Literals.HTTP_CALL__SUCCESS_CODE, newSuccessCode);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case NcorePackage.HTTP_CALL__HEADERS:
				return ((InternalEList<?>)getHeaders()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case NcorePackage.HTTP_CALL__URL:
				return getUrl();
			case NcorePackage.HTTP_CALL__METHOD:
				return getMethod();
			case NcorePackage.HTTP_CALL__HEADERS:
				return getHeaders();
			case NcorePackage.HTTP_CALL__CONNECT_TIMEOUT:
				return getConnectTimeout();
			case NcorePackage.HTTP_CALL__READ_TIMEOUT:
				return getReadTimeout();
			case NcorePackage.HTTP_CALL__SUCCESS_CODE:
				return getSuccessCode();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case NcorePackage.HTTP_CALL__URL:
				setUrl((String)newValue);
				return;
			case NcorePackage.HTTP_CALL__METHOD:
				setMethod((HttpMethod)newValue);
				return;
			case NcorePackage.HTTP_CALL__HEADERS:
				getHeaders().clear();
				getHeaders().addAll((Collection<? extends Entry<Object>>)newValue);
				return;
			case NcorePackage.HTTP_CALL__CONNECT_TIMEOUT:
				setConnectTimeout((Integer)newValue);
				return;
			case NcorePackage.HTTP_CALL__READ_TIMEOUT:
				setReadTimeout((Integer)newValue);
				return;
			case NcorePackage.HTTP_CALL__SUCCESS_CODE:
				setSuccessCode((Integer)newValue);
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
			case NcorePackage.HTTP_CALL__URL:
				setUrl(URL_EDEFAULT);
				return;
			case NcorePackage.HTTP_CALL__METHOD:
				setMethod(METHOD_EDEFAULT);
				return;
			case NcorePackage.HTTP_CALL__HEADERS:
				getHeaders().clear();
				return;
			case NcorePackage.HTTP_CALL__CONNECT_TIMEOUT:
				setConnectTimeout(CONNECT_TIMEOUT_EDEFAULT);
				return;
			case NcorePackage.HTTP_CALL__READ_TIMEOUT:
				setReadTimeout(READ_TIMEOUT_EDEFAULT);
				return;
			case NcorePackage.HTTP_CALL__SUCCESS_CODE:
				setSuccessCode(SUCCESS_CODE_EDEFAULT);
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
			case NcorePackage.HTTP_CALL__URL:
				return URL_EDEFAULT == null ? getUrl() != null : !URL_EDEFAULT.equals(getUrl());
			case NcorePackage.HTTP_CALL__METHOD:
				return getMethod() != METHOD_EDEFAULT;
			case NcorePackage.HTTP_CALL__HEADERS:
				return !getHeaders().isEmpty();
			case NcorePackage.HTTP_CALL__CONNECT_TIMEOUT:
				return getConnectTimeout() != CONNECT_TIMEOUT_EDEFAULT;
			case NcorePackage.HTTP_CALL__READ_TIMEOUT:
				return getReadTimeout() != READ_TIMEOUT_EDEFAULT;
			case NcorePackage.HTTP_CALL__SUCCESS_CODE:
				return getSuccessCode() != SUCCESS_CODE_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}
	
	/**
	 * Override to provide request body.
	 * @return
	 */
	protected Command<InputStream> createBodyCommand(Context context) throws Exception {
		return null;
	}
	
	protected Command<Map<String,Object>> createHeadersCommand(Context context) throws Exception {
		EList<Entry<Object>> headers = getHeaders();
		if (headers.isEmpty()) {
			return null;
		}
		
		CompoundCommand<Map<String, Object>, Map.Entry<String, Object>> headersCommand = new CompoundCommand<Map<String, Object>, Map.Entry<String, Object>>(context.get(Executor.class), false) {
			
			@Override
			protected Map<String, Object> combine(List<Map.Entry<String, Object>> results, ProgressMonitor progressMonitor) throws Exception {
				Map<String, Object> ret = new LinkedHashMap<>();
				for (Map.Entry<String, Object> e: results) {
					ret.put(e.getKey(), e.getValue());
				}
				return ret;
			}

			
		};
		for (Entry<Object> e: headers) {
			Command<Object> child = e.create(context);
			headersCommand.add(new Command<Map.Entry<String,Object>>() {
				
				@Override
				public Map.Entry<String, Object> execute(ProgressMonitor progressMonitor) throws Exception {
					Object val = child.execute(progressMonitor);
					return new Map.Entry<String, Object>() {

						@Override
						public String getKey() {
							return e.getName();
						}

						@Override
						public Object getValue() {
							return val;
						}

						@Override
						public Object setValue(Object arg0) {
							// TODO Auto-generated method stub
							return null;
						}
					};
				}
				
			}, "Entry "+e.getName(), 1);
		}

		return headersCommand;
	}

	@Override
	public Command<Object> create(Context context) throws Exception {
				
		return new Command<Object>() {

			@Override
			public Object execute(ProgressMonitor progressMonitor) throws Exception {
				long size = 1;
				Command<Map<String, Object>> headersCommand = createHeadersCommand(context);
				if (headersCommand != null) {
					++size;
				}
				Command<InputStream> bodyCommand = createBodyCommand(context);
				if (bodyCommand != null) {
					++size;
				}
				progressMonitor.setWorkRemaining(size);
				
				URL url = new URL(context.interpolate(getUrl()));
				URLConnection connection = url.openConnection();
				if (!(connection instanceof HttpURLConnection)) {
					throw new IllegalArgumentException("Not an HTTP(s) url: "+url);
				}
				
				HttpURLConnection httpConnection = (HttpURLConnection) connection;
				httpConnection.setRequestMethod(getMethod().getLiteral());
				httpConnection.setDoOutput(bodyCommand != null);
				if (headersCommand != null) {
					Converter converter = context.get(Converter.class);
					if (converter == null) {
						converter = DefaultConverter.INSTANCE;
					}
					for (Map.Entry<String, Object> header: headersCommand.execute(progressMonitor.split("Headers", 1)).entrySet()) {						
						httpConnection.setRequestProperty(header.getKey(), converter.convert(header.getValue(), String.class));
					}
				}
				httpConnection.setConnectTimeout(getConnectTimeout() * 1000); 
				httpConnection.setReadTimeout(getReadTimeout() * 1000); 
				
				if (bodyCommand != null) {
					try (OutputStream bout = new BufferedOutputStream(connection.getOutputStream()); InputStream bin = new BufferedInputStream(bodyCommand.execute(progressMonitor.split("Request body", 1)))) {
						int b;
						while ((b = bin.read()) != -1) {
							bout.write(b);
						}
					}
				}
				
				int responseCode = httpConnection.getResponseCode();
				if (responseCode == getSuccessCode()) { 
					return httpConnection.getInputStream(); // TODO - convert to String, Map, ... 
				}
				
				throw new NasdanikaException("HTTP Call to "+url+" has failed with response: "+responseCode+" "+httpConnection.getResponseMessage()); // TODO - body to message if message is empty, e.g. JSON details. Also TODO - to common.
			}
			
		};
	}

} //HttpCallImpl
