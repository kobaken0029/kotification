package jp.co.kobaken.kotification

fun String.parseInt(): Int? = try { Integer.parseInt(this) } catch (e: NumberFormatException) { null }
