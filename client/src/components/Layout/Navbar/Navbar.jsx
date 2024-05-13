import {
  Box,
  Flex,
  IconButton,
  Stack,
  Collapse,
  useDisclosure,
} from "@chakra-ui/react";
import { AiOutlineClose, AiOutlineMenu } from "react-icons/ai";

import DesktopNav from "./DesktopNav";
import MobileNav from "./MobileNav";
import logo from "../../../assets/icons/logo.png";
import { useUserStore } from "../../../store";
import { itemsNavbarData, theme } from "../../../config";
import AvatarDropdown from "./AvatarDropdown";
import { FaSchool } from "react-icons/fa";

export default function Navbar() {
  const { isOpen, onToggle } = useDisclosure();

  const rolUser = useUserStore((state) => state.rol);
  const isActive = useUserStore((state) => state.isActive);

  if (!isActive()) {
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
          <Box display={{ base: "center", md: "block" }} mr={5}>
            <img src={logo} alt="logo" width={150} />
          </Box>
        </Flex>
      </Box>
    );
  }

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
            <DesktopNav navItems={itemsNavbarData[rolUser]} />
          </Flex>
        </Flex>

        <FaSchool color={theme.colors.primary[400]} />
        <Box
          display={{ base: "none", md: "flex" }}
          pr={5}
          pl={2}
          color={"gray.700"}
          fontWeight={500}
        >
          IE Virginia Gomez
        </Box>
        <Stack
          flex={{ base: 1, md: 0 }}
          justify={"flex-end"}
          direction={"row"}
          spacing={6}
        >
          <AvatarDropdown />
        </Stack>
      </Flex>
      <Collapse in={isOpen} animateOpacity>
        <MobileNav navItems={itemsNavbarData[rolUser]} />
      </Collapse>
    </Box>
  );
}
