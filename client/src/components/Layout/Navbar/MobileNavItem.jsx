import {
  Box,
  Stack,
  Text,
  useColorModeValue,
  useDisclosure,
} from "@chakra-ui/react";
import PropTypes from "prop-types";
import { NavLink } from "react-router-dom";

const MobileNavItem = ({ label, children, href }) => {
  const { onToggle } = useDisclosure();

  return (
    <NavLink to={"/" + label}>
      <Stack spacing={4} onClick={children && onToggle}>
        <Box
          py={2}
          href={href ?? "#"}
          justifyContent="space-between"
          alignItems="center"
          _hover={{
            textDecoration: "none",
          }}
        >
          <Text
            fontWeight={600}
            color={useColorModeValue("gray.600", "gray.200")}
          >
            {label}
          </Text>
        </Box>
      </Stack>
    </NavLink>
  );
};

MobileNavItem.propTypes = {
  label: PropTypes.string,
  children: PropTypes.array,
  href: PropTypes.string,
};

export default MobileNavItem;
