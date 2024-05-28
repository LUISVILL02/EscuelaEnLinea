import {
  Box,
  useDisclosure,
  Center,
  Flex,
  Input,
  InputGroup,
  InputLeftElement,
} from "@chakra-ui/react";
import { BannerSection } from "@components/Common";
import { fieldsTeacher } from "./data/fields";
import ButtonAddModal from "./common/ButtonAddModal";
import TeacherCard from "./TeacherCard";
import { FaSearch } from "react-icons/fa";
import useTeacher from "@hooks/useTeacher";

const TeachersPanel = () => {
  const { isOpen, onOpen, onClose } = useDisclosure();

  const { teacherTerm, data, handleFilter, handleSave, handleDelete } =
    useTeacher();

  return (
    <Box pb={100}>
      <BannerSection
        mb={10}
        title="Lista de profesores"
        subtitle="Aquí puedes ver la lista de profesores registrados en el sistema, si le das click a uno de ellos podrás ver más detalles."
      />
      <Flex justify="space-between" alignItems="center" mb={8} px={10}>
        <InputGroup maxW="300px">
          <InputLeftElement pointerEvents="none">
            <FaSearch color="gray.300" />
          </InputLeftElement>
          <Input
            type="text"
            placeholder="Buscar profesor"
            value={teacherTerm}
            onChange={handleFilter}
          />
        </InputGroup>
        <ButtonAddModal
          fields={fieldsTeacher}
          onOpen={onOpen}
          isOpen={isOpen}
          onClose={onClose}
          saveFunction={handleSave}
          message="Añadir"
        />
      </Flex>
      <Center>
        <Flex justify="center" wrap="wrap" gap={10} p={5}>
          {data?.length > 0 &&
            data.map((teacher) => (
              <TeacherCard
                teacherData={teacher}
                onDelete={handleDelete}
                key={teacher.idUser}
              />
            ))}
          {!data && <p>No hay profesores registrados</p>}
        </Flex>
      </Center>
    </Box>
  );
};

export default TeachersPanel;
