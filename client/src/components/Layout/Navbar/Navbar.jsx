import {
  Box,
  Flex,
  IconButton,
  Stack,
  Collapse,
  useColorModeValue,
  useDisclosure,
} from "@chakra-ui/react";
import { AiOutlineClose, AiOutlineMenu } from "react-icons/ai";
import { IoExitOutline } from "react-icons/io5";

import DesktopNav from "./DesktopNav";
import MobileNav from "./MobileNav";
import logo from "../../../assets/icons/logo.png";

export default function Navbar() {
  const { isOpen, onToggle } = useDisclosure();

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
              isOpen ? (
                <AiOutlineClose w={3} h={3} />
              ) : (
                <AiOutlineMenu w={5} h={5} />
              )
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
          <Box display={{ base: "center", md: "block" }} mr={5}>
            <img src={logo} alt="logo" width={150} />
          </Box>
          <Flex display={{ base: "none", md: "flex" }} ml={5}>
            <DesktopNav navItems={NAV_ITEMS} />
          </Flex>
        </Flex>

        <Stack
          flex={{ base: 1, md: 0 }}
          justify={"flex-end"}
          direction={"row"}
          spacing={6}
        >
          <IconButton
            as={"a"}
            display={{ base: "inline-flex", md: "inline-flex" }}
            fontSize={"sm"}
            fontWeight={600}
            href={"#"}
            icon={<IoExitOutline />}
            bg={"#5a04dc"}
            color={"white"}
            _hover={{
              bg: "#fff",
              color: "#000",
              border: "1px solid #4D44B5",
            }}
          />
        </Stack>
      </Flex>

      <Collapse in={isOpen} animateOpacity>
        <MobileNav navItems={NAV_ITEMS} />
      </Collapse>
    </Box>
  );
}
