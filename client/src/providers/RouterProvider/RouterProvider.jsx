import { Auth, LandingPage, Layout } from "@components";
import { routes } from "@config";
import {
  createBrowserRouter,
  RouterProvider as ReactRouterProvider,
} from "react-router-dom";

const router = createBrowserRouter([
  {
    path: routes.HOME,
    element: <Layout />,
    children: [
      {
        path: routes.HOME,
        element: <LandingPage />,
      },
      {
        path: routes.AUTH,
        element: <Auth />,
      },
    ],
  },
]);

function RouterProvider() {
  return <ReactRouterProvider router={router} />;
}

export default RouterProvider;
