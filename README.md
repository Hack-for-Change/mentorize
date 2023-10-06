# Mentorize

 <div align="center">
<img src="https://i.imgur.com/u7kIgzo.png" alt="logo"></div>
<br>

> Nossa equipe se uniu na hackathon "Hack for Change" para criar uma plataforma educacional inovadora na cidade em desenvolvimento Embu-Guaçu. Optamos pela área da Educação e desenvolvemos uma plataforma onde recém-formados podem ganhar experiência valiosa ao oferecer aprendizado gratuito. Utilizamos Java para o backend, assegurando robustez, JavaScript e CSS para um frontend amigável, e o Docker para eficiência na implantação. Estamos empolgados em contribuir para o desenvolvimento educacional na cidade e nossa paixão pela inovação nos motiva a continuar trabalhando para um futuro melhor.

## 💻 Pré-requisitos

Antes de começar, verifique se você atendeu aos seguintes requisitos:

* Você instalou a versão mais recente do `Docker`
* Você leu <a href="https://documenter.getpostman.com/view/14838966/2s9YJdXNkt"> a documentação do backend</a> e o nosso <a href="">pdf de apresentação</a>.
---

## Documentação Backend
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
- JavaScript (ECMAScript 6)
```

## Rodar a aplicação

Para testar nossa aplicação siga os seguintes passos:

```sql
>> Clone o repositorio em : 
git clone https://github.com/Hack-for-Change/mentorize.git

>> Em seu terminal:
docker-compose up -d

>> Para o teste completo, faça o import de nossa coleção disponivel em:
https://github.com/Hack-for-Change/mentorize/tree/master/src/main/java/com/api/mentorize/documentations/Mentorize.postman_collection.json

>> Frontend:
localhost:3000

>> Backend:
localhost:8080
```

Opcional: para rodar o pgAdmin:

```sql
docker run -d --network pg_network -p 5050:5050 --name pgadmin-container -e PGADMIN_DEFAULT_EMAIL=user@example.com -e PGADMIN_DEFAULT_PASSWORD=SuperSecretPassword dpage/pgadmin4
```
---
## 🤝 Equipe

Conheça o nosso time:

<table>
  <tr>
    <td align="center">
      <a href="#">
        <img src="https://media.licdn.com/dms/image/D4D35AQFDqHYmZeWgFw/profile-framedphoto-shrink_200_200/0/1695017830532?e=1697155200&v=beta&t=mxy2Fxt3X6omSG9tmbcOA-AQCcjGuQjy039zIab0v5c" width="100px;" alt="Foto do Iuri Silva no GitHub"/><br>
        <sub>
          <b>Tomaz Pontes</b><br>
          <b>Front-end</b><br><br>
          <a href="https://www.linkedin.com/in/tomaz-pontes/?locale=pt_BR">Linkedin</a>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="#">
        <img src="https://media.licdn.com/dms/image/D4E03AQEfk3HPDXY_Cw/profile-displayphoto-shrink_200_200/0/1691527141182?e=1701907200&v=beta&t=8xcFNIBevnWsG5fCmkQuIQIdYSIbjvHXJXbLhaXYaX8" width="100px;" alt="Foto do Mark Zuckerberg"/><br>
        <sub>
          <b>Thaís Martins</b><br>
          <b>Back-end</b><br><br>
          <a href="https://www.linkedin.com/in/thcamposmartins/">Linkedin</a>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="#">
        <img src="https://media.licdn.com/dms/image/D4D35AQFRoORFb_p_tg/profile-framedphoto-shrink_200_200/0/1687332432224?e=1697155200&v=beta&t=P_Ai70xDf7A_PP9q5PUsjazLS-yRjef9YucyDTxRQ-o" width="100px;" alt="Foto do Iuri Silva no GitHub"/><br>
        <sub>
          <b>Heloisa Botelho</b><br>
          <b>UX/UI</b><br><br>
          <a href="https://www.linkedin.com/in/heloisabotelhoc/">Linkedin</a>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="#">
        <img src="https://media.licdn.com/dms/image/C4E03AQHTOQSqTQViLg/profile-displayphoto-shrink_200_200/0/1652916858155?e=1701907200&v=beta&t=9nZ1M0C0EVTFdc1QgHmW4QLl6wZL1AfI8F9F-1lmrM8" width="100px;" alt="Foto do Iuri Silva no GitHub"/><br>
        <sub>
          <b>Paulo Alexandre</b><br>
          <b>Business/Pitch</b><br><br>
          <a href="https://www.linkedin.com/in/tomaz-pontes/?locale=pt_BR">Linkedin</a>
        </sub>
      </a>
    </td>
    <td align="center">
      <a href="#">
        <img src="https://media.licdn.com/dms/image/D4D03AQHGwmFZSr1sfg/profile-displayphoto-shrink_200_200/0/1680578321414?e=1701907200&v=beta&t=sQQ4MLjy9ytuuw5HjvB7uETYrG8d9DP078anHV09OrE" width="100px;" alt="Foto do Iuri Silva no GitHub"/><br>
        <sub>
          <b>Matheus Borges</b><br>
          <b>Pesquisa</b><br><br>
          <a href="https://www.linkedin.com/in/matheus-borges-2208/">Linkedin</a>
        </sub>
      </a>
    </td>
  </tr>
</table>
