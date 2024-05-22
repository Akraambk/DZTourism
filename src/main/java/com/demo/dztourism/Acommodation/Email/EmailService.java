package com.demo.dztourism.Acommodation.Email;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring6.SpringTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static java.nio.charset.StandardCharsets.UTF_8;

@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender ;
    private final SpringTemplateEngine templateEngine ;

//    @Async
//   public void sendMail(
//           String to ,
//           String userName ,
//           EmailTemplateName emailTemplate ,
//           String confirmationUrl ,
//           String activationCode ,
//           String subject
//   ) throws MessagingException {
//
//       String templateName ;
//
//       if (emailTemplate == null) {
//           templateName = "confirmation_mail" ;
//       }else {
//           templateName = emailTemplate.name() ;
//       }
//
//       MimeMessage mimeMessage = mailSender.createMimeMessage();
//       MimeMessageHelper helper = new MimeMessageHelper(
//               mimeMessage ,
//               MimeMessageHelper.MULTIPART_MODE_MIXED ,
//               UTF_8.name()
//       ) ;
//
//       Map<String , Object> properties = new HashMap<>() ;
//
//       properties.put("userName" , userName);
//       properties.put("confirmationUrl" , confirmationUrl);
//       properties.put("activationCode" , activationCode);
//
//       Context context = new Context() ;
//       context.setVariables(properties);
//
//       helper.setTo(to);
//       helper.setFrom("bakhouche.akram01@gmail.com");
//       helper.setSubject(subject);
//
//       String text = templateEngine.process(templateName , context) ;
//       helper.setText(text , true);
//
//       mailSender.send(mimeMessage);
//
//   }
//


    @Async
    public void sendMail(
            String to,
            String userName,
            EmailTemplateName emailTemplate,
            String confirmationUrl,
            String activationCode,
            String subject
    ) throws MessagingException {
        /* Determine the email template name
         based on the provided EmailTemplateName */
        String templateName;
        if (emailTemplate == null) {
            templateName = "confirmation_mail";
        } else {
            templateName = emailTemplate.name();
        }

        // Create a MimeMessage for sending the email
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(
                mimeMessage,
                MimeMessageHelper.MULTIPART_MODE_MIXED,
                UTF_8.name()
        );

        // Prepare email template variables
        Map<String, Object> properties = new HashMap<>();
        properties.put("userName", userName);
        properties.put("confirmationUrl", confirmationUrl);
        properties.put("activationCode", activationCode);

        // Create a Thymeleaf context and set template variables
        Context context = new Context();
        context.setVariables(properties);

        // Configure email properties
        helper.setTo(to);
        helper.setFrom("bakhouche.akram01@gmail.com");
        helper.setSubject(subject);

        /* Process the Thymeleaf template with
        the provided template name and context*/
        String text = templateEngine.process(templateName, context);
        helper.setText(text, true);

        // Send the email using the configured mail sender
        mailSender.send(mimeMessage);
    }




}
