package com.org.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@ComponentScan(basePackages = { "com.org.dunkey", "com.org.mapper", "com.org.domain"})
//@ComponentScan(basePackages = {"org.dunkey.exception"})
//@ComponentScan(basePackages = {"org.dunkey.task"})
public class ServletConfig implements WebMvcConfigurer {
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
		bean.setViewClass(JstlView.class);
		bean.setPrefix("/WEB-INF/views/");
		bean.setSuffix(".jsp");
		registry.viewResolver(bean);
	}
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/");
	}
	
	
	  @Bean(name="multipartResolver") public CommonsMultipartResolver getResolver() throws IOException{ 
	  CommonsMultipartResolver resolver = new
	  CommonsMultipartResolver(); resolver.setMaxUploadSize(1024*1024*10);
	  resolver.setMaxUploadSizePerFile(1024*1024*2);
	  resolver.setMaxInMemorySize(1024*1024); // 디스크에 저장하지 않고 메모리에 유지하도록 허용하는 바이트단위의 최대 용량을 설정 
	  resolver.setUploadTempDir(new FileSystemResource("C:/Users/BIT/Desktop/multipartUpload"));
	  resolver.setDefaultEncoding("utf-8"); return resolver; 
	  }
	 
}
