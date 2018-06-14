package com.example.ljy.kotlin001

/**
 * Created by ljy on 2018/6/13.
 * 创建 DTOs(POJOs/POCOs)
 * 会为 Person 类提供以下功能:
 * — 所有属性的 getters(对于 var 定义的还有 setters)
 * — equals()
 * — hashCode()
 * — toString()
 * — copy()
 * — 所有属性的 component1() 、component2() ......等等(参⻅数据类)
 */
data class Person(val name: String, val email: String)