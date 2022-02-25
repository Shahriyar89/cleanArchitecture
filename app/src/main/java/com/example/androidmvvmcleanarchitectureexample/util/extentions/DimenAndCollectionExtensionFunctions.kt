package com.example.androidmvvmcleanarchitectureexample.util.extentions

import android.content.res.Resources
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.*


val Int.asDp: Int get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

val Float.asDp: Int get() = (this * Resources.getSystem().displayMetrics.density + 0.5f).toInt()

/**
 * This Kotlin extension function is responsible to replace blank values
 * @return all replaces blank values string
 */
fun String.replaceBlank(): String {
    return replace(" ".toRegex(), "")
}

/**
 * This Kotlin extension function is responsible to replace blank values
 * @return all replaces blank values string
 */
fun String.replaceString(replaceText: String): String {
    return replace(replaceText.toRegex(), "")
}

/**
 * This extension function is responsible to check if list position is bigger than list size to
 * eliminate indexoutofbounds exception
 */
fun <E> List<E>.getIfExists(position: Int): E? {
    return if (position in 0 until size)
        get(position)
    else
        null
}

/**
 * This extension function is responsible to check if list position is bigger than list size to
 * eliminate indexoutofbounds exception
 */
fun <E> Array<E>.getIfExists(position: Int): E? {
    return if (position in 0 until size)
        get(position)
    else
        null
}


fun <K, V> Map<K, V>.getIfExists(k: K): V? {
    return if (containsKey(k))
        get(k)
    else
        null
}

fun <T> mergeLists(first: List<T>, second: List<T>): List<T> {
    return first + second
}

fun Any?.isNull(): Boolean {
    return this == null
}

fun Any?.isNotNull(): Boolean {
    return this != null
}

fun String.isDecimalValue(): Boolean {
    return this.isNotEmpty() && this.matches(Regex("^\\d*\\.?\\d*\$"))
}

fun Double.isPositive() = this > 0


fun Float.formatToString(): String? {
    val formatter = NumberFormat.getInstance(Locale.US) as DecimalFormat
    val symbols = formatter.decimalFormatSymbols
    symbols.groupingSeparator = ','
    formatter.decimalFormatSymbols = symbols
    return formatter.format(this)
}

fun Double.formatToString(): String? {
    val formatter = NumberFormat.getInstance(Locale.US) as DecimalFormat
    val symbols = formatter.decimalFormatSymbols
    symbols.groupingSeparator = ','
    formatter.decimalFormatSymbols = symbols
    return formatter.format(this)
}
