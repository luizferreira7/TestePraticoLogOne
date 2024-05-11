# Teste Prático Log.One

Instruções podem ser encontradas no arquivo ```Desafio - Teste Prático Java.pdf``` neste mesmo repositório.

# Solução

Para resolver o desafio, adicionei as dependências do JSF, Primefaces e Tomcat ao projeto para poder integrar o SpringBoot com o front-end.

Também utilizei o Lombok para gerar Getter, Setter e Constructor de forma automatica deixando o código mais limpo.

Adicionei o ModelMapper para poder mapear os VOs e as entidades.

# Deploy

Conectei o projeto a uma AWS da Amazon utilizando o CodePipeline para gerar as builds e novos deploys automicamente a partir de novos pushs.

Pode ser acessado clicando [aqui](http://testepratico.us-east-2.elasticbeanstalk.com/index.html).

## Sistema de Agendamento

O sistema consiste numa página principal exibindo o que pode ser feito, como buscar pelas entidades já cadastradas a partir do uso de filtros e o cadastro de novas entidades nas páginas de cadastro.

Para buildar o projeto execute o seguinte comando:
``` bash 
mvn install -DskipTests
```

Para executar utilize o seguinte comando:
``` bash 
java -jar -Dserver.port=9292 target/Teste-Pratico-Desenvolvedor-Java-1.0.0.jar
```

Acesse o sistema no seu browser a partir da url:
```url
http://localhost:9292/index.html
```
ou clique [aqui](http://localhost:9292/index.html).

## Detalhes da Implementação do Sistema
Para conectar o front-end em JSF com o back-end em SpringBoot implementei o arquivo de faces-config.xml para configurar o ELResolver a fim de habilitar as expressões ```#{teste.salvar()}``` 
nos arquivos .xhtml além disso configurei o FacesServlet na classe TestePraticoApplication.java permitindo que o SpringBoot processasse os requests do ciclo de vida do JSF.

### Back-end

No backend decidi utilizar o padrão de Repository extendendo o JpaRepository que por sua vez extende o CrudRepository e já implementa diversos método como ```findById()```, ```save()``` 
e facilitando a criação de queries em JPQL a já que podemos cria-las a partir de um método com a anotação ```@Query```.

Para as regras de negócio optei por criar Services responsaveis por executar validações e chamar os repositorios para persistência e obtenção de dados.

### Front-end

No front-end criei um template base para o projeto que implementa um Header e um Footer, além de permitir facilmente a utilização do mesmo em diversas outras partes do projeto reutilizando componentes.

Optei por seguir um padrão de projeto em que cada entidade possui sua respectitiva página de filtro onde é possivel buscar por entidades já cadastradas e edita-las a partir de um dialog,
e uma pagina de cadastro que pode ser acessada diretamente pela pagina principal ou pela pagina de filtro, para poder cadastrar as entidades.

Também criei layouts para a pagina de filtro, cadastro (form) e dialog de edição (modalForm) o que permite a reutilização de código para criação de todas as paginas.

### Conexão Back-end e Front-end

A conexão entre o back e o front ocorre a partir da utilização do ELResolver que permite utilizar no front dados que estão em beans gerenciados no back-end,
adotei o padrão de chamar os beans de ManagedView e FiltroView, também optei por utilizar sempre um ViewObject (VO) represntando a entidade no front para evitar
trabalhar com a mesma entidade gerenciada diretamente no front.

### Testes Automatizados

Optei por não implementa-los pois acredito não estava no escopo do projeto.
