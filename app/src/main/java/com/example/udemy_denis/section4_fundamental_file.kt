package com.example.udemy_denis

//🍀 🍉 섹터 나눔 마크 ,  js-6
//🍄Algorithm)  알고리즘 (코딩 순서, 소프트코딩)
//
//🐞 bug
//❓ question, bug
//......🌊 다음에 할거
//
//⚡ : connect..JS, CSS, HTML
//
//🎃 : etc
//🎃 : (hard-coding) (soft-coding)
//🎃 : way-1 way-2 way-3


//🍀c43 ~ 44 : Functions
fun main(){
    myFunction()
    println(addUp(5,3))
    println(avg(3.2,5.3))
}

// The syntax of a function - fun stands for function
fun myFunction(){
    // The body of a function
    println("myFunction was called")
}

// This function has two parameters and returns a value of type Int
fun addUp(a: Int, b: Int): Int{
    // the return keyword indicates that this function will return the following value
    // once this function is called and executed
    return (a+b)
}
// Article on Kotlin words https://blog.kotlin-academy.com/kotlin-programmer-dictionary-function-vs-method-vs-procedure-c0216642ee87
// CHALLENGE: create a function that calculates the average and call it
fun avg(a: Double, b: Double): Double {
    return  (a + b)/2
}


//🍀c45~46 : null

fun main_45(){
    // NULLABLES/OPTIONALS in Kotlin
// Kotlin supports nullability as part of its type System.
// That means You have the ability to declare whether
// a variable can hold a null value or not.
// By supporting nullability in the type system,
// the compiler can detect
// possible NullPointerException errors at compile time
// and reduce the possibility of having them thrown at runtime.

//🍀c45-10 일반적으로 var 변수는 un-nullable

    var name: String = "Denis"
    name = "adam"  // 다른 string... 바꿀 수 있음
// name = null //  null로 새로 지정....Error 생김

//🍉 ? 붙이면 nulliable변수가 됨

    var nullableName: String? = "Denis"
    nullableName = null // null로 새로지정....Works


//🍀c45-20 Here name cannot/must not be null
    val len = name.length
    val upper = name.toLowerCase()

// 🍉 but the same methods won't work on nullable types
//  val len2 = nullableName.length // ... Error  - non-nullable에만 reciver붙을 수 있음
//  val upper2 = nullableName.toLowerCase()  // ... Error  - non-nullable에만 reciver붙을 수 있음


// So how can we solve this? We could do a null check before hand

    val nullableName2: String? = "Denis"

    if(nullableName2 != null) {
        println("Hello, ${nullableName2.toLowerCase()}.")
        println("Your name is ${nullableName2.length} characters long.")
    } else {
        println("Hello, Guest")
    }

// This works but seems to be quite some work...
// So how about we shorten the syntax...
// Kotlin provides a Safe call operator, ?.
// It allows you to combine a null-check and
// a method call in a single expression.

    nullableName2?.toLowerCase()

// This is the same as:
    if(nullableName2 != null)
        nullableName2.toLowerCase()
    else
        null

// You can use methods on a nullable variable like this
    val nullableName3: String? = null

    println(nullableName3?.toLowerCase()) // prints null
    println(nullableName3?.length) // prints null

// You can perform a chain safe calls:
    //val wifesAge: String? = user?.wife?.age


// Let'S say we don’t want to print anything if
// the variable is null?

// In order to perform an operation only if the
// variable is not null, we can use the safe call
// operator with let -

    val nullableName4: String? = null

    nullableName4?.let { println(it.toLowerCase()) }
    nullableName4?.let { println(it.length) }
// Prints nothing because there nullableName is null
// and we used let to prevent anything from being performed


//    c46   elvis operator ?:
// What if we would like to enter a default value?

//    값이  null 일때, default로 넣은 value를 사용함

//    val nullableName4 = null

    val name2 = nullableName4 ?: "Guest"

//    print($name2)  // Guest

    //val wifesAge2: String? = user?.wife?.age ?: 0


// Not null assertion : !! Operator
// The !! operator converts a nullable type to a
// non-null type, and throws a NullPointerException
// if the nullable type holds a null value.
// This is risky, and you should only use it if
// you are 100% certain, that there will be a value in
// the variable.
    val nullableName5: String? = null
    nullableName5!!.toLowerCase() // Results in NullPointerException
}


//🍀49 ~58
//🍀52. Classes And Initializers

fun main52(){
    var denis = Person("Denmis","Panjuta")

}
class Person constructor(_firstName: String, _lastName: String) { // or class Person constructor    (_firstName: String, _lastName: String)
    // Member Variables (Properties) of the class
    var firstName: String
    var lastName: String

    // Initializer Block
    init {
        this.firstName = _firstName
        this.lastName = _lastName

        println("Initialized a new Person object with firstName = $firstName and lastName = $lastName")
    }
}

// create an object like so:
// val denis = Person("Denis", "Panjuta")


//
//// Alternatively:
//class Person51 (_firstName: String, _lastName: String) {
//    // Member Variables (Properties) of the class
//    var firstName: String = _firstName
//    var lastName: String = _lastName
//
//    // Initializer Block
//    init {
//        println("Initialized a new Person object with firstName = $firstName and lastName = $lastName")
//    }
//}
//
//// Alternatively:
//class Person53(var firstName: String, var lastName: String) {
//    // Initializer Block
//    init {
//        println("Initialized a new Person object with firstName = $firstName and lastName = $lastName")
//    }
//}
//
//// Or even:
//// whereby John and Doe will be default values
//class Person54(var firstName: String = "John", var lastName: String= "Doe") {
//    // Initializer Block
//    init {
//        println("Initialized a new Person object with firstName = $firstName and lastName = $lastName")
//    }
//}
//
//// Create an object:
///*
//    val john = Person()
//    val johnPeterson = Person(lastname: "Peterson")
//
//*/
//
//class Person55(var firstName: String, var lastName: String) {
//    var age: Int? = null
//    var hobby: String = "Watch Netflix"
//    var myFirstName = firstName
//
//    // Secondary Constructor
//    constructor(firstName: String, lastName: String, age: Int): this(firstName, lastName)  {
//        this.age = if(age > 0) age else throw IllegalArgumentException("Age must be greater than zero")
//    }
//
//    fun stateHobby(){
////        println("$firstname \'s Hobby is: $hobby'" )
//    }
//}
//
//// You can use primary or secondary Constructor to create an object
//
//// Calls the primary constructor (Age will be null in this case)
//val person1 = Person("Denis", "Panjuta")
//
//// Calls the secondary constructor
//val person2 = Person("Elon", "Musk", 48)
//
//
//
//// Having multiple overloads:
//
//class Person56(var firstName: String, var lastName: String) {
//    var age: Int? = null
//    var eyeColor: String? = null
//
//    // Secondary Constructor
//    constructor(firstName: String, lastName: String, age: Int): this(firstName, lastName)  {
//        this.age = if(age > 0) age else throw IllegalArgumentException("Age must be greater than zero")
//    }
//
//    // Secondary Constructor
//    constructor(firstName: String, lastName: String, age: Int, eyeColor: String):
//            this(firstName, lastName, age)  {
//        this.eyeColor = eyeColor
//    }
//}
//
//
//// SETTERS AND GETTERS
//
//// User class with a Primary constructor that accepts
//// three parameters
//class Car57(_brand: String, _model: String, _maxSpeed: Int) {
//    // Properties of User class
//    val brand: String = _brand         // Immutable (Read only)
//    var model: String = _model  // Mutable
//    var maxSpeed: Int = _maxSpeed       // Mutable
//}
//
//// Kotlin internally generates a default getter and setter for mutable properties, and a getter (only) for read-only properties.
//
////It calls these getters and setters internally whenever
//// you access or modify a property using the dot(.) notation.
////This is how it would look like internally
//class Car58(_brand: String, _model: String, _maxSpeed: Int) {
//    val brand: String = _brand
//        get() = field
//
//    var model: String = _model
//        get() = field
//        set(value) {
//            field = value
//        }
//
//    var maxSpeed: Int = _maxSpeed
//        get() = field
//        set(value) {
//            field = value
//        }
//}
//
//// value
//// We use value as the name of the setter parameter. This is the default convention in Kotlin but you’re free to use any other name if you want.
//// The value parameter contains the value that a property is assigned to. For example, when you write user.name = "Elon Musk",
//// the value parameter contains the assigned value "Elon Musk".
//
//// 2. Backing Field (field)
//// Backing field helps you refer to the property
//// inside the getter and setter methods.
//// This is required because if you use the property
//// directly inside the getter or setter then you’ll
//// run into a recursive call which will generate
//// a StackOverflowError.
//
//
//class Car() {
//
//    private val maxSpeed: Int
//    lateinit var owner : String
//
//    val myBrand: String = "BMW"
//        // Custom getter
//        get() {
//            return field.toLowerCase()
//        }
//
//
//    // default setter and getter
//    var myModel: String = "M5"
//        private set
//
//    var myMaxSpeed: Int = maxSpeed
//        get() = field
//        // Custom Setter
//        set(value) {
//            field = if(value > 0) value else throw IllegalArgumentException("_maxSpeed must be greater than zero")
//        }
//
//    init{
//        this.myModel = "M3"
//        this.owner = "Frank"
//    }
//}
