# 📧 Email Sender API

API REST desenvolvida em **Java com Spring Boot** para envio de e-mails de forma segura, escalável e organizada, utilizando **Arquitetura Hexagonal**, **Spring Boot Mail**, **Rate Limiting** e **Testes Unitários**.

---

## 🚀 Funcionalidades

- ✅ Envio de e-mails via SMTP
- ✅ Arquitetura Hexagonal (Ports & Adapters)
- ✅ Rate Limiting (limite de requisições por cliente/IP)
- ✅ Testes Unitários com JUnit e Mockito
- ✅ Validação de entrada com Bean Validation
- ✅ Separação clara de responsabilidades (domínio isolado)

---

## 🛠️ Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot**
- **Spring Boot Mail**
- **Spring Web**
- **Arquitetura Hexagonal**
- **JUnit 5**
- **Mockito**
- **Maven**
- **Rate Limit Filter / Interceptor**

---

## 📂 Estrutura do Projeto (Hexagonal)

```bash
src/main/java/com/seuprojeto/emailsender
│
├── aplication
│   ├── entity
│   ├── exception
│   ├── ports
│   │   └── input
│   └── usecase
│
├── adapter
│     └── input
│           └── controller
│   
│       
│
├── infrastructure
│   ├── configuration
│   ├── ratelimit
│   └── secutiry config
│
└── EmailSenderApplication.java
```
---
## Configure o SMTP no application.properties
```
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=seuemail@gmail.com
spring.mail.password=suasenha
spring.mail.properties.mail.smtp.auth=true
```
📌 Recomendado usar variáveis de ambiente em produção.

---
## 📩 Endpoint Principal
Enviar E-mail: 
POST /email
```
Request Body (JSON)
{
    "email": "quemenvia@email.com",
    "assunto": "Olá!",
    "mensagem": "Este é um email enviado pela API."
}
```

---
## ⏳ Rate Limiting
A API possui limitador de requisições para evitar abusos.

Exemplo:
- Máximo: 5 requisições por minuto.
- Identificação por IP
```
Headers retornados:
X-Rate-Limit-Limit: 5
X-Rate-Limit-Remaining: 3

Caso ultrapasse:
HTTP/ 429 Too Many Requests
```

---
## 🧪 Testes Unitários
Os testes são feitos com:
- JUnit 5
- Mockito
- Spring Boot Test 

Executar os testes:
```
mvn test
```
Exemplo de testes:
- Serviço de envio de e-mail
- Controller REST
- Validações
- Rate Limit Filter
---
## ▶️ Executando a Aplicação
Rodar localmente:
```
mvn spring-boot:run
```
Aplicação disponível em:
```
http://localhost:8080
```
---
Projeto de uso livre. sinta-se livre para usar e modificar.
