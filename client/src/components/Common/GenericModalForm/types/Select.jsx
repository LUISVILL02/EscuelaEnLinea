import PropTypes from "prop-types";
import { useOptions } from "@hooks";
import { FormLabel, Select } from "@chakra-ui/react";

const SelectTeacher = ({ field, register }) => {
  const data = useOptions(field);

  return (
    <>
      <FormLabel>{field.label}</FormLabel>
      <Select
        placeholder={field.label}
        {...register(field.name, field.validationRules)}
      >
        {data?.map((option) => (
          <option key={option.value} value={option.value}>
            {option.label}
          </option>
        ))}
      </Select>
    </>
  );
};

SelectTeacher.propTypes = {
  field: PropTypes.object.isRequired,
  register: PropTypes.func.isRequired,
};

export default SelectTeacher;
