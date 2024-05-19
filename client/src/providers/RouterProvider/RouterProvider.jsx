import { Auth, LandingPage, Layout, App } from "@components";
import { routes } from "@config";
import {
  createBrowserRouter,
  RouterProvider as ReactRouterProvider,
} from "react-router-dom";
import PublicRoutes from "./PublicRoutes";

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
        element: (
          <PublicRoutes>
            <Auth />
          </PublicRoutes>
        ),
      },
      {
        path: routes.APP,
        element: <App />,
      },
      {
        path: routes.ASSISTANCES,
        element: <div>Assistances</div>,
      },
      {
        path: routes.REMARKS,
        element: <div>Remarks</div>,
      },
      {
        path: routes.MESSAGES,
        element: <div>Messages</div>,
      },
      {
        path: routes.SETTINGS,
        element: <div>Settings</div>,
      },
    ],
  },
]);

function RouterProvider() {
  return <ReactRouterProvider router={router} />;
}

export default RouterProvider;
