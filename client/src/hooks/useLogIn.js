import { useForm } from "react-hook-form";
import { useUserStore, users } from "@store";
import { routes } from "@config";
import { useNavigate } from "react-router-dom";

const useLogIn = () => {
  const {
    handleSubmit,
    formState: { errors, isSubmitting, isValid },
    register,
    setError,
  } = useForm();

  const logIn = useUserStore((state) => state.logIn);

  const navigate = useNavigate();

  const onSubmitHandler = async (data) => {
    return new Promise((resolve) => {
      setTimeout(() => {
        const userFound = users.find((user) => user.email === data.email);
        if (userFound) {
          logIn(userFound);
          navigate(routes.AUTH); // esto deberia redirigir a la ruta de la app, (aun no existe por lo que redirige a la ruta de atenticacion)
        } else {
          setError("email", {
            type: "manual",
            message: "correo o contraseña incorrectos",
          });
        }
        resolve();
      }, 1500);
    });
  };

  return {
    handleSubmit,
    errors,
    isSubmitting,
    isValid,
    register,
    onSubmitHandler,
  };
};

export default useLogIn;
