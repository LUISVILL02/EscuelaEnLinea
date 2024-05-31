import PropTypes from "prop-types";
import {
  Box,
  Flex,
  Text,
  Avatar,
  useColorModeValue,
  Icon,
  IconButton,
} from "@chakra-ui/react";
import { FaEnvelope, FaPhone, FaMapMarkerAlt } from "react-icons/fa";
import { theme } from "@config";
import { DeleteIcon, EditIcon } from "@chakra-ui/icons";

const AttendantCard = ({ attendantData, onDelete }) => {
  const bgColor = useColorModeValue("white", "gray.800");
  const textColor = useColorModeValue("gray.700", "gray.300");
  const iconColor = useColorModeValue("primary.400", "primary.300");

  if (!attendantData) {
    return null;
  }

  return (
    <Box
      bg={bgColor}
      p={6}
      borderRadius="lg"
      boxShadow="md"
      h="300px"
      w="300px"
      transition="all 0.3s ease"
      _hover={{
        boxShadow: `0 0 10px ${theme.colors.primary[400]}`,
        borderColor: theme.colors.primary[400],
      }}
    >
      <Flex alignItems="center" mb={4}>
        <Avatar
          size="lg"
          name={`${attendantData.nombre} ${attendantData.apellido}`}
          mr={4}
        />
        <Box>
          <Text fontSize="xl" fontWeight="bold">
            {attendantData.nombre} {attendantData.apellido}
          </Text>
          <Text color={textColor}>cc: {attendantData.identificador}</Text>
        </Box>
      </Flex>
      <Flex direction="column" justifyContent="space-between" maxH={"350px"}>
        <Box>
          <Flex align="center" mb={2}>
            <Icon as={FaEnvelope} color={iconColor} mr={2} />
            <Text color={textColor}>{attendantData.correo}</Text>
          </Flex>
          <Flex align="center" mb={2}>
            <Icon as={FaPhone} color={iconColor} mr={2} />
            <Text color={textColor}>{attendantData.telefono}</Text>
          </Flex>
          <Flex align="center">
            <Icon as={FaMapMarkerAlt} color={iconColor} mr={2} />
            <Text color={textColor}>{attendantData.direccion}</Text>
          </Flex>
        </Box>
        <Flex justifyContent="flex-end" mt={5} gap={2}>
          <IconButton
            borderRadius={10}
            variant={"outline"}
            color={"black"}
            aria-label="Search database"
            onClick={() => onDelete(attendantData.idUser)}
            icon={<DeleteIcon />}
          />
          <IconButton
            borderRadius={10}
            variant={"outline"}
            color={"black"}
            aria-label="Search database"
            icon={<EditIcon />}
          />
        </Flex>
      </Flex>
    </Box>
  );
};

AttendantCard.propTypes = {
  attendantData: PropTypes.object.isRequired,
  onDelete: PropTypes.func.isRequired,
};

export default AttendantCard;
