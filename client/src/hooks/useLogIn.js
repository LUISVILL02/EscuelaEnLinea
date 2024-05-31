import { useForm } from "react-hook-form";
import { authenticate } from "@services";
import { useMutation } from "@tanstack/react-query";
import { useUserStore } from "@store";
import { useNavigate } from "react-router-dom";
import { routes } from "@config";

const useLogIn = () => {
  const {
    handleSubmit,
    formState: { errors, isSubmitting, isValid },
    register,
  } = useForm();

  const logIn = useUserStore((state) => state.logIn);
  const navigate = useNavigate();

  const mutation = useMutation({
    mutationFn: (credentials) => authenticate(credentials),
    onSuccess: (data) => {
      logIn(data);
      navigate(routes[data.roles[0]]?.APP);
    },
  });

  const onSubmitHandler = (credentials) => {
    credentials = {
      ...credentials,
      correo: credentials.correo.toLowerCase(),
    };
    mutation.mutate(credentials);
  };

  return {
    handleSubmit,
    onSubmitHandler,
    errors,
    isSubmitting: isSubmitting || mutation.isPending,
    isValid,
    register,
  };
};

export default useLogIn;
