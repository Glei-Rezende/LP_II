# API Carros

# Descrição
Projeto desenvolvido em Java para gerenciamento de loja de venda de veículos, utilizando SQLite como banco de dados e Maven para gerenciamento das dependências.
O sistema implementa operações de CRUD (Create, Read, Update e Delete), permitindo cadastrar, consultar, atualizar e excluir carros.

# Requisitos
Para executar o projeto, é necessário possuir:
Software:
- Java JDK 24
- Apache Maven 3.9 ou superior
- SQLite 3.x
- IntelliJ IDEA (ou outra IDE compatível)

# Dependências
- Jackson Databind 2.17.0
- SQLite JDBC 3.46.0.0

# Banco de Dados
O projeto utiliza um banco SQLite local:
carro.db

# Compilação da Aplicação
Antes de iniciar a compilação, certifique-se de que o Java JDK e o Apache Maven estejam devidamente instalados e configurados no ambiente.
Execute o comando abaixo na raiz do projeto:
- mvn clean compile durante a execução, o Maven realiza as seguintes etapas:
- Remove os artefatos gerados em compilações anteriores (clean);
- Resolve e baixa as dependências definidas no arquivo pom.xml;
- Compila os arquivos-fonte localizados em src/main/java;
- Gera os arquivos compilados (.class) no diretório target/classes.
- A compilação será considerada concluída com sucesso quando a mensagem abaixo for exibida no terminal:
BUILD SUCCESS

# Build (Empacotamento da Aplicação)
O processo de build tem como objetivo empacotar a aplicação em um arquivo executável no formato JAR (Java Archive), contendo todos os arquivos compilados e dependências necessárias para execução.
Para gerar o pacote da aplicação, deve-se executar o seguinte comando na raiz do projeto:
mvn clean package
O que este processo realiza:
- Executa a limpeza do projeto, removendo arquivos de builds anteriores (clean);
- Compila novamente todos os arquivos-fonte do projeto;
- Executa os testes configurados (caso existam);
- Empacota a aplicação em um arquivo .jar dentro da pasta target/;
- Inclui os arquivos compilados (.class) e as dependências necessárias para execução.

Resultado do Build
Após a execução bem-sucedida do comando, será gerado o seguinte arquivo:
target/api-carros-1.0-SNAPSHOT.jar
A mensagem BUILD SUCCESS indica que o empacotamento foi concluído corretamente e que o artefato da aplicação está pronto para execução ou distribuição.

