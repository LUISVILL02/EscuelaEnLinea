import { useForm } from "react-hook-form";
import { authenticate } from "@services";
import { useMutation } from "@tanstack/react-query";
import { useUserStore } from "@store";
import { useNavigate } from "react-router-dom";

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
      navigate("/app");
    },
    onError: (error) => {
      console.log("error", error.message);
    },
  });

  const onSubmitHandler = (credentials) => mutation.mutate(credentials);

  return {
    handleSubmit,
    onSubmitHandler,
    errors,
    isSubmitting: isSubmitting || mutation.isLoading,
    isValid,
    register,
  };
};

export default useLogIn;
