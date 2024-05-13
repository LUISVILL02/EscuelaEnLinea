import {
  Avatar,
  Button,
  Center,
  Menu,
  MenuButton,
  MenuDivider,
  MenuItem,
  MenuList,
} from "@chakra-ui/react";
import { IoSettingsOutline, IoExitOutline } from "react-icons/io5";

import { useUserStore } from "../../../store";

const AvatarDropdown = () => {
  const firtName = useUserStore((state) => state.firtName);
  const lastName = useUserStore((state) => state.lastName);
  const imgUrl = useUserStore((state) => state.imgUrl);

  const parseName = (name) => {
    return (name?.charAt(0).toUpperCase() + name?.slice(1))?.split(" ")[0];
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
        <Center>
          <Avatar size={"xl"} src={imgUrl} />
        </Center>
        <Center my={4}>
          <p>
            {parseName(firtName)} {parseName(lastName)}
          </p>
        </Center>
        <MenuDivider />
        <MenuItem
          _hover={{ background: "primary.400", color: "white" }}
          icon={<IoSettingsOutline />}
        >
          Mi Perfil
        </MenuItem>
        <MenuItem
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
