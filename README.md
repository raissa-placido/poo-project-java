# POO Project - Sistema de Controle de Chamados Técnicos

Este repositório contém uma implementação em Java de um sistema simples
de controle de chamados técnicos, usado para demonstrar conceitos de
Programação Orientada a Objetos (POO).

**Visão geral**
- **Propósito:** Gerenciar usuários, técnicos e chamados, incluindo
	prioridades e status de atendimento.
- **Linguagem:** Java

**Estrutura do projeto**
- [Cadastro.java](Cadastro.java) — gerencia cadastros de pessoas.
- [Chamado.java](Chamado.java) — modelo que representa um chamado.
- [ChamadoService.java](ChamadoService.java) — lógica de negócio para chamados.
- [ICadastro.java](ICadastro.java) — interface para operações de cadastro.
- [IChamadoService.java](IChamadoService.java) — interface de serviço de chamados.
- [Main.java](Main.java) — classe de entrada (exemplo de execução).
- [Pessoa.java](Pessoa.java) — classe base para pessoas.
- [Prioridade.java](Prioridade.java) — enumeração de prioridades de um chamado.
- [Status.java](Status.java) — enumeração dos status de um chamado.
- [Tecnico.java](Tecnico.java) — representação de um técnico.
- [Usuario.java](Usuario.java) — representação de um usuário.

Modelos principais
- `Pessoa`: classe base com informações comuns (nome, matricula, etc.).
- `Usuario`: representa o solicitante do chamado.
- `Tecnico`: representa o responsável pelo atendimento.
- `Chamado`: contém dados do chamado (descrição, prioridade, status,
	autor, técnico atribuído, datas).
- `Prioridade` e `Status`: enums que definem valores possíveis.

Serviços e interfaces
- `ChamadoService` / `IChamadoService`: operações para criar, atualizar e listar chamados.
- `Cadastro` / `ICadastro`: operações para registrar e obter pessoas.

Como compilar e executar
1. Compile todos os arquivos Java:

```bash
javac *.java
```

2. Execute a aplicação de exemplo (classe `Main`):

```bash
java Main
```

Exemplo de fluxo de uso
1. Registrar um `Usuario` e um `Tecnico` via `Cadastro`.
2. Criar um `Chamado` com titulo e descrição, gerando assim um ID do chamado.
3. O `Tecnico` atribui a ele o `Chamado` e atualiza o `Status` conforme o atendimento avança.
