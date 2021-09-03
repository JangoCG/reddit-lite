import {
  FormControl,
  FormLabel,
  Input,
  FormErrorMessage,
} from "@chakra-ui/react";
import { useField } from "formik";
import React from "react";

interface InputFieldProps {
  label: string;
  placeholder: string;
  name: string;
  type?: string;
}

export const InputField: React.FC<InputFieldProps> = (props) => {
  // special formik hook
  const [field, { error }] = useField(props);

  return (
    // !! error casts string to boolean -> empty string = false
    // !!''=> false
    // !!"message" => true

    <FormControl isInvalid={!!error}>
      <FormLabel htmlFor={field.name}>{props.label}</FormLabel>
      <Input
        {...field}
        id={field.name}
        type={props.type}
        placeholder={props.placeholder}
      />

      {error ? <FormErrorMessage>{error}</FormErrorMessage> : null}
    </FormControl>
  );
};
