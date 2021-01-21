package Model;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class MailService {
    final static String userName="ngyuenhuunhon978@gmail.com";
    final static String passWord="tthkdursxtxdgxvh";
    public MailService(){

    }
    public static Message prepareMessage(String emailTo, Session session,String subjectMess, String contentMess){
        MimeMessage msg=new MimeMessage(session);
        try {
            msg.setFrom(new InternetAddress(userName));
            msg.setRecipient(Message.RecipientType.CC,new InternetAddress(emailTo));
            msg.setSentDate(new Date());
            msg.setSubject(subjectMess,"utf-8");
            msg.setContent(contentMess,"text/html;charset=UTF-8");
        }catch (MessagingException e){
            e.printStackTrace();
        }
        return msg;
    }
    public static void sendMail(String emailTo,String subjectMess,String contentMess){
        Properties props=new Properties();
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.starttls.enable","true");
        props.put("mail.smtp.host","smtp.gmail.com");
        props.put("mail.smtp.port","587");
        Session session=Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName,passWord);
            }
        });
        try{
            Message msg =prepareMessage(emailTo,session,subjectMess,contentMess);
            Transport.send(msg);
            System.out.println("gui thanh cong");
        }catch (MessagingException e){
           e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        MailService.sendMail("vui01677000989@gmail.com","xat nhan,","helfsfsfsfsdfdsdffslo");
    }
}
