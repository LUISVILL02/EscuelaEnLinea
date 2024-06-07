import routes from "./routes";

export const itemsNavbarData = {
  PROFESOR: [
    {
      label: "Panel",
      href: routes.PROFESOR.APP,
    },
    {
      label: "Asistencias",
      href: routes.PROFESOR.ASSISTNCE,
    },
    {
      label: "Observaciones",
      href: routes.PROFESOR.OBSERVATIONS,
    },
    {
      label: "Notas",
      href: routes.PROFESOR.GRADE,
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
      href: routes.ACUDIENTE.APP,
    },
    {
      label: "Acudidos",
      href: routes.ACUDIENTE.STUDENTS,
    },
    {
      label: "Citas",
      href: routes.ACUDIENTE.APPOINTMENT,
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
