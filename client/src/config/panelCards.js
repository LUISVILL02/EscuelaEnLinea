import { Icon } from "@chakra-ui/react";
import routes from "./routes";

import {
  FaUserGraduate,
  FaChalkboardTeacher,
  FaUserFriends,
  FaBookOpen,
  FaClipboardList,
  FaCalendarAlt,
} from "react-icons/fa";
import { SiMicrosoftexcel } from "react-icons/si";
import { MdFeedback, MdAssignment } from "react-icons/md";
import { BiSolidMessageSquareDetail } from "react-icons/bi";

export const panelCards = {
  PROFESOR: [
    {
      label: "Asistencias",
      href: routes.PROFESOR.ASSISTNCE,
      Icon: MdAssignment,
    },
    {
      label: "Observaciones",
      href: routes.PROFESOR.OBSERVATIONS,
      Icon: MdFeedback,
    },
    {
      label: "Notas",
      href: routes.PROFESOR.GRADE,
      Icon: SiMicrosoftexcel,
    },
    {
      label: "Mensajes",
      href: "/messages",
      Icon: BiSolidMessageSquareDetail,
    },
  ],
  ESTUDIANTE: [],
  ACUDIENTE: [
    {
      label: "Acudidos",
      href: routes.ACUDIENTE.STUDENTS,
      Icon: FaUserGraduate,
    },
    {
      label: "Citas",
      href: routes.ACUDIENTE.APPOINTMENT,
      Icon: FaCalendarAlt,
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
