# 📚 Sistema de Biblioteca em Java

Projeto desenvolvido em **Java** utilizando o padrão **MVC (Model–View–Controller)**, com interface gráfica em **Swing**, acesso a banco de dados via **JDBC** e versionamento utilizando **Git e GitHub**.

---

## 🎯 Objetivo do Projeto

O objetivo deste projeto é desenvolver um sistema simples de biblioteca que permita:

- Cadastrar autores
- Cadastrar livros
- Editar livros
- Excluir livros
- Relacionar livros a seus respectivos autores
- Listar registros em uma interface gráfica

O projeto foi desenvolvido como atividade acadêmica, com foco em:
- Organização de código
- Aplicação do padrão MVC
- Trabalho colaborativo com GitHub

---

## 🛠️ Tecnologias Utilizadas

- **Java**
- **Swing (Interface Gráfica)**
- **JDBC**
- **MySQL**
- **Git**
- **GitHub**

---

## 🧱 Arquitetura do Projeto

O sistema segue o padrão **MVC**, dividido da seguinte forma:

### 📦 Model
Responsável por representar as entidades do sistema.
- `Autor`
- `Livro`

### 📦 DAO
Responsável pelo acesso ao banco de dados.
- `AutorDAO`
- `AutorDAOImpl`
- `LivroDAO`
- `LivroDAOImpl`

### 📦 Controller
Responsável pela regra de negócio e comunicação entre View e DAO.
- `AutorController`
- `LivroController`

### 📦 View
Responsável pela interface gráfica do sistema.
- `BibliotecaView`
- `AutorView`
- `LivroView`

### 📦 Util
Responsável pela conexão com o banco de dados.
- `ConnectionFactory`

---

## 📂 Estrutura de Pastas

```bash

src/
├── model/
│ ├── Autor.java
│ └── Livro.java
│
├── dao/
│ ├── AutorDAO.java
│ ├── AutorDAOImpl.java
│ ├── LivroDAO.java
│ └── LivroDAOImpl.java
│
├── controller/
│ ├── AutorController.java
│ └── LivroController.java
│
├── util/
│ └── ConnectionFactory.java
│
├── view/
│ ├── BibliotecaView.java
│ ├── AutorView.java
│ └── LivroView.java
│
docs/
└── DiagramaClasses.png
```

---


## 🗄️ Banco de Dados

### Script de Criação do Banco

```sql
CREATE DATABASE sistema_biblioteca;
USE sistema_biblioteca;

CREATE TABLE autor (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL
);

CREATE TABLE livro (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    ano INT NOT NULL,
    autor_id INT,
    FOREIGN KEY (autor_id) REFERENCES autor(id) ON DELETE CASCADE
);
```
--- 
## 🚀 Como Executar o Projeto
### Clone o repositório:

* git clone https://github.com/Joao-P-Diniz/Gestao-Biblioteca.git

* Configure o banco de dados MySQL

* Ajuste as credenciais em ConnectionFactory

* Execute a classe BibliotecaView

* Utilize a interface gráfica para gerenciar autores e livros

## 👥 Autores

Projeto desenvolvido em dupla:

`João Pedro`
Responsável pelo Back-end, Models, DAOs, Controllers e Conexão com Banco de Dados.

`Lucas Bezerra`
Responsável pela Interface Gráfica (Swing), Integração View ↔ Controller e Documentação.