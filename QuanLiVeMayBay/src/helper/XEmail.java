/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package helper;

import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author FPT
 */
public class XEmail {



    public static void send(String from, String toEmail, String pass, String content) {
        Properties mailServerProperties;
        Session getMailSession;
        MimeMessage mailMessage;

        // Step1: setup Mail Server
        mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");

        // Step2: get Mail Session
        getMailSession = Session.getDefaultInstance(mailServerProperties, null);
        mailMessage = new MimeMessage(getMailSession);

        try {
            mailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            mailMessage.setSubject("Ma xac nhan phan mem quan li ve may bay!", "UTF-8");


            // mail content

//            mailMessage.setText(String.valueOf(maXn));
            Multipart mp = new MimeMultipart();
            MimeBodyPart htmlPart = new MimeBodyPart();
            htmlPart.setContent(content, "text/html; charset=utf-8");
            mp.addBodyPart(htmlPart);
            mailMessage.setContent(mp);
            // Step3: Send mail
            Transport transport = getMailSession.getTransport("smtp");

            transport.connect("smtp.gmail.com", from, pass);

            transport.sendMessage(mailMessage, mailMessage.getAllRecipients());
            transport.close();
        } catch (AddressException ex) {

        } catch (MessagingException ex) {
            Logger.getLogger(XEmail.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
