package com.mathsena.mailreportms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MailReportMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailReportMsApplication.class, args);
    }

}
