package com.dayi.demo.util;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.FileHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.List;

/**
 * Zip压缩文件工具类
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-15
 */
public class ZipUtil {

    private final static Logger logger = LoggerFactory.getLogger(ZipUtil.class);

    /**
     * 解压Zip文件
     *
     * @param sourceFile 要解压的文件
     * @param path       解压到的路径
     * @throws ZipException
     */
    public static void unZip(File sourceFile, String path) {
        try {
            ZipFile zipFile = new ZipFile(sourceFile);
            zipFile.setFileNameCharset(getEncoding(zipFile));
            zipFile.extractAll(path);
        } catch (Exception e) {
            logger.error(ZipUtil.class.toString() + "_" + e.getMessage(), e);
        }
    }

    /**
     * 获取要转换的编码格式
     *
     * @param zipFile
     * @return
     * @throws Exception
     */
    private static String getEncoding(ZipFile zipFile) throws ZipException {
        String encoding = "UTF-8";
        zipFile.setFileNameCharset(encoding);
        List<FileHeader> list = zipFile.getFileHeaders();
        for (int i = 0; i < list.size(); i++) {
            FileHeader fileHeader = list.get(i);
            String fileName = fileHeader.getFileName();
            if (isMessyCode(fileName)) {
                encoding = "GBK";
                break;
            }
        }
        return encoding;
    }

    /**
     * 判断是否有乱码
     *
     * @param str
     * @return
     */
    private static boolean isMessyCode(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 当从Unicode编码向某个字符集转换时，如果在该字符集中没有对应的编码，则得到0x3f（即问号字符?）
            // 从其他字符集向Unicode编码转换时，如果这个二进制数在该字符集中没有标识任何的字符，则得到的结果是0xfffd
            if ((int) c == 0xfffd) {
                // 存在乱码
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        String path = "C:\\Users\\Administrator\\Desktop\\jf";
        File file = new File("C:\\Users\\Administrator\\Desktop\\jf.zip");
        unZip(file, path);
    }
}
