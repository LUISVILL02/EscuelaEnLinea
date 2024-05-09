import {
  Box,
  Flex,
  IconButton,
  Button,
  Stack,
  Collapse,
  useColorModeValue,
  useBreakpointValue,
  useDisclosure,
} from "@chakra-ui/react";
import { HamburgerIcon, CloseIcon } from "@chakra-ui/icons";
import DesktopNav from "./DesktopNav";
import MobileNav from "./MobileNav";
import logo from "../../../assets/icons/logo.png";

export default function Navbar() {
  const { isOpen, onToggle } = useDisclosure();
  const buttonText = useBreakpointValue({ base: "X", md: "Cerrar sesión" });

  const NAV_ITEMS = [
    {
      label: "Panel",
      href: "/app",
    },
    {
      label: "Asistencias",
      href: "/assistance",
    },
    {
      label: "Observaciones",
      href: "/Remarks",
    },
    {
      label: "Mensajes",
      href: "/sign-in",
    },
  ];

  let sesion = false;

  return (
    <Box>
      <Flex
        bg={useColorModeValue("white", "gray.800")}
        color={useColorModeValue("gray.600", "white")}
        minH={"60px"}
        py={{ base: 2 }}
        px={{ base: 5 }}
        borderBottom={1}
        borderStyle={"solid"}
        borderColor={useColorModeValue("gray.200", "gray.900")}
        align={"center"}
      >
        <Flex
          flex={{ base: 1, md: "auto" }}
          ml={{ base: -2 }}
          display={{ base: "flex", md: "none" }}
        >
          <IconButton
            onClick={onToggle}
            icon={
              isOpen ? <CloseIcon w={3} h={3} /> : <HamburgerIcon w={5} h={5} />
            }
            variant={"ghost"}
            aria-label={"Toggle Navigation"}
          />
        </Flex>
        <Flex
          flex={{ base: 1 }}
          justify={{ base: "center", md: "start" }}
          alignItems="center"
        >
          <Box display={{ base: "center", md: "block" }}>
            <img src={logo} alt="logo" width={150} />
          </Box>
          {// no hay navbar
          }
        </Flex>

        <Stack
          flex={{ base: 1, md: 0 }}
          justify={"flex-end"}
          direction={"row"}
          spacing={6}
        >
          {sesion && <Button
            as={"a"}
            display={{ base: "inline-flex", md: "inline-flex" }}
            fontSize={"sm"}
            fontWeight={600}
            href={"#"}
            bg={"#5a04dc"}
            color={"white"}
            _hover={{
              bg: "#5a04dc",
            }}
          >
            {buttonText}
          </Button>} 
        </Stack>
      </Flex>

      <Collapse in={isOpen} animateOpacity>
        <MobileNav navItems={NAV_ITEMS} />
      </Collapse>
    </Box>
  );
}
