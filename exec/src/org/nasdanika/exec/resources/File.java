package org.nasdanika.exec.resources;

import java.io.InputStream;
import java.net.URL;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CancellationException;

import org.nasdanika.common.BiSupplier;
import org.nasdanika.common.Consumer;
import org.nasdanika.common.ConsumerFactory;
import org.nasdanika.common.Context;
import org.nasdanika.common.FunctionFactory;
import org.nasdanika.common.ObjectLoader;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.common.SupplierFactory;
import org.nasdanika.common.Util;
import org.nasdanika.common.persistence.ConfigurationException;
import org.nasdanika.common.persistence.Marker;
import org.nasdanika.common.resources.BinaryEntity;
import org.nasdanika.common.resources.BinaryEntityContainer;
import org.nasdanika.common.resources.Merger;
import org.nasdanika.exec.Loader;

public class File extends Resource {
	
	private SupplierFactory<InputStream> contents;
	private Merger merger;
	private Marker marker;

	@SuppressWarnings("unchecked")
	public File(ObjectLoader loader, String type, Object config, URL base, ProgressMonitor progressMonitor, Marker marker) throws Exception {
		super(loader, type, config, base, progressMonitor, marker);
		this.marker = marker;
		Map<String,Object> configMap = (Map<String,Object>) config;
		if (configMap.containsKey(CONTENTS_KEY)) {
			contents = Loader.asSupplierFactory(loader.load(configMap.get(CONTENTS_KEY), base, progressMonitor));
		}
		if (configMap.containsKey(MERGER_KEY)) {
			merger = (Merger) loader.load(configMap.get(CONTENTS_KEY), base, progressMonitor);
		}
	}
	
	protected SupplierFactory<InputStream> getContents() {
		return contents;
	}
		
	private ConsumerFactory<BiSupplier<BinaryEntityContainer, InputStream>> fileFactory = context -> new Consumer<BiSupplier<BinaryEntityContainer, InputStream>>() {

		private String finalName = finalName(context.interpolateToString(File.this.name));
	
		@Override
		public double size() {
			return 1;
		}

		@Override
		public String name() {
			return "Create file " + finalName;
		}

		@Override
		public void execute(BiSupplier<BinaryEntityContainer, InputStream> input, ProgressMonitor progressMonitor) throws Exception {
			switch (reconcileAction) {
			case CANCEL:
				if (input.getFirst().find(finalName, progressMonitor) != null) {
					throw new CancellationException("Cancelling generation - resource '" + finalName + "' already exists in " + input.getFirst());
				}
			case OVERWRITE: {
				BinaryEntity file = Objects.requireNonNull(input.getFirst().get(finalName, progressMonitor), "Cannot create file " + finalName + " in " + input.getFirst());
				if (input.getSecond() != null) {
					file.setState(input.getSecond(), progressMonitor);
				}
				break;
			}
			case KEEP: {
				if (input.getFirst().find(finalName, progressMonitor) == null) {
					BinaryEntity file = Objects.requireNonNull(input.getFirst().get(finalName, progressMonitor), "Cannot create file " + finalName + " in " + input.getFirst());
					if (input.getSecond() != null) {
						file.setState(input.getSecond(), progressMonitor);
					}
				}
				break;
			}
			case APPEND: {
				BinaryEntity file = Objects.requireNonNull(input.getFirst().get(finalName, progressMonitor), "Cannot create file " + finalName + " in " + input.getFirst());
				if (input.getSecond() != null) {
					file.setState(file.exists(progressMonitor) ? Util.join(file.getState(progressMonitor), input.getSecond()) : input.getSecond(), progressMonitor);
				}
				break;
			}							
			case MERGE: {
				BinaryEntity file = Objects.requireNonNull(input.getFirst().get(finalName, progressMonitor), "Cannot create file " + finalName + " in " + input.getFirst());
				if (input.getSecond() != null) {
					if (file.exists(progressMonitor)) {
						file.setState(merge(context, file, file.getState(progressMonitor), input.getSecond(), progressMonitor), progressMonitor);
					} else {
						file.setState(input.getSecond(), progressMonitor);
					}
				}
				break;
			}							
			}
		}
		
	};

	@Override
	public Consumer<BinaryEntityContainer> create(Context iContext) throws Exception {
		FunctionFactory<BinaryEntityContainer, BiSupplier<BinaryEntityContainer, InputStream>> contentFunctionFactory = getContents().asFunctionFactory();
		return contentFunctionFactory.then(fileFactory).create(iContext);
	}
	
	protected InputStream merge(Context context, BinaryEntity entity, InputStream oldContent, InputStream newContent, ProgressMonitor progressMonitor) throws Exception {
		Merger merger = this.merger == null ? getNativeMerger(context) : this.merger;
		if (merger == null) {			
			throw new ConfigurationException("No merger for reconcile action MERGE", marker);
		}
		return merger.merge(context, entity, oldContent, newContent, progressMonitor);
	}
	
	protected Merger getNativeMerger(Context context) {
		return null;
	}	

}
