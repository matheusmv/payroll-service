FROM postgres:13-alpine

ENV POSTGRES_USER=admin
ENV POSTGRES_PASSWORD=1234567
ENV POSTGRES_DB=db_hr_worker

COPY ./docker/config/create-db-worker.sql /docker-entrypoint-initdb.d/
RUN chmod a+r /docker-entrypoint-initdb.d/*

EXPOSE 5432