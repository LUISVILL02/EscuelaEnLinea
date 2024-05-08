import {
  Box,
  chakra,
  Container,
  Stack,
  Text,
  useColorModeValue,
  VisuallyHidden,
} from "@chakra-ui/react";
import logo from "../../../assets/icons/logo.png";
import PropTypes from "prop-types";

const SocialButton = ({ children, label, href }) => {
  return (
    <chakra.button
      bg={useColorModeValue("blackAlpha.100", "whiteAlpha.100")}
      rounded={"full"}
      w={8}
      h={8}
      cursor={"pointer"}
      as={"a"}
      href={href}
      display={"inline-flex"}
      alignItems={"center"}
      justifyContent={"center"}
      transition={"background 0.3s ease"}
      _hover={{
        bg: useColorModeValue("blackAlpha.200", "whiteAlpha.200"),
      }}
    >
      <VisuallyHidden>{label}</VisuallyHidden>
      {children}
    </chakra.button>
  );
};

export default function Footer() {
  return (
    <Box
      bg={useColorModeValue("#4D44B5", "gray.900")}
      color={useColorModeValue("white", "gray.200")}
      h={{xl: "max-content"}}
      // position="fixed"
      // bottom="0"
      // left="0"
      // right="0"
    >
      <Container
        as={Stack}
        maxW={"6xl"}
        py={4}
        direction={{ base: "column", md: "row" }}
        spacing={4}
        justify={{ base: "center", md: "space-between" }}
        align={{ base: "center", md: "center" }}
        h={{xl: "82px"}}
      >
        <img src={logo} alt="logo" width={150} />
        <Text>© 2022 Escuela en linea. Todo los derechos reservados</Text>
        <Stack direction={"row"} spacing={6}>
          <SocialButton label={"Twitter"} href={"#"}>
            <p>a</p>
          </SocialButton>
          <SocialButton label={"YouTube"} href={"#"}>
            <p>a</p>
          </SocialButton>
          <SocialButton label={"Instagram"} href={"#"}>
            <p>a</p>
          </SocialButton>
        </Stack>
      </Container>
    </Box>
  );
}

SocialButton.propTypes = {
  children: PropTypes.node.isRequired,
  label: PropTypes.string.isRequired,
  href: PropTypes.string.isRequired,
};
