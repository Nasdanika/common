package org.nasdanika.common.persistence;

import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;
import org.yaml.snakeyaml.nodes.MappingNode;
import org.yaml.snakeyaml.nodes.NodeTuple;
import org.yaml.snakeyaml.nodes.ScalarNode;
import org.yaml.snakeyaml.nodes.SequenceNode;
import org.yaml.snakeyaml.representer.Representer;
import org.yaml.snakeyaml.resolver.Resolver;

/**
 * Snake YAML {@link Constructor} which creates {@link MarkedArrayList} and {@link MarkedLinkedHashMap} which allows to obtain locations of of elements in the source file using {@link Marker}s.
 * @author Pavel Vlasov
 *
 */
public class MarkingYamlConstructor extends Constructor {
	
	@Override
	protected List<? extends Object> constructSequence(SequenceNode node) {
		MarkedArrayList<? extends Object> ret = (MarkedArrayList<? extends Object>) super.constructSequence(node);
		node.getValue().forEach(n -> ret.getMarkers().add(new MarkerImpl(n.getStartMark())));
		return ret;
	}
	
	@Override
	protected List<Object> newList(SequenceNode node) {
		return new MarkedArrayList<Object>();
	}
				
	@Override
	protected Map<Object, Object> constructMapping(MappingNode node) {
		MarkedLinkedHashMap<Object, Object> ret = (MarkedLinkedHashMap<Object, Object>) super.constructMapping(node);
		node.getValue()
			.stream()
			.map(NodeTuple::getKeyNode)
			.filter(n -> n instanceof ScalarNode)
			.forEach(keyNode -> ret.mark(((ScalarNode) keyNode).getValue(), new MarkerImpl(keyNode.getStartMark())));
		return ret;
	}
	
	@Override
	protected Map<Object, Object> newMap(MappingNode node) {
		return new MarkedLinkedHashMap<Object, Object>();
	}					
		
	/**
	 * @return Yaml which uses this {@link MarkingYamlConstructor} to create collections with markers.
	 */
	public static Yaml createMarkingYaml() {
		LoaderOptions loadingConfig = new LoaderOptions();
		loadingConfig.setAllowDuplicateKeys(false);
		return new Yaml(new MarkingYamlConstructor(), new Representer(), new DumperOptions(), loadingConfig, new Resolver());
	}

}
