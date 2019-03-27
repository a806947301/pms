package com.dayi.demo.util;

import com.dayi.demo.common.exception.SystemException;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.apache.poi.xwpf.converter.core.BasicURIResolver;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

/**
 * Word文档工具类
 *
 * @author WuTong<wut@pvc123.com>
 * @date 2019-03-11
 */
public class WordUtil {

    private final static Logger logger = LoggerFactory.getLogger(WordUtil.class);

    /**
     * Word doc 后缀
     */
    private static final String DOC = ".doc";

    /**
     * Word docx 后缀
     */
    private static final String DOCX = ".docx";

    /**
     * word转换成html
     *
     * @param filepath       源文件路径
     * @param imagePath      图片相对源文件路径
     * @param sourceFileName 源文件文件名
     * @return
     * @throws Exception
     */
    public static String wordToHtml(String filepath, String imagePath, String sourceFileName) throws SystemException {
        try {
            if (sourceFileName.endsWith(DOC)) {
                return docToHtml(filepath, imagePath, sourceFileName);
            } else if (sourceFileName.endsWith(DOCX)) {
                return docxToHtml(filepath, imagePath, sourceFileName);
            } else {
                throw new SystemException("需求文件格式不正确");
            }
        } catch (Exception e) {
            logger.error(sourceFileName + "_" + e.getMessage(), e);
            throw new SystemException("文件转换失败");
        }
    }

    /**
     * doc转换成html
     *
     * @param filepath       源文件路径
     * @param imagePath      图片相对源文件路径
     * @param sourceFileName 源文件文件名
     * @return
     * @throws Exception
     */
    private static String docToHtml(String filepath, final String imagePath, String sourceFileName) throws Exception {
        // 把路径进行拼接，确定转换后的各个路径
        File path = new File(filepath);
        final String imagePathStr = path.getAbsolutePath() + "\\" + imagePath + "\\";
        String targetFileName = path.getAbsolutePath() + "\\" + sourceFileName + ".html";
        sourceFileName = path.getAbsolutePath() + "\\" + sourceFileName;
        // 创建图片文件夹
        File file = new File(imagePathStr);
        if (!file.exists()) {
            file.mkdirs();
        }
        // word对象转换成html对象
        HWPFDocument wordDocument = new HWPFDocument(new FileInputStream(sourceFileName));
        org.w3c.dom.Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(document);
        // 设置图片管理器
        wordToHtmlConverter.setPicturesManager(new PicturesManager() {
            @Override
            public String savePicture(byte[] bytes, PictureType pictureType, String s, float v, float v1) {
                FileOutputStream out = null;
                try {
                    // 保存图片
                    out = new FileOutputStream(imagePathStr + "\\" + s);
                    out.write(bytes);
                } catch (Exception e) {
                    logger.error(out.toString() + "_" + e.getMessage(),e);
                    try {
                        out.close();
                    } catch (Exception ex) {}
                    return "";
                }
                return imagePath + "\\" + s;
            }
        });
        wordToHtmlConverter.processDocument(wordDocument);
        org.w3c.dom.Document htmlDocument = wordToHtmlConverter.getDocument();
        DOMSource domSource = new DOMSource(htmlDocument);
        StreamResult streamResult = new StreamResult(new File(targetFileName));
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer serializer = tf.newTransformer();
        serializer.setOutputProperty(OutputKeys.ENCODING, "utf-8");
        serializer.setOutputProperty(OutputKeys.INDENT, "yes");
        serializer.setOutputProperty(OutputKeys.METHOD, "html");
        serializer.transform(domSource, streamResult);
        return targetFileName;
    }

    /**
     * docx转换成html
     *
     * @param filepath       源文件路径
     * @param imagePath      图片相对源文件路径
     * @param sourceFileName 源文件文件名
     * @return
     * @throws Exception
     */
    private static String docxToHtml(String filepath, String imagePath, String sourceFileName) throws IOException {
        // 把路径进行拼接，确定转换后的各个路径
        File path = new File(filepath);
        String imagePathStr = path.getAbsolutePath() + "\\" + imagePath + "\\";
        sourceFileName = path.getAbsolutePath() + "\\" + sourceFileName;
        String targetFileName = sourceFileName + ".html";

        OutputStreamWriter outputStreamWriter = null;
        try {
            XWPFDocument document = new XWPFDocument(new FileInputStream(sourceFileName));
            XHTMLOptions options = XHTMLOptions.create();
            // 存放图片的文件夹
            options.setExtractor(new FileImageExtractor(new File(imagePathStr)));
            // html中图片的路径
            options.URIResolver(new BasicURIResolver(imagePath));
            outputStreamWriter = new OutputStreamWriter(new FileOutputStream(targetFileName), "utf-8");

            XHTMLConverter xhtmlConverter = (XHTMLConverter) XHTMLConverter.getInstance();
            xhtmlConverter.convert(document, outputStreamWriter, options);
        } finally {
            if (outputStreamWriter != null) {
                outputStreamWriter.close();
            }
        }
        return targetFileName;
    }
}