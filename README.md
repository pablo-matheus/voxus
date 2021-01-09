# Desafio

You’re the developer responsible for creating our payment posting system on the Voxus
platform. This system should allow our financial team to create, update, delete, and list all
payments directly through the platform.

1. Create the function that allows users to insert new payments at the platform.
The payment must contain a title, a value, a date, an external tax and comments.
A few rules must be applied before the record get inserted into the database:
  - Title must have between 5 and 100 characters;
  - Value must be a decimal value. Any non numeric value must not be
  accepted;
  - Date must be on the pattern Y-m-d (year-month-day);
  - External tax is a fixed value of 5% of the value of the payment and must be
  automatically calculated by your code;
  - The observations box can or cannot be filled by the user;

2. Create the function to list all the payments through the platform. All payment
posting data should be listed, displaying payment posting id, title, value, date,
external tax and comments.

3. On the list of payments, create a function that deletes the selected payment on
the click of a button.

4. Create a function to edit payments that were already inserted in the platform.
The same rules applied in the insertion should be considered on the editing feature.

5. Some payments are pre-saved on .xlsx files (a simple file from Excel) and our financial team
needs to be capable of uploading these files into the platform. The platform should accept
these files and save them into the database (use the .xlsx file “Arquivo base - Desafio Voxus”).

6. Create a function that allows the user to upload a .xlsx file and keep the file
saved in their project folder. No validation is needed, you just need the file uploaded
and saved into the project folder.

7. Change the behavior of the previous function to make your code read the
uploaded file and create a new record in the database from the provided information on
the file.

## Ambiente

Para que seja possível executar a aplicação é necessário:

- Docker e Docker Compose
- Java Development Kit 8
- Apache Maven
- IDE de preferência
- Browser de preferência

## Instruções de uso

- Inicializar banco de dados:

```
$ docker-compose up
```

> É necessário executar o comando na raiz do projeto...

- Para Inicializar o servidor é necessário executar a partir de sua IDE a classe `VoxusApplication` e 
acessar no browser a url `http://localhost:8080`.

## Observações

- Para mim a maior dificuldade foi em relação a importar o arquivo do Excel e gravá-lo no banco de dados, 
pois nunca havia feito algo semelhante. Nos demais desafios tive facilidade. 
