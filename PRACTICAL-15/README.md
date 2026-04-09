# PRACTICAL-15: JWT-Based Authentication & Role Authorization

## Tech Stack

- Spring Boot 3
- Spring Security
- JWT (jjwt)
- Spring Data JPA
- MySQL database (`fsads52`)

## Default Users

- ADMIN: `admin` / `admin123`
- EMPLOYEE: `employee` / `employee123`

## Run

```bash
cd PRACTICAL-15
mvn spring-boot:run
```

## Login

`POST /login`

```json
{
  "username": "admin",
  "password": "admin123"
}
```

## Secured Endpoints

- `POST /admin/add` (ADMIN only)
- `DELETE /admin/delete` (ADMIN only)
- `GET /employee/profile` (EMPLOYEE and ADMIN)

Use header:
`Authorization: Bearer <token>`

## Postman Test Plan

1. Login as admin and employee, copy tokens.
2. Call `/admin/add` with admin token -> success.
3. Call `/admin/delete` with employee token -> forbidden.
4. Call `/employee/profile` with employee token -> success.
5. Call `/employee/profile` without token -> unauthorized.
6. Call `/employee/profile` with invalid token -> unauthorized.
