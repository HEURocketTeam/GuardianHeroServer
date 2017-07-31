package com.ysz.dao

import com.ysz.domain.User
import com.ysz.log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
open class UserDao {

    @Autowired
    open var jdbcTemplate: JdbcTemplate? = null

    val IF_ID_EXISTS = "select count(*) from t_user where id = ?"
    val SIGN_UP = "insert into t_user (id, pwd, name) values(?, ?, ?)"
    val LOG_IN = "select count(*) from t_user where id = ? and pwd = ?"

    open fun checkIfIdExists(id: String): Int {
        return jdbcTemplate!!.queryForObject(IF_ID_EXISTS, arrayOf(id), Int::class.java)
    }

    open fun signup(user: User): Int {
        log("haha")
        val result = jdbcTemplate!!.update(SIGN_UP, *arrayOf(user.id, user.pwd, user.name))
        log(result)
        return result
    }

    open fun login(user: User): Int {
        return jdbcTemplate!!.queryForObject(LOG_IN, arrayOf(user.id, user.pwd), Int::class.java)
    }


}