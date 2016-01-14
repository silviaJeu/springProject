package com.journaldev.spring.mongodb.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.journaldev.spring.mongodb.dao.PersonDAO;
import com.journaldev.spring.mongodb.dao.PersonDAOImpl;
import com.mongodb.MongoClient;

/**
 * @author silvia.ghisla
 *
 */
@Configuration
@ComponentScan("com.journaldev.spring.mongodb")
@EnableTransactionManagement
public class ApplicationContextConfig {
	
//	@Bean(name="resourceViewResolver")
//	public ResourceBundleViewResolver getResourceViewResolver() {
//		ResourceBundleViewResolver resourceViewResolver = new ResourceBundleViewResolver();
//		resourceViewResolver.setOrder(1);
//		resourceViewResolver.setBasename("views");
//		return resourceViewResolver;
//	}

    @Bean(name = "viewResolver")
    public InternalResourceViewResolver getViewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }
	

	@Autowired
	@Bean(name = "personDAO")
	public PersonDAO getUserDao(MongoTemplate mongoOps) {
	    return new PersonDAOImpl(mongoOps);
	}
	
	@Autowired
	@Bean( name = "mongoDbFactory")
	public MongoDbFactory getMongoDbFactory() throws Exception {
        return new SimpleMongoDbFactory(new MongoClient("localhost",27017), "journaldev");
    }
 
	@Autowired
	@Bean( name = "mongoOps")
    public MongoTemplate getMongoTemplate() throws Exception {
        MongoTemplate mongoTemplate = new MongoTemplate(getMongoDbFactory());
        return mongoTemplate;
    }
	
}
