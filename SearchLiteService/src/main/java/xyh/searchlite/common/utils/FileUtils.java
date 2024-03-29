package xyh.searchlite.common.utils;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 读取本地文件工具类
 */
public class FileUtils {
    /**
     * 使用NIO读取文件
     * @param fileName
     * @return
     * @throws Exception
     */
    public static String FileRead(String fileName) throws Exception {
        Resource resource = new ClassPathResource(fileName);
        FileInputStream in=new FileInputStream(resource.getFile());
        FileChannel channel = in.getChannel();
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        StringBuilder sb=new StringBuilder();
        while (channel.read(buffer) > 0) {
            buffer.flip();
            sb.append(new String(buffer.array()));
        }
        return sb.toString();
    }
}
