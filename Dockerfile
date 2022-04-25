# partimos de uma imagem padr�o do JAVA 11 
# para a constru��o da imagem docker do nosso micro servi�o
FROM adoptopenjdk/openjdk11:alpine

# RUN � utilizado para executar comando no "terminal" do micro servi�o
# apk update � utilizado para atualizar os 
#    reposit�rios que o container pode fazer download
# apk add bash � utilizado para adicionar o bash (shell script - linguagem de terminal CMD)
RUN apk update && apk add bash

# criar uma pasta nova dentro do container
RUN mkdir /opt/app

# copiar o arquivo app.jar para a pasta criada anteriormente
COPY target/app.jar /opt/app/app.jar

#abri (expor) porta para receber come�ar  requisi��es
EXPOSE 8080

#para executar o jar do nosso microsservi�o 
CMD ["java", "-Dspring.profiles.active=docker", "-jar", "/opt/app/app.jar"]

#docker build -t primeiro-ms . 
