import { ChakraProvider } from "@chakra-ui/react";
import RouterProvider from "./providers";
import React from "react";
import ReactDOM from "react-dom/client";

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <ChakraProvider>
      <RouterProvider />
    </ChakraProvider>
  </React.StrictMode>,
);
