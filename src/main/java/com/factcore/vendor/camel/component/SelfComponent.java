package com.factcore.vendor.camel.component;

import com.factcore.vendor.camel.component.self.Lifecycle;
import org.apache.camel.Endpoint;
import org.apache.camel.component.bean.BeanEndpoint;
import org.apache.camel.component.bean.BeanProcessor;
import org.apache.camel.component.bean.ClassComponent;
import org.apache.camel.util.IntrospectionSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

/**
 * Scorpio (c) 2014
 * Module: com.factcore.vendor.camel
 * User  : lee
 * Date  : 22/06/2014
 * Time  : 11:51 PM
 */
public class SelfComponent extends ClassComponent {
	protected final Logger log = LoggerFactory.getLogger(SelfComponent.class);
	protected Object bean;

	public SelfComponent(Object bean) {
		this.bean = bean;
	}

	public Object getBean() {
		return bean;
	}

	protected Endpoint createEndpoint(String uri, String remaining, Map<String, Object> parameters) throws Exception {
		Map<String, Object> params = IntrospectionSupport.extractProperties(parameters, "scorpio4.");
		return new BeanEndpoint(uri,this, new BeanProcessor(new Lifecycle(this, uri, remaining, params), getCamelContext() ));
	}

}