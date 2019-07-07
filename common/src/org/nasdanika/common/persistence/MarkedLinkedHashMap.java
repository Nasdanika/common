package org.nasdanika.common.persistence;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Linked hash map which provides source location information for keys.
 * @author Pavel Vlasov
 *
 * @param <K>
 * @param <V>
 */
@SuppressWarnings("serial")
public class MarkedLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
	
	private Map<K, Marker> markers = new HashMap<>();
	
	public void mark(K key, Marker marker) {
		markers.put(key, marker);
	}

	public Marker getMarker(K key) {
		return markers.get(key);
	}
	
}