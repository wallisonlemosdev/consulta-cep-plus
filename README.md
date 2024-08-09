# Padrões de Projeto com Spring Boot

## Descrição do Projeto

Este projeto é uma evolução significativa de um projeto simples desenvolvido como parte do desafio "Design Patterns com Java: Dos Clássicos (GoF) ao Spring Framework" oferecido pela DIO. Ele exemplifica a aplicação prática dos padrões de projeto **Singleton**, **Strategy** e **Facade** em uma aplicação Spring Boot.

O objetivo é demonstrar como esses padrões podem ser utilizados para criar uma arquitetura robusta e flexível, facilitando a manutenção e evolução do código. A aplicação realiza operações básicas de CRUD para a entidade `Cliente`, integrando-se a um serviço externo (ViaCep) para obtenção de informações de endereço.

## Evoluções e Melhorias

Este projeto é uma evolução significativa de um desafio anterior do DIO. As principais melhorias implementadas incluem:

- **Atualização do Java**: A versão do Java foi atualizada de 11 para 21, aproveitando as novas funcionalidades e melhorias de desempenho.
- **Atualização do Spring Boot**: O projeto original utilizava o Spring Boot 2.5, que foi atualizado para a versão 3.3.2, garantindo maior compatibilidade e acesso às últimas funcionalidades do Spring.
- **Tratamento de Erros e Exceções**: Foram adicionados tratamentos de erro robustos e implementações de exceções, melhorando a segurança e a experiência do usuário.
- **Melhoria de Código**: Diversos trechos do código foram refinados para seguir boas práticas de programação, resultando em um código mais limpo, eficiente e fácil de manter.
- **Validação e DTOs:** Foram criados DTOs (Data Transfer Objects) para validar as solicitações de entrada e melhorar a estrutura do código. O ClienteRequestDTO é utilizado para a criação e atualização de clientes, garantindo que os dados recebidos estejam corretos e completos.

## Padrões de Projeto Implementados

| Padrão    | Descrição                                                                                                                                     |
|-----------|-----------------------------------------------------------------------------------------------------------------------------------------------|
| Singleton | Garante que uma classe tenha apenas uma instância em toda a aplicação. Implementado em serviços Spring através da anotação `@Service`.        |
| Strategy  | Permite definir uma família de algoritmos, encapsulando-os em classes separadas, e tornando-os intercambiáveis. Aplicado em `ClienteService`. |
| Facade    | Fornece uma interface simplificada para interações complexas com subsistemas. Implementado na classe `ClienteController`.                     |

## Tecnologias Utilizadas

| Tecnologia                     | Versão   | Descrição                                                                                                    |
|--------------------------------|----------|--------------------------------------------------------------------------------------------------------------|
| Java                           | 21       | A versão mais recente do Java, trazendo novas funcionalidades e melhorias de desempenho.                     |
| Spring Boot                    | 3.3.2    | Framework para simplificação do desenvolvimento de aplicações Java.                                          |
| Spring Data JPA                | -        | Implementação de repositórios JPA com o Spring Data.                                                         |
| Spring Cloud OpenFeign         | 2023.0.3 | Utilizado para comunicação com APIs externas, como o serviço ViaCep.                                         |
| H2 Database                    | -        | Banco de dados em memória utilizado para simplificação de testes e desenvolvimento local.                    |
| Lombok                         | -        | Biblioteca que reduz a verbosidade do código Java, gerando automaticamente getters, setters, e construtores. |
| Spring Boot Starter Validation | -        | Adiciona suporte para validação de beans, facilitando a aplicação de restrições e validações nos DTOs.       |

## Tratamento de Erros e Boas Práticas

A aplicação segue boas práticas de codificação e tratamento de erros:

- **Tratamento de Erros**: Utiliza o padrão `ResponseEntity` do Spring para retornar respostas HTTP apropriadas em todas as operações CRUD.
- **Documentação**: Código documentado com Javadoc para melhorar a clareza e facilitar a manutenção futura.
- **Arquitetura Modular**: O projeto está estruturado para permitir fácil manutenção e extensão, com implementação de padrões de projeto que favorecem a reutilização e a substituição de componentes.

## Como Executar o Projeto

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/padroes-de-projeto-spring.git


2. **Navegue até o diretório do projeto:**
   ```bash
   cd padroes-de-projeto-spring

3. **Execute o projeto com o Maven:**
   ```bash
   mvn spring-boot:run

4. **Acesse a API:**

| Operação                 | Método HTTP | URL                                 | Corpo Exemplo                                       |
|--------------------------|-------------|-------------------------------------|-----------------------------------------------------|
| Buscar todos os clientes | GET         | http://localhost:8080/clientes      | -                                                   |
| Buscar cliente por ID    | GET         | http://localhost:8080/clientes/{id} | -                                                   |
| Inserir um novo cliente  | POST        | http://localhost:8080/clientes      | `{"nome": "João", "endereco": {"cep": "12345678"}}` |
| Atualizar um cliente     | PUT         | http://localhost:8080/clientes/{id} | -                                                   |
| Atualizar um cliente     | DELETE      | http://localhost:8080/clientes/{id} | -                                                   |

## Considerações Finais
Este projeto é um exemplo prático de como combinar padrões de projeto clássicos com o poder do Spring Boot para construir aplicações escaláveis e de fácil manutenção.
A aplicação demonstra a importância de boas práticas de codificação, incluindo tratamento adequado de erros, retornos consistentes e uma arquitetura bem estruturada.

---

### Desenvolvido por [Wallison Lemos](https://www.linkedin.com/in/wallisonlemosdev/)

[![LinkedIn Badge](https://img.shields.io/badge/Connect-blue?style=flat-square&logo=LinkedIn&logoColor=white)](https://www.linkedin.com/in/wallisonlemosdev/)
