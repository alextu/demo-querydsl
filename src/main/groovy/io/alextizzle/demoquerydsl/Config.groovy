package io.alextizzle.demoquerydsl

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.jdbc.query.QueryDslJdbcTemplate
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.datasource.DataSourceTransactionManager
import org.springframework.jdbc.datasource.DriverManagerDataSource
import org.springframework.transaction.PlatformTransactionManager

import javax.sql.DataSource

/**
 * Created by alexis on 06/03/15.
 */
@Configuration
class Config {

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.h2.Driver")
        dataSource.setUrl("jdbc:h2:~/test")
        dataSource.setUsername("sa")
        dataSource.setPassword("")
        return dataSource
    }

    @Bean
    public PlatformTransactionManager transactionManager(DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource)
    }

    @Bean
    public QueryDslJdbcTemplate queryDslJdbcTemplate(DataSource dataSource) {
        return new QueryDslJdbcTemplate(new JdbcTemplate(dataSource))
    }


}
