import PropTypes from "prop-types";
import { Box, Button } from "@chakra-ui/react";
import { GenericModalForm } from "@components/Common";

const ButtonAddModal = ({
  onOpen,
  isOpen,
  onClose,
  fields,
  saveFunction,
  message,
  props,
}) => {
  return (
    <Box {...props}>
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
        {message}
      </Button>
      <GenericModalForm
        isOpen={isOpen}
        onClose={onClose}
        fields={fields}
        postFunction={saveFunction}
      />
    </Box>
  );
};

ButtonAddModal.propTypes = {
  onOpen: PropTypes.func.isRequired,
  isOpen: PropTypes.bool.isRequired,
  onClose: PropTypes.func.isRequired,
  fields: PropTypes.array.isRequired,
  saveFunction: PropTypes.func.isRequired,
  message: PropTypes.string.isRequired,
  props: PropTypes.object,
};

export default ButtonAddModal;
