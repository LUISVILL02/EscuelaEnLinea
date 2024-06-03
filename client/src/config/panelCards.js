import routes from "./routes";

import {
  FaUserGraduate,
  FaChalkboardTeacher,
  FaUserFriends,
  FaBookOpen,
  FaClipboardList,
} from "react-icons/fa";

export const panelCards = {
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
      label: "Estudiantes",
      href: routes.ADMIN.STUDENTS,
      Icon: FaUserGraduate,
    },
    {
      label: "Profesores",
      href: routes.ADMIN.TEACHERS,
      Icon: FaChalkboardTeacher,
    },
    {
      label: "Acudientes",
      href: routes.ADMIN.ATTENDANTS,
      Icon: FaUserFriends,
    },
    {
      label: "Cursos",
      href: routes.ADMIN.COURSES,
      Icon: FaBookOpen,
    },
    {
      label: "Asignaturas",
      href: routes.ADMIN.SUBJECTS,
      Icon: FaClipboardList,
    },
  ],
};
