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
import { fieldsAttendant } from "../data/fields";
import ButtonAddModal from "../common/ButtonAddModal";
import { FaSearch } from "react-icons/fa";
import AttendantCard from "./AttendantsCard";
import { useAttendant } from "@hooks";

const AttendantsPanel = () => {
  const { isOpen, onOpen, onClose } = useDisclosure();

  const {
    attendantTerm,
    AttendantData,
    handleSave,
    handleDelete,
    handleFilter,
  } = useAttendant();

  return (
    <Box pb={10}>
      <BannerSection
        mb={10}
        title="Lista de acudientes"
        subtitle="Aquí puedes ver la lista de acudientes registrados en el sistema, si le das click a uno de ellos podrás ver más detalles."
      />
      <Flex justify="space-between" alignItems="center" mb={8} px={10}>
        <InputGroup maxW="300px">
          <InputLeftElement pointerEvents="none">
            <FaSearch color="gray.300" />
          </InputLeftElement>
          <Input
            type="text"
            placeholder="Buscar Acudiente"
            value={attendantTerm}
            onChange={handleFilter}
          />
        </InputGroup>
        <ButtonAddModal
          fields={fieldsAttendant}
          onOpen={onOpen}
          isOpen={isOpen}
          onClose={onClose}
          saveFunction={handleSave}
          message="Añadir"
        />
      </Flex>
      <Center>
        <Flex justify="center" wrap="wrap" gap={10} p={5}>
          {AttendantData?.length &&
            AttendantData.map((attendant) => (
              <AttendantCard
                attendantData={attendant}
                onDelete={handleDelete}
                key={attendant.idUser}
              />
            ))}
          {!AttendantData?.length && <p>No hay profesores registrados</p>}
        </Flex>
      </Center>
    </Box>
  );
};

export default AttendantsPanel;
