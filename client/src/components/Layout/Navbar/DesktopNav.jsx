import { Stack, Text } from "@chakra-ui/react";
import PropTypes from "prop-types";
import { NavLink } from "react-router-dom";

const DesktopNav = ({ navItems }) => {
  return (
    <>
      <Stack direction={"row"} spacing={4}>
        {navItems.map((navItem) => (
          <NavLink
            key={navItem.label}
            to={navItem.href}
            style={({ isActive }) => ({
              color: isActive ? "#5a04dc" : "inherit",
            })}
          >
            <Text fontWeight={500} _hover={{ color: "#5a04dc" }}>
              {navItem.label}
            </Text>
          </NavLink>
        ))}
      </Stack>
    </>
  );
};

DesktopNav.propTypes = {
  navItems: PropTypes.array.isRequired,
};

export default DesktopNav;
