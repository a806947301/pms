package com.dayi.demo.util;

import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.converter.PicturesManager;
import org.apache.poi.hwpf.converter.WordToHtmlConverter;
import org.apache.poi.hwpf.usermodel.PictureType;
import org.apache.poi.xwpf.converter.core.BasicURIResolver;
import org.apache.poi.xwpf.converter.core.FileImageExtractor;
import org.apache.poi.xwpf.converter.xhtml.XHTMLConverter;
import org.apache.poi.xwpf.converter.xhtml.XHTMLOptions;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTDocument1;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

/**
 * @Author wut
 * @Date 2019-03-11
 */
public class WordUtils {

    /**
     * doc转换成html
     * @param filepath  文件存放的路径
     * @param imagePath  转换后图片相对于基地址的路径
     * @param sourceFileName    word文件文件名
     * @return
     * @throws Exception
     */
    private static String docToHtml(String filepath,final String imagePath,String sourceFileName) throws Exception {
        /** 把路径进行拼接，确定转换后的各个路径 */
        File path = new File(filepath);
        final String imagePathStr = path.getAbsolutePath() + "\\"+imagePath+"\\";
        String targetFileName = path.getAbsolutePath() + "\\"+sourceFileName+".html";
        sourceFileName = path.getAbsolutePath() + "\\"+sourceFileName;
        /** 创建图片文件夹 */
        File file = new File(imagePathStr);
        if(!file.exists()) {
            file.mkdirs();
        }
        /** word对象转换成html对象  */
        HWPFDocument wordDocument = new HWPFDocument(new FileInputStream(sourceFileName));
        org.w3c.dom.Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        WordToHtmlConverter wordToHtmlConverter = new WordToHtmlConverter(document);
        /** 保存图片，并返回图片的相对路径 */
        wordToHtmlConverter.setPicturesManager(new PicturesManager() {
            @Override
            public String savePicture(byte[] bytes, PictureType pictureType, String s, float v, float v1){
                try {
                    FileOutputStream out = new FileOutputStream(imagePathStr + "\\" + s);
                    out.write(bytes);
                    out.close();
                }catch (Exception e) {
                    e.printStackTrace();
                    return "";
                }
                return imagePath+"\\"+s;
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

    private static String docxToHtml(String filepath,String imagePath,String sourceFileName) throws Exception {
        File path = new File(filepath);
        String imagePathStr = path.getAbsolutePath() + "\\" + imagePath + "\\";
        sourceFileName = path.getAbsolutePath() + "\\" + sourceFileName;
        String targetFileName = sourceFileName + ".html";

        OutputStreamWriter outputStreamWriter = null;
        try {
            XWPFDocument document = new XWPFDocument(new FileInputStream(sourceFileName));
            System.out.println(document.toString());
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
    public static String wordToHtml(String filepath,String imagePath,String sourceFileName) throws Exception{
        if(sourceFileName.endsWith(".doc")) {
            return docToHtml(filepath,imagePath,sourceFileName);
        } else if (sourceFileName.endsWith(".docx")) {
            return docxToHtml(filepath,imagePath,sourceFileName);
        }
        return null;
    }
    public static void main(String[] args) throws Exception{
        //docToHtml();
        wordToHtml("C:\\Users\\Administrator\\Desktop","image","实习单位接收证明1.doc");
       // docxToHtml("C:\\Users\\Administrator\\Desktop","image","新手考核第二部分-项目.docx");
//        wordToHtml("C:\\Users\\Administrator\\Desktop","image","新手考核第二部分-项目.docx");
     /*   String str = "实习单位接收证明1.doc";
        System.out.println(str.substring(0,str.length()-3)+"html")     ;*/


    }
}
