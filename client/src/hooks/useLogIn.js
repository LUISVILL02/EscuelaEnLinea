import { useForm } from "react-hook-form";
import { authenticate } from "@services";
import { useMutation } from "@tanstack/react-query";
import { useUserStore } from "@store";

const useLogIn = () => {
  const {
    handleSubmit,
    formState: { errors, isSubmitting, isValid },
    register,
    isLoading,
    isError,
  } = useForm();

  const logIn = useUserStore((state) => state.logIn);

  const mutation = useMutation({
    mutationFn: (credentials) => authenticate(credentials),
    onSuccess: (data) => {
      console.log(data);
      logIn(data);
    },
  });

  const onSubmitHandler = (credentials) => mutation.mutate(credentials);

  return {
    handleSubmit,
    onSubmitHandler,
    errors,
    isSubmitting,
    isValid,
    register,
    isLoading,
    isError,
  };
};

export default useLogIn;
