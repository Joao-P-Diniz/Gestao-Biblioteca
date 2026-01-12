# 📚 Sistema de Biblioteca em Java

Projeto desenvolvido em **Java** utilizando o padrão **MVC (Model–View–Controller)**, com interface gráfica em **Swing**, acesso a banco de dados via **JDBC** e versionamento utilizando **Git e GitHub** desenvolvido por João Pedro e Lucas Bezerra,no período 2025.2.

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
## Capturas de Telas
<p>Tela inicial</p>
<img width="302" height="198" alt="Captura de tela 2026-01-12 141128" src="https://github.com/user-attachments/assets/e8762dee-6d44-4441-876d-a776c361dff7" />
<p>Tela de cadastrar Autor</p>
<img width="388" height="200" alt="Captura de tela 2026-01-12 141146" src="https://github.com/user-attachments/assets/53f4e4b5-55ac-4e47-b623-33107a509afc" />
<p>Tela de Lista de autores</p>
<img width="490" height="299" alt="Captura de tela 2026-01-12 141207" src="https://github.com/user-attachments/assets/64d9adba-f60c-40ec-a777-af8cece76b65" />
<p>Tela de cadastrar Livro</p>
<img width="598" height="347" alt="Captura de tela 2026-01-12 141238" src="https://github.com/user-attachments/assets/15f77be6-a444-409b-9053-c3571ac40d27" />

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
