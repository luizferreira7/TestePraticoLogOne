FROM maven:eclipse-temurin
VOLUME /tmp
RUN apt install git
RUN git clone https://github.com/luizferreira7/TestePraticoLogOne.git
WORKDIR TestePraticoLogOne
RUN mvn install -DskipTests
RUN cp target/Teste-Pratico-Desenvolvedor-Java-1.0.0.war ..
WORKDIR ..
ENTRYPOINT ["java","-jar","/Teste-Pratico-Desenvolvedor-Java-1.0.0.war"]