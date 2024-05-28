import { ChakraProvider } from "@chakra-ui/react";
import { RouterProvider } from "@providers";
import React from "react";
import ReactDOM from "react-dom/client";
import { theme } from "@config";
import { AxiosInterceptor } from "@services";
import { QueryClient, QueryClientProvider } from "@tanstack/react-query";
import { SnackbarProvider } from "notistack";
import { SnackbarUtilsConfigurator } from "@components";

AxiosInterceptor();
const queryClient = new QueryClient();

localStorage.removeItem("token");

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <QueryClientProvider client={queryClient}>
      <ChakraProvider theme={theme}>
        <SnackbarProvider>
          <SnackbarUtilsConfigurator />
          <RouterProvider />
        </SnackbarProvider>
      </ChakraProvider>
    </QueryClientProvider>
  </React.StrictMode>,
);
