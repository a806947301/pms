package com.dayi.demo.util;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

/**
 * @Author wut
 * @Date 2019-03-11
 */
public class MailUtils {

    /** 邮箱主机 */
    private static String HOST = "smtp.exmail.qq.com";
    /** 发送的邮箱号 */
    private static String EMAIL = "wut@pvc123.com";
    /** 邮箱密码 */
    private static String PASSWORD = "J3zPqzKJ5GQkAJQV";
    /** 发送的协议 */
    private static String SEND_PROTOCOL = "smtp";

    /**
     * 发送邮件
     * @param to    接收者邮箱号
     * @param title 邮件标题
     * @param content   邮件内容
     * @throws Exception
     */
    public static void sendMail(String to,String title,String content)  throws Exception {
        Properties properties = new Properties();
        properties.setProperty("mail.host",HOST);
        properties.setProperty("mail.transport.protocol",SEND_PROTOCOL);
        properties.setProperty("mail.smtp.auth","true");
        Session session = Session.getInstance(properties);
        Transport transport = session.getTransport();
        transport.connect(HOST,EMAIL,PASSWORD);
        /** 打包成邮件message对象 */
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(EMAIL));
        message.setRecipient(Message.RecipientType.TO,new InternetAddress(to));
        message.setSubject(title);
        message.setContent(content,"text/html;charset=UTF-8");
        /** 发送邮件 */
        transport.sendMessage(message,message.getAllRecipients());
        transport.close();
    }
}
