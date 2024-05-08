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
    <Flex height={{xl: 880}} align="center"  bg="gray.100" display="flex">
      <Box
        bg="white"
        height="100%"
        width="100vw"
        display="flex"
        alignItems="center"
        justifyContent="center"
      >
        {/* Formulario de inicio de sesión */}
        <Box width="50%" height="83%" padding=" 0 100px" display="flex" flexDirection="column">          
          <Heading fontSize={{xl: 64, lg: 50, sm: 40, base: 28}} fontWeight="300" color="#4D44B5" mb={20}>
            Ingreso de sesión
          </Heading>
          <Box mb={10}>
            <Text fontSize="36px" color="#3D3D3D" fontWeight="300">Identificación</Text>
            <Input placeholder="123456" height="65px" borderRadius="5px" color="#3D3D3D" fontSize="24px"/>
          </Box>
          <Box mb={10}>
            <Text fontSize="36px" color="#3D3D3D" fontWeight="300">Contraseña</Text>
            <Input placeholder="ingrese una contraseña" type="password" height="65px" borderRadius="5px" color="#3D3D3D" fontSize="24px"/>
          </Box>
          <Box>
            <Button colorScheme="blue" mb={4} height="65px" width="100%" backgroundColor="#4D44B5" fontSize="32px" fontWeight="300" _hover={{bg: "white", color: "#4D44B5", border: "1px solid #4D44B5"}}>
              Iniciar Sesión
            </Button>
            <Text fontSize="sm">¿Olvidaste tu contraseña?</Text>
          </Box>          
        </Box>

        {/* Imagen */}
        <Box display={{ base: "none", md: "block" }}  height="100%" width="50%">
          <Image
            src="https://images.pexels.com/photos/2675061/pexels-photo-2675061.jpeg?auto=compress&cs=tinysrgb&w=1260&h=750&dpr=2"
            alt="Imagen"
            height="100%"
            width="100%"
            objectFit="cover"
          />
        </Box>
      </Box>
    </Flex>
  );
};

export default Auth;
