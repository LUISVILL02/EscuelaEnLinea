import PropTypes from "prop-types";
import { Box, Flex, Heading, Icon } from "@chakra-ui/react";
import { theme } from "@config";
import { Link } from "react-router-dom";

const CardPanel = ({ title, route, iconComponent }) => {
  return (
    <Box
      as={Link}
      to={route}
      borderRadius="lg"
      boxShadow="md"
      overflow="hidden"
      width="300px"
      height="150px"
      transition="all 0.3s ease"
      _hover={{
        boxShadow: `0 0 10px ${theme.colors.primary[400]}`,
        borderColor: theme.colors.primary[400],
        transform: "scale(1.05)",
      }}
    >
      <Flex justify="center" align="center" py={6}>
        <Icon as={iconComponent} boxSize={10} color={"gray.600"} />
      </Flex>
      <Heading size="md" textAlign="center">
        {title}
      </Heading>
    </Box>
  );
};

CardPanel.propTypes = {
  title: PropTypes.string.isRequired,
  route: PropTypes.string.isRequired,
  iconComponent: PropTypes.elementType.isRequired,
};

export default CardPanel;
