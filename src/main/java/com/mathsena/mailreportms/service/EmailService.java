package com.mathsena.mailreportms.service;


import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Date;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class EmailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Value("${spring.mail.from}")
    private String from;

    public void sendReport(String content, String to) {
        try {
            log.info("Iniciando o envio do relatório para {}", to);

            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);

            int currentMonth = new Date().getMonth();

            helper.setFrom(from);
            helper.setText(content, true);
            helper.setSubject("Monthly Report - " + currentMonth);
            helper.setTo(to);

            javaMailSender.send(message);

            log.info("Relatório enviado com sucesso para {}", to);
        } catch (Exception e) {
            log.error("Erro ao enviar o relatório para {}", to, e);
        }
    }
}