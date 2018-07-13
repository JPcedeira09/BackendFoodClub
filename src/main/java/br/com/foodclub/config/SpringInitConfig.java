package br.com.foodclub.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class SpringInitConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		
		return null;
	}

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {SpringRoot.class}
        ;
    }

    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }
}
