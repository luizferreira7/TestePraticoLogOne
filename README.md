# Teste Prático Log.One

Instruções podem ser encontradas no arquivo ```Desafio - Teste Prático Java.pdf``` neste mesmo repositório.

# Solução

Para resolver o desafio, adicionei as dependências do JSF, Primefaces e Tomcat ao projeto para poder integrar o SpringBoot com o front-end.

## Sistema de Agendamento

O sistema consiste em uma página principal exibindo o que pode ser feito, como buscar pelas entidades já cadastradas a partir do uso de filtros e o cadastro de novas entidades nas páginas de cadastro.

Para buildar o projeto execute o seguinte comando:
``` bash 
mvn install -DskipTests
```

Para executar utilize o seguinte comando:
``` bash 
java -jar -Dserver.port=9292 target/Teste-Pratico-Desenvolvedor-Java-0.0.1-SNAPSHOT.jar
```

Acesse o sistema em seu browser a partir da url:
```url
http://localhost:9292/index.html
```
ou clique [aqui](http://localhost:9292/index.html).

## Detalhes da Implementação do Sistema

