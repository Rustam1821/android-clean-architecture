package com.rustamaliiev.caa_ex_0201

import junit.framework.Assert.assertEquals
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runBlockingTest
import org.junit.Rule
import org.junit.Test

class NumberAdderTest {

    @get:Rule
    val dispatcherTestRule: DispatcherTestRule = DispatcherTestRule()

    @Test
    fun testAdd() = runBlockingTest {
        val adder = NumberAdder(
            dispatcher = dispatcherTestRule.testDispatcher,
            delay = 0,
        )
        val result = adder.add(1, 4).first()
        assertEquals(5, result)
    }
}