# API Carros

## Descrição
Aplicação desenvolvida em Java para gerenciamento de uma loja de venda de veículos.  
O sistema permite realizar operações de CRUD (Create, Read, Update e Delete), possibilitando o cadastro, consulta, atualização e exclusão de carros.

A aplicação pode ser executada via:
- Interface de linha de comando (menu interativo)
- Estrutura preparada para evolução como API HTTP (caso o servidor esteja habilitado)

---

## Arquitetura do Projeto
O projeto segue uma estrutura organizada em camadas:
- **controller** → Responsável pela entrada e roteamento das requisições
- **service** → Regras de negócio
- **repository** → Acesso ao banco de dados
- **model** → Entidades do sistema
- **database** → Configuração e conexão com o banco (SQLite)
- **app** → Classe principal com menu interativo

---

## Requisitos
### Software necessário:
- Java JDK 17 ou superior (recomendado LTS)
- Apache Maven 3.9 ou superior
- SQLite 3.x
- IntelliJ IDEA (ou outra IDE compatível)

---

## Compilação da Aplicação
Antes de compilar, certifique-se de que o Java e o Maven estão instalados e configurados.

Execute na raiz do projeto:
mvn clean compile
O que acontece na compilação:
- Remove arquivos de builds anteriores (clean)
- Resolve e baixa dependências do pom.xml
- Compila os arquivos em src/main/java
- Gera arquivos .class em target/classes

A compilação será concluída com sucesso quando aparecer:
BUILD SUCCESS

---

## Build (Empacotamento)
Para gerar o artefato da aplicação (JAR), execute:
mvn clean package
Etapas do build:
- Limpeza do projeto
- Compilação dos fontes
- Execução de testes (caso existam)
- Empacotamento em arquivo .jar

## Resultado do Build
Após a execução, será gerado o arquivo:
target/api-carros-1.0-SNAPSHOT.jar
A mensagem:
BUILD SUCCESS, indica que o empacotamento foi concluído corretamente.

---

## Execução da Aplicação
Após a realização do build da aplicação por meio do comando `mvn clean package`, será gerado o arquivo executável no formato JAR no diretório `target/`, como por exemplo `api-carros-1.0-SNAPSHOT.jar`.
Para executar o sistema compilado, é necessário ter o Java previamente instalado e configurado no ambiente.
Em seguida, deve-se acessar o diretório raiz do projeto via terminal e executar o comando `java -jar target/api-carros-1.0-SNAPSHOT.jar`.
Após a execução, a aplicação será iniciada no terminal, apresentando um menu interativo com as opções disponíveis para gerenciamento dos veículos, como cadastro e listagem de carros.
Alternativamente, durante o desenvolvimento, o sistema também pode ser executado diretamente pela classe principal `MenuCarroApp`, por meio de uma IDE como o IntelliJ IDEA.

---

## Dependências
Principais bibliotecas utilizadas:
- Jackson Databind 2.17.0 (para serialização/desserialização JSON)
- SQLite JDBC 3.46.0.0 (conectividade com banco SQLite)

---

## Banco de Dados
O projeto utiliza um banco de dados SQLite local:carros.db

---

## Execução da Aplicação
A aplicação pode ser executada a partir da classe principal:MenuCarroApp.java
Ao executar, será exibido um menu interativo no terminal:SISTEMA DE CARROS
1 - Cadastrar carro
2 - Listar carros
...

---

## Possíveis Evoluções
- Exposição completa como API REST
- Integração com outros bancos de dados (MySQL, PostgreSQL)
- Implementação de validações e tratamento de erros mais robustos
- Criação de testes automatizados
