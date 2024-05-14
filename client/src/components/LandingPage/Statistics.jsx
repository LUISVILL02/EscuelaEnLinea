import {
  Box,
  chakra,
  Flex,
  SimpleGrid,
  Stat,
  StatLabel,
  StatNumber,
} from "@chakra-ui/react";
import { theme } from "@config";
import { statsData } from "./data/stats";
import PropTypes from "prop-types";

function StatsCard({ title, stat, icon: Icon }) {
  return (
    <Stat
      py={"5"}
      border={"1px solid"}
      rounded={"lg"}
      transition="box-shadow 0.3s ease-in-out"
      _hover={{
        boxShadow: `0 0 30px ${theme.colors.primary[400]}`,
        borderColor: theme.colors.primary[400],
      }}
    >
      <Flex
        flexDirection="column"
        alignItems="center"
        justifyContent="center"
        zIndex={0}
      >
        <Box my={"auto"} color={"gray.700"}>
          <Icon size={30} />
        </Box>
        <SimpleGrid row={[2]} placeItems="center">
          <StatNumber
            fontSize={"2xl"}
            fontWeight={"extrabold"}
            color={"primary.400"}
          >
            {stat}
          </StatNumber>
          <StatLabel fontWeight={""} fontSize={"xl"}>
            {title}
          </StatLabel>
        </SimpleGrid>
      </Flex>
    </Stat>
  );
}

export default function Statistics() {
  return (
    <Box maxW="4xl" mx={{ base: "36px", lg: "auto" }} pt={5}>
      <Flex direction="column" alignItems="flex-start" py={10}>
        <chakra.h2 fontSize={"3xl"} fontWeight={"bold"}>
          La Unimagdalena en cifras
        </chakra.h2>
        <Box width="100px" height="5px" bg="primary.400" />
      </Flex>

      <SimpleGrid
        columns={{ base: 2, sm: 3, md: 4, lg: 5 }}
        spacing={{ base: 5, lg: 8 }}
      >
        {statsData.map((data, index) => (
          <StatsCard
            key={index}
            title={data.title}
            stat={data.stat}
            icon={data.icon}
          />
        ))}
      </SimpleGrid>
    </Box>
  );
}

StatsCard.propTypes = {
  title: PropTypes.string.isRequired,
  stat: PropTypes.string.isRequired,
  icon: PropTypes.elementType,
};
