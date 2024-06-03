# Escuela en linea

## Descripción del Proyecto

Desarrollo de una aplicación web para la gestión escolar, utilizando Spring Boot en el backend y React en el frontend. La aplicación está diseñada para satisfacer las necesidades tanto de los alumnos como de sus acudientes y profesores, facilitando el proceso de matrícula y ofreciendo funcionalidades clave para la administración escolar.

## Funcionalidades Principales

1. **Matrícula de Alumnos**:
   - Registro de nuevos alumnos en el sistema.
   - Gestión de la información personal y académica de los alumnos.

2. **Consultas para Acudientes**:
   - **Notas**: Visualización de las calificaciones de los alumnos en tiempo real.
   - **Asistencia**: Consulta de la asistencia de los alumnos acudidos.
   - **Citas con Profesores**: Solicitud y programación de citas para discutir el progreso académico y resolver dudas.

## Tecnologías Utilizadas
- **Backend**: Spring boot <img src="https://www.armadilloamarillo.com/wp-content/uploads/spring-boot-ok.png" alt="Spring boot" width="100px" height="50px">

- **Frontend**: React <img src="https://cdn4.iconfinder.com/data/icons/logos-3/600/React.js_logo-1024.png" alt="React" width="50px" height="50px">

Esta aplicación web está diseñada para mejorar la gestión escolar y la comunicación entre todos los actores involucrados en el proceso educativo. Utilizando tecnologías modernas y enfocándonos en la experiencia del usuario, buscamos proporcionar una herramienta eficiente y efectiva para el manejo diario de las actividades escolares.


A continuación se muestra un resumen completo para la utilización la APi proporcionada que sirve recursos para un colegio.

## Empezar a usar los endpoints

Para comenzar a utilizar los endpoints de la API de EscuelaEnLinea, sigue los siguientes pasos:

1. **Obtener un TOKEN de acceso al iniciar sesion**: Necesitas una TOKEN de acceso que se válida para enviar solicitudes a los endpoints de la API. Puedes obtener tu TOKEN iniciando sesion en la api EscuelaEnLinea.
2. **Formato de respuesta en JSON**: La API devuelve las respuestas de las solicitudes en formato JSON. Cuando una solicitud a la API devuelve un error, se envía en la respuesta JSON como un mensaje de error.
    

## Autenticación

La API de EscuelaEnLinea utiliza autenticación con Bearer token.

- **Inicia sesion en la ai**: Puedes generar un TOKEN de acceso en la sección en EscuelaEnLinea.
- **Incluir el TOKEN en cada solicitud**: Debes incluir un TOKEN en cada solicitud a la API de EscuelaEnLinea usando en Authorization `Bearer token`.
    

### Respuesta de error de autenticación

Si falta, está mal formada o es inválido el TOKEN, recibirás un código de respuesta HTTP 401 Unauthorized.

## Endpoints

### Users

- Url base: `http://localhost:8010/EscuelaEnLinea/V.1.0.0/auth`

| Endpoint | Verbo | Url |
| ----- | ----- | ----- | 
| `Login` | <section style="color: yellow; text-align: center">Post</secction> | `/login` |
| `Registrar admin` | <section style="color: yellow; text-align: center">Post</secction> | `/register/administrador` |
| `Registrar profesor` | <section style="color: yellow; text-align: center">Post</secction> | `/register/profesor` |
| `Registrar acudiente` | <section style="color: yellow; text-align: center">Post</secction> | `/register/acudiente` |

### La documentación se irá realizando poco a poco.
