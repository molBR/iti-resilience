# Circuit Breaker & Fallback Method

##Requisitos
* Java 8
* Kotlin
* Docker
* Doker-compose



## Inicialização
* Rodar a aplicação com `mvn spring-boot:run`

* Rodar `docker-compose up -d`

### Curl

```$xslt
curl --location --request GET 'localhost:8080/bears'
```

## Explicação
O intuito deste repositório é demonstrar uma POC utilizando Resiliencia com Kotlin, redis e wiremock.

O programa simula a consulta de uma API que retorna o objeto `Bear`:

```json
{
     "name": "Pooh Bear",
     "weight": "100KG",
     "color": "yellow",
     "id": "101"
}
```
Então este objeto é salvo no `Redis`.
Caso a aplicação apresente falha a aplicação procura o objeto dentro do Redis, retornando caso ele exista.

Para fazer esta simulação basta editar o arquivo `mappngs/test.json` retornar 200 na primeira chamada, editar para um retorno de erro (basta mudar o status code para 500) e fazer a mesma chamada novamente. Desta forma o objeto continuará sendo retornado uma vez que ele foi salvo no redis.




Para mais explicações: LINK DO MEDIUM


####Importante:
* Escolheu-se manter o stack trace para fins didáticos, importante deixar claro que para uma aplicação produtiva, não é uma boa ideia manter o stack trace para o retorno do objeto json.

* Como objetivo é mostrar na prática o uso de circuit breakers e estratégia de fallback, este README não entra em detalhe na implementação do código. Caso seja de curiosidade, abra uma issue manifestando o interesse.