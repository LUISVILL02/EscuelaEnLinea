import axios from "axios";
import { SnackbarUtils } from "@components";

const baseUrl = "https://escuelaenlinea-production.up.railway.app";
const projectName = "EscuelaEnLinea";
const version = "V.1.0.0";
export const API_URL = `${baseUrl}/${projectName}/${version}`;

// Configurar la URL base de Axios
axios.defaults.baseURL = API_URL;

export const AxiosInterceptor = () => {
  const updateHeader = (req) => {
    const token = localStorage.getItem("token");
    if (token) {
      req.headers.Authorization = `Bearer ${token}`;
    }
    return req;
  };

  axios.interceptors.request.use((req) => {
    return updateHeader(req);
  });

  axios.interceptors.response.use(
    (res) => {
      return res.data;
    },
    (error) => {
      if (error.code === "ECONNABORTED") {
        SnackbarUtils.error(
          "El servidor no responde. Por favor, inténtelo más tarde.",
        );
      } else if (error.message === "Network Error") {
        SnackbarUtils.error(
          "No se pudo establecer conexión con el servidor. Por favor, verifique su conexión a Internet.",
        );
      } else if (error.response) {
        // El servidor respondió con un código de estado fuera del rango 2xx
        if (error.response.status === 404) {
          SnackbarUtils.error("No se ha encontrado datos");
        } else {
          SnackbarUtils.error(
            `Error ${error?.response?.status}: ${error?.response?.data}`,
          );
        }
      } else {
        // Hubo un problema al configurar la solicitud que provocó un error
        SnackbarUtils.error("Error al procesar la solicitud: " + error.message);
      }
      return Promise.reject(error);
    },
  );
};
