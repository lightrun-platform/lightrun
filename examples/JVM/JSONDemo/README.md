# JSON Demo

This is a simple demo that let's me show off different JSON libraries and how they work. 

Create a new user:

```bash
curl -X PUT -H "Content-Type: application/json" -d '{"login":"shai","password":"123456"}' http://localhost:8080/addUser
```

Login:

```bash
curl -X POST -H "Content-Type: application/json" -d '{"login":"shai","password":"123456"}' -H "type: jackson" http://localhost:8080/auth
```

Adding data to the DB:

```bash
curl -X POST -H "Content-Type: application/json" -H "Authorization: 45971c45-4049-48f8-970f-04d47be2defc" -d '[{"coreData":[20,22,22,22,33,44]}]' http://localhost:8080/create
```
