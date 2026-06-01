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

Inserir print do Swagger.

---

## Registro de Telemetria

Inserir print do Swagger.

---

## Geração de Alertas

Inserir print do endpoint:

```http
GET /alertas
```

---

## Banco PostgreSQL

Inserir prints das tabelas:

```sql
SELECT * FROM tb_rover;

SELECT * FROM tb_telemetria;

SELECT * FROM tb_alerta;
```

---

# 🌌 Conclusão

O ARES demonstra a aplicação prática de conceitos de SOA e Web Services em um cenário alinhado à Economia Espacial.

A solução integra APIs REST, persistência de dados, monitoramento autônomo e geração automática de alertas, simulando operações que podem ser utilizadas em missões de exploração espacial baseadas em sistemas robóticos autônomos.

---

## 🚀 FIAP – Global Solution 2026

**ARES – Autonomous Rover Exploration System**
