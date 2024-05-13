export const parseName = (name) => {
  return (name?.charAt(0).toUpperCase() + name?.slice(1))?.split(" ")[0];
};

export const parseRole = (rol) => {
  const roles = {
    teacher: "Profesor",
    student: "Estudiante",
    attendant: "Acudiente",
    admin: "Administrador",
  };

  return roles[rol];
};
