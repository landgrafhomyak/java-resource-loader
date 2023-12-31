@file:JvmName("JavaResourceLoaderKt")

package ru.landgrafhomyak.utility

import java.lang.Class
import java.io.IOException
import java.nio.charset.Charset
import kotlin.reflect.KClass

@Throws(IOException::class)
fun ClassLoader.getResourceAsBytesFromRoot(path: String): ByteArray =
    JavaResourceLoader.loadBytesFromRoot(this, path)

@Throws(IOException::class)
fun Class<*>.getResourceAsBytesFromRoot(path: String): ByteArray =
    JavaResourceLoader.loadBytesFromRoot(this, path)

@Throws(IOException::class)
fun Class<*>.getResourceAsBytesRelative(path: String): ByteArray =
    JavaResourceLoader.loadBytesRelative(this, path)

fun ClassLoader.getResourceAsBytesFromRootExitOnFail(path: String, exitCode: Int = JavaResourceLoader.DEFAULT_EXIT_CODE): ByteArray =
    JavaResourceLoader.loadBytesFromRootExitOnFail(this, path, exitCode)

fun Class<*>.getResourceAsBytesFromRootExitOnFail(path: String, exitCode: Int = JavaResourceLoader.DEFAULT_EXIT_CODE): ByteArray =
    JavaResourceLoader.loadBytesFromRootExitOnFail(this, path, exitCode)

fun Class<*>.getResourceAsBytesRelativeExitOnFail(path: String, exitCode: Int = JavaResourceLoader.DEFAULT_EXIT_CODE): ByteArray =
    JavaResourceLoader.loadBytesRelativeExitOnFail(this, path, exitCode)

@Throws(IOException::class)
fun ClassLoader.getResourceAsTextFromRoot(path: String, charset: Charset = JavaResourceLoader.DEFAULT_CHARSET): String =
    JavaResourceLoader.loadTextFromRoot(this, path, charset)

@Throws(IOException::class)
fun Class<*>.getResourceAsTextFromRoot(path: String, charset: Charset = JavaResourceLoader.DEFAULT_CHARSET): String =
    JavaResourceLoader.loadTextFromRoot(this, path, charset)

@Throws(IOException::class)
fun Class<*>.getResourceAsTextRelative(path: String, charset: Charset = JavaResourceLoader.DEFAULT_CHARSET): String =
    JavaResourceLoader.loadTextRelative(this, path, charset)

fun ClassLoader.getResourceAsTextFromRootExitOnFail(path: String, charset: Charset = JavaResourceLoader.DEFAULT_CHARSET, exitCode: Int = JavaResourceLoader.DEFAULT_EXIT_CODE): String =
    JavaResourceLoader.loadTextFromRootExitOnFail(this, path, charset, exitCode)

fun Class<*>.getResourceAsTextFromRootExitOnFail(path: String, charset: Charset = JavaResourceLoader.DEFAULT_CHARSET, exitCode: Int = JavaResourceLoader.DEFAULT_EXIT_CODE): String =
    JavaResourceLoader.loadTextFromRootExitOnFail(this, path, charset, exitCode)

fun Class<*>.getResourceAsTextRelativeExitOnFail(path: String, charset: Charset = JavaResourceLoader.DEFAULT_CHARSET, exitCode: Int = JavaResourceLoader.DEFAULT_EXIT_CODE): String =
    JavaResourceLoader.loadTextRelativeExitOnFail(this, path, charset, exitCode)

fun ClassLoader.getResourceAsTextFromRootExitOnFail(path: String, exitCode: Int): String =
    JavaResourceLoader.loadTextFromRootExitOnFail(this, path, JavaResourceLoader.DEFAULT_CHARSET, exitCode)

fun Class<*>.getResourceAsTextFromRootExitOnFail(path: String, exitCode: Int): String =
    JavaResourceLoader.loadTextFromRootExitOnFail(this, path, JavaResourceLoader.DEFAULT_CHARSET, exitCode)

fun Class<*>.getResourceAsTextRelativeExitOnFail(path: String, exitCode: Int): String =
    JavaResourceLoader.loadTextRelativeExitOnFail(this, path, JavaResourceLoader.DEFAULT_CHARSET, exitCode)

@Throws(IOException::class)
fun KClass<*>.getResourceAsBytesFromRoot(path: String): ByteArray =
    JavaResourceLoader.loadBytesFromRoot(this.java, path)

@Throws(IOException::class)
fun KClass<*>.getResourceAsBytesRelative(path: String): ByteArray =
    JavaResourceLoader.loadBytesRelative(this.java, path)

fun KClass<*>.getResourceAsBytesFromRootExitOnFail(path: String, exitCode: Int = JavaResourceLoader.DEFAULT_EXIT_CODE): ByteArray =
    JavaResourceLoader.loadBytesFromRootExitOnFail(this.java, path, exitCode)

fun KClass<*>.getResourceAsBytesRelativeExitOnFail(path: String, exitCode: Int = JavaResourceLoader.DEFAULT_EXIT_CODE): ByteArray =
    JavaResourceLoader.loadBytesRelativeExitOnFail(this.java, path, exitCode)

@Throws(IOException::class)
fun KClass<*>.getResourceAsTextFromRoot(path: String, charset: Charset = JavaResourceLoader.DEFAULT_CHARSET): String =
    JavaResourceLoader.loadTextFromRoot(this.java, path, charset)

@Throws(IOException::class)
fun KClass<*>.getResourceAsTextRelative(path: String, charset: Charset = JavaResourceLoader.DEFAULT_CHARSET): String =
    JavaResourceLoader.loadTextRelative(this.java, path, charset)

fun KClass<*>.getResourceAsTextFromRootExitOnFail(path: String, charset: Charset = JavaResourceLoader.DEFAULT_CHARSET, exitCode: Int = JavaResourceLoader.DEFAULT_EXIT_CODE): String =
    JavaResourceLoader.loadTextFromRootExitOnFail(this.java, path, charset, exitCode)

fun KClass<*>.getResourceAsTextRelativeExitOnFail(path: String, charset: Charset = JavaResourceLoader.DEFAULT_CHARSET, exitCode: Int = JavaResourceLoader.DEFAULT_EXIT_CODE): String =
    JavaResourceLoader.loadTextRelativeExitOnFail(this.java, path, charset, exitCode)

fun KClass<*>.getResourceAsTextFromRootExitOnFail(path: String, exitCode: Int): String =
    JavaResourceLoader.loadTextFromRootExitOnFail(this.java, path, JavaResourceLoader.DEFAULT_CHARSET, exitCode)

fun KClass<*>.getResourceAsTextRelativeExitOnFail(path: String, exitCode: Int): String =
    JavaResourceLoader.loadTextRelativeExitOnFail(this.java, path, JavaResourceLoader.DEFAULT_CHARSET, exitCode)