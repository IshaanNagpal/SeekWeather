package com.sample.gitrepos.extensions

import java.lang.StringBuilder


/**
 * String extension functions to be added in this file
 */


fun String.toIntOrDefault(default: Int = 0): Int = this.toIntOrNull()
    ?: default

fun String.toDoubleOrDefault(default: Double = 0.0): Double = this.toDoubleOrNull()
    ?: default

fun String.toFloatOrDefault(default: Float = 0f): Float = this.toFloatOrNull()
    ?: default

fun String.toLongOrDefault(default: Long = 0): Long = this.toLongOrNull()
    ?: default

fun String?.filterNull(defaultValue: String = ""): String {
    return this ?: defaultValue
}

fun String?.appendDegreeCelcius(): String {
    val strBuilder =  StringBuilder(this.filterNull())
    return strBuilder.append("\u2103").toString()
}

fun String?.appendDegreeFahreneits(): String {
    val strBuilder =  StringBuilder(this.filterNull())
    return strBuilder.append("\u2109").toString()
}

fun List<String>?.getCommaSeparatedString(): String {

    var strBuilder = StringBuilder()
    if (this.isNullOrEmpty()) {
        return ""
    } else {
        this.forEachIndexed { index, s ->
            strBuilder.append(s)
            if(index < this.size-1)
                strBuilder.append(", ")
        }
        return strBuilder.toString()
    }
}