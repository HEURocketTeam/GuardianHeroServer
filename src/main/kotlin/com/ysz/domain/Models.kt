package com.ysz.domain

import com.fasterxml.jackson.databind.ObjectMapper

data class User(
        var id: String? = null,
        var pwd: String? = null,
        var name: String? = null
)

data class Login(
        val id: String,
        var pwd: String,
        val token: String
)

open class Response<T>(
        val stat: String,
        val code: Int,
        val message: String? = null,
        val result: T? = null
) {
    override fun toString(): String {
        val mapper = ObjectMapper()
        return mapper.writeValueAsString(this)
    }
}

object Success : Response<Unit>(stat = "ok", code = 0)













