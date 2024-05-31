export const courseData = [
  {
    name: "nombre",
    label: "Nombre  del curso",
    type: "text",
    validationRules: {
      required: "El nombre es obligatorio",
    },
  },
  {
    name: "idProfesor",
    label: "Profesor del curso",
    type: "select",
    validationRules: {
      required: "El profesor es obligatorio",
    },
  }
];