import PropTypes from "prop-types";
import { FormLabel, Input } from "@chakra-ui/react";

const DefaultType = ({ field, register }) => {
  return (
    <>
      <FormLabel>{field.label}</FormLabel>
      <Input
        type={field.type}
        {...register(field.name, field.validationRules)}
      />
    </>
  );
};

DefaultType.propTypes = {
  field: PropTypes.object.isRequired,
  register: PropTypes.func.isRequired,
};

export default DefaultType;
