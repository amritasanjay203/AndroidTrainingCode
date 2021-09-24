package com.example.androidtraining

import junit.framework.TestCase

class CalculatorTest : TestCase() {

    val calc = Calculator()

    fun testAdd() {
        var expected = 30
        var actual = calc.add(10,20)
        assertEquals(expected,actual)
    }

    fun testMultiply() {
        val expected = 10
        val actual = calc.multiply(2, 5)
        assertEquals(expected, actual)
    }
}