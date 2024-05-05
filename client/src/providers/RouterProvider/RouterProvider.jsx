import { Auth, LandingPage } from "../../components";
import { routes } from "../../config";
import {
  createBrowserRouter,
  RouterProvider as ReactRouterProvider,
} from "react-router-dom";

const router = createBrowserRouter([
  {
    path: routes.AUTH,
    element: <Auth />,
  },
  {
    path: routes.LANDING_PAGE,
    element: <LandingPage />,
  },
]);

function RouterProvider() {
  return <ReactRouterProvider router={router} />;
}

export default RouterProvider;
