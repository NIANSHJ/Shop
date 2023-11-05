package utils;

import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;


//向用户发送订单确认邮件的工具类
public class EmailUtils {

    //发件人的邮箱和密码（授权码）
    public static String myEmailAccount = "Ljj1033173808@163.com";
    public static String myEmailPassword = "TCNPDGZTJBCMALKG";

    //发件人邮箱的SMTP服务器地址，网易163邮箱的SMTP服务器地址为:smtp.163.com
    public static String myEmailSMTPHost = "smtp.163.com";
    public static String receiveMailAccount = "";

    public static MimeMessage createMimeMessage(Session session, String sendMail, String receiveMail, String userName, String goodsName) throws Exception {

        // 1.创建一封邮件
        MimeMessage message = new MimeMessage(session);

        // 2.From:发件人（昵称有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改昵称）
        message.setFrom(new InternetAddress(sendMail, "NSHJ商城", "UTF-8"));

        // 3.To:收件人（可以增加多个收件人、抄送、密送）
        message.setRecipient(MimeMessage.RecipientType.TO, new InternetAddress(receiveMail, userName + "客户", "UTF-8"));

        // 4.Subject: 邮件主题（标题有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改标题）
        message.setSubject("发货确认", "UTF-8");

        // 5.Content: 邮件正文（可以使用html标签）（内容有广告嫌疑，避免被邮件服务器误认为是滥发广告以至返回失败，请修改发送内容）
        message.setContent("尊敬的客户" + userName + ",你好! " + "你购买的" + goodsName + "下单成功，已开始发货。", "text/html;charset=UTF-8");

        // 6.设置发件时间
        message.setSentDate(new Date());

        // 7.保存设置
        message.saveChanges();
        return message;
    }

    public static void sendEmail(String email, String userName, String goodsName) throws Exception {

        //1.创建参数配置，用于连接邮件服务器的参数配置
        Properties props = new Properties();                    //参数配置
        props.setProperty("mail.transport.protocol", "smtp");   //使用的协议（JavaMail规范要求）
        props.setProperty("mail.smtp.host", myEmailSMTPHost);   //发件人的邮箱的 SMTP 服务器地址
        props.setProperty("mail.smtp.auth", "true");            //需要请求认证
        receiveMailAccount = email;

        //2.根据配置创建会话对象，用于和邮件服务器交互
        Session session = Session.getInstance(props);

        //3.创建一封邮件
        MimeMessage message = createMimeMessage(session, myEmailAccount, receiveMailAccount, userName, goodsName);

        //4.根据Session获取邮件传输对象
        Transport transport = session.getTransport();

        //5.使用邮箱账号和密码连接邮件服务器
        transport.connect(myEmailAccount, myEmailPassword);

        //6.发送邮件，发到所有的收件地址，message.getAllRecipients()获取到的是在创建邮件对象时添加的所有收件人、抄送人、密送人
        transport.sendMessage(message, message.getAllRecipients());

        // 7. 关闭连接
        transport.close();
    }

}
