import {
  Box,
  Center,
  Flex,
  Input,
  InputGroup,
  InputLeftElement,
  useDisclosure,
  Select,
} from "@chakra-ui/react";
import { BannerSection } from "@components/Common";
import { FaSearch } from "react-icons/fa";
import ButtonAddModal from "../common/ButtonAddModal";
import StudentCard from "./StudentCard";
import useStudent from "@hooks/useStudent";
import { fieldsStudent } from "../data/fields";

const StudentPanel = () => {
    const page = {
        start: 0,
        limit: 20
    }
    const { isOpen, onOpen, onClose } = useDisclosure();

  const { students, handleSave, handleDelete } = useStudent(page);

  const content = students.content;

  return (
    <Box pb={100}>
      <BannerSection
        mb={10}
        title="Lista de estudiantes"
        subtitle="Estos son todos los estudiantes registrados en el sistema."
      />
      <Flex justify="space-between" alignItems="center" mb={8} px={20}>
        <InputGroup maxW="350px" gap={2}>
          <InputLeftElement pointerEvents="none">
            <FaSearch color="gray.300" />
          </InputLeftElement>
          <Input
            type="text"
            placeholder="Buscar estudiante"
            //value={courseFilterSearh}
            //onChange={handleFilter}
          />
        </InputGroup>
        <ButtonAddModal
          fields={fieldsStudent}
          onOpen={onOpen}
          isOpen={isOpen}
          onClose={onClose}
          saveFunction={handleSave}
          message="Añadir"
        />
      </Flex>
      <Center>
        <Flex justify="center" wrap="wrap" gap={10} p={5}>
          {content?.length > 0 ? (
            content.map((student) => (
              <StudentCard
                studentData={student}
                onDelete={handleDelete}
                key={student.idAlumno}
              />
            ))
          ) : (
            <p>No hay estudiantes registrados</p>
          )}
        </Flex>
      </Center>
    </Box>
  );
};
export default StudentPanel;
