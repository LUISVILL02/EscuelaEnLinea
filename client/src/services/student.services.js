import axios from "axios";

export const createAlumno = async (alumno) => {
  return await axios.post("/alumno", alumno);
};

export const getAlumnos = async ({ queryKey }) => {
  return await axios.get(`/alumno?start=${queryKey[1]}&limit=${queryKey[2]}`);
};

export const deleteAlumno = async (id) => {
  return await axios.delete(`/alumno/${id}`);
};

export const updateAlumno = async (data) => {
  console.log("service: ", data, " ", "id ", data.idAlumno);
  const dataR = await axios.put(`/alumno/${data.idAlumno}`, data);
  console.log("data", dataR);
  return dataR;
}

export const getAlumnoPorAcudiente = async (id) => {
  return await axios.get(`/alumno/acudiente/${id}`);
}
