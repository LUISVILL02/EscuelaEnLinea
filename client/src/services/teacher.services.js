import axios from "axios";

export const createTeacher = async (teacher) => {
  return await axios.post("/auth/register/profesor", teacher);
};

export const getTeachers = async () => {
  return await axios.get("/profesor/all");
};

export const deleteTeacher = async (id) => {
  return await axios.delete(`/profesor/${id}`);
};
