package ru.landgrafhomyak.utility;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class JavaResourceLoader {
    private JavaResourceLoader() {
        throw new UnsupportedOperationException();
    }

    final static int DEFAULT_EXIT_CODE = 1;
    final static Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    public static byte[] loadBytes(ClassLoader loader, String path) throws IOException {
        try (InputStream is = loader.getResourceAsStream(path)) {
            if (is == null) return null;
            try (ByteArrayOutputStream builder = new ByteArrayOutputStream()) {
                byte[] buffer = new byte[1024];
                int size;
                while ((size = is.read(buffer)) > 0) {
                    builder.write(buffer, 0, size);
                }
                return builder.toByteArray();
            }
        }
    }

    public static byte[] loadBytes(Class<?> cls, String path) throws IOException {
        return loadBytes(cls.getClassLoader(), path);
    }

    public static byte[] loadBytesExitOnFail(ClassLoader loader, String path, int exitCode) {
        try {
            return loadBytes(loader, path);
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(exitCode);
            return null;
        }
    }

    public static byte[] loadBytesExitOnFail(ClassLoader loader, String path) {
        return loadBytesExitOnFail(loader, path, DEFAULT_EXIT_CODE);
    }

    public static byte[] loadBytesExitOnFail(Class<?> cls, String path, int exitCode) {
        return loadBytesExitOnFail(cls.getClassLoader(), path, exitCode);
    }

    public static byte[] loadBytesExitOnFail(Class<?> cls, String path) {
        return loadBytesExitOnFail(cls.getClassLoader(), path, DEFAULT_EXIT_CODE);
    }

    public static String loadText(ClassLoader loader, String path, Charset charset) throws IOException {
        byte[] raw = loadBytes(loader, path);
        if (raw == null)
            return null;
        return new String(raw, charset);
    }

    public static String loadText(ClassLoader loader, String path) throws IOException {
        return loadText(loader, path, DEFAULT_CHARSET);
    }

    public static String loadText(Class<?> loader, String path, Charset charset) throws IOException {
        return loadText(loader.getClassLoader(), path, charset);
    }

    public static String loadText(Class<?> loader, String path) throws IOException {
        return loadText(loader.getClassLoader(), path);
    }

    public static String loadTextExitOnFail(ClassLoader loader, String path, Charset charset, int exitCode) {
        try {
            return loadText(loader, path, charset);
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(exitCode);
            return null;
        }
    }

    public static String loadTextExitOnFail(ClassLoader loader, String path, Charset charset) {
        return loadTextExitOnFail(loader, path, charset, DEFAULT_EXIT_CODE);
    }

    public static String loadTextExitOnFail(ClassLoader loader, String path, int exitCode) {
        return loadTextExitOnFail(loader, path, DEFAULT_CHARSET, exitCode);
    }

    public static String loadTextExitOnFail(ClassLoader loader, String path) {
        return loadTextExitOnFail(loader, path, DEFAULT_CHARSET, DEFAULT_EXIT_CODE);
    }

    public static String loadTextExitOnFail(Class<?> cls, String path, Charset charset, int exitCode) {
        return loadTextExitOnFail(cls.getClassLoader(), path, charset, DEFAULT_EXIT_CODE);
    }

    public static String loadTextExitOnFail(Class<?> cls, String path, Charset charset) {
        return loadTextExitOnFail(cls.getClassLoader(), path, charset, DEFAULT_EXIT_CODE);
    }

    public static String loadTextExitOnFail(Class<?> cls, String path, int exitCode) {
        return loadTextExitOnFail(cls.getClassLoader(), path, DEFAULT_CHARSET, exitCode);
    }

    public static String loadTextExitOnFail(Class<?> cls, String path) {
        return loadTextExitOnFail(cls.getClassLoader(), path, DEFAULT_CHARSET, DEFAULT_EXIT_CODE);
    }
}
