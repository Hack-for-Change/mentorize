# docker build -f Dockerfile -t mentorize-local .
# docker run -p 5432:5432 -v $(pwd):/mentorize/ mentorize-local
FROM postgres:latest

ENV POSTGRES_DB mentorize
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD postgres

COPY init.sql /docker-entrypoint-initdb.d/

EXPOSE 5432