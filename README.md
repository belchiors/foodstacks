# Foodstacks REST API

API REST para aplicação web de uma vitrine virtual, destinada a comunidade acadêmica do CIn-UFPE, busca oferecer uma solução prática e simples, tanto para aqueles que buscam vender seus produtos, quanto para quem os procura, e ao mesmo tempo, promover uma integração entre essa comunidade.

## Configurando

Antes de executar o projeto é necessário definir as variáveis de ambiente de desenvolvimento conforme os comandos listados abaixo, lembrando que é preciso ter o JDK em sua última versão e o MongoDB instalado localmente.

Substitua `<username>` e `<password>` pelo nome de usuário e senha do banco de dados (MongoDB) instalado na sua máquina.

No Linux, Mac e Linux Subsystem for Windows:
```
export SPRINGBOOT_ENVIRONMENT="development"
export MONGODB_LOCAL_URI="mongodb+srv://<username>:<password>@localhost/foodstacksdb"
```

No Windows CMD, usar `set` ao invés de `export`:
```
set SPRINGBOOT_ENVIRONMENT=development
set MONGODB_LOCAL_URI=mongodb+srv://<username>:<password>@localhost/foodstacksdb
```

No PowerShell, use `$env`:
```
$env:SPRINGBOOT_ENVIRONMENT="development"
$env:MONGODB_LOCAL_URI="mongodb+srv://<username>:<password>@localhost/foodstacksdb"
```

## Executando

Após ter definido as variáveis de ambiente conforme os passos acima, exetute o seguinte comando na raiz do projeto:

```
./mvnw spring-boot:run
```

Após isso, se não houver nenhum erro, o projeto deverá estar sendo executando normalmente em sua máquina local.