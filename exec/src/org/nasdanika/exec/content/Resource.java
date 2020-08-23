package org.nasdanika.exec.content;

import java.io.InputStream;
import java.net.URL;
import java.util.Objects;

import org.nasdanika.common.Context;
import org.nasdanika.common.ObjectLoader;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.common.Supplier;
import org.nasdanika.common.SupplierFactory;
import org.nasdanika.common.persistence.ConfigurationException;
import org.nasdanika.common.persistence.Marked;
import org.nasdanika.common.persistence.Marker;

/**
 * Loads content from URL resolved relative to the base url passed to the constructor.
 * The URL is not interpolated.
 * @author Pavel
 *
 */
public class Resource implements SupplierFactory<InputStream>, Marked {
	
	private URL url;
	private Marker marker;
	
	@Override
	public Marker getMarker() {
		return marker;
	}

	public Resource(ObjectLoader loader, Object config, URL base, ProgressMonitor progressMonitor, Marker marker) throws Exception {
		if (config instanceof String) {
			this.marker = marker;
			url = new URL(base, (String) config);
		} else {
			throw new ConfigurationException("Resource value must be a string, got " + config.getClass(), marker);
		}
	}

	@Override
	public Supplier<InputStream> create(Context context) throws Exception {
		return new Supplier<InputStream>() {

			@Override
			public double size() {
				return 1;
			}

			@Override
			public String name() {
				return "Resource: " + url;
			}

			@Override
			public InputStream execute(ProgressMonitor progressMonitor) throws Exception {
				return Objects.requireNonNull(url.openStream(), "Resource does not exist at "+url);
			}
			
		};
	}

}