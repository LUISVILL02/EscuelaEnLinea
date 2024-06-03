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
import { fieldsCourse } from "../data/fields";
import { FaSearch } from "react-icons/fa";
import useCourse from "@hooks/useCourse";
import ButtonAddModal from "../common/ButtonAddModal";
import CourseCard from "./CourseCard";

const CoursePanel = () => {
  const { isOpen, onOpen, onClose } = useDisclosure();
  const {
    courses,
    handleSave,
    handleDelete,
    handleFilter,
    courseFilter,
    courseFilterSearh,
  } = useCourse();
  const conten = courseFilter?.content;
  const conten2 = courses?.content;

  const uniqueSet = new Set(conten2?.map((cur) => cur.nombre.split(" ")[0]));
  const uniqueArray = [...uniqueSet];

  return (
    <Box pb={100}>
      <BannerSection
        mb={10}
        title="Lista de cursos"
        subtitle="Estos son todos los cursos registrados en el sistema."
      />
      <Flex justify="space-between" alignItems="center" mb={8} px={20}>
        <InputGroup maxW="350px" gap={2}>
          <InputLeftElement pointerEvents="none">
            <FaSearch color="gray.300" />
          </InputLeftElement>
          <Input
            type="text"
            placeholder="Buscar curso"
            value={courseFilterSearh}
            onChange={handleFilter}
          />
          <Select
            maxW="max-content"
            placeholder="Filtrar cursos"
            onChange={handleFilter}
          >
            {uniqueArray?.length > 0
              ? uniqueArray?.map((curso, index) => {
                  return (
                    <option key={index} value={curso}>
                      {curso}
                    </option>
                  );
                })
              : "No hay cursos"}
          </Select>
        </InputGroup>
        <ButtonAddModal
          fields={fieldsCourse}
          onOpen={onOpen}
          isOpen={isOpen}
          onClose={onClose}
          saveFunction={handleSave}
          message="Añadir"
        />
      </Flex>
      <Center>
        <Flex justify="center" wrap="wrap" gap={10} p={5}>
          {conten?.length > 0 &&
            conten.map((course) => (
              <CourseCard
                course={course}
                key={course.idCurso}
                onDelete={handleDelete}
              />
            ))}
          {!conten && <p>No hay cursos registrados</p>}
        </Flex>
      </Center>
    </Box>
  );
};

export default CoursePanel;
