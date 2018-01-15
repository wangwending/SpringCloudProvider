package com.wwd.spring.cloud.conf;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

/**
 * 
		* ClassName: MybatisForBoot <br/>
		* Function: Mybatis配置. <br/>
		* @author wangwending
		* @since JDK 1.7
 */
@Configuration
public class MybatisForBoot implements TransactionManagementConfigurer {

	@Resource(name = "dataSource")
	private DataSource dataSource;
	
	@Bean(name = "sqlSessionFactory")
	public SqlSessionFactory sqlSessionFactoryBean() {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(dataSource);
//		bean.setConfigLocation();
		bean.setTypeAliasesPackage("com.wwd.model");
		
		//添加XML目录
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        try {
            //设置xml扫描路径
            bean.setMapperLocations(resolver.getResources("classpath*:com/wwd/mapper/**/*Mapper.xml"));
            bean.setConfigLocation(resolver.getResource("classpath:META-INF/spring/mybatis-config.xml"));
            return bean.getObject();
        } catch (Exception e) {
            throw new RuntimeException("sqlSessionFactory init fail",e);
        }
	}
	
	public org.mybatis.spring.mapper.MapperScannerConfigurer mapperScannerConfigurer() {
		org.mybatis.spring.mapper.MapperScannerConfigurer configurer = new org.mybatis.spring.mapper.MapperScannerConfigurer();
		configurer.setBasePackage("com.wwd.mapper");
		
		return configurer;
	}
	
	/**
     * 用于实际查询的sql工具,传统dao开发形式可以使用这个,基于mapper代理则不需要注入
     * @param sqlSessionFactory
     * @return
     */
    @Bean(name = "sqlSessionTemplate")
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }
    /**
     * 事务管理,具体使用在service层加入@Transactional注解
     */
    @Bean(name = "transactionManager")
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }

}
