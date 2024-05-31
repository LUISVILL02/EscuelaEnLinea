import { Navbar } from "./Navbar";
import { Footer } from "./Footer";
import { Outlet } from "react-router-dom";
import { Box, Flex } from "@chakra-ui/react";

const Layout = () => {
  return (
    <Flex direction="column" minH="100vh">
      <Box flex="1">
        <Navbar />
        <Outlet />
      </Box>
      <Footer />
    </Flex>
  );
};

export default Layout;
