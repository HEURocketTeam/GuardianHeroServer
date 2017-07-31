package com.ysz.service

import com.ysz.dao.UserDao
import com.ysz.domain.Response
import com.ysz.domain.Success
import com.ysz.domain.User
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class SignupService {

    @Autowired
    val userDao: UserDao? = null

    fun signup(user: User): Response<Unit> {
        try {
            userDao!!.signup(user)
            return Success
        } catch (e: Exception) {
            return Response("fail", 2, "字段过长")
        }
    }
}