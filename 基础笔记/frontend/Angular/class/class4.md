# Login

http://localhost:4200/login
Login Component 
    -> Login service
    -> account/password post to Server, validate, generate token in the backend 
    <- token JWT.IO
    -> store token in localStorage(do not need to be sent in each communication)/sessionStorage/Cookie

EX.

a. if entering localhost:4200/movie
    1. anyone can go
b. if entering localhost:4200/my/movie
    1. if user has a GOOD token
c. if entering localhost:4200/admin/movie
    1. if user has a GOOD token
    2. if user have access to specific pag (e.g.: admin page)  

postman email Antra300#