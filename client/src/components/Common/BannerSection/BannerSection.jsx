import PropTypes from "prop-types";
import { Box, Heading, Text } from "@chakra-ui/react";

const BannerSection = ({ title, subtitle, ...props }) => {
  return (
    <Box bg="gray.100" py={2} {...props} px={10}>
      <Box maxW="container.xl" mx="auto">
        <Heading as="h1" size="lg" color={"gray.700"}>
          {title}
        </Heading>
        <Text fontSize="md">{subtitle}</Text>
      </Box>
    </Box>
  );
};

BannerSection.propTypes = {
  title: PropTypes.string.isRequired,
  subtitle: PropTypes.string.isRequired,
};

export default BannerSection;
