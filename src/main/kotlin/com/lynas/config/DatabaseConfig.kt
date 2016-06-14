package com.lynas.config

import com.lynas.model.AppUser
import com.zaxxer.hikari.HikariDataSource
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.orm.hibernate5.HibernateTransactionManager
import org.springframework.orm.hibernate5.LocalSessionFactoryBean
import org.springframework.transaction.annotation.EnableTransactionManagement
import java.util.*

@Configuration
@EnableTransactionManagement
open class DatabaseConfig {

    @Bean
    open fun dataSource(): HikariDataSource {
        val dataSource = HikariDataSource()
        dataSource.dataSourceClassName = "com.mysql.jdbc.jdbc2.optional.MysqlDataSource"
        dataSource.dataSourceClassName = "com.mysql.jdbc.jdbc2.optional.MysqlDataSource"
        dataSource.addDataSourceProperty("databaseName", "kotlin_spring")
        dataSource.addDataSourceProperty("portNumber", 3306)
        dataSource.addDataSourceProperty("serverName", "127.0.0.1")
        dataSource.addDataSourceProperty("user", "root")
        dataSource.addDataSourceProperty("password", "")
        return dataSource
    }


    @Bean
    open fun transactionManager(): HibernateTransactionManager {
        val manager = HibernateTransactionManager()
        manager.sessionFactory = sessionFactory().`object`
        return manager
    }

    @Bean(name = arrayOf("sessionFactory"))
    open fun sessionFactory(): LocalSessionFactoryBean {
        val sessionBean = LocalSessionFactoryBean()
        sessionBean.setDataSource(dataSource())
        sessionBean.setAnnotatedClasses(
                AppUser::class.java)
        val properties = Properties()
        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect")
        //properties.put("hibernate.current_session_context_class","thread");
        properties.put("hibernate.hbm2ddl.auto", "update")
        properties.put("hibernate.show_sql", true)
        sessionBean.hibernateProperties = properties

        return sessionBean
    }

}