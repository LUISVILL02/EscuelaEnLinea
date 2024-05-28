import PropTypes from "prop-types";
import { Table as ChakraTable, Tbody, Tr, Td } from "@chakra-ui/react";
import TableHead from "./TableHead";
import TableRow from "./TableRow";
import TableLayout from "./TableLayout";

const Table = ({ columns, rows, actions, modalToAdd }) => {
  return (
    <TableLayout modalToAdd={modalToAdd}>
      <ChakraTable px={10}>
        <TableHead columns={columns} actions={actions} />
        <Tbody>
          {rows.length === 0 && (
            <Tr>
              <Td colSpan={columns.length + (actions ? 1 : 0)}>
                No se ha encontrado ningún registro
              </Td>
            </Tr>
          )}
          {rows.map((row) => (
            <TableRow
              key={row.id}
              columns={columns}
              actions={actions}
              row={row}
            />
          ))}
        </Tbody>
      </ChakraTable>
    </TableLayout>
  );
};

Table.propTypes = {
  columns: PropTypes.arrayOf(PropTypes.object).isRequired,
  rows: PropTypes.arrayOf(PropTypes.object).isRequired,
  actions: PropTypes.bool,
  modalToAdd: PropTypes.node,
};

export default Table;
