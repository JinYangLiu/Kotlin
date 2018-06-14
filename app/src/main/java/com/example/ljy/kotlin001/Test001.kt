package com.example.ljy.kotlin001

import java.io.File


/**
 * Created by ljy on 2017/11/30.
 *
 * 本类介绍kotlin的基本语法
 */


class Test001 {


    fun init() {

        /**
         * 0. 注释
         */

        //注释：与 Java 不同, Kotlin 中的块注释允许嵌套
        // 这是一个单行注释
        /* 这是一个
        多行的 /*abc*/
        块注释。 */

        /**
         * 1. 变量与常量：
         */

        // - 0.声明：var关键字 变量名 ：变量类型 ，类型也可以省略
        // - 1.可变变量定义：var 关键字
        var x = 5        // 系统自动推断变量类型为Int
        x += 1           // 变量可修改

        // - 2.不可变变量定义：val 关键字，只能赋值一次的变量(类似Java中final修饰的变量)
        val a: Int = 0
        val b = 1       // 系统自动推断变量类型为Int
        val c: Int      // 如果不在声明时初始化则必须提供变量类型
        c = 2

        /**
         * 2. 函数
         * Kotlin函数支持函数嵌套，即在函数体内还可以嵌套局部函数
         */

        /*
         * - 1. 定义一个普通的函数
         * 1。函数定义使用关键字 fun
         * 2。参数格式为：参数 : 类型 ,参数 : 类型，...
         * 3。返回值类型在（）后面加 : 类型
         */
        fun testFun(n: Int, str: String): Boolean {
            println("n=$n")
            println("str=$str")
            return true
        }

        val bool = testFun(10, "abc")
        println("bool=$bool")

        /*
         * - 2.表达式作为函数体，返回类型自动推断：
         */
        fun isZero(i: Int) = i == 0

        val isZero = isZero(1)
        println("isZero:$isZero")

        /*
         * - 3.无返回值的函数(类似Java中的void)
         * Unit类型，可以省略
         */
        fun noReturn(): Unit {
            println("no return")
        }
        noReturn()

        /*
         *  - 4.可变长参数函数：
         *  变长参数可以用 vararg 关键字进行标识
         *  注意混用时的调用：
         *  可变长参数与普通参数混用, 注意普通参数要用key=value，以和可变长参数区分
         */
        fun printNums(vararg nums: Int, str: String?) {
            //上面str: String?中的？表示可为空
            for (n in nums) {
                println("n-->$n")
            }
            if (str != null)//null检测
                println("str--->$str")
        }
        printNums(1, 2, 3, 4, 5, str = "ljy")

        /*
         * - 5. lambda(匿名函数)
         * 在lambda表达式中, 大括号左右要加空格，分隔参数与代码体的箭头左右也要加空格
         * lambda表达应尽可能不要写在圆括号中
         * 在非嵌套的短lambda表达式中，最好使用约定俗成的默认参数 it 来替代显式声明参数名
         * 在嵌套的有参数的lambda表达式中，参数应该总是显式声明
         */
        val sumLambda: (Int, Int) -> Int = { x, y -> x + y }
        println("1+2=" + sumLambda(1, 2))
        /*
         * - 6. 函数的默认参数(给参数添加默认值)
         */
        fun foo(a: Int = 0, b: String = "") {
            println("a=$a,b=$b")
        }
        foo()
        foo(10)
        foo(a = 101)
        foo(b = "abc")
        foo(101, "abc")
        /*
         * - 7.单位表达式函数
         *
         */
        fun theAnswer() = 24

        //等价于:
        fun theAnswer2(): Int {
            return 24
        }

        /**
         * 3. 字符串模版
         */

        //- 1.模版中的简单名称
        var num = 101
        val s1 = "num is $num"
        println(s1)
        //- 2.模版中的任意表达式
        num = 102
        val s2 = "${s1.replace("is", "was")},but now is $num"
        println(s2)

        /**
         * 4. 条件表达式和循环表达式
         */

        //- 1.if判断
        if (num > 0) {
            println(num)
        } else {
            println("num < 0")
        }
        //
        val data = mapOf("name" to "ljy", "email" to null)
        // if null
        data["name"] ?: println("name is null")
        data["email"] ?: println("email is null")
        // if not null 缩写
        println("name len = ${data["name"]?.length}")
        println("email len = ${data["email"]?.length}")
        // if not null and else 缩写
        println(data["name"]?.length ?: "empty")
        println(data["email"]?.length ?: "empty")


        /*
         * - 2.使用if作为表达式
         * 并结合单位表达式函数使用
         */
        fun maxof(a: Int, b: Int) = if (a > b) a else b

        num = maxof(a, b)

        /*
         * - 3.when表达式做函数返回值
         * 并结合单位表达式函数使用
         */
        fun describe(obj: Any) =
                when (obj) {
                    1 -> "one"
                    "Hello" -> "greeting"
                    is Long -> "Long"
                    !is String -> "not a string"
                    else -> "Unknown"
                }

        println("-->${describe(1)}")
        println("-->${describe("Hello")}")
        println("-->${describe(1L)}")
        println("-->${describe(321)}")
        println("-->${describe("abc")}")

        //- 4.for循环
        val items = listOf("a", "ca", "ac", "bb", "ab", "ba", "c")
        for (item in items)
            println("for-->$item")
        for (index in items.indices)
            println("for-->item at $index is ${items[index]}")
        //- 5.while循环
        var index = 0
        while (index < items.size) {
            println("while-->item at $index is ${items[index]}")
            index++
        }

        /**
         * 5. 可空值和null检测,详见printNums中
         */
        printNums(num, str = null)

        /**
         * 6. 使用类型检测及自动类型转换
         */
        fun getStringLength(obj: Any): Int? {
            if (obj is String) {
                // `obj` 在该条件分支内自动转换成 `String`
                return obj.length
            }
            return null
        }

        val len = getStringLength(s1)
        println("$s1<--len-->$len")

        /**
         * 7. 使用区间（range）
         */
        //- 1.区间外
        num = 100
        if (num !in 0..10) {
            println("num 不在0～10范围内")
        }
        //- 2.区间内
        val max = 100
        if (num in 1..max + 1) {//闭区间:包含101
            println("num 在1～101范围内")
        }
        if (num in 1 until max) {//半开区间:不包含 100
            println("num 在1～99范围内")
        } else {
            println("num 不 在1～99范围内")
        }

        //- 3.区间迭代
        for (it in 1..10) {
            println("x = $it")
        }

        //- 4.数列迭代
        for (y in 1..10 step 2)
            println("y = $y")
        for (z in 9 downTo 0 step 3)
            println("z = $z")

        /**
         * 8.使用集合
         */
        for (item in items) {
            println("for-->$item")
        }
        when {
            "a" in items -> println("items 包含 a")
            "c" in items -> println("items 包含 c")
            "d" in items -> println("items 包含 d")
        }
        //使用 lambda 表达式来过滤(filter)和映射(map)集合
        items.filter { it.contains("a") }//过滤
                .sortedBy { it }//排序
                .map { "--" + it.toUpperCase() }//转换
                .forEach { println(it) }//遍历
        //过滤
        val nums = listOf(0, 1, 2, 3, 4)
        //1
        nums.filter { it -> it > 2 }
                .forEach { println(it) }
        //2
        nums.filter { it > 2 }
                .forEach { println(it) }

        //遍历 map/pair型list
        val map = mapOf("name" to "ljy", "age" to 18, "isMan" to true)
        for ((k, v) in map) {
            println("$k-->$v")
        }
        //val创建的list/map表示只读
//        map["name"]="abc"//对元素进行修改会在编辑时直接提示错误

        /**
         * 9.延迟属性
         *
         * 相当于：if(p==null) { p=1+2+3+4+5 }
         * 且是第一次用到时才加载
         */
        val p: Int by lazy {
            1 + 2 + 3 + 4 + 5
        }
        println("p --> $p")


        /**
         * 10.扩展函数
         * 下例为给String类添加一个扩展函数add
         */
        fun String.add(s: String): String {
            return "$this$s"
        }

        println("abc".add("def"))

        /**
         * 11.创建单例
         */
        println(StrConfig.name)
        println(StrConfig.s)

        /**
         * 12 try/cache表达式
         */
        fun test(): Int {
            var result = try {
                12 / 0
            } catch (e: Exception) {
                -1
            }
            return result
        }

        println("result=${test()}")

        /**
         * 13 对一个对象实例调用多个方法(with)
         *
         */
        //1.1 创建一个类:见Person.kt
        //1.2 添加一个扩展函数
        fun Person.sayHi() {
            println("$name say: Hello World")
        }
        //2.创建类对象
        val person = Person("ljy", "123456@qq.com")
        //3.with调用一个对象对多个方法
        with(person) {
            val s = toString()
            println(s)
            hashCode()
            println(name)
            println(email)
            sayHi()
        }

        /**
         * 14 对于需要泛型信息的泛型函数的适宜形式
         */
        //1. java
        //  public final class Gson {
        // ......
        // public <T> T fromJson(JsonElement json, Class<T> classOfT) throws JsonSyntaxException {
        // ......
        //2. kotlin
//        inline fun <reified T: Any> Gson.fromJson(json): T = this.fromJson(json, T::class.java)

        /**
         * 15 使用可空布尔
         */
        val bol: Boolean? = null
        if (bol == true) {
            println("bol = true")
        } else {
            println("`bol` 是 false 或者 null ")
        }

        /**
         * 16 冒号
         *  类型和超类型之间的冒号前要有一个空格，而实例和类型之间的冒号前不要有空格
         *  详见下面对Bar和Bar2
         */


    }

    interface Bar

    interface Bar2<out T : Any> : Bar {
        fun foo(a: Int): T
    }

    /**
     * 创建单例
     */
    object StrConfig {
        //经过const修饰的常量，才是java中理解的常量
        const val name = "Mr.L"
        var s = "str"
    }
}


