package com.mathsena.mailreportms.service;


import com.mathsena.mailreportms.config.OSClientConfiguration;
import com.oracle.bmc.objectstorage.requests.GetObjectRequest;
import com.oracle.bmc.objectstorage.responses.GetObjectResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;


@Service
@Slf4j
public class FileOSService {


    String bucketName = "YOUR_BUCKETNAME";
    String namespace = "YOUR_NAMESPACE";

    @Autowired
    private OSClientConfiguration clientConfiguration;

    public String getReportFileContent(String filename) {
        log.info("Iniciando a obtenção do conteúdo do arquivo: {}", filename);

        GetObjectRequest objectRequest = GetObjectRequest.builder()
                .namespaceName(namespace)
                .bucketName(bucketName)
                .objectName(filename)
                .build();

        log.info("GetObjectRequest criado com sucesso para o arquivo: {}", filename);

        try {
            GetObjectResponse objectResponse = clientConfiguration.getObjectStorage()
                    .getObject(objectRequest);

            log.info("Resposta obtida com sucesso para o arquivo: {}", filename);

            InputStream inputStream = objectResponse.getInputStream();

            String content = new BufferedReader(new InputStreamReader(inputStream)).lines()
                    .collect(Collectors.joining());

            log.debug("Conteúdo do arquivo {}: {}", filename, content);

            return content;
        } catch (Exception e) {
            log.error("Erro ao obter o conteúdo do arquivo: {}", filename, e);
        }

        return "";
    }
}