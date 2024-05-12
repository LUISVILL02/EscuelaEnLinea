import {
  Box,
  Container,
  IconButton,
  Stack,
  Text,
  useColorModeValue,
} from "@chakra-ui/react";
import logo from "../../../assets/icons/logo.png";
import { FaGithub, FaLinkedin } from "react-icons/fa";

import PropTypes from "prop-types";

const SocialButton = ({ href, icon }) => {
  return (
    <IconButton
      bg={"gray.100"}
      rounded={"full"}
      icon={icon}
      h={10}
      cursor={"pointer"}
      as={"a"}
      href={href}
      display={"inline-flex"}
      alignItems={"center"}
      justifyContent={"center"}
      transition={"background 0.3s ease"}
      _hover={{
        bg: "primary.400",
        color: "white",
      }}
    />
  );
};

export default function Footer() {
  return (
    <Box
      bg={"white"}
      color={"gray.700"}
      h={{ xl: "max-content" }}
      borderTop={1}
      borderStyle={"solid"}
      borderColor={useColorModeValue("gray.200", "gray.900")}
    >
      <Container
        as={Stack}
        maxW={"6xl"}
        py={4}
        direction={{ base: "column", md: "row" }}
        spacing={4}
        justify={{ base: "center", md: "space-between" }}
        align={{ base: "center", md: "center" }}
        h={{ xl: "82px" }}
      >
        <img src={logo} alt="logo" width={150} />
        <Text align={"center"}>
          © {new Date().getFullYear()} Escuela en linea. Todo los derechos
          reservados
        </Text>
        <Stack direction={"row"} spacing={6}>
          <SocialButton href={"#"} icon={<FaGithub />} />
          <SocialButton href={"#"} icon={<FaLinkedin />} />
        </Stack>
      </Container>
    </Box>
  );
}

SocialButton.propTypes = {
  children: PropTypes.node.isRequired,
  href: PropTypes.string.isRequired,
  icon: PropTypes.node.isRequired,
};
