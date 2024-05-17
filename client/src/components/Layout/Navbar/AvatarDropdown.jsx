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
import { routes } from "@config";
import { parseName, parseRole } from "@utils";

const AvatarDropdown = () => {
  const firtName = useUserStore((state) => state.firtName);
  const lastName = useUserStore((state) => state.lastName);
  const imgUrl = useUserStore((state) => state.imgUrl);
  const rol = useUserStore((state) => state.rol);
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
        <Avatar size={"md"} src={imgUrl} />
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
          {parseRole(rol)}
        </Badge>
        <Center>
          <Avatar size={"xl"} src={imgUrl} />
        </Center>
        <Center my={4}>
          <Box alignItems={"center"}>
            <Text fontWeight={500}>
              {parseName(firtName)} {parseName(lastName)}
            </Text>
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
