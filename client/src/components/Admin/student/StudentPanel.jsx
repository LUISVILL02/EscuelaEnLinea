import {
  Box,
  Center,
  Flex,
  Input,
  InputGroup,
  InputLeftElement,
  useDisclosure,
  Select,
  Spinner,
} from "@chakra-ui/react";
import { BannerSection } from "@components/Common";
import { FaSearch } from "react-icons/fa";
import ButtonAddModal from "../common/ButtonAddModal";
import StudentCard from "./StudentCard";
import useStudent from "@hooks/useStudent";
import { fieldsStudent } from "../data/fields";
import { useEffect, useState } from "react";
import { decodedToken } from "@utils";

const StudentPanel = () => {
    const page = {
        start: 0,
        limit: 20
    }
    const { isOpen, onOpen, onClose } = useDisclosure();
    const [idAlumnoCard, setIdAlumnoCard] = useState(0);
    const [role, setRole] = useState("Admin");

    const user = decodedToken(localStorage.getItem("token"));
    useEffect(() => {
        if (user) {
            setRole(user.roles[0]);
            console.log(user.roles[0].name);
        }
    }, []);

  const {
    students,
    handleSave,
    handleUpdate,
    handleDelete,
    loading,
    handleFilter,
    filterSearh,
    selectFilter,
  } = useStudent(page, idAlumnoCard);

   const handleAlumno = (idAlumno) => {
     setIdAlumnoCard(idAlumno);
   };

  const content = students;

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
            value={filterSearh}
            onChange={handleFilter}
          />
          <Select placeholder="Filtrar estudiantes" onChange={selectFilter}>
            <option value="Acudiente">Acudiente</option>
            <option value="Nombre estudiante">Nombre estudiante</option>
            <option value="Curso">Curso</option>
          </Select>
        </InputGroup>
        {role === "ADMIN" && (
          <ButtonAddModal
            fields={fieldsStudent}
            onOpen={onOpen}
            isOpen={isOpen}
            onClose={onClose}
            saveFunction={handleSave}
            message="Añadir"
          />
        )}
      </Flex>
      <Center>
        {loading ? (
          <Spinner
            thickness="4px"
            speed="0.65s"
            emptyColor="gray.200"
            color="blue.500"
            size="xl"
          />
        ) : (
          <Flex justify="center" wrap="wrap" gap={10} p={5}>
            {content?.length > 0 ? (
              content.map((student) => (
                <StudentCard
                  studentData={student}
                  onDelete={handleDelete}
                  onUpdate={handleUpdate}
                  key={student.idAlumno}
                  onIdAlumno={handleAlumno}
                />
              ))
            ) : (
              <p>No hay estudiantes registrados</p>
            )}
          </Flex>
        )}
      </Center>
    </Box>
  );
};
export default StudentPanel;
