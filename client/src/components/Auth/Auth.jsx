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
} from "@chakra-ui/react";

export default function Auth() {
  return (
    <Stack
      minH={"80vh"}
      direction={{ base: "column", md: "row" }}
      color={"gray.700"}
    >
      <Flex p={8} flex={1} align={"center"} justify={"center"}>
        <Stack spacing={4} w={"full"} maxW={"md"}>
          <Heading fontSize={"2xl"}>Bienvenido de vuelta!</Heading>
          <FormControl id="email">
            <FormLabel>Correo Electronico</FormLabel>
            <Input
              placeholder="luis@gmail.com"
              type="email"
              focusBorderColor="primary.400"
            />
          </FormControl>
          <FormControl id="password">
            <FormLabel>Contraseña</FormLabel>
            <Input
              placeholder="****"
              type="password"
              focusBorderColor="primary.400"
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
            <Button
              bg={"primary.400"}
              color={"#fff"}
              variant={"solid"}
              _hover={{
                bg: "#fff",
                color: "primary.400",
                border: "1px solid #4D44B5",
              }}
            >
              Iniciar sesión
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
