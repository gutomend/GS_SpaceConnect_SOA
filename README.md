# 🚀 ARES – Autonomous Rover Exploration System

## 🌎 Global Solution 2026 – FIAP
### Disciplina: SOA & Web Services

---

# 👥 Integrantes

| Nome | RM |
|--------|--------|
| Augusto Mendonça | RM 558371 |
| Gabriel Vasquez | RM 557056 |
| Gustavo Oliveira | RM 559163 |

---

# 📖 Sobre o Projeto

O **ARES (Autonomous Rover Exploration System)** é uma solução desenvolvida para o desafio da **Global Solution FIAP**, inserida no contexto da nova Economia Espacial.

O projeto tem como objetivo simular um sistema de monitoramento autônomo para rovers espaciais, permitindo o registro de telemetrias, análise automática de dados operacionais e geração de alertas em situações críticas.

A solução busca reproduzir parte dos processos utilizados em missões espaciais reais, onde veículos autônomos operam em ambientes hostis e precisam reportar continuamente seu estado operacional para centros de controle.

---

# 🎯 Problema

Em missões de exploração espacial, os rovers coletam constantemente informações do ambiente e do próprio equipamento.

Esses dados precisam ser:

- Armazenados de forma segura;
- Processados em tempo real;
- Monitorados continuamente;
- Transformados em informações relevantes para tomada de decisão.

Sem um sistema de monitoramento eficiente, situações críticas podem passar despercebidas, colocando em risco a missão.

---

# 💡 Solução Proposta

O ARES fornece uma API REST capaz de:

- Cadastrar Rovers;
- Registrar Telemetrias;
- Armazenar histórico operacional;
- Gerar alertas automaticamente;
- Disponibilizar informações através de Web Services;
- Persistir dados em banco PostgreSQL.

O sistema analisa automaticamente dados como:

- Temperatura;
- Radiação;
- Velocidade;

e gera alertas quando limites pré-definidos são ultrapassados.

---

# 🏗️ Arquitetura da Solução

A aplicação foi desenvolvida seguindo uma arquitetura em camadas:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
PostgreSQL
```

### Camadas

#### Controller
Responsável por expor os endpoints REST da aplicação.

#### Service
Contém as regras de negócio e análise de telemetria.

#### Repository
Responsável pela comunicação com o banco de dados.

#### Database
Persistência dos dados utilizando PostgreSQL.

---

# 🛠️ Tecnologias Utilizadas

| Tecnologia | Versão |
|------------|---------|
| Java | 21 |
| Spring Boot | 3.x |
| Spring Data JPA | 3.x |
| PostgreSQL | 17 |
| Maven | 3.x |
| Swagger/OpenAPI | 2.x |
| Lombok | Última |
| Hibernate | Integrado ao Spring |

---

# 📂 Estrutura do Projeto

```text
src/main/java
│
├── controller
│   ├── RoverController
│   ├── TelemetriaController
│   └── AlertaController
│
├── dto
│   ├── RoverDTO
│   ├── TelemetriaDTO
│   └── AlertaDTO
│
├── entity
│   ├── Rover
│   ├── Telemetria
│   └── Alerta
│
├── enums
│   ├── StatusRover
│   └── NivelAlerta
│
├── exception
│   ├── RoverNotFoundException
│   └── GlobalExceptionHandler
│
├── repository
│   ├── RoverRepository
│   ├── TelemetriaRepository
│   └── AlertaRepository
│
├── service
│   ├── RoverService
│   ├── TelemetriaService
│   ├── AlertaService
│   │
│   └── impl
│       ├── RoverServiceImpl
│       ├── TelemetriaServiceImpl
│       └── AlertaServiceImpl
│
└── vo
    └── Coordenada
```

---

# 🧠 Regras de Negócio

O sistema realiza análise automática das telemetrias recebidas.

## Temperatura

```java
if (telemetria.getTemperatura() > 80)
```

Gera:

```text
Alerta Crítico
```

---

## Radiação

```java
if (telemetria.getRadiacao() > 7)
```

Gera:

```text
Alerta Alto
```

---

## Velocidade

```java
if (telemetria.getVelocidade() > 40)
```

Gera:

```text
Alerta Médio
```

---

# 📊 Modelo de Dados

## Rover

| Campo | Tipo |
|---------|---------|
| id | Long |
| nome | String |
| modelo | String |
| nivelBateria | Double |
| status | StatusRover |
| latitude | Double |
| longitude | Double |
| ultimaComunicacao | LocalDateTime |

---

## Telemetria

| Campo | Tipo |
|---------|---------|
| id | Long |
| temperatura | Double |
| radiacao | Double |
| velocidade | Double |
| dataRegistro | LocalDateTime |

---

## Alerta

| Campo | Tipo |
|---------|---------|
| id | Long |
| descricao | String |
| nivel | NivelAlerta |
| dataGeracao | LocalDateTime |

---

# 🔗 Relacionamentos

```text
Rover
 │
 ├── 1:N Telemetria
 │
 └── 1:N Alerta
