
# 📋 ToDoList - API de Gerenciamento de Tarefas

Este projeto foi desenvolvido por @Gbquintela e @ovitudev, com o objetivo de atender à demanda proposta pelo professor Djalma.
Trata-se de uma API completa para gerenciamento de tarefas com sistema de usuários, desenvolvida utilizando Java 17 e Spring Boot.
Vale destacar que nosso foco principal está no backend. O frontend atual é apenas um recurso adicional, construído com auxílio de IAs, e ainda precisa ser refatorado para funcionar corretamente.

---

## 🚀 Tecnologias Utilizadas

- **Backend:** Spring Boot 3.x, Java 17, Hibernate, Lombok  
- **Frontend:** HTML5, CSS3, JavaScript  
- **Banco de Dados:** MySQL 8.x  
- **Documentação:** Swagger UI  

---

## 📦 Como Executar

### ✅ Pré-requisitos

- Java JDK 17+  
- Maven 3.6+  
- MySQL 8.x  

### 🔧 Instalação

```bash
git clone https://github.com/Gbquintela/to-do-list.git
cd to-do-list
```

Configure seu banco de dados em `src/main/resources/application.properties`:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/todo_db
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

Execute o projeto:

```bash
mvn spring-boot:run
```

---

## 🌐 Documentação da API

Acesse a documentação Swagger em:

🔗 [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 📌 Endpoints Disponíveis

### 👤 Usuários

| Método | Endpoint         | Descrição             |
|--------|------------------|------------------------|
| POST   | `/user/register` | Registrar novo usuário |

### 📝 Tarefas

| Método | Endpoint             | Descrição              |
|--------|----------------------|-------------------------|
| POST   | `/task/create`       | Criar nova tarefa       |
| GET    | `/task/findAllTask`  | Listar todas as tarefas |
| GET    | `/task/findTask/{id}`| Buscar tarefa por ID    |
| PUT    | `/task/update/{id}`  | Atualizar tarefa        |
| DELETE | `/task/delete/{id}`  | Deletar tarefa          |
| DELETE | `/task/delete/all`   | Deletar todas tarefas   |

---

## 🏗️ Estrutura do Projeto

```
MyToDoList/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/to_do_list/
│       │       ├── controller/   # Controladores REST
│       │       ├── dto/          # Objetos de transferência
│       │       ├── entity/       # Entidades JPA
|       |       ├── enums         # Enumerados das entidades
│       │       ├── repository/   # Repositórios
│       │       └── service/      # Lógica de negócio
│       └── resources/
│           ├── static/           # Frontend (opcional)
│           └── application.properties
├── pom.xml
└── README.md
```
---

## 🤝 Como Contribuir

1. Faça um fork do projeto  
2. Crie uma nova branch:  
   ```bash
   git checkout -b feature/sua-feature
   ```
3. Commit suas alterações:  
   ```bash
   git commit -m 'Adiciona nova feature'
   ```
4. Faça push para a branch remota:  
   ```bash
   git push origin feature/sua-feature
   ```
5. Abra um Pull Request
