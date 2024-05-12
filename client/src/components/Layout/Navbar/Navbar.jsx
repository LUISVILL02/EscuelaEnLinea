import {
  Box,
  Flex,
  IconButton,
  Stack,
  Collapse,
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
        bg={"white"}
        minH={"60px"}
        py={{ base: 2 }}
        px={{ base: 5 }}
        color={"gray.700"}
        borderBottom={1}
        borderStyle={"solid"}
        borderColor="gray.200"
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
            href={"#"}
            icon={<IoExitOutline />}
            bg={"primary.400"}
            color={"white"}
            _hover={{
              bg: "white",
              color: "black",
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
