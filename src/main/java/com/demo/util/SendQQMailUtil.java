package com.demo.util;

import java.util.Properties;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;


public class SendQQMailUtil {

    public void sendMail(String mailAddress,String header,String content) throws Exception{

        Properties properties = new Properties();
        properties.setProperty("mail.transport.protocol", "smtp");// 连接协议
        properties.setProperty("mail.smtp.host", "smtp.qq.com");// 主机名
        properties.setProperty("mail.smtp.port", "465");// 端口号
        properties.setProperty("mail.smtp.auth", "true");//指定验证为true
        properties.setProperty("mail.smtp.ssl.enable", "true");// 设置是否使用ssl安全连接 ---一般都使用
        properties.setProperty("mail.debug", "true");// 设置是否显示debug信息 true 会在控制台显示相关信息
        // 得到回话对象
        Session session = Session.getInstance(properties);
        // 获取邮件对象
        Message message = new MimeMessage(session);
        // 设置发件人邮箱地址
        message.setFrom(new InternetAddress("1461483915@qq.com"));
        // 设置收件人邮箱地址
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailAddress));//一个收件人
        // 设置邮件标题
        message.setSubject(header);
        // 设置邮件内容
        message.setText(content);
        // 得到邮差对象
        Transport transport = session.getTransport();
        // 连接自己的邮箱账户
        transport.connect("1461483915@qq.com", "sbbupfwliectjiaa");// 密码为QQ邮箱开通的stmp服务后得到的客户端授权码
        // 发送邮件
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    public void send163Mail(String to,String title,String text)throws Exception{
        String from="15017814621@163.com";
        String user="15017814621@163.com";
        String password="zy5201314";

        Properties props=new Properties();
        props.setProperty("mail.smtp.host", "smtp.163.com");
        // 需要经过授权，也就是有户名和密码的校验，这样才能通过验证（一定要有这一条）
        props.setProperty("mail.smtp.auth", "true");
        // 用刚刚设置好的props对象构建一个session
        Session session = Session.getDefaultInstance(props);
        // 有了这句便可以在发送邮件的过程中在console处显示过程信息，供调试使
        // 用（你可以在控制台（console)上看到发送邮件的过程）
        session.setDebug(true); // 用session为参数定义消息对象
        MimeMessage message = new MimeMessage(session); // 加载发件人地址
        message.setFrom(new InternetAddress(from));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to)); // 加载收件人地址
        message.setSubject(title); // 加载标题
        Multipart multipart = new MimeMultipart(); // 向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
        BodyPart contentPart = new MimeBodyPart(); // 设置邮件的文本内容
        contentPart.setContent(text, "text/html;charset=utf-8");
        multipart.addBodyPart(contentPart);
        message.setContent(multipart);
        message.saveChanges(); // 保存变化
        Transport transport = session.getTransport("smtp"); // 连接服务器的邮箱
        transport.connect("smtp.163.com", user, password); // 把邮件发送出去
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
}
