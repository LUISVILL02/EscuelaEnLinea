import axios from "axios";

export const createAttendant = async (teacher) => {
  return await axios.post("/auth/register/acudiente", teacher);
};

export const getAttendant = async () => {
  return await axios.get("/acudiente/all");
};

export const deleteAttendant = async (id) => {
  return await axios.delete(`/acudiente/${id}`);
};
