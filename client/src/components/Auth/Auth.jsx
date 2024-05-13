import {
  Button,
  Flex,
  FormControl,
  FormLabel,
  Heading,
  Input,
  Link,
  Stack,
  Image,
  Alert,
  AlertIcon,
  AlertTitle,
  AlertDescription,
} from "@chakra-ui/react";
import { useForm } from "react-hook-form";
import { users, useUserStore } from "../../store";
import { useNavigate } from "react-router-dom";
import { routes } from "../../config";

export default function Auth() {
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

  return (
    <Stack
      minH={"80vh"}
      direction={{ base: "column", md: "row" }}
      color={"gray.700"}
    >
      <Flex p={8} flex={1} align={"center"} justify={"center"}>
        <Stack
          spacing={4}
          w={"full"}
          maxW={"md"}
          as="form"
          onSubmit={handleSubmit(onSubmitHandler)}
        >
          <Heading fontSize={"2xl"}>Bienvenido de vuelta!</Heading>
          <FormControl id="email">
            <FormLabel>Correo Electronico</FormLabel>
            <Input
              placeholder="luis@gmail.com"
              focusBorderColor="primary.400"
              {...register("email", {
                required: "El correo es requerido",
                pattern: {
                  value: /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i,
                  message: "No es un correo electronico",
                },
              })}
            />
          </FormControl>
          <FormControl id="password">
            <FormLabel>Contraseña</FormLabel>
            <Input
              placeholder="****"
              type="password"
              focusBorderColor="primary.400"
              {...register("password", {
                required: "La contraseña es requerida",
              })}
            />
          </FormControl>
          <Stack spacing={6}>
            <Stack
              direction={{ base: "column", sm: "row" }}
              align={"start"}
              justify={"space-between"}
            >
              <Link color={"primary.400"}>Recuperar contraseña</Link>
            </Stack>
            {(errors.password || errors.email) && (
              <Alert
                status="error"
                bg="danger.50"
                borderRadius={5}
                variant="left-accent"
              >
                <AlertIcon />
                <AlertTitle>Error!</AlertTitle>
                <AlertDescription>
                  {errors.email?.message || errors.password?.message}
                </AlertDescription>
              </Alert>
            )}
            <Button
              disabled={!isValid || isSubmitting}
              type="submit"
              bg={"primary.400"}
              color={"#fff"}
              variant={"solid"}
              _hover={{
                bg: "#fff",
                color: "primary.400",
                border: "1px solid #4D44B5",
              }}
            >
              {isSubmitting ? "Cargando..." : "Iniciar Sesión"}
            </Button>
          </Stack>
        </Stack>
      </Flex>
      <Flex flex={1}>
        <Image
          display={{ base: "none", md: "block" }}
          alt={"Login Image"}
          objectFit={"cover"}
          src={
            "https://images.unsplash.com/photo-1486312338219-ce68d2c6f44d?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1352&q=80"
          }
        />
      </Flex>
    </Stack>
  );
}
