import PropTypes from "prop-types";
import {
  Box,
  Flex,
  IconButton,
  Stack,
  Table,
  Tbody,
  Td,
  Th,
  Thead,
  Tr,
} from "@chakra-ui/react";
import { DeleteIcon, EditIcon } from "@chakra-ui/icons";

const SubjectTable = ({ rows, handleDelete }) => {
  if (!rows) {
    return null;
  }

  return (
    <Flex justify="center" px={40}>
      <Box
        overflowX="auto"
        overflowY="auto"
        maxHeight="500px"
        minWidth={{ base: "100vw", md: "80vw" }}
      >
        <Table px={10}>
          <Thead>
            <Tr>
              <Th>Indice</Th>
              <Th>Nombre asignatura</Th>
              <Th>Acciones</Th>
            </Tr>
          </Thead>
          <Tbody>
            {rows.length === 0 ? (
              <Tr>
                <Td>No se ha encontrado ningún registro</Td>
              </Tr>
            ) : (
              rows.map((row, i) => (
                <TableRow
                  indice={i + 1}
                  key={row.idAsignatura}
                  row={row}
                  handleDelete={handleDelete}
                />
              ))
            )}
          </Tbody>
        </Table>
      </Box>
    </Flex>
  );
};

SubjectTable.propTypes = {
  rows: PropTypes.arrayOf(PropTypes.object).isRequired,
  handleDelete: PropTypes.func,
};

export default SubjectTable;

// ------------------------------------------------------------------------------------------

const TableRow = ({ row, indice, handleDelete }) => {
  return (
    <Tr key={row.id}>
      <Td>{indice}</Td>
      <Td>{row.nombre}</Td>
      <Td>
        <Stack direction="row" spacing={4} align="center">
          <IconButton
            borderRadius={10}
            variant={"outline"}
            color={"black"}
            aria-label={`boton de borrar la asignatura ${row.nombre}`}
            onClick={() => handleDelete(row.idAsignatura)}
            icon={<DeleteIcon />}
          />
          <IconButton
            borderRadius={10}
            variant={"outline"}
            color={"black"}
            aria-label={`boton de editar la asignatura ${row.nombre}`}
            onClick={() => console.log(`editado id=${row.idAsignatura}`)}
            icon={<EditIcon />}
          />
        </Stack>
      </Td>
    </Tr>
  );
};

TableRow.propTypes = {
  row: PropTypes.object.isRequired,
  indice: PropTypes.number.isRequired,
  handleDelete: PropTypes.func,
};
