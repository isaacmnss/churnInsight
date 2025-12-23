# 🧩 Guia de Desenvolvimento — Projeto

Este README é temporário e dedicado exclusivamente aos **desenvolvedores do projeto**.  
Ele descreve como devemos trabalhar com **branches**, **commits** e **Pull Requests** durante o desenvolvimento.

Quando o sistema estiver mais maduro, este arquivo será substituído pela documentação oficial do projeto.

---

## 🗂️ Estrutura de Pastas

```
src/
  main/
    java/
      controller/
      service/
      repository/
      dto/
      entity/
    resources/
      db/migration/
      static/
      templates/
      application.properties
  test/
```

## ⚙️ Variáveis de ambiente

As variáveis de credenciais (chave de API, senha e usuário de banco dados) devem ficar .env

O .env deve ser criado localmente e **JAMAIS** deve ser adicionado ao git (sempre .gitignore)

### Exemplo: 

```properties
DB_USER= usuario-banco
DB_PASSWORD= senha-banco
DB_HOST= host-banco
DB_NAME= nome-banco
API_KEY= chave-api 
```
---

## 🚧 Estrutura de Branches

O projeto seguirá a seguinte organização:

    main
    ↓
    develop
    ↓
    feature/<nome-da-feature>

### 🔹 main
- Contém a **versão estável** do projeto.
- **É terminantemente proibido fazer push direto para `main`.**
- Somente recebe código via Pull Request aprovado e revisado.

### 🔹 develop
- Branch onde todo o desenvolvimento se integra.
- Recebe PRs de `feature/*`.
- Apenas após validação é feito o merge para `main`.

### 🔹 feature/*
- Branches criadas para desenvolvimento de funcionalidades, correções ou melhorias.
- Formato recomendado: `feature/nome-descritivo`.

Exemplos:
- `feature/cadastro-de-medico`
- `feature/ajuste-endpoint-agendamentos`

---

## 🌱 Como criar uma feature

Sempre inicie sua feature a partir da branch **develop**:

```bash
git checkout develop
git pull
git checkout -b feature/nome-da-feature
```
---
## ✍️ Padrão de Commits

- Os commits devem ser claros, explicativos e objetivos.
- Evite commits genéricos como "ajustes" ou "update".

Use um padrão descritivo, como:

```
feat: implementa criação de endpoint 
fix: corrige validação de service (nome do service)
refactor: melhora lógica do serviço de autenticação
docs: adiciona documentação da API
test: adiciona testes para o repositório de (nome do repositório)
```
### Recomendações

- Escreva no imperativo → "adiciona", "corrige", "remove"
- Commits pequenos e frequentes são bem-vindos

---

## 🔀 Pull Requests

### Regras gerais:

1. **Nunca faça push para main.**

2. Toda feature deve gerar um PR da sua branch feature/* → develop.

3. O PR deve ter:

    - título descritivo

    - descrição do que foi feito

## ✔️ Fluxo de Trabalho (Resumo)

1. Criar branch a partir de develop

2. Desenvolver → commits claros

3. Abrir Pull Request para develop

4. Revisão + ajustes (se necessário)

5. Merge para develop

6. Periodicamente, develop é integrado à main via PR

Se tiver dúvidas sobre o fluxo de trabalho ou sobre padrões de código, fale com o time antes de abrir PR.