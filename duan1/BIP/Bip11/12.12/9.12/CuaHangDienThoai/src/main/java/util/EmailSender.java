/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.swing.JProgressBar;

public class EmailSender {

    private final static String emailGui = "quanlydienthoainhom2@gmail.com";
    private final static String matKhau = "xjvvrwmrajfhktbl";

    public static void guiMail(String emailNhan,
            String tieuDe, String noiDung)
            throws AddressException, MessagingException {
        Properties prop = new Properties();
        prop.put("mail.smtp.auth", true);
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        prop.put("mail.smtp.ssl.protocols", "TLSv1.2");
        prop.put("mail.smtp.ssl.trust", "smtp.gmail.com");

        Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(emailGui, matKhau);
            }
        });

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(emailGui));
        message.setRecipients(
                Message.RecipientType.TO, InternetAddress.parse(emailNhan));

        // Tiêu đề
        message.setSubject(tieuDe, "UTF-8");

        // Nội dung
        MimeBodyPart mimeBodyPart = new MimeBodyPart();
        mimeBodyPart.setContent(noiDung, "text/html; charset=utf-8");

        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mimeBodyPart);

        message.setContent(multipart);

        Transport.send(message);
    }

    // Hàm để test
//    public static void main(String[] args) throws MessagingException {
////        EmailSender.guiMail("sktfk97@gmail.com", "ABC", "Hello World!");
//        Thread thread = new Thread() {
//            @Override
//            public void run() {
//                JProgressBar progressBar = new JProgressBar();
//                progressBar.setMinimum(0);
//                progressBar.setMaximum(100);
//                while (progressBar.getValue() == progressBar.getMaximum()) {
//                    progressBar.setValue(progressBar.getValue() + 10);
//                }
//            }
//        };
////        Integer code = RandomCode.getCode();
////        EmailSender.guiMail("anhdtph23299@fpt.edu.vn", "Mã Code để lấy mật khẩu mới", "Chúng tôi đã nhận được yêu cầu đặt lại mật khẩu của bạn từ ứng dụng quán trà sữa.<br>"
////                + "Nhập mã đặt lại mật khẩu sau đây: " + code);
//    }
}
