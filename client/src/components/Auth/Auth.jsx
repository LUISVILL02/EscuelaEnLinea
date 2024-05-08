import {
  Box,
  Flex,
  Heading,
  Input,
  Image,
  Button,
  Text,
} from "@chakra-ui/react";

const Auth = () => {
  return (
    <Flex minHeight="100vh" align="center" justify="center" bg="gray.100">
      <Box
        bg="white"
        p={8}
        mx={{ base: 6, md: 0 }}
        borderRadius={8}
        boxShadow="lg"
        display={{ base: "block", md: "flex" }}
        alignItems="center"
      >
        {/* Formulario de inicio de sesión */}
        <Box mb={{ base: 6, md: 0 }}>
          <Heading size="xl" mb={6}>
            Iniciar Sesión
          </Heading>
          <Box mr={{ base: 0, md: 10 }}>
            <Input mb={4} placeholder="Correo electrónico" />
            <Input mb={6} placeholder="Contraseña" type="password" />
            <Button colorScheme="blue" mb={4}>
              Iniciar Sesión
            </Button>
            <Text fontSize="sm">¿Olvidaste tu contraseña?</Text>
          </Box>
        </Box>

        {/* Imagen */}
        <Box display={{ base: "none", md: "block" }}>
          <Image
            src="https://images.pexels.com/photos/2675061/pexels-photo-2675061.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"
            alt="Imagen"
            boxSize="300px"
            objectFit="cover"
            borderRadius={8}
          />
        </Box>
      </Box>
    </Flex>
  );
};

export default Auth;
