# Projeto Controle de Estoque de Produtos

API REST desenvolvida em Spring Boot para gerenciamento de produtos, permitindo operações completas de CRUD (Create, Read, Update e Delete).

O projeto foi desenvolvido com foco em aprendizado e consolidação de conceitos fundamentais do Spring Boot, seguindo boas práticas de organização em camadas e arquitetura REST.

## Tecnologias Utilizadas

- Java
- Spring Boot
- Spring Web
- Spring Data JPA
- SQLite
- Maven

## Pré-requisitos

- Java 17 ou superior
- Maven

## Arquitetura e organização do projeto

O projeto segue o padrão de arquitetura em camadas, separando responsabilidades e facilitando manutenção e evolução do código. </br>
controller/ -> Camada de exposição da API (endpoints REST) </br>
service/ -> Camada de regras de negócio </br> 
repository/ -> Camada de acesso a dados </br>
model/ -> Entidades do domínio </br>
client/ -> Páginas HTML para testes manuais da API 

## Maven

O Apache Maven foi utilizado como ferramenta de gerenciamento de dependências e automação do build da aplicação.

Suas principais responsabilidades no projeto incluem:

Gerenciamento e controle de versões das dependências do Spring Boot

Organização e padronização da estrutura do projeto

Automatização do processo de compilação e empacotamento da aplicação

Facilitação da manutenção e escalabilidade do projeto

Todas as dependências estão configuradas no arquivo pom.xml, permitindo que o projeto seja executado facilmente em qualquer ambiente compatível.


## Descrição das classes

### Controller

Responsável por expor os endpoints REST da aplicação e receber as requisições HTTP.

Funções principais:
- Mapear rotas HTTP (GET, POST, PUT, DELETE)
- Receber e validar dados de entrada
- Retornar respostas HTTP adequadas

Exemplo de responsabilidades:
- Listar produtos
- Buscar produto por ID
- Criar novo produto
- Atualizar produto existente
- Excluir produto


### Service

Camada responsável pela lógica de negócio da aplicação.

Funções principais:
- Centralizar regras de negócio
- Orquestrar chamadas ao repositório
- Evitar que regras fiquem acopladas ao controller

Essa camada garante maior organização, reutilização de código e facilita futuras manutenções.


### Repository

Responsável pela comunicação com o banco de dados.

Funções principais:
- Persistir dados
- Buscar registros
- Atualizar e remover entidades

Utiliza Spring Data JPA, o que reduz a necessidade de código SQL e facilita a implementação de operações básicas de CRUD.


### Model (Entity)

Representa as entidades do domínio da aplicação.

Funções principais:
- Mapear as tabelas do banco de dados
- Definir atributos e relacionamentos
- Utilizar anotações JPA para persistência

No projeto, a entidade principal que gera o Banco de dados é o Produto.


### Client (HTML)

O projeto possui páginas utilizam HTML, CSS e JavaScript localizadas na pasta `client/`.

Essas páginas permitem:
- Testar a criação de produtos
- Listar produtos cadastrados
- Interagir com a API de forma visual

Elas servem como apoio para testes manuais e demonstração do funcionamento da API.

##  Runner

A classe Runner é responsável por executar código automaticamente no momento da inicialização da aplicação.

Ela implementa a interface `CommandLineRunner` e é utilizada para inserir dados iniciais no banco de dados, facilitando testes e validações da API logo após a aplicação ser iniciada.

Essa classe tem finalidade de apoio ao desenvolvimento e não é indicada para uso em ambientes de produção.

## Banco de dados

O projeto utiliza SQLite como banco de dados local, facilitando a execução sem necessidade de configuração externa.

O arquivo de banco de dados é criado automaticamente ao executar a aplicação.

As configurações estão localizadas no arquivo `application.properties`.

## Endpoints da API

A API disponibiliza endpoints para operações CRUD e para consultas detalhadas de produtos, utilizando parâmetros via `@RequestParam` e `@PathVariable`.

### CRUD de produtos

| Método | Endpoint | Descrição |
|------|---------|----------|
| GET | `/produtos/{id}` | Busca um produto pelo ID |
| POST | `/produtos` | Cadastra um novo produto |
| PUT | `/produtos/{id}` | Atualiza um produto existente |
| DELETE | `/produtos/{id}` | Remove um produto |
| POST | `/produtos/salvarlista` | Salva uma lista de produtos |
| GET | `/produtos/contarTotal` | Retorna a quantidade total de produtos |


### Consultas por nome

| Endpoint | Descrição |
|---------|----------|
| `/produtos/buscarPorNome` | Busca por nome exato |
| `/produtos/buscarPorNomeContendo` | Busca por nome contendo |
| `/produtos/buscarPorNomeComecandoCom` | Busca por nome iniciando com |
| `/produtos/buscarPorNomeTerminandoCom` | Busca por nome terminando com |
| `/produtos/buscarPorNomeEStatus` | Busca por nome e status |


### Consultas por preço

| Endpoint | Descrição |
|---------|----------|
| `/produtos/buscarPorPreco` | Busca por preço exato |
| `/produtos/buscarPorPrecoMaiorQue` | Busca por preço maior que |
| `/produtos/buscarPorPrecoMenorQue` | Busca por preço menor que |
| `/produtos/buscarPorPrecoEStatus` | Busca por preço e status |
| `/produtos/buscarTotalPreco` | Retorna o valor total dos preços |

### Consultas por quantidade

| Endpoint | Descrição |
|---------|----------|
| `/produtos/buscarPorQuantidade` | Busca por quantidade exata |
| `/produtos/buscarPorQuantidadeMaiorQue` | Busca por quantidade maior que |
| `/produtos/buscarPorQuantidadeMenorQue` | Busca por quantidade menor que |


### Consultas por status

| Endpoint | Descrição |
|---------|----------|
| `/produtos/buscaPorStatus` | Busca por status |
| `/produtos/buscarPorStatusPadrao` | Busca por status padrão |
| `/produtos/buscarPorStatusNulo` | Busca por status nulo |

## Testes
Os testes da API foram realizados utilizando o Postman.
Foram testados:
- Criação de produtos (POST)
- Listagem de produtos (GET)
- Atualização de produtos (PUT)
- Exclusão de produtos (DELETE)
- Validação das respostas HTTP e dos dados retornados

Os testes foram feitos manualmente, garantindo o correto funcionamento dos endpoints.

## Melhorias futuras
- Testes automatizados com JUnit e Mockito
  
## Como executar o projeto

Clone o repositório:

```bash
git clone https://github.com/joaovictrorbarbosa/CRUDProdutosSpringboot.git

