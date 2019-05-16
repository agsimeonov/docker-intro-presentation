FROM java

COPY ./postgress-boot/target/postgress-0.0.1-SNAPSHOT.jar /
COPY ./wait-for-it.sh /

CMD [ "/bin/bash", "-c", "/wait-for-it.sh ${POSTGRES_HOST}:5432 -- java -jar /postgress-0.0.1-SNAPSHOT.jar"]
