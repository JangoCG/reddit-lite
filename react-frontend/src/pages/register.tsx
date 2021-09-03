import React from "react";
import {Form, Formik} from "formik";
import {Box, Button} from "@chakra-ui/react";
import Wrapper from "../components/Wrapper";
import {InputField} from "../components/InputField";
import axios from "axios";

interface registerProps {
}

const Register: React.FC<registerProps> = ({}) => {
    const data = {
        username: "aaaaaaaaaaa",
        password: "123123213",
    };

    const client = axios.create({
        baseURL: "http://localhost:8081/api",
        timeout: 1000,
    });

    function registerUser() {
        client
            .post("/v1/user/register", data)
            .then((response) => {
                console.log(response.data);
            })
            .catch((err) => {
                console.log(err.response.data);
            });
    }

    return (
        <Wrapper variant="small">
            <Formik
                initialValues={{username: "", password: ""}}
                onSubmit={(values) => {
                    console.log(values);
                    registerUser();
                }}
            >
                {({isSubmitting}) => (
                    <Form>
                        <InputField
                            name="username"
                            placeholder="username"
                            label="Username"
                        />
                        <Box mt={4}>
                            <InputField
                                name="password"
                                placeholder="password"
                                label="Password"
                                type="password"
                            />
                        </Box>
                        <Button
                            mt={4}
                            type="submit"
                            colorScheme="teal"
                            isLoading={isSubmitting}
                        >
                            register
                        </Button>
                    </Form>
                )}
            </Formik>
        </Wrapper>
    );
};

export default Register;
