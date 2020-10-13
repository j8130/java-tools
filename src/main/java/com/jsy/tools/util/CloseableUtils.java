package com.jsy.tools.util;

import java.io.Closeable;
import java.io.IOException;

/**
 * @Author: jsy
 * @Date: 2020/10/13 23:02
 */
public class CloseableUtils {
    private CloseableUtils() {
    }

    //关闭对象
    public static void closeQuietly(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
