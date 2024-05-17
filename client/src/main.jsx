import { ChakraProvider } from "@chakra-ui/react";
import RouterProvider from "@providers";
import React from "react";
import ReactDOM from "react-dom/client";
import { theme } from "@config";

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <ChakraProvider theme={theme}>
      <RouterProvider />
    </ChakraProvider>
  </React.StrictMode>,
);
