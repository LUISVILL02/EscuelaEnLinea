import PropTypes from "prop-types";
import {
  Accordion,
  AccordionItem,
  AccordionButton,
  AccordionPanel,
  Box,
  List,
  ListItem,
  ListIcon,
  Flex,
  IconButton,
} from "@chakra-ui/react";
import { theme } from "@config";
import { FaUserGraduate } from "react-icons/fa6";
import { FaUserCircle, FaUsers } from "react-icons/fa";
import { RiSchoolLine } from "react-icons/ri";
import { DeleteIcon } from "@chakra-ui/icons";

const CourseCard = ({ course, onDelete }) => {
  return (
    <Box>
      <Accordion
        boxShadow={"lg"}
        w={250}
        maxHeight={{ xl: "300px" }}
        minHeight={{ xl: "120px" }}
        allowToggle
        borderRadius="lg"
        _hover={{
          boxShadow: `0 0 10px ${theme.colors.primary[400]}`,
          borderColor: theme.colors.primary[400],
        }}
      >
        <AccordionItem border="none">
          <h2>
            <AccordionButton
              flexDirection="column"
              alignItems="flex-start"
              borderRadius="lg"
              _hover={{ bgColor: theme.colors.white }}
            >
              <Box
                display="flex"
                fontSize="3xl"
                justifyContent="flex-start"
                alignItems="center"
                gap={2}
                w="100%"
              >
                <RiSchoolLine color={`${theme.colors.primary[400]}`} />{" "}
                {course.nombre}
              </Box>
              <Box
                display="flex"
                gap={1}
                justifyContent="flex-start"
                alignItems="center"
                fontSize={`${theme.fontSizes.md}`}
              >
                <FaUserGraduate color={`${theme.colors.primary[400]}`} />{" "}
                Docente: {course.nombreProfesor} {course.apellidoProfesor}
              </Box>
            </AccordionButton>
          </h2>
          <AccordionPanel
            pb={4}
            overflow={{ xl: "auto" }}
            sx={{ "&::-webkit-scrollbar": { display: "none" } }}
            maxHeight={{ xl: "200px" }}
          >
            <Box
              fontSize={`${theme.fontSizes.md}`}
              display="flex"
              alignItems="center"
              gap={1}
              mb={2}
            >
              <FaUsers /> Estudiantes en este curso:
            </Box>
            {course.alumnos?.length > 0 ? (
              course.alumnos.map((alumno) => (
                <List
                  spacing={3}
                  key={alumno.idAlumno}
                  fontSize={`${theme.fontSizes.lg}`}
                >
                  <ListItem fontSize={`${theme.fontSizes.md}`}>
                    <ListIcon as={FaUserCircle} color="info.600" />
                    {alumno.nombre} {alumno.apellido}
                  </ListItem>
                </List>
              ))
            ) : (
              <p>No hay alumnos para este curso</p>
            )}
          </AccordionPanel>
        </AccordionItem>
        <Flex justifyContent="flex-end" gap={2} p={2}>
          <IconButton
            borderRadius={10}
            variant={"outline"}
            color={"black"}
            aria-label="Search database"
            onClick={() => onDelete(course.idCurso)}
            icon={<DeleteIcon />}
          />
        </Flex>
      </Accordion>
    </Box>
  );
};

CourseCard.propTypes = {
  course: PropTypes.object.isRequired,
  onDelete: PropTypes.func.isRequired,
};

export default CourseCard;
