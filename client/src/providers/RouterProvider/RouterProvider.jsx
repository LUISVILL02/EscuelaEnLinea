import { Auth, LandingPage, Layout } from "../../components";
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
  return (
    <Layout>
      <ReactRouterProvider router={router} />
    </Layout>
  );
}

export default RouterProvider;
