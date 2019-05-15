FROM ubuntu:18.04

ENV MESSAGE default message

COPY do-stuff.sh /

RUN chmod +x do-stuff.sh \
 && echo some other stuff

ENTRYPOINT ["/do-stuff.sh"]
CMD ["hello"]
