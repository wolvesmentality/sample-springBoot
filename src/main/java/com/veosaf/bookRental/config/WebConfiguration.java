package com.veosaf.bookRental.config;

import org.h2.server.web.WebServlet;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

	@Value("${spring.h2.console.path}")
	private String h2ConsoleUrl;

	@Bean
	ServletRegistrationBean servletRegistration() {
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(new WebServlet());

		// add h2 url console
		if (!StringUtils.isEmpty(h2ConsoleUrl)) {
			h2ConsoleUrl = h2ConsoleUrl.trim();
			h2ConsoleUrl = h2ConsoleUrl.endsWith("/") ? h2ConsoleUrl.concat("*") : h2ConsoleUrl.concat("/*");
		}
		registrationBean.addUrlMappings(h2ConsoleUrl);

		return registrationBean;
	}

}