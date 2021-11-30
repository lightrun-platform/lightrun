FROM amazon/aws-lambda-python

COPY requirements.txt .
COPY src/ .

# RUN apt-get update \
#   && apt-get install -y python3-pip python3-dev \
#   && cd /usr/local/bin \
#   && ln -s /usr/bin/python3 python \
#   && pip3 --no-cache-dir install --upgrade pip \
#   && pip install -r requirements.txt \
#   && rm -rf /var/lib/apt/lists/*
RUN pip install --upgrade pip \
    && pip install -r requirements.txt

CMD ["sample.main"]

