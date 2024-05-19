import axios from "axios";

const baseUrl = "http://localhost:8010";
const projectName = "EscuelaEnLinea";
const version = "V.1.0.0";
export const API_URL = `${baseUrl}/${projectName}/${version}`;

export const AxiosInterceptor = () => {
  const updateHeader = (req) => {
    return req;
  };

  axios.interceptors.request.use((req) => {
    return updateHeader(req);
  });

  axios.interceptors.response.use(
    (res) => {
      return res.data;
    },
    (err) => {
      // Si la respuesta tiene un código de error (400, 401, 500, etc.)
      console.log(err.response);
      if (err.response) {
        if (!err.response.data.ok) {
          throw new Error(`${err?.response?.data}`);
        }
      } else {
        throw new Error(err.message);
      }
    },
  );
};
