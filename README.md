# Micro-serviço com Spring + Oracle Cloud

O objetivo deste projeto é exemplificar como criar um microserviço completo usando Spring Boot, integrando com serviços gratuitos da Oracle Cloud para armazenamento de objetos, arquivos e disparo de e-mails. Este projeto simula um microserviço capaz de gerar e enviar relatórios por e-mail, utilizando os serviços Object Storage e Mail Delivery.

## Modo Gratuito Oracle Cloud

Para criar uma conta gratuita na Oracle Cloud, acesse o [Oracle Cloud Free Tier](https://www.oracle.com/cloud/free/) e siga as instruções.

A conta gratuita oferece serviços com uso ilimitado como Instâncias de Máquinas Virtuais, Object Storage, Email Delivery, Banco de Dados NoSQL e Banco de Dados SQL.

## Pré-requisitos para execução

- Possuir conta na Oracle Cloud
- Java versão 17
- Maven 3.9.7

## Configuração

### Application.properties

O arquivo de configuração `application.properties` deve ser configurado com as informações da sua conta Oracle Cloud. Preencha o arquivo `application.properties` na pasta `src/main/resources` com as seguintes informações:

```properties
# Oracle Cloud
spring.application.name=mailservice
spring.mail.username=YOUR_SMTP_USERNAME
spring.mail.password=YOUR_SMTP_PASSWORD
spring.mail.from=YOUR_REGISTERED_EMAIL
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
spring.mail.properties.mail.smtp.starttls.required=true
spring.mail.properties.mail.smtp.ssl.trust=smtp.email.sa-saopaulo-1.oci.oraclecloud.com
spring.mail.host=smtp.email.sa-saopaulo-1.oci.oraclecloud.com
spring.mail.port=587
spring.mail.protocol=smtp
```

### Configuração das Credenciais SDK

No arquivo `.oci/config` você deve configurar as credenciais de acesso à Oracle Cloud. Para isso, preencha o arquivo `.oci/config` na raiz do projeto com as configurações geradas na sua conta.

#### Passo a passo

1. Acesse a sua conta Oracle Cloud.
2. Na página de detalhes do seu perfil no console OCI, vá para a aba “Chaves de API”.
3. Clique no botão “Adicionar chave de API”. Isso abrirá uma janela pop-up.
4. Insira um nome para a chave de API e clique no botão “Adicionar”. Isso fará o download do arquivo da chave de API.
5. Copie o conteúdo do arquivo e cole-o no arquivo `~/.oci/config` na sua máquina local.

Exemplo do conteúdo do arquivo `~/.oci/config`:

```ini
[DEFAULT]
user=YOUR_USER_ID
fingerprint=YOUR_FINGERPRINT
tenancy=YOUR_TENANCY_ID
region=sa-saopaulo-1
key_file=private-key.pem
```

## Execução

### Passos para Compilar e Executar o Projeto:

1. Certifique-se de que você possui o Java 21 e o Maven 3.9.7 instalados.
2. Clone o repositório do projeto.
3. Navegue até o diretório do projeto e execute o seguinte comando para compilar:

   ```sh
   mvn clean install
   ```

4. Para iniciar o serviço, execute:

   ```sh
   mvn spring-boot:run
   ```

### Verificação

- Certifique-se de que as configurações de correio eletrônico e armazenamento de objetos estão corretas.
- Teste o serviço enviando um arquivo de relatório e verificando se o e-mail foi entregue com sucesso.

## Conclusão

Este projeto demonstra a integração de um microserviço Spring Boot com os serviços gratuitos da Oracle Cloud, facilitando a geração e envio de relatórios por e-mail. Aproveite para explorar mais funcionalidades e adaptar o serviço às suas necessidades específicas.