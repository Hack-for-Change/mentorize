# Mentorize
Unimos aprendizes de todas as idades a educadores dedicados, em um ambiente onde o ensino e o aprendizado são recompensadores e de graça para sempre.

---

# Documentação
``` 
https://documenter.getpostman.com/view/14838966/2s9YJdXNkt
```
## Tecnologias 
``` 
- Java 17
- Spring Boot 3.1.4
- Maven 4.0.0
- Postgres 42.6.0
- Docker 24.0.4
- docker-compose 1.29.2
```

## Rodar a aplicação

Para testar nossa aplicação siga os seguintes passos:

```sql
>> Clone o repositorio em : 
git clone https://github.com/Hack-for-Change/mentorize.git

>> Em seu terminal:
docker-compose up -d

>> Conforme documentação a aplicação estará disponivel em http://localhost:8080/
Para o teste completo, faça o import de nossa coleção disponivel em:
https://github.com/Hack-for-Change/mentorize/tree/master/src/main/java/com/api/mentorize/documentations/Mentorize.postman_collection.json
```

Opcional: para rodar o pgAdmin:

```sql
docker run -d --network pg_network -p 5050:5050 --name pgadmin-container -e PGADMIN_DEFAULT_EMAIL=user@example.com -e PGADMIN_DEFAULT_PASSWORD=SuperSecretPassword dpage/pgadmin4
```
