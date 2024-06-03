import {
  Avatar,
  Badge,
  Box,
  Button,
  Center,
  Menu,
  MenuButton,
  MenuDivider,
  MenuItem,
  MenuList,
  Text,
} from "@chakra-ui/react";
import { IoSettingsOutline, IoExitOutline } from "react-icons/io5";

import { useUserStore } from "@store";
import { NavLink, useNavigate } from "react-router-dom";
import avatarImg from "@assets/avatar/avatar-male-gold-1.png";
import { routes } from "@config";

const AvatarDropdown = () => {
  const rol = useUserStore((state) => state.roles[0]);
  const email = useUserStore((state) => state.email);
  const logOut = useUserStore((state) => state.logOut);
  const navigate = useNavigate();

  const handleLogOut = () => {
    logOut();
    navigate("/");
  };

  return (
    <Menu>
      <MenuButton
        as={Button}
        rounded={"full"}
        variant={"link"}
        cursor={"pointer"}
        minW={0}
      >
        <Avatar size={"md"} src={avatarImg} />
      </MenuButton>

      <MenuList alignItems={"center"}>
        <Badge
          variant="subtle"
          colorScheme="green"
          textAlign={"center"}
          borderRadius={0}
          fontStyle={"italic"}
          bg={"primary.400"}
          color={"white"}
        >
          {rol.toLowerCase()}
        </Badge>
        <Center>
          <Avatar size={"xl"} src={avatarImg} />
        </Center>
        <Center my={4}>
          <Box alignItems={"center"}>
            <Text fontWeight={500}>{email}</Text>
          </Box>
        </Center>

        <MenuDivider />
        <MenuItem
          as={NavLink}
          to={routes.SETTINGS}
          borderRadius={10}
          _hover={{
            background: "primary.400",
            color: "white",
          }}
          icon={<IoSettingsOutline />}
        >
          Mi Perfil
        </MenuItem>
        <MenuItem
          onClick={handleLogOut}
          borderRadius={10}
          _hover={{ background: "primary.400", color: "white" }}
          icon={<IoExitOutline />}
        >
          Cerrar Sesión
        </MenuItem>
      </MenuList>
    </Menu>
  );
};

export default AvatarDropdown;
