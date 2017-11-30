package com.example.ljy.kotlin001

/**
 * Created by ljy on 2017/11/30.
 *
 * 本类是对kotlin的函数的基本使用
 */
class Test001 {

    /**
     * 调用下面的演示函数
     */
    fun init() {

        //一个普通的函数
        testFun(10, "abc")

        //kotlin中声明变量是通过var， 如 var i:Int=5
        var isZero = isZero(1)
        println("isZero:" + isZero)

        //没有返回值的函数
        noReturn()

        //可变长参数与普通参数混用
        printNums(1, 2, 3, 4, 5, str = "ljy")

        //lambda(匿名函数)
        val sumLambda: (Int, Int) -> Int = { x, y -> x + y }
        println("1+2=" + sumLambda(1, 2))
    }

    /**
     * 函数定义使用关键字 fun，参数格式为：参数 : 类型
     */
    fun testFun(n: Int, str: String): Boolean {
        println("n=" + n)
        println("str=" + str)
        return true
    }

    /**
     * 表达式作为函数体，返回类型自动推断：
     */
    fun isZero(i: Int) = i == 0

    /**
     * 无返回值的函数(类似Java中的void)
     * Unit类型，可以省略
     */
    fun noReturn(): Unit {
        println("no return")
    }

    /**
     *  可变长参数函数,变长参数可以用 vararg 关键字进行标识
     *  注意混用时的调用
     */
    fun printNums(vararg nums: Int, str: String) {
        for (n in nums) {
            println("n-->" + n)
        }
        println("str--->" + str)
    }


}