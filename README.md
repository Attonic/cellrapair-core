# CellRapair-Core

Back-end para um sistema de **Ordem de Serviço de Reparo de Celulares**, desenvolvido com Java e arquitetura baseada em APIs REST.

Projeto focado em organização, boas práticas, escalabilidade e estrutura profissional para aplicações Spring Boot.

---
![Java](https://img.shields.io/badge/Java-21-007396?logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.3-6DB33F?logo=springboot&logoColor=white)
![MySQL](https://img.shields.io/badge/MySQL-8.0-4479A1?logo=mysql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-2496ED?logo=docker&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.9+-C71A36?logo=apachemaven&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-green)

## Visão Geral


O **CellRAPair-Core** é a API principal responsável por:

- Cadastro e consulta de **clientes**
- Registro de **aparelhos** (marca, modelo, IMEI, etc.)
- Criação, atualização e acompanhamento de **ordens de serviço** (OS)
- Controle de **peças** utilizadas nas ordens
- Gestão de **técnicos**
- Registro de **anexos** nas ordens de serviço
- Autenticação via **JWT**
- Documentação automática da API (Springdoc OpenAPI / Swagger)


Este projeto representa o núcleo do sistema (core), responsável por toda a regra de negócio.

---

## Tecnologias Utilizadas

- **Java 17+**
- **Spring Boot**
- **Spring Data JPA**
- **Hibernate**
- **Maven**
- **PostgreSQL / MySQL**
- **Lombok**
- **Validation API**
- **Git & GitHub**

---

## Estrutura do Projeto
```
cellrepair-core/
├── .mvn/                   # Maven Wrapper (arquivos de suporte)
├── docker/                 # Arquivos de configuração Docker (Dockerfile, compose)
├── docs/                   # Documentação do projeto (requisitos, diagramas)
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── io/github/cellrepair/
│   │   │       ├── controller/   # Camada de exposição (API Rest)
│   │   │       ├── service/      # Camada de regras de negócio
│   │   │       ├── repository/   # Camada de persistência (Interfaces JPA)
│   │   │       ├── model/        # Classes de dados
│   │   │       │   ├── entity/   # Entidades do Banco de Dados
│   │   │       │   └── enums/    # Tipos enumerados
│   │   │       └── config/       # Configurações do Spring (Security, Beans)
│   │   └── resources/
│   │       ├── application.yml   # Configurações da aplicação
│   │       └── data.sql          # Scripts de inicialização (opcional)
│   └── test/                     # Testes unitários e de integração
├── pom.xml                       # Dependências e build do Maven
├── mvnw                          # Script executável do Maven (Linux/macOS)
├── mvnw.cmd                      # Script executável do Maven (Windows)
└── README.md                     # Guia principal do projeto
```

## Arquitetura

O projeto segue o padrão em camadas:

- **Controller** → Camada de entrada (REST)
- **Service** → Regras de negócio
- **Repository** → Acesso ao banco (JPA)
- **Entity** → Modelos de dados
- **DTO** → Transferência de dados
- **Config** → Configurações da aplicação

## Documentação da API

Após iniciar o projeto:

- http://localhost:8080/swagger-ui.html
- http://localhost:8080/v3/api-docs


## Autores

O projeto CellRepair Core é um projeto feito pela Equipe de alunos de Universidade Estadual do Maranhão:

- **Antonio Cleison**  
  Autor principal e mantenedor  
  [GitHub: @Attonic](https://github.com/Attonic)

- **João Vinícius**  
  Contribuições no desenvolvimento  
  [GitHub: @Xiriuu](https://github.com/Xiriuu)

- **Wallisson**  
  Contribuições no desenvolvimento Banco de Dados  
  [GitHub: @r3df0x35](https://github.com/r3df0x35)


## Licença

Este projeto está licenciado sob a Licença MIT.

MIT License

Copyright (c) 2026 Antonio Cleison

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
---
