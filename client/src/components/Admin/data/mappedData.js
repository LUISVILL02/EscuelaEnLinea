export const mapCourseData = (data) => {
  return data?.map((item) => ({
    value: item.idCurso,
    label: item.nombre,
  }));
};

export const mapTeacherData = (data) => {
  return data?.map((item) => ({
    value: item.idUser,
    label: item.nombre + " " + item.apellido,
  }));
};
