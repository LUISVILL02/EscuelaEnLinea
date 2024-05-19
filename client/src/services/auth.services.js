import axios from "axios";
import { API_URL } from "./axios.interceptor";

const URL = API_URL + "/auth/login";

export const authenticate = async (credentials) => {
  return await axios.post(URL, credentials);
};
