import {
  Box,
  Flex,
  Input,
  InputGroup,
  InputLeftElement,
  useDisclosure,
} from "@chakra-ui/react";
import { FaSearch } from "react-icons/fa";
import { fieldSubject } from "../data/fields";
import { ButtonAddModal } from "../common";
import { useSubject } from "@hooks";
import { BannerSection } from "@components/Common";
import SubjectTable from "./SubjectTable";

const SubjectsPanel = () => {
  const { isOpen, onOpen, onClose } = useDisclosure();

  const { handleSave, handleFilter, handleDelete, subjectData, subjectTerm } =
    useSubject();

  return (
    <Box pb={10}>
      <BannerSection
        mb={10}
        title="Lista de asignaturas"
        subtitle="Aquí puedes ver la lista de asignaturas registradas en el sistema."
      />
      <Flex justify="space-between" alignItems="center" mb={8} px={10}>
        <InputGroup maxW="300px">
          <InputLeftElement pointerEvents="none">
            <FaSearch color="gray.300" />
          </InputLeftElement>
          <Input
            type="text"
            placeholder="Buscar asignatura"
            value={subjectTerm}
            onChange={handleFilter}
          />
        </InputGroup>
        <ButtonAddModal
          fields={fieldSubject}
          onOpen={onOpen}
          isOpen={isOpen}
          onClose={onClose}
          saveFunction={handleSave}
          message="Añadir"
        />
      </Flex>
      <SubjectTable rows={subjectData} handleDelete={handleDelete} />
    </Box>
  );
};

export default SubjectsPanel;
