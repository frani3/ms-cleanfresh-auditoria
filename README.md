# ms-cleanfresh-auditoria

Microservicio de auditoría de Clean&Fresh Manager. Spring Boot 4.1.1 / Java
21, puerto **8085**. En la entrega 2 es un **esqueleto**: devuelve una
respuesta fija, sin base de datos y sin llamar a otros servicios. El registro
real de acciones y accesos denegados se implementa en la siguiente entrega.

Se consume únicamente a través del BFF (`ms-cleanfresh-bff`, ruta
`/api/auditoria`, solo rol Admin). No valida JWT: confía en que solo el BFF le
habla.

Proyecto individual de **DSY1107 Cloud Native 1** (DuocUC).

## Endpoints

| Método | Ruta | Descripción |
|---|---|---|
| GET | `/api/auditoria` | Eventos de auditoría (datos fijos de ejemplo) |

Respuesta (misma forma que usa hoy la pestaña "Registro de auditoría" del
panel Admin): una lista de `{ "time", "actor", "action", "level" }`, con
`level` en `info`, `warn` o `error`.

## Requisitos

- Java 21 (`JAVA_HOME` apuntando a un JDK 21)

## Levantar en local

```powershell
.\mvnw.cmd spring-boot:run
```

O compilar y correr el jar:

```powershell
.\mvnw.cmd clean package
java -jar target\ms-cleanfresh-auditoria-0.0.1-SNAPSHOT.jar
```

Corre en `http://localhost:8085`. Probar: `curl http://localhost:8085/api/auditoria`.

## Arquitectura y decisiones técnicas

Ver [`CLAUDE.md`](CLAUDE.md) y, en el repo del frontend,
`EP2/ARQUITECTURA.md`.

## Docker

`Dockerfile` multi-etapa (Maven + JDK 21 para compilar, JRE 21 sin root para correr). Se configura solo por variables de entorno.

```bash
docker build -t cleanfresh/auditoria .
docker run -p 8085:8085 cleanfresh/auditoria
```

Los 5 microservicios se levantan juntos con el `docker-compose.yml` de `EP2/despliegue/` en el repo `cleanfresh-frontend`.
