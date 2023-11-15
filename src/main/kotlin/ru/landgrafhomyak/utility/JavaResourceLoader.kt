@file:JvmName("JavaResourceLoaderKt")

package ru.landgrafhomyak.utility

import java.io.IOException
import java.nio.charset.Charset

@Throws(IOException::class)
fun ClassLoader.getResourceAsBytes(path: String): ByteArray =
    JavaResourceLoader.loadBytes(this, path)

@Throws(IOException::class)
fun Class<*>.getResourceAsBytes(path: String): ByteArray =
    JavaResourceLoader.loadBytes(this, path)

fun ClassLoader.getResourceAsBytesExitOnFail(
    path: String,
    exitCode: Int = JavaResourceLoader.DEFAULT_EXIT_CODE
): ByteArray = JavaResourceLoader.loadBytesExitOnFail(this, path, exitCode)

fun Class<*>.getResourceAsBytesExitOnFail(
    path: String,
    exitCode: Int = JavaResourceLoader.DEFAULT_EXIT_CODE
): ByteArray = JavaResourceLoader.loadBytesExitOnFail(this, path, exitCode)

@Throws(IOException::class)
fun ClassLoader.getResourceAsText(path: String, charset: Charset = JavaResourceLoader.DEFAULT_CHARSET): String =
    JavaResourceLoader.loadText(this, path, charset)

@Throws(IOException::class)
fun Class<*>.getResourceAsText(path: String, charset: Charset = JavaResourceLoader.DEFAULT_CHARSET): String =
    JavaResourceLoader.loadText(this, path, charset)

fun ClassLoader.getResourceAsTextExitOnFail(
    path: String,
    charset: Charset = JavaResourceLoader.DEFAULT_CHARSET,
    exitCode: Int = JavaResourceLoader.DEFAULT_EXIT_CODE
): String = JavaResourceLoader.loadTextExitOnFail(this, path, charset, exitCode)

fun ClassLoader.getResourceAsTextExitOnFail(
    path: String,
    exitCode: Int
): String = JavaResourceLoader.loadTextExitOnFail(this, path, exitCode)

fun Class<*>.getResourceAsTextExitOnFail(
    path: String,
    charset: Charset = JavaResourceLoader.DEFAULT_CHARSET,
    exitCode: Int = JavaResourceLoader.DEFAULT_EXIT_CODE
): String = JavaResourceLoader.loadTextExitOnFail(this, path, charset, exitCode)

fun Class<*>.getResourceAsTextExitOnFail(
    path: String,
    exitCode: Int
): String = JavaResourceLoader.loadTextExitOnFail(this, path, exitCode)
