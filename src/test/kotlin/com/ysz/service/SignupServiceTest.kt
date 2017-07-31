package com.ysz.service

import com.ysz.Application
import com.ysz.domain.User
import com.ysz.log
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import java.util.*

@RunWith(SpringJUnit4ClassRunner::class)
@ContextConfiguration(classes = arrayOf(Application::class))
class SignupServiceTest {
    @Autowired
    val service: SignupService? = null

    @Test
    fun sign_up_test() {
        val id = UUID.randomUUID().toString()
        val user = User(id, "test-pwd", "111")
        val r = service?.signup(user)
        log(r)
    }
}