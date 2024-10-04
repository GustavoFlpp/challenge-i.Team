# Catálogo de Produtos - API RESTful

## Descrição
Esta é uma API RESTful desenvolvida com Java e Spring Boot para gerenciar um catálogo de produtos. A API permite realizar operações CRUD (Criar, Ler, Atualizar e Excluir) em produtos, com integração com um banco de dados MongoDB.

## Funcionalidades
- **Criar produto**: Adicionar um novo produto com nome, descrição, preço, quantidade em estoque, data de criação e atualização automática.
- **Ler produtos**: Listar todos os produtos ou buscar um produto específico pelo ID.
- **Atualizar produto**: Atualizar as informações de um produto existente.
- **Excluir produto**: Remover um produto do sistema.

## Requisitos
- Java 17 ou superior
- Maven 3.6+
- Docker (opcional para rodar MongoDB via container)
- MongoDB (local ou em container via Docker)

## Como Rodar a Aplicação

### Passo 1: Clonar o Repositório

git clone <URL_DO_REPOSITORIO>
cd nome-do-repositorio

## Passo 2: Configurar o MongoDB

### Usando Docker (recomendado)

Você pode rodar uma instância do MongoDB usando Docker. Certifique-se de que o Docker está instalado e funcionando. Para rodar o MongoDB via Docker Compose, siga os passos abaixo:

1. Certifique-se de ter um arquivo `docker-compose.yml` na raiz do projeto (ver abaixo para o conteúdo do arquivo).
2. Rode o comando:
    docker-compose up

Isso irá iniciar uma instância do MongoDB no container.

### Usando MongoDB local

Se você já tiver o MongoDB instalado na sua máquina, basta garantir que ele esteja rodando na porta padrão `27017`.

### Passo 3: Rodar a Aplicação

No diretório raiz do projeto, execute os seguintes comandos:

# Para compilar e rodar a aplicação
./mvnw clean install
./mvnw spring-boot:run

## Passo 4: Acessar a API

Após rodar a aplicação, você pode acessar os endpoints usando uma ferramenta como Postman ou cURL:

- **GET /produtos**: Listar todos os produtos
- **POST /produtos**: Criar um novo produto (com corpo JSON)
- **GET /produtos/{id}**: Obter um produto pelo ID
- **PUT /produtos/{id}**: Atualizar um produto existente
- **DELETE /produtos/{id}**: Remover um produto

## Passo 5: Rodar os Testes

Para rodar os testes unitários da aplicação, use o comando:

./mvnw test

Isso vai rodar todos os testes e gerar um relatório sobre os resultados.

## Docker Compose

Crie um arquivo `docker-compose.yml` na raiz do projeto para rodar o MongoDB em um container:
version: '3'
services:
  mongodb:
    image: mongo:latest
    container_name: mongo_container
    ports:
      - 27017:27017
    networks:
      - backend

networks:
  backend:
    driver: bridge

## Boas Práticas Seguidas

- **Nomeação de métodos e variáveis**: Métodos e variáveis foram nomeados de maneira descritiva, facilitando a compreensão do código.
- **Separação de responsabilidades**: O código está organizado em camadas (controller, service, repository), seguindo o padrão MVC (Model-View-Controller).
- **Validação e tratamento de erros**: As validações foram implementadas utilizando anotações do Bean Validation (`@NotNull`, `@Positive`) e o tratamento de erros é feito por um `GlobalExceptionHandler`.
- **Testes unitários**: Foram criados testes unitários para garantir que as funcionalidades principais da API funcionem corretamente.

## Estrutura do Projeto

src
└── main
    ├── java
    │   └── com
    │       └── seuprojeto
    │           ├── controller
    │           ├── model
    │           ├── repository
    │           ├── service
    │           └── exception
    └── resources
        └── application.properties

## Estrutura do Projeto

src
└── main
    ├── java
    │   └── com
    │       └── seuprojeto
    │           ├── controller
    │           ├── model
    │           ├── repository
    │           ├── service
    │           └── exception
    └── resources
        └── application.properties

Foi a minha primeira experiência com tanta coisa então confesso que me desafiei bastante e espero que funcione e gostem, obrigado pela oportunidade :).
