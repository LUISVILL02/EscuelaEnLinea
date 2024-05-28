import PropTypes from "prop-types";
import { Search2Icon } from "@chakra-ui/icons";
import {
  Box,
  Flex,
  Input,
  InputGroup,
  InputLeftElement,
} from "@chakra-ui/react";

const TableLayout = ({ modalToAdd, children }) => {
  return (
    <Flex justify="center" px={40}>
      <Box
        overflowX="auto"
        overflowY="auto"
        maxHeight="500px"
        minWidth={{ base: "100vw", md: "80vw" }}
      >
        <Box mb={4}>
          <Flex justify="space-between" align="center">
            <Box>
              <InputGroup m={1}>
                <InputLeftElement pointerEvents="none">
                  <Search2Icon color="gray.300" />
                </InputLeftElement>
                <Input
                  type="tel"
                  placeholder="Buscar Estudiante"
                  focusBorderColor="primary.400"
                />
              </InputGroup>
            </Box>
            {modalToAdd}
          </Flex>
        </Box>
        {children}
      </Box>
    </Flex>
  );
};

TableLayout.propTypes = {
  children: PropTypes.node.isRequired,
  modalToAdd: PropTypes.node,
};

export default TableLayout;
