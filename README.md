# Fasten-Your-Seatbelt-5
School project of team 5 at the university of applied sciences in Amsterdam

Database table users should contain the following at least.
Table : users
- id (Primary, auto increment)
- email (varchar)
- password (varchar)
- type (int)

Test user :
INSERT INTO `users` (`id`, `email`, `password`, `type`) VALUES
(1, 'rekoffer@test.com', '$2a$12$R7eVnSEnXCXtvrX0zNujc.KS2f1H/3sMYwJ8rXeMMj1xWSXPZQXc6', 1);
