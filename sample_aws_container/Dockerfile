FROM amazon/aws-lambda-python

COPY requirements.txt .
COPY src/ .

RUN pip install --upgrade pip \
    && pip install -r requirements.txt

CMD ["sample.main"]

