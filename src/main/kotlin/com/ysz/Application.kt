package com.ysz

import org.apache.commons.dbcp2.BasicDataSource
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.Bean

@SpringBootApplication
open class Application {

    @Bean(destroyMethod = "close")
    open fun dataSource(): BasicDataSource {
        val source = BasicDataSource()
        source.apply {
            driverClassName = "com.mysql.jdbc.Driver"
            url = "jdbc:mysql://localhost:3306/guardianheros"
            username = "root"
            password = "12345"
        }
        return source
    }
}