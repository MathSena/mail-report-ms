package com.mathsena.mailreportms.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Slf4j
@Service
public class ScheduleReportService {

    @Autowired
    private FileOSService fileOSService;

    @Autowired
    private EmailService emailService;

    private List<String> emailList = Arrays.asList("seumail@mail.com");

    private static final int SEVEN_DAYS_IN_MILLISECONDS = 604_800_000;

    @Scheduled(fixedRate = SEVEN_DAYS_IN_MILLISECONDS)
    public void sendReport() {
        log.info("Iniciando o envio do relatório agendado.");

        try {
            String report = fileOSService.getReportFileContent("report.html");
            log.info("Relatório obtido com sucesso do arquivo 'report.html'.");

            for (String email : emailList) {
                log.info("Enviando relatório para: {}", email);
                emailService.sendReport(report, email);
            }

            log.info("Envio do relatório concluído.");
        } catch (Exception e) {
            log.error("Erro ao enviar o relatório agendado.", e);
        }
    }
}