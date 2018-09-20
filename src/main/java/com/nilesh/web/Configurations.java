package com.nilesh.web;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.AprLifecycleListener;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.springframework.beans.factory.annotation.Value; 
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory; 
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory; 
import org.springframework.context.annotation.Bean; 
import org.springframework.context.annotation.Configuration; 

 @Configuration
 public class Configurations { 
	 @Value("${server.tomcat.apr.enabled:false}") 
     private boolean enabled; 
     @Value("${server.nonsslport}") 
     private int nonSSLPort; 
     @Value("${server.port}") 
     private int sslPort;
     @Value("${usessl}") 
     boolean sslEnabled;
     @Bean
	  public EmbeddedServletContainerFactory servletContainer() {
   	 
   	 if(sslEnabled){
   		 	TomcatEmbeddedServletContainerFactory tomcat = new TomcatEmbeddedServletContainerFactory() {
			        @Override
			        protected void postProcessContext(Context context) {
			          SecurityConstraint securityConstraint = new SecurityConstraint();
			          securityConstraint.setUserConstraint("CONFIDENTIAL");
			          SecurityCollection collection = new SecurityCollection();
			          collection.addPattern("/*");
			          securityConstraint.addCollection(collection);
			          context.addConstraint(securityConstraint);
			        }
			      };
		      if (enabled) { 
		             LifecycleListener arpLifecycle = new AprLifecycleListener(); 
		             tomcat.setProtocol("org.apache.coyote.http11.Http11AprProtocol"); 
		             tomcat.addContextLifecycleListeners(arpLifecycle); 
		         } 
		  	  tomcat.addAdditionalTomcatConnectors(initiateHttpConnector());
			  return tomcat;
   	 }else{
   		 TomcatEmbeddedServletContainerFactory container = new TomcatEmbeddedServletContainerFactory(); 
            if (enabled) { 
                LifecycleListener arpLifecycle = new AprLifecycleListener(); 
                container.setProtocol("org.apache.coyote.http11.Http11AprProtocol"); 
                container.addContextLifecycleListeners(arpLifecycle); 
            } 
            return container; 
   	 }
	}
	 
	private Connector initiateHttpConnector() {
	
	    Connector connector = new Connector("org.apache.coyote.http11.Http11NioProtocol");
		// Connector connector = new Connector("org.apache.coyote.http11.Http11AprProtocol");
	    connector.setScheme("http");
	    connector.setPort(nonSSLPort);
	    connector.setSecure(false);
	    connector.setRedirectPort(sslPort);
	    
	    return connector;
	}
    
   /* @Bean 
    public EmbeddedServletContainerFactory servletContainer() { 
        TomcatEmbeddedServletContainerFactory container = new TomcatEmbeddedServletContainerFactory(); 
        if (enabled) { 
            LifecycleListener arpLifecycle = new AprLifecycleListener(); 
            container.setProtocol("org.apache.coyote.http11.Http11AprProtocol"); 
            container.addContextLifecycleListeners(arpLifecycle); 
        } 


        return container; 
    } */
} 
