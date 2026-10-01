## Aula: Construindo um Avaliador de Senhas em Java

Este projeto é o exercício prático da aula **"Construindo um Avaliador de Senhas em Java"**, voltada para estudantes de Ciência da Computação que estão aprendendo os fundamentos da linguagem: `if`, `for`, arrays, métodos e retorno antecipado (early return).

> ⚠️ **Observação importante**: este é um exercício didático de lógica de programação. Ele **não** é um validador de senhas adequado para produção — não faz hashing, não cobre todas as boas práticas de segurança e não deve ser usado para proteger credenciais reais.

### Objetivo da aula

Implementar o método `static String avaliarSenha(String senha)`, que recebe uma senha (sempre fictícia, nunca real) e retorna uma mensagem de acordo com a primeira regra que ela não cumprir, ou uma mensagem de sucesso se passar em todas.

### Conceitos praticados

- Estruturas condicionais (`if`) e retorno antecipado de um método
- Laços `for` tradicionais e `for-each`
- Percorrer caracteres de uma `String` com `charAt(i)`
- Arrays de `String` como listas de valores conhecidos
- Métodos utilitários da classe `Character`: `isDigit`, `isUpperCase`
- Comparação de strings com `.equals()` (em vez de `==`)

### Passo a passo da lógica implementada

O método [`avaliarSenha`](/e:/windows/Java/ValidaSenhaForte/src/App.java:22) verifica as regras **nesta ordem**, retornando assim que encontra o primeiro problema:

1. **Tamanho mínimo**: se a senha tiver menos de 8 caracteres, retorna uma dica pedindo mais caracteres.
2. **Presença de número**: percorre a senha com `for` e `Character.isDigit()`; se não houver nenhum dígito, retorna uma dica.
3. **Senha comum/óbvia**: compara a senha (com `for-each` e `.equals()`) contra a lista `{"12345678", "senha123", "admin123"}`; se houver correspondência, retorna um alerta.
4. **Letra maiúscula** (missão extra proposta em aula): percorre a senha com `Character.isUpperCase()`; se não houver nenhuma letra maiúscula, retorna uma dica específica.
5. **Sucesso**: se a senha passar por todas as regras anteriores, retorna a mensagem de sucesso.

### Demonstração no `main`

O método `main` em [`App.java`](/e:/windows/Java/ValidaSenhaForte/src/App.java) testa o avaliador com um array de senhas **fictícias**, cada uma exercitando um resultado diferente:

| Senha fictícia | Regra que falha / resultado |
|---|---|
| `batata` | menos de 8 caracteres |
| `semnumero` | sem nenhum número |
| `senha123` | senha comum/óbvia |
| `segredo123` | sem letra maiúscula |
| `Segredo123` | sucesso (passa em todas as regras) |

### Como compilar e executar

O arquivo-fonte usa acentuação (português), então é importante compilar informando a codificação UTF-8:

```powershell
javac -encoding UTF-8 -d bin src\App.java
java -cp bin App
```

Se os acentos aparecerem corrompidos no terminal do Windows, ajuste a codificação do console antes de rodar:

```powershell
chcp 65001
java -Dstdout.encoding=UTF-8 -cp bin App
```

### Saída esperada

```
Senha: batata -> DICA: A senha deve ter no mínimo 8 caracteres.
Senha: semnumero -> DICA: Adicione pelo menos um número à sua senha.
Senha: senha123 -> ALERTA: Esta senha é muito comum ou óbvia.
Senha: segredo123 -> DICA: Adicione pelo menos uma letra maiúscula à sua senha.
Senha: Segredo123 -> SUCESSO: Sua senha passou pelos critérios básicos!
```

### Sugestões de exercícios para os alunos

- Adicionar uma nova regra (por exemplo, exigir um caractere especial) seguindo o mesmo padrão de retorno antecipado.
- Permitir que o usuário digite uma senha fictícia via `Scanner` em vez de usar apenas o array de testes.
- Refatorar cada regra para um método separado (ex.: `temNumero(String senha)`), reforçando o conceito de decomposição em métodos.

## Estrutura do projeto (padrão VS Code Java)

O workspace segue a estrutura padrão de projetos Java no VS Code:

- `src`: pasta com o código-fonte (`App.java`)
- `lib`: pasta para dependências (não utilizada neste exercício)
- `bin`: pasta onde os arquivos compilados (`.class`) são gerados

> Para customizar essa estrutura, edite `.vscode/settings.json`.

## Gerenciamento de dependências

A view `JAVA PROJECTS` do VS Code permite gerenciar dependências do projeto. Mais detalhes [aqui](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
