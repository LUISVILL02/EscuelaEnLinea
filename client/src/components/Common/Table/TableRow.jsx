import PropTypes from "prop-types";
import { ButtonGroup, IconButton, Td, Tr } from "@chakra-ui/react";
import { FaEdit, FaEye, FaTrash } from "react-icons/fa";

const TableRow = ({ columns, actions, row }) => {
  return (
    <Tr key={row.id} _hover={{ bg: "gray.200", cursor: "pointer" }}>
      {columns.map((column) => (
        <Td key={`${row.id}-${column.id}`}>{row[column.id]}</Td>
      ))}
      {actions && (
        <Td>
          <ButtonGroup>
            <IconButton
              variant="outline"
              colorScheme="black"
              isRound={true}
              _hover={{ bg: "info.50" }}
              icon={<FaEye />}
            />
            <IconButton
              variant="outline"
              colorScheme="black"
              isRound={true}
              _hover={{ bg: "success.50" }}
              icon={<FaEdit />}
            />
            <IconButton
              variant="outline"
              colorScheme="black"
              isRound={true}
              _hover={{ bg: "danger.50" }}
              icon={<FaTrash />}
            />
          </ButtonGroup>
        </Td>
      )}
    </Tr>
  );
};

TableRow.propTypes = {
  columns: PropTypes.array.isRequired,
  actions: PropTypes.bool,
  row: PropTypes.object.isRequired,
};

export default TableRow;
