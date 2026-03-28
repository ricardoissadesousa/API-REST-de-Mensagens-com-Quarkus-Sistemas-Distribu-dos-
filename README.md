# ✉️ API REST de Mensagens com Quarkus (Sistemas Distribuídos)

## 📝 Resumo do Projeto
O projeto **API REST de Mensagens** é uma aplicação back-end desenvolvida em Java utilizando o framework Quarkus. A atividade propõe a criação de um sistema simples de troca de mensagens entre processos distribuídos, utilizando a especificação JAX-RS para expor endpoints HTTP. 

O armazenamento dos dados é realizado em memória (sem uso de banco de dados neste momento). O objetivo principal é compreender na prática o roteamento de requisições, o encapsulamento de dados em formato JSON e o mapeamento dos métodos HTTP (GET, POST, DELETE) dentro de uma arquitetura REST.

---

## 🚀 Funcionalidades Principais e Endpoints

A API gerencia os seguintes endpoints na rota base `/mensagens`:

### 📥 Envio de Mensagem (POST)
- **Rota:** `POST /mensagens`
- **Descrição:** Recebe um JSON com remetente e conteúdo, gera um ID sequencial e um *timestamp* automático, e salva na lista em memória. Retorna o status `201 Created`.

### 📋 Listagem de Mensagens (GET)
- **Rota:** `GET /mensagens`
- **Descrição:** Retorna um array JSON com todas as mensagens armazenadas atualmente no servidor. Retorna o status `200 OK`.

### 🔍 Busca por ID (GET)
- **Rota:** `GET /mensagens/{id}`
- **Descrição:** Busca uma mensagem específica pelo seu identificador. Retorna `200 OK` em caso de sucesso ou `404 Not Found` caso o ID não exista.

### 🗑️ Remoção por ID (DELETE)
- **Rota:** `DELETE /mensagens/{id}`
- **Descrição:** Remove uma mensagem da memória com base no identificador fornecido. Retorna `200 OK` se removido com sucesso ou `404 Not Found` caso o ID seja inválido.

---

## 🛠 Tecnologias Utilizadas

### 💻 Linguagem, Frameworks e Ferramentas
- **Java (JDK 17+)**
- **Quarkus Framework**: Para a criação rápida e otimizada da aplicação.
- **JAX-RS (RESTEasy Classic)**: Especificação utilizada para criar os endpoints REST e definir as rotas (`@Path`, `@GET`, `@POST`, etc.).
- **Jackson**: Biblioteca responsável pela serialização e desserialização automática entre objetos Java e formato JSON.
- **Maven**: Gerenciador de dependências e build do projeto.
- **Postman**: Utilizado como Cliente HTTP para testar as requisições e respostas da API.

---

## 📂 Organização de Pastas (Padrão MVC Adaptado)

A estrutura do projeto está organizada em pacotes para separar as responsabilidades:

```text
sistema-mensagens/
├── src/main/java/br/com/sistema/
│   ├── model/                 # Representação dos dados
│   │   └── Mensagem.java
│   ├── repository/            # Armazenamento em memória (Regra de Negócio)
│   │   └── MensagemRepository.java
│   └── controller/            # Exposição dos endpoints REST (JAX-RS)
│       └── MensagemController.java
└── pom.xml                    # Configurações do Maven
```
## 🧪 Testes com Cliente HTTP (Postman)

Abaixo estão as evidências de teste dos endpoints, validando os respectivos status HTTP:

### 1. Criação de Mensagem (Status 201 Created)
> **[ INSIRA AQUI O SEU PRINT DO POSTMAN MOSTRANDO O POST E O STATUS 201 ]**
![Print 201 Created](caminho-da-imagem/print-201.png)

### 2. Busca Bem-sucedida (Status 200 OK)
> **[ INSIRA AQUI O SEU PRINT DO POSTMAN MOSTRANDO O GET COM ID 1 E O STATUS 200 ]**
![Print 200 OK](caminho-da-imagem/print-200.png)

### 3. ID Inexistente (Status 404 Not Found)
> **[ INSIRA AQUI O SEU PRINT DO POSTMAN MOSTRANDO O GET COM ID 999 E O STATUS 404 ]**
![Print 404 Not Found](caminho-da-imagem/print-404.png)
