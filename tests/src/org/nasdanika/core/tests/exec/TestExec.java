package org.nasdanika.core.tests.exec;

import static org.junit.Assert.assertEquals;

import java.io.InputStream;
import java.util.Map;

import org.junit.Test;
import org.nasdanika.common.Adaptable;
import org.nasdanika.common.Context;
import org.nasdanika.common.ObjectLoader;
import org.nasdanika.common.PrintStreamProgressMonitor;
import org.nasdanika.common.ProgressMonitor;
import org.nasdanika.common.Supplier;
import org.nasdanika.common.SupplierFactory;
import org.nasdanika.common.Util;
import org.nasdanika.exec.Configurator;
import org.nasdanika.exec.Iterator;
import org.nasdanika.exec.Mapper;
import org.nasdanika.exec.Reference;
import org.nasdanika.exec.content.Interpolator;
import org.nasdanika.exec.content.Mustache;
import org.nasdanika.exec.content.Resource;
import org.yaml.snakeyaml.Yaml;


public class TestExec {
	
	/**
	 * Tests retrieval of different entries from a context wrapping a map.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testIterator() throws Exception {
		ObjectLoader loader = new org.nasdanika.exec.Loader();
		ProgressMonitor monitor = new PrintStreamProgressMonitor(System.out, 0, 4, false);
		Object iterator = loader.loadYaml(TestExec.class.getResource("iterator-spec.yml"), monitor);
		assertEquals(Iterator.class, iterator.getClass());
		
		Map<String, Object> yaml = new Yaml().load(TestExec.class.getResourceAsStream("iterator-config.yml"));
		Context context = Context.wrap(yaml::get);
		
		SupplierFactory<InputStream> sf = ((Adaptable) iterator).adaptTo(SupplierFactory.class);
		Supplier<InputStream> s = sf.create(context);
		assertEquals(" * uno *  * dos *  * tres * ", Util.toString(context, s.execute(monitor)));
	}
	
	/**
	 * Tests injection of configuration.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testConfigurator() throws Exception {
		ObjectLoader loader = new org.nasdanika.exec.Loader();
		ProgressMonitor monitor = new PrintStreamProgressMonitor(System.out, 0, 4, false);
		Object configurator = loader.loadYaml(TestExec.class.getResource("configurator-spec.yml"), monitor);
		assertEquals(Configurator.class, configurator.getClass());
		
		Map<String, Object> yaml = new Yaml().load(TestExec.class.getResourceAsStream("iterator-config.yml"));
		Context context = Context.wrap(yaml::get);
		
		SupplierFactory<InputStream> sf = ((Adaptable) configurator).adaptTo(SupplierFactory.class);
		Supplier<InputStream> s = sf.create(context);
		assertEquals(" * 123 -- v11 * ", Util.toString(context, s.execute(monitor)));
	}
		
	/**
	 * Tests injection of configuration.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testMapper() throws Exception {
		ObjectLoader loader = new org.nasdanika.exec.Loader();
		ProgressMonitor monitor = new PrintStreamProgressMonitor(System.out, 0, 4, false);
		Object mapper = loader.loadYaml(TestExec.class.getResource("mapper-spec.yml"), monitor);
		assertEquals(Mapper.class, mapper.getClass());
		
		Map<String, Object> yaml = new Yaml().load(TestExec.class.getResourceAsStream("iterator-config.yml"));
		Context context = Context.wrap(yaml::get);
		
		SupplierFactory<InputStream> sf = ((Adaptable) mapper).adaptTo(SupplierFactory.class);
		Supplier<InputStream> s = sf.create(context);
		assertEquals(" * 123_v11 -- ${a/a1/a11} * ", Util.toString(context, s.execute(monitor)));
	}
		
	/**
	 * Tests injection of configuration.
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testMapperResource() throws Exception {
		ObjectLoader loader = new org.nasdanika.exec.Loader();
		ProgressMonitor monitor = new PrintStreamProgressMonitor(System.out, 0, 4, false);
		Object mapper = loader.loadYaml(TestExec.class.getResource("mapper-resource-spec.yml"), monitor);
		assertEquals(Mapper.class, mapper.getClass());
		
		Map<String, Object> yaml = new Yaml().load(TestExec.class.getResourceAsStream("iterator-config.yml"));
		Context context = Context.wrap(yaml::get);
		
		SupplierFactory<InputStream> sf = ((Adaptable) mapper).adaptTo(SupplierFactory.class);
		Supplier<InputStream> s = sf.create(context);
		assertEquals(" * 123_v11 -- Hello! * ", Util.toString(context, s.execute(monitor)));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testMapperReference() throws Exception {
		ObjectLoader loader = new org.nasdanika.exec.Loader();
		ProgressMonitor monitor = new PrintStreamProgressMonitor(System.out, 0, 4, false);
		Object reference = loader.loadYaml(TestExec.class.getResource("mapper-reference-spec.yml"), monitor);
		assertEquals(Reference.class, reference.getClass());
		
		Map<String, Object> yaml = new Yaml().load(TestExec.class.getResourceAsStream("iterator-config.yml"));
		Context context = Context.wrap(yaml::get);
		
		SupplierFactory<InputStream> sf = ((Adaptable) reference).adaptTo(SupplierFactory.class);
		Supplier<InputStream> s = sf.create(context);
		assertEquals(" * 123_v11 -- ${a/a1/a11} * ", Util.toString(context, s.execute(monitor)));
	}
	
	@Test
	public void testResource() throws Exception {
		ObjectLoader loader = new org.nasdanika.exec.Loader();
		ProgressMonitor monitor = new PrintStreamProgressMonitor(System.out, 0, 4, false);
		Object resource = loader.loadYaml(TestExec.class.getResource("resource-spec.yml"), monitor);
		assertEquals(Resource.class, resource.getClass());
		
		Context context = Context.EMPTY_CONTEXT;		
		
		Supplier<InputStream> s = ((Resource) resource).create(context);
		assertEquals("Hello, ${name}!", Util.toString(context, s.execute(monitor)));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testInterpolator() throws Exception {
		ObjectLoader loader = new org.nasdanika.exec.Loader();
		ProgressMonitor monitor = new PrintStreamProgressMonitor(System.out, 0, 4, false);
		Object interpolator = loader.loadYaml(TestExec.class.getResource("interpolator-spec.yml"), monitor);
		assertEquals(Interpolator.class, interpolator.getClass());
		
		Context context = Context.singleton("name", "World");		
		
		Supplier<InputStream> s = ((SupplierFactory<InputStream>) interpolator).create(context);
		assertEquals("Hello, World!", Util.toString(context, s.execute(monitor)));
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testMustache() throws Exception {
		ObjectLoader loader = new org.nasdanika.exec.Loader();
		ProgressMonitor monitor = new PrintStreamProgressMonitor(System.out, 0, 4, false);
		Object mustache = loader.loadYaml(TestExec.class.getResource("mustache-spec.yml"), monitor);
		assertEquals(Mustache.class, mustache.getClass());
		
		Context context = Context.singleton("name", "World");		
		
		Supplier<InputStream> s = ((SupplierFactory<InputStream>) mustache).create(context);
		assertEquals("Hello, World!", Util.toString(context, s.execute(monitor)));
	}
	
}
