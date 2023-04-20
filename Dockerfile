FROM postgres
ENV POSTGRES_PASSWORD docker
ENV POSTGRES_DB produksjonsplass 
COPY database/produksjonsplass.sql /docker-entrypoint-initdb.d/
