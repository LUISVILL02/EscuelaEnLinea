import axios from "axios";

export const authenticate = async (credentials) => {
  return await axios.post("/auth/login", credentials);
};
