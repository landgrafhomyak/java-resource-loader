package ru.landgrafhomyak.utility;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class JavaResourceLoader {
    private JavaResourceLoader() {
        throw new UnsupportedOperationException();
    }

    final static int DEFAULT_EXIT_CODE = 1;
    final static Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    private static byte[] _collectBytes(InputStream is) throws IOException {
        try (@SuppressWarnings("unused") InputStream _is = is) {
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

    /**
     * @param loader {@link ClassLoader#getResourceAsStream(String) Class loader} which will load the resource.
     * @param path   Location of resource relative to resource root. Should start with <code>/</code> symbol.
     * @return Byte array with raw content of resource.
     * @throws IOException Thrown by passed {@link ClassLoader#getResourceAsStream(String) class loader}.
     * @since 2.0
     */
    public static byte[] loadBytesFromRoot(ClassLoader loader, String path) throws IOException {
        if (path.isEmpty() || path.charAt(0) != '/')
            throw new IllegalArgumentException("Path must be started with /");
        if (path.length() >= 2 && path.charAt(1) == '/')
            throw new IllegalArgumentException("Too many leading / symbols");
        path = path.substring(1);
        return JavaResourceLoader._collectBytes(loader.getResourceAsStream(path));
    }

    /**
     * @param cls  {@link Class#getResourceAsStream(String)  Class} which will be used to resolve resource location by {@link Class#getResourceAsStream(String)}.
     * @param path Location of resource relative to specified class. Should not contain leading / symbols.
     * @return Byte array with raw content of resource.
     * @throws IOException Thrown by passed {@link Class#getResourceAsStream(String) class}.
     * @since 2.0
     */
    public static byte[] loadBytesRelative(Class<?> cls, String path) throws IOException {
        if (!path.isEmpty() && path.charAt(0) == '/')
            throw new IllegalArgumentException("If you want load resource relative to resources root, use loadBytesFromRoot");
        return JavaResourceLoader._collectBytes(cls.getResourceAsStream(path));
    }

    /**
     * @param cls  {@link Class#getClassLoader() Class} whose {@link ClassLoader#getResourceAsStream(String) class loader} will load resource.
     * @param path Location of resource relative to resource root. Should start with <code>/</code> symbol.
     * @return Byte array with raw content of resource.
     * @throws IOException Thrown by passed {@link ClassLoader#getResourceAsStream(String) class loader}.
     * @since 2.0
     */
    public static byte[] loadBytesFromRoot(Class<?> cls, String path) throws IOException {
        return JavaResourceLoader.loadBytesFromRoot(cls.getClassLoader(), path);
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public static byte[] loadBytesFromRootExitOnFail(ClassLoader loader, String path, int exitCode) {
        try {
            return JavaResourceLoader.loadBytesFromRoot(loader, path);
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(exitCode);
            return null;
        }
    }

    public static byte[] loadBytesFromRootExitOnFail(ClassLoader loader, String path) {
        return JavaResourceLoader.loadBytesFromRootExitOnFail(loader, path, JavaResourceLoader.DEFAULT_EXIT_CODE);
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public static byte[] loadBytesFromRootExitOnFail(Class<?> cls, String path, int exitCode) {
        try {
            return JavaResourceLoader.loadBytesFromRoot(cls, path);
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(exitCode);
            return null;
        }
    }

    public static byte[] loadBytesFromRootExitOnFail(Class<?> cls, String path) {
        return JavaResourceLoader.loadBytesFromRootExitOnFail(cls, path, JavaResourceLoader.DEFAULT_EXIT_CODE);
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public static byte[] loadBytesRelativeExitOnFail(Class<?> cls, String path, int exitCode) {
        try {
            return JavaResourceLoader.loadBytesRelative(cls, path);
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(exitCode);
            return null;
        }
    }

    public static byte[] loadBytesRelativeExitOnFail(Class<?> cls, String path) {
        return JavaResourceLoader.loadBytesRelativeExitOnFail(cls, path, JavaResourceLoader.DEFAULT_EXIT_CODE);
    }


    public static String loadTextFromRoot(ClassLoader loader, String path, Charset charset) throws IOException {
        byte[] raw = JavaResourceLoader.loadBytesFromRoot(loader, path);
        if (raw == null)
            return null;
        return new String(raw, charset);
    }

    public static String loadTextFromRoot(ClassLoader loader, String path) throws IOException {
        return JavaResourceLoader.loadTextFromRoot(loader, path, JavaResourceLoader.DEFAULT_CHARSET);
    }

    public static String loadTextFromRoot(Class<?> cls, String path, Charset charset) throws IOException {
        byte[] raw = JavaResourceLoader.loadBytesFromRoot(cls, path);
        if (raw == null)
            return null;
        return new String(raw, charset);
    }

    public static String loadTextFromRoot(Class<?> cls, String path) throws IOException {
        return JavaResourceLoader.loadTextFromRoot(cls, path, JavaResourceLoader.DEFAULT_CHARSET);
    }

    public static String loadTextRelative(Class<?> cls, String path, Charset charset) throws IOException {
        byte[] raw = JavaResourceLoader.loadBytesRelative(cls, path);
        if (raw == null)
            return null;
        return new String(raw, charset);
    }

    public static String loadTextRelative(Class<?> cls, String path) throws IOException {
        return JavaResourceLoader.loadTextRelative(cls, path, JavaResourceLoader.DEFAULT_CHARSET);
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public static String loadTextFromRootExitOnFail(ClassLoader loader, String path, Charset charset, int exitCode) {
        try {
            return JavaResourceLoader.loadTextFromRoot(loader, path, charset);
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(exitCode);
            return null;
        }
    }

    public static String loadTextFromRootExitOnFail(ClassLoader loader, String path, Charset charset) {
        return JavaResourceLoader.loadTextFromRootExitOnFail(loader, path, charset, JavaResourceLoader.DEFAULT_EXIT_CODE);
    }

    public static String loadTextFromRootExitOnFail(ClassLoader loader, String path, int exitCode) {
        return JavaResourceLoader.loadTextFromRootExitOnFail(loader, path, JavaResourceLoader.DEFAULT_CHARSET, exitCode);
    }

    public static String loadTextFromRootExitOnFail(ClassLoader loader, String path) {
        return JavaResourceLoader.loadTextFromRootExitOnFail(loader, path, JavaResourceLoader.DEFAULT_CHARSET, JavaResourceLoader.DEFAULT_EXIT_CODE);
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public static String loadTextFromRootExitOnFail(Class<?> cls, String path, Charset charset, int exitCode) {
        try {
            return JavaResourceLoader.loadTextFromRoot(cls, path, charset);
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(exitCode);
            return null;
        }
    }

    public static String loadTextFromRootExitOnFail(Class<?> cls, String path, Charset charset) {
        return JavaResourceLoader.loadTextFromRootExitOnFail(cls, path, charset, JavaResourceLoader.DEFAULT_EXIT_CODE);
    }

    public static String loadTextFromRootExitOnFail(Class<?> cls, String path, int exitCode) {
        return JavaResourceLoader.loadTextFromRootExitOnFail(cls, path, JavaResourceLoader.DEFAULT_CHARSET, exitCode);
    }

    public static String loadTextFromRootExitOnFail(Class<?> cls, String path) {
        return JavaResourceLoader.loadTextFromRootExitOnFail(cls, path, JavaResourceLoader.DEFAULT_CHARSET, JavaResourceLoader.DEFAULT_EXIT_CODE);
    }

    @SuppressWarnings("CallToPrintStackTrace")
    public static String loadTextRelativeExitOnFail(Class<?> cls, String path, Charset charset, int exitCode) {
        try {
            return JavaResourceLoader.loadTextRelative(cls, path, charset);
        } catch (Throwable e) {
            e.printStackTrace();
            System.exit(exitCode);
            return null;
        }
    }

    public static String loadTextRelativeExitOnFail(Class<?> cls, String path, Charset charset) {
        return JavaResourceLoader.loadTextRelativeExitOnFail(cls, path, charset, JavaResourceLoader.DEFAULT_EXIT_CODE);
    }

    public static String loadTextRelativeExitOnFail(Class<?> cls, String path, int exitCode) {
        return JavaResourceLoader.loadTextRelativeExitOnFail(cls, path, JavaResourceLoader.DEFAULT_CHARSET, exitCode);
    }

    public static String loadTextRelativeExitOnFail(Class<?> cls, String path) {
        return JavaResourceLoader.loadTextRelativeExitOnFail(cls, path, JavaResourceLoader.DEFAULT_CHARSET, JavaResourceLoader.DEFAULT_EXIT_CODE);
    }
}
