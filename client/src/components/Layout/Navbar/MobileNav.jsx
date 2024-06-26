import { Stack, useColorModeValue } from "@chakra-ui/react";
import MobileNavItem from "./MobileNavItem";
import PropTypes from "prop-types";

const MobileNav = ({ navItems = [] }) => {
  return (
    <Stack
      bg={useColorModeValue("white", "gray.800")}
      p={4}
      display={{ md: "none" }}
    >
      {navItems.map((navItem) => (
        <MobileNavItem key={navItem.label} {...navItem} />
      ))}
    </Stack>
  );
};

MobileNav.propTypes = {
  navItems: PropTypes.array.isRequired,
};

export default MobileNav;