```

---

# 📡 Endpoints da API

## Rover

### Criar Rover

```http
POST /rovers
```

### Listar Rovers

```http
GET /rovers
```

### Buscar Rover

```http
GET /rovers/{id}
```

### Atualizar Rover

```http
PUT /rovers/{id}
```

### Remover Rover

```http
DELETE /rovers/{id}
```

---

## Telemetria

### Registrar Telemetria

```http
POST /telemetrias
```

### Listar Telemetrias

```http
GET /telemetrias
```

---

## Alertas

### Listar Alertas

```http
GET /alertas
```

---

# 🗄️ Banco de Dados

O sistema utiliza PostgreSQL para persistência dos dados.

Tabelas criadas automaticamente pelo Hibernate:

```text
TB_ROVER
TB_TELEMETRIA
TB_ALERTA
```

---

# 📄 Documentação Swagger

Após iniciar a aplicação:

```text
http://localhost:8080/swagger-ui/index.html
```

A documentação da API poderá ser acessada diretamente pelo navegador.

---

# ▶️ Como Executar

## 1. Clonar o Projeto

```bash
git clone https://github.com/seu-repositorio.git
```

---

## 2. Configurar Banco PostgreSQL

Criar banco:

```sql
CREATE DATABASE ares_db;
```

---

## 3. Configurar application.properties

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/ares_db
spring.datasource.username=postgres
spring.datasource.password=senha

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

---

## 4. Executar

```bash
mvn spring-boot:run
```

---

# 📸 Evidências

## Cadastro de Rover

Print do Swagger.
<img width="1440" height="900" alt="evidencia_01_swagger" src="https://github.com/user-attachments/assets/8b434b8d-0665-491a-9837-033c08b37935" />

---

## Registro de Telemetria

Print do Swagger.
<img width="720" height="852" alt="evidencia_04_telemetria" src="https://github.com/user-attachments/assets/4c1fdf28-8e25-4875-9768-66412e437735" />

---

## Geração de Alertas

Print do endpoint:
<img width="720" height="852" alt="evidencia_05_alertas" src="https://github.com/user-attachments/assets/34eee87b-a336-4a75-80e1-90ee0f821c35" />

```http
GET /alertas
```

---

## Banco PostgreSQL

Prints das tabelas:

```sql
SELECT * FROM tb_rover.
<img width="1440" height="852" alt="evidencia_06_postgres_rover" src="https://github.com/user-attachments/assets/7c44a6da-c3a0-43bb-9181-6fa4bd6cb115" />
---
SELECT * FROM tb_telemetria.
<img width="1440" height="852" alt="evidencia_07_postgres_telemetria" src="https://github.com/user-attachments/assets/85a30d46-11f1-4e40-8f14-301131671002" />
---
SELECT * FROM tb_alerta.
<img width="1440" height="852" alt="evidencia_08_postgres_alerta" src="https://github.com/user-attachments/assets/a79e46b5-6bd4-4b8f-bb97-eebc0a2ed3fb" />

```
---
# 📸 Diagramas

## 1. UML
<img width="648" height="541" alt="UML" src="https://github.com/user-attachments/assets/409abf5e-766a-4478-95e2-74c28b6dcede" />

---
## 1. Fluxo
<img width="667" height="437" alt="Fluxo" src="https://github.com/user-attachments/assets/d2ec4fa6-1e7a-4502-8895-3ef8bb8acea3" />

---

# 🌌 Conclusão

O ARES demonstra a aplicação prática de conceitos de SOA e Web Services em um cenário alinhado à Economia Espacial.

A solução integra APIs REST, persistência de dados, monitoramento autônomo e geração automática de alertas, simulando operações que podem ser utilizadas em missões de exploração espacial baseadas em sistemas robóticos autônomos.

---

## 🚀 FIAP – Global Solution 2026

**ARES – Autonomous Rover Exploration System**
