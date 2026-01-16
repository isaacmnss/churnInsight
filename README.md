# ⚙️ ChurnInsight — API Backend

> API responsável por orquestrar o **modelo de Machine Learning de churn**, fornecer endpoints REST e servir dados para o frontend do **ChurnInsight**.

Este repositório representa o **núcleo da aplicação**, conectando o modelo de ML aos consumidores externos (frontend, testes e integrações), garantindo padronização, validação e escalabilidade.

---

## 🧩 Visão Geral da Arquitetura

O **ChurnInsight** é composto por três camadas principais:

| Camada          | Repositório                                                                                              | Responsabilidade                 |
|-----------------|----------------------------------------------------------------------------------------------------------|----------------------------------|
| 🖥️ Frontend    | [https://github.com/isaacmnss/churnInsight-frontend](https://github.com/isaacmnss/churnInsight-frontend) | Interface com o usuário          |
| ⚙️ API Backend  | [https://github.com/isaacmnss/churnInsight](https://github.com/isaacmnss/churnInsight)                   | Orquestração, regras e endpoints |
| 🧠 Modelo de ML | [https://github.com/isaacmnss/churnInsight-model](https://github.com/isaacmnss/churnInsight-model)       | Previsão de churn                |

A API atua como **ponte entre o frontend e o modelo de ML**, garantindo desacoplamento e organização.

---

## 🎯 Responsabilidades da API

A API é responsável por:

* 📥 Receber dados de clientes
* 🧪 Validar e normalizar entradas
* 🧠 Executar previsões de churn via modelo de ML
* 📊 Retornar probabilidades e classificações
* 📁 Persistir dados (quando aplicável)
* 📄 Expor documentação dos endpoints

---

## 🛠️ Tecnologias Utilizadas

* **Java 21**
* **Spring Boot**
* **Spring Web (REST)**
* **Spring Validation**
* **Spring Data JPA**
* **H2 / PostgreSQL** (configurável)
* **Lombok**
* **MapStruct**
* **Swagger / OpenAPI**
* **JUnit / Mockito** (testes)

---

## 📁 Estrutura do Projeto

```
src/
  main/
    java/
      application/
      domain/
         dto/
         entity/
      framework/
         adapters/
            in/
            out/
         exceptions/
         helper/
            config/    
    resources/
      db/migration/
      application.properties
  test/
```

---

## 🔌 Endpoints Principais

Exemplos de endpoints expostos pela API:

```http
POST /v1/prediction
GET  /v1/stats
GET  /actuator/health
```

Exemplo de request para previsão:

```json
{
  "CreditScore": 650,
  "Geography": "FRANCE",
  "Gender": "MALE",
  "Age": 35,
  "Tenure": 5,
  "Balance": 50000,
  "NumOfProducts": 1,
  "HasCrCard": 1,
  "IsActiveMember": 1,
  "EstimatedSalary": 50000,
  "Satisfaction_Score": 5,
  "Point_Earned": 500,
  "CardType": "SILVER"
}
```

Exemplo de response:

```json
{
  "prediction": 0,
  "churn_probability": 0.1,
  "risk_message": "string",
  "timeStamp": "2026-01-15T01:01:34.410Z"
}
```

---

## 🧠 Integração com o Modelo de ML

A API carrega o modelo treinado do repositório:

```
https://github.com/isaacmnss/churnInsight-model
```

Fluxo de integração:

1. API recebe dados via HTTP
2. Realiza validação e transformação
3. Executa o modelo de ML
4. Retorna a previsão ao consumidor

---

## 🧪 Dataset Utilizado

O modelo de ML consumido pela API foi treinado utilizando o dataset público:

🔗 [https://www.kaggle.com/datasets/radheshyamkollipara/bank-customer-churn](https://www.kaggle.com/datasets/radheshyamkollipara/bank-customer-churn)

> ⚠️ Dataset utilizado exclusivamente para fins educacionais e de demonstração.

---


## 🚀 Como Executar Localmente

### 1️⃣ Clonar o repositório

```bash
git clone https://github.com/isaacmnss/churnInsight.git
cd churnInsight
```

### 2️⃣ Configurar o projeto

Crie o arquivo `application.properties`:

```yaml
spring.application.name=ChurnInsight
spring.datasource.url=URL_DO_BANCO
spring.datasource.username=USER_DO_BANCO
spring.datasource.password=SENHA_DO_BANCO
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=validate
spring.flyway.enabled=true
spring.jackson.mapper.accept-case-insensitive-enums=true
management.endpoints.web.exposure.include=health,info
management.endpoint.health.show-details=when_authorized

```

### 3️⃣ Execute o modelo de ML

Para entender melhor como fazer isso, consulte a [documentação do modelo](https://github.com/isaacmnss/churnInsight-model)

### 4️⃣ Executar a aplicação

```bash
./mvnw spring-boot:run
```

A API ficará disponível em:

```
http://localhost:8080
```

### 5️⃣ Utilize Postman / UI para fazer as requisições 

Caso deseje utilizar o projeto com uma interface intuitiva, recomendamos consultar a 
[documentação do frontend](https://github.com/isaacmnss/churnInsight-frontend)

Mas você também pode utilizar o Postman nos seguintes endpoints

```http
POST /v1/prediction
GET  /v1/stats
GET  /actuator/health
```

---

## 📄 Documentação da API

A API disponibiliza documentação interativa via **Swagger/OpenAPI**:

```
http://localhost:8080/swagger-ui.html
```

---

## ❤️ Agradecimentos

Projeto desenvolvido no contexto de um **Hackathon** promovido por Alura e Oracle durante o bootcamp Oracle Next Education

Agradecimentos especiais ao restante dos membros da equipe:

### Data Scientists

- Pedro Camargo

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0A66C2?logo=linkedin&logoColor=white)](https://www.linkedin.com/in/pedrocamargo1/)
[![GitHub](https://img.shields.io/badge/GitHub-181717?logo=github&logoColor=white)](https://github.com/Pdrnho)

- Suellen Costa


[![GitHub](https://img.shields.io/badge/GitHub-181717?logo=github&logoColor=white)](https://github.com/suellensilva86)

- Antonio Sergio

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0A66C2?logo=linkedin&logoColor=white)](https://www.linkedin.com/in/asccjr/)
[![GitHub](https://img.shields.io/badge/GitHub-181717?logo=github&logoColor=white)](https://github.com/ASCCJR)

### Devs Backend

- Paulo Cruz

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0A66C2?logo=linkedin&logoColor=white)](https://www.linkedin.com/in/paulo-cruz-dev/)
[![GitHub](https://img.shields.io/badge/GitHub-181717?logo=github&logoColor=white)](https://github.com/PauloBrazilian)

- Isaaac Meneses

[![LinkedIn](https://img.shields.io/badge/LinkedIn-0A66C2?logo=linkedin&logoColor=white)](https://www.linkedin.com/in/isaac-meneses/)
[![GitHub](https://img.shields.io/badge/GitHub-181717?logo=github&logoColor=white)](https://github.com/isaacmnss)