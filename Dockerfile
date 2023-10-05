# docker network create pg_network
# docker build -f Dockerfile -t mentorize-local .
# docker run -d --network pg_network -p 5432:5432 -v $(pwd):/mentorize/ mentorize
FROM postgres:latest

ENV POSTGRES_DB mentorize
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD postgres

COPY init.sql /docker-entrypoint-initdb.d/

EXPOSE 5432