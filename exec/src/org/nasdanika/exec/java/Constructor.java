package org.nasdanika.exec.java;

import java.io.InputStream;
import java.net.URL;
import java.util.List;

import org.nasdanika.common.Context;
import org.nasdanika.common.ObjectLoader;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.common.SupplierFactory;
import org.nasdanika.common.persistence.Marker;

public class Constructor extends Operation {

	public Constructor(ObjectLoader loader, Object config, URL base, ProgressMonitor progressMonitor, Marker marker) throws Exception {
		super(loader, config, base, progressMonitor, marker);
	}

	public Constructor(
			Marker marker, 
			String name, 
			List<String> modifiers, 
			List<String> annotations,
			List<String> typeParameters, 
			SupplierFactory<InputStream> comment, 
			SupplierFactory<InputStream> body,
			List<String> imports, 
			List<String> parameters, 
			List<String> exceptions) {
		
		super(marker, name, modifiers, annotations, typeParameters, comment, body, imports, parameters, exceptions);
	}

	@Override
	protected String generate(Context context, String comment, String body, ProgressMonitor progressMonitor) throws Exception {
		StringBuilder ret = new StringBuilder();
		// Comment
		ret.append(comment);
		appendAnnotations(context, ret);
		appendModifiers(context, ret);
		appendTypeParameters(context, ret);
		
		// Name
		ret.append(context.interpolateToString(name));
		
		appendParameters(context, ret);
		appendExceptions(context, ret);
		ret
			.append(" {")
			.append(System.lineSeparator())
			.append(body)
			.append(System.lineSeparator())
			.append("}")
			.append(System.lineSeparator());
		
		return ret.toString();
	}

}
