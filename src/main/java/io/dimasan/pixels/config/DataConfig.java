package io.dimasan.pixels.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
@PropertySource("app.properties")
public class DataConfig {

    private Environment env;

    @Autowired
    public void setEnv(Environment env) {
        this.env = env;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        Resource config = new ClassPathResource("hibernate.cfg.xml");
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setConfigLocation(config);
        sessionFactoryBean.setPackagesToScan(env.getProperty("pixels.entity.package"));
        return sessionFactoryBean;
    }
}
