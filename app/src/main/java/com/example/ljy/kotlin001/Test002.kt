package com.example.ljy.kotlin001

/**
 * Created by ljy on 2017/11/30.
 *
 * 本类对kotlin中的常量，变量，字符串等一些基本用法的演示
 */
class Test002 {

    /**
     * 下面是演示用的变量
     */
    fun init() {

        //变量与常量：

        // 1.可变变量定义：var 关键字
        var x = 5        // 系统自动推断变量类型为Int
        x += 1           // 变量可修改

        // 2.不可变变量定义：val 关键字，只能赋值一次的变量(类似Java中final修饰的变量)
        val a: Int = 1
        val b = 1       // 系统自动推断变量类型为Int
        val c: Int      // 如果不在声明时初始化则必须提供变量类型
        c = 1

        //注释：与 Java 不同, Kotlin 中的块注释允许嵌套
        // 这是一个单行注释
        /* 这是一个
        多行的 /*abc*/
        块注释。 */

    }
}