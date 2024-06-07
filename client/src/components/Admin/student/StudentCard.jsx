import PropTypes from "prop-types";
import {
  Box,
  Flex,
  Text,
  Avatar,
  useColorModeValue,
  Icon,
  IconButton,
  useDisclosure,
} from "@chakra-ui/react";
import {
  FaEnvelope,
  FaPhone,
  FaCalendarAlt,
  FaMapMarkerAlt,
  FaUserTie,
} from "react-icons/fa";
import { theme } from "@config";
import { DeleteIcon, EditIcon } from "@chakra-ui/icons";
import ButtonAddModal from "../common/ButtonAddModal";
import { fieldsStudent } from "../data/fields";
import { FaSchoolFlag } from "react-icons/fa6";

const StudentCard = ({ studentData, onDelete, onUpdate, onIdAlumno}) => {
  const bgColor = useColorModeValue("white", "gray.800");
  const textColor = useColorModeValue("gray.700", "gray.300");
  const iconColor = useColorModeValue("primary.400", "primary.300");

  const { isOpen, onOpen, onClose } = useDisclosure();

  const handleSelect = () => {
    onIdAlumno(studentData.idAlumno);
  };

  if(isOpen) handleSelect();

  return (
    <Box
      bg={bgColor}
      p={6}
      borderRadius="lg"
      boxShadow="md"
      h="370px"
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
          name={`${studentData.nombre} ${studentData.apellido}`}
          src={studentData.fotografia}
          mr={4}
        />
        <Box>
          <Text fontSize="xl" fontWeight="bold">
            {studentData.nombre} {studentData.apellido}
          </Text>
          <Text color={textColor}>cc: {studentData.identificación}</Text>
        </Box>
      </Flex>
      <Flex
        direction="column"
        justifyContent="space-between"
        h={"200px"}
        maxH={"300px"}
      >
        <Box
          maxH={"200px"}
          overflow="auto"
          h={"180px"}
          sx={{ "&::-webkit-scrollbar": { display: "none" } }}
        >
          <Flex align="center" mb={2}>
            <Icon as={FaEnvelope} color={iconColor} mr={2} />
            <Text color={textColor}>{studentData.correo}</Text>
          </Flex>
          <Flex align="center" mb={2}>
            <Icon as={FaPhone} color={iconColor} mr={2} />
            <Text color={textColor}>{studentData.telefono}</Text>
          </Flex>
          <Flex align="center" mb={2}>
            <Icon as={FaCalendarAlt} color={iconColor} mr={2} />
            <Text color={textColor}>
              {new Date(
                studentData.fechaNacimiento[0],
                studentData.fechaNacimiento[1] - 1,
                studentData.fechaNacimiento[2],
              ).toLocaleDateString()}
            </Text>
          </Flex>
          <Flex align="center">
            <Icon as={FaMapMarkerAlt} color={iconColor} mr={2} />
            {studentData.dirección ? (
              <Text color={textColor}>{studentData.dirección}</Text>
            ) : (
              <Text color={textColor}>Sin dirección</Text>
            )}
          </Flex>
          <Flex align="center">
            <Icon as={FaUserTie} color={iconColor} mr={2} />
            {studentData.nombreAcudiente && studentData.apellidoAcudiente ? (
              <Text color={textColor}>
                {studentData.nombreAcudiente} {studentData.apellidoAcudiente}
              </Text>
            ) : (
              <Text color={textColor}>Sin acudiente</Text>
            )}
          </Flex>
          <Flex align="center" mb={2}>
            <Icon as={FaSchoolFlag} color={iconColor} mr={2} />
            <Text color={textColor}>{studentData.nombreCurso}</Text>
          </Flex>
        </Box>
        <Flex justifyContent="flex-end" mt={5} gap={2}>
          <IconButton
            borderRadius={10}
            variant={"outline"}
            color={"black"}
            aria-label="Search database"
            onClick={() => onDelete(studentData.idAlumno)}
            icon={<DeleteIcon />}
          />
          <ButtonAddModal
            fields={fieldsStudent}
            onOpen={onOpen}
            isOpen={isOpen}
            onClose={onClose}
            saveFunction={onUpdate}
            bg={theme.colors.gray[400]}
            message={<EditIcon />}
          />
        </Flex>
      </Flex>
    </Box>
  );
};

StudentCard.propTypes = {
  studentData: PropTypes.object.isRequired,
  //onDelete: PropTypes.func.isRequired,
};

export default StudentCard;
