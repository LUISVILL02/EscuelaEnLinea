import axios from "axios";

export const createAttendant = async (teacher) => {
  return await axios.post("/auth/register/acudiente", teacher);
};

export const getAttendant = async () => {
  return await axios.get("/acudiente");
};

export const deleteAttendant = async (id) => {
  return await axios.delete(`/acudiente/${id}`);
};
