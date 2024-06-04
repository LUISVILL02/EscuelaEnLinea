import PropTypes from "prop-types";
import {
  Modal,
  ModalOverlay,
  ModalContent,
  ModalHeader,
  ModalCloseButton,
  ModalBody,
  ModalFooter,
  Button,
  FormControl,
} from "@chakra-ui/react";
import { useForm } from "react-hook-form";
import Select from "./types/Select";
import DefaultType from "./types/DefaultType";

const GenericModalForm = ({ isOpen, onClose, fields, postFunction }) => {
  const { handleSubmit, register, reset } = useForm();

  const onSubmit = async (data) => {
    await postFunction(data);
    onClose();
    reset();
  };

  const renderField = (field, register) => {
    switch (field.type) {
      case "selectTeacher":
        return <Select field={field} register={register} />;
      case "selectCourse":
        return <Select field={field} register={register} />;
      case "selectAttendants":
        return <Select field={field} register={register} />;
      default:
        return <DefaultType field={field} register={register} />;
    }
  };

  return (
    <Modal isOpen={isOpen} onClose={onClose}>
      <ModalOverlay />
      <ModalContent>
        <ModalHeader>Agregar nuevo</ModalHeader>
        <ModalCloseButton />
        <form onSubmit={handleSubmit(onSubmit)}>
          <ModalBody>
            {fields.map((field) => (
              <FormControl key={field.name} mb={4}>
                {renderField(field, register)}
              </FormControl>
            ))}
          </ModalBody>
          <ModalFooter>
            <Button
              colorScheme="blue"
              mr={3}
              type="submit"
              bg="primary.400"
              _hover={{
                bg: "#fff",
                color: "primary.400",
                border: "1px solid #4D44B5",
              }}
            >
              Guardar
            </Button>
            <Button variant="ghost" onClick={onClose}>
              Cancelar
            </Button>
          </ModalFooter>
        </form>
      </ModalContent>
    </Modal>
  );
};

GenericModalForm.propTypes = {
  isOpen: PropTypes.bool.isRequired,
  onClose: PropTypes.func.isRequired,
  fields: PropTypes.arrayOf(
    PropTypes.shape({
      name: PropTypes.string.isRequired,
      label: PropTypes.string.isRequired,
      type: PropTypes.string.isRequired,
      validationRules: PropTypes.object,
    }),
  ).isRequired,
  postFunction: PropTypes.func.isRequired,
};

export default GenericModalForm;
