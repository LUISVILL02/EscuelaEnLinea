import axios from "axios";

export const createSubject = async (subject) => {
  return await axios.post("/asignatura", subject);
};

export const getSubjects = async () => {
  return await axios.get("/asignatura");
};

export const getSubjectById = async (id) => {
  return await axios.get(`/asignatura/${id}`);
};

export const deleteSubject = async (id) => {
  return await axios.delete(`/asignatura/${id}`);
};
