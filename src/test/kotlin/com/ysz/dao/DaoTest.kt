package com.ysz.dao


import com.ysz.Application
import com.ysz.domain.User
import com.ysz.log
import org.junit.Assert.*
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import java.util.*

@RunWith(SpringJUnit4ClassRunner::class)
@ContextConfiguration(classes = arrayOf(Application::class))
class DaoTest {

    @Autowired
    val userDao: UserDao? = null

    @Test
    fun check_if_id_exitst_test() {
        assertNotNull(userDao)
        assertEquals(userDao?.checkIfIdExists("admin"), 1)
        assertEquals(userDao?.checkIfIdExists("foo"), 0)
        assertEquals(userDao?.checkIfIdExists("admin2"), 0)
    }

    @Test
    fun sign_up_test() {
        val id = UUID.randomUUID().toString()
        println("************************")
        println(id.length)
        println("************************")
        val user = User(id, "test-pwd", "test-name")
        userDao?.signup(user)
        log("finish")
    }

    @Test
    fun login_test() {
        assertEquals(1, userDao?.login(User("admin", "12345")))
        assertEquals(0, userDao?.login(User("admin2", "12345")))
        assertEquals(1, userDao?.login(User("test", "pwd")))
    }
}