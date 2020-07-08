package com.example.hw1

abstract class Typeitem(val type: Int)
data class Userinf(val names: String, val grade: String, val github: String) : Typeitem(1)
data class Projectinf(val head: String, val text: String) : Typeitem(2)
data class Skillhead(val c: Boolean) : Typeitem(3)
data class Skill(val skill: String, val time: String) : Typeitem(4)