# Plugin Terremoto

Um simples plugin para Spigot/Paper que adiciona um comando para agendar um reinício (restart) do servidor após um contador, simulando um evento de "terremoto".

## ✨ Funcionalidades

- **Contador para Reinício**: Inicia uma contagem regressiva de 5 minutos para reiniciar o servidor.
- **Anúncios Globais**: Envia mensagens de aviso para todos os jogadores em intervalos configurados (minutos, 30s, 10s, 5s, etc.).
- **Mensagem de Kick Personalizada**: Antes de reiniciar, todos os jogadores são desconectados com uma mensagem customizada, informando sobre o reinício.
- **Sistema de Permissão**: O comando principal é protegido por uma permissão, garantindo que apenas administradores possam usá-lo.
- **Seguro e Confiável**: Previne a execução de múltiplos contadores simultaneamente e cancela a tarefa de reinício caso o plugin seja desabilitado.

---

## 🚀 Comandos e Permissões

### Comando

- `/terremoto`
  - **Descrição**: Inicia a contagem regressiva de 5 minutos para o reinício do servidor.
  - **Uso**: `/terremoto`

### Permissão

- `terremoto.use`
  - **Descrição**: Permite que o jogador ou grupo execute o comando `/terremoto`.
  - **Padrão**: `OP` (Operadores do servidor).

---

## 🔧 Instalação

1.  Baixe a versão mais recente do plugin (o arquivo `.jar`).
2.  Coloque o arquivo `Terremoto-1.0.jar` na pasta `plugins/` do seu servidor.
3.  Reinicie ou carregue o servidor. O plugin será ativado automaticamente.

---

## ⚙️ Configuração

Atualmente, o plugin não possui um arquivo `config.yml`. As principais configurações, como o tempo do contador (5 minutos) e as mensagens, estão definidas diretamente no código.

**Mensagem de Kick:**

```
Rede FullDev

Servidor se encontra em RR, por favor aguarde.
Já estaremos online
```

---

## 🛠️ Compilando a partir do código-fonte (Opcional)

Se desejar modificar o plugin, você pode compilá-lo usando o Apache Maven.

1.  Clone este repositório.
2.  Navegue até a pasta raiz do projeto pelo terminal.
3.  Execute o comando:
    ```bash
    mvn clean install
    ```
4.  O arquivo `.jar` compilado estará na pasta `target/`.

---

<p align="center">
  Desenvolvido com ❤️ por Nin
</p>
