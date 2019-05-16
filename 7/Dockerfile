FROM python:3.6-alpine

RUN mkdir /app \
 && apk update \
 && apk add curl

COPY app.py /app
COPY requirements.txt /app

WORKDIR /app

RUN pip install -r requirements.txt

HEALTHCHECK --interval=5s --timeout=3s CMD curl -fail -s http://0.0.0.0:5000/ || exit 1

CMD ["python", "app.py"]
