import axios from "axios";

export const createAlumno = async (alumno) => {
  console.log("service",alumno);
  const data = await axios.post("/alumno", alumno);
  console.log("service",data);	
  return data;
};

export const getAlumnos = async ({ queryKey }) => {
  return await axios.get(`/alumno?start=${queryKey[1]}&limit=${queryKey[2]}`);
};

export const deleteAlumno = async (id) => {
  return await axios.delete(`/alumno/${id}`);
};

export const updateAlumno = async (id, alumno) => {
  return await axios.put(`/alumno/${id}`, alumno);
}

export const getAlumnoPorAcudiente = async (id) => {
  return await axios.get(`/alumno/acudiente/${id}`);
}
