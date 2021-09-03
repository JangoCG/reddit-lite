import {Box} from '@chakra-ui/react';
import React from 'react';


interface WrapperProps {
    variant?: "small" | "regular"
}

const Wrapper: React.FC<WrapperProps> = ({ children, variant = "regular" }) => {
    return (
        // mx = margin x direction
        // maxW = max width
        // w = width
        // mt = margin top
        <Box mt="8" mx="auto" maxW={variant === "regular" ? "800px" : "400px"} w="100%">
            {/* Children displays whatever you include between the opening and clasing tags when invoking this component */}
            {children}
        </Box>
    )

}

export default Wrapper;
