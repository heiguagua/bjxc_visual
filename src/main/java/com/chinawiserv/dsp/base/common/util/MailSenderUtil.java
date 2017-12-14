package com.chinawiserv.dsp.base.common.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA
 * Description:邮件发送工具类 对应配置文件mail.properties
 * Author:GongJun
 * Date:2017/11/17
 * Time:10:28
 * Chinawiserv Technologies Co., Ltd.
 */
@Component
public class MailSenderUtil {

    @Value("${mail.smtp.host}")
    private String smtpHost;

    private static String smtpHost_static;

    @Value("${mail.smtp.from}")
    private String smtpFrom;

    private static String smtpFrom_static;

    @Value("${mail.smtp.username}")
    private String smtpUsername;

    private static String smtpUsername_static;

    @Value("${mail.smtp.password}")
    private String smtpPassword;

    private static String smtpPassword_static;

    @Value("${mail.ssi.port}")
    private String ssiPort;

    private static String ssiPort_static;

    @Value("${mail.smtp.auth}")
    private String smtpAuth;

    private static String smtpAuth_static;

    private static MailSenderUtil mailSenderUtil;


    @PostConstruct
    private void init (){
        mailSenderUtil = this;
        mailSenderUtil.smtpHost_static = this.smtpHost;
        mailSenderUtil.smtpFrom_static = this.smtpFrom;
        mailSenderUtil.smtpUsername_static = this.smtpUsername;
        mailSenderUtil.smtpPassword_static = this.smtpPassword;
        mailSenderUtil.ssiPort_static = this.ssiPort;
        mailSenderUtil.smtpAuth_static = this.smtpAuth;
    }

    /**
     * 创建一封只包含文本的简单邮件
     * @param session         和服务器交互的会话
     * @param sendMail        发件人邮箱
     * @param receiveMail     收件人邮箱
     * @param receiveUsername 收件人用户名
     * @param mailTheme       邮件标题
     * @param mailContent     邮件内容
     * @return
     * @throws Exception
     */
    private static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail, String receiveUsername, String mailTheme, String mailContent) {
        // 1. 创建一封邮件
        MimeMessage message = new MimeMessage(session);

        try {
            // 2. From: 发件人
            message.setFrom(new InternetAddress(sendMail, smtpUsername_static, "UTF-8"));

            // 3. To: 收件人（可以增加多个收件人、抄送、密送）
            message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, receiveUsername, "UTF-8"));

            // 4. Subject: 邮件主题（主题）
            message.setSubject(mailTheme, "UTF-8");

            // 5. Content: 邮件正文（可以使用html标签）
            message.setContent(mailContent, "text/html;charset=UTF-8");

            // 6. 设置发件时间
            message.setSentDate(new Date());

            // 7. 保存设置
            message.saveChanges();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return message;
    }

    public static boolean sendMail(String receiveMail, String receiveUsername, String mailTheme, String mailContent) {
        // 1. 创建参数配置, 用于连接邮件服务器的参数配置
        Properties props = new Properties();                    // 参数配置
        props.setProperty("mail.transport.protocol", "smtp");   // 使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", smtpHost_static);   // 发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", smtpAuth_static);            // 需要请求认证

        // 开启 SSL 安全连接。
        if (StringUtils.isNotBlank(ssiPort_static)) {
            props.setProperty("mail.smtp.port", ssiPort_static);
            props.setProperty("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
            props.setProperty("mail.smtp.socketFactory.fallback", "false");
            props.setProperty("mail.smtp.socketFactory.port", ssiPort_static);
        }

        // 2. 根据配置创建会话对象, 用于和邮件服务器交互
        Session session = Session.getInstance(props);
        session.setDebug(true);
        MimeMessage message;
        Transport transport;

        try {
            // 3. 创建一封邮件
            message = createMimeMessage(session, smtpFrom_static, receiveMail, receiveUsername, mailTheme, mailContent);

            // 4. 根据 Session 获取邮件传输对象
            transport = session.getTransport();

            // 5. 使用 邮箱账号 和 密码 连接邮件服务器, 这里认证的邮箱必须与 message 中的发件人邮箱一致, 否则报错
            transport.connect(smtpFrom_static, smtpPassword_static);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

        // 6. 发送邮件, 发到所有的收件地址, message.getAllRecipients() 获取到的是在创建邮件对象时添加的所有收件人, 抄送人, 密送人
        try {
            transport.sendMessage(message, message.getAllRecipients());
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }

        // 7. 关闭连接
        try {
            transport.close();
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

}
