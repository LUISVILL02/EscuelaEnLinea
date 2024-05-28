import PropTypes from "prop-types";
import { Td, Tr } from "@chakra-ui/react";
import { useNavigate } from "react-router-dom";

const TableRow = ({ columns, row }) => {
  const navigate = useNavigate();

  const handleClick = (id) => {
    navigate(`${id}`);
  };

  return (
    <Tr
      key={row.id}
      _hover={{ bg: "gray.100", cursor: "pointer" }}
      onClick={() => handleClick(row.id)}
    >
      {columns.map((column) => (
        <Td key={`${row.id}-${column.id}`}>{row[column.id]}</Td>
      ))}
    </Tr>
  );
};

TableRow.propTypes = {
  columns: PropTypes.array.isRequired,
  actions: PropTypes.bool,
  row: PropTypes.object.isRequired,
};

export default TableRow;
