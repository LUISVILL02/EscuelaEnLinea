import PropTypes from "prop-types";
import { Th, Thead, Tr } from "@chakra-ui/react";

const TableHead = ({ columns, actions }) => {
  return (
    <Thead>
      <Tr>
        {columns.map((column) => (
          <Th key={column.id} fontWeight={"bold"}>
            {column.label}
          </Th>
        ))}
        {actions && <Th>Acciones</Th>}
      </Tr>
    </Thead>
  );
};

TableHead.propTypes = {
  columns: PropTypes.array.isRequired,
  actions: PropTypes.bool,
};

export default TableHead;
