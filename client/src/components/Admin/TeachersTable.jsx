import { Box, Button, useDisclosure } from "@chakra-ui/react";
import { BannerSection, Table, GenericModalForm } from "@components/Common";
import { getTeachers, createTeacher } from "@services";
import { useMutation, useQuery } from "@tanstack/react-query";
import { fieldsTeacher } from "./data/fields";
import { columnsTeacher } from "./data/columns";
import { useEffect, useState } from "react";
import { formatDataRow, formatDate } from "@utils";

const TeachersTable = () => {
  const [rows, setRows] = useState([]);

  const { isOpen, onOpen, onClose } = useDisclosure();

  const { data, refetch } = useQuery({
    queryKey: ["getTeachers"],
    queryFn: getTeachers,
  });

  useEffect(() => {
    if (data) {
      setRows(formatDataRow(data, columnsTeacher));
    }
  }, [data]);

  const mutation = useMutation({
    mutationFn: createTeacher,
    onSuccess: () => {
      refetch();
      onClose();
    },
  });

  const saveTeacher = async (data) => {
    const payload = {
      ...data,
      fechaNacimiento: formatDate(data.fechaNacimiento),
      roles: ["PROFESOR"],
    };

    mutation.mutate(payload);
  };

  const modal = (
    <>
      <Button
        onClick={onOpen}
        color={"white"}
        bg={"primary.400"}
        _hover={{
          bg: "#fff",
          color: "primary.400",
          border: "1px solid #4D44B5",
        }}
      >
        Agregar Profesor
      </Button>
      <GenericModalForm
        isOpen={isOpen}
        onClose={onClose}
        fields={fieldsTeacher}
        postFunction={saveTeacher}
      />
    </>
  );

  return (
    <Box pb={100}>
      <BannerSection
        mb={10}
        title="Lista de profesores"
        subtitle="Aquí puedes ver la lista de profesores registrados en el sistema, ademas de poder realizar acciones como ver, editar o eliminar un profesor."
      />
      <Table columns={columnsTeacher} rows={rows} actions modalToAdd={modal} />
    </Box>
  );
};

export default TeachersTable;
