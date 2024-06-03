import routes from "./routes";

export const itemsNavbarData = {
  PROFESOR: [
    {
      label: "Panel",
      href: "/app",
    },
    {
      label: "Asistencias",
      href: "/assistance",
    },
    {
      label: "Observaciones",
      href: "/Remarks",
    },
    {
      label: "Mensajes",
      href: "/messages",
    },
  ],
  ESTUDIANTE: [],
  ACUDIENTE: [
    {
      label: "Panel",
      href: "/app",
    },
    {
      label: "Acudidos",
      href: "/attendees",
    },
  ],
  ADMIN: [
    {
      label: "Panel",
      href: routes.ADMIN.APP,
    },
    {
      label: "Estudiantes",
      href: routes.ADMIN.STUDENTS,
    },
    {
      label: "Profesores",
      href: routes.ADMIN.TEACHERS,
    },
    {
      label: "Acudientes",
      href: routes.ADMIN.ATTENDANTS,
    },
    {
      label: "Cursos",
      href: routes.ADMIN.COURSES,
    },
    {
      label: "Asignaturas",
      href: routes.ADMIN.SUBJECTS,
    },
  ],
};
