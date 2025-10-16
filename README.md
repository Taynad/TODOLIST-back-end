# 🛠️ TODO LIST – Back-end

Este é o **back-end** do projeto **TODO LIST**, desenvolvido com **Spring Boot**.
A aplicação implementa **autenticação segura com Spring Security e JWT**, permitindo que os usuários **façam login e gerenciem suas tarefas de forma protegida**.

O sistema foi integrado a um **front-end desenvolvido em HTML, CSS e JavaScript**, que consome os endpoints da API.

---

## 🚀 Tecnologias Utilizadas

* **Java 17+**
* **Spring Boot 3**
* **Spring Security**
* **JWT (JSON Web Token)**
* **Spring Web**
* **Spring Data JPA**
* **H2 Database** (banco em memória para testes)

---

## ⚙️ Funcionalidades

* ✅ Cadastro e autenticação de usuários
* ✅ Geração e validação de tokens JWT
* ✅ CRUD completo de tarefas (criar, listar, atualizar e excluir)
* ✅ Proteção de rotas com autenticação via token
* ✅ Organização em camadas (Controller, Service, Repository, DTO, Config)
---

## 🔐 Autenticação com JWT

A aplicação utiliza **Spring Security** para autenticação e autorização.
Após o login, é gerado um **token JWT**, que deve ser enviado no cabeçalho (`Authorization`) das requisições subsequentes.

### Exemplo de cabeçalho:

```
Authorization: Bearer seu_token_aqui
```

---

## 🌐 Endpoints Principais

### 🔸 Autenticação

| Método | Endpoint         | Descrição                       |
| :----- | :--------------- | :------------------------------ |
| `POST` | `/auth/register` | Cadastra um novo usuário        |
| `POST` | `/auth/login`    | Faz login e retorna o token JWT |

---

### 🔸 Tarefas

| Método   | Endpoint      | Descrição                                |
| :------- | :------------ | :--------------------------------------- |
| `GET`    | `/tasks`      | Lista todas as tarefas do usuário logado |
| `POST`   | `/tasks`      | Cria uma nova tarefa                     |
| `PUT`    | `/tasks/{id}` | Atualiza uma tarefa existente            |
| `DELETE` | `/tasks/{id}` | Remove uma tarefa                        |

> ⚠️ Todos os endpoints de tarefas requerem autenticação JWT.

---

## 🔗 Integração com o Front-end

O front-end deste projeto consome a API deste back-end.
👉 [TODO LIST - Front-end](https://github.com/Taynad/TODOLIST-front-end)

> Todas as requisições são feitas via **Fetch API**, enviando o token JWT no cabeçalho de autorização.

---

## 💡 Aprendizados

Durante o desenvolvimento, aprimorei meus conhecimentos em:

* **Autenticação e autorização com Spring Security**
* **JWT e segurança de APIs REST**
* **Camadas de aplicação e boas práticas com Spring Boot**
* **Integração entre front-end e back-end**

---

## 🧑‍💻 Autora

**Tayna dos Santos**
* 📍 Estudante de Análise e Desenvolvimento de Sistemas – Fatec Ferraz de Vasconcelos
* 💼 Foco em desenvolvimento back-end com **Java e Spring Boot**
* 🌐 [LinkedIn](https://www.linkedin.com/in/tayna-dos-santos-9b61b2219/)

