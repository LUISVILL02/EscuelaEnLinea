import {
  Auth,
  LandingPage,
  Layout,
  AdminPanel,
  TeachersTable,
} from "@components";
import { routes } from "@config";
import {
  createBrowserRouter,
  RouterProvider as ReactRouterProvider,
} from "react-router-dom";
import PublicRoutes from "./PublicRoutes";
import PrivateRoutes from "./PrivateRoutes";

const ADMIN_ROUTES = [
  {
    path: routes.ADMIN.APP,
    element: (
      <PrivateRoutes rol={["ADMIN"]}>
        <AdminPanel />
      </PrivateRoutes>
    ),
  },
  {
    path: routes.ADMIN.STUDENTS,
    element: <div>Students</div>,
  },
  {
    path: routes.ADMIN.TEACHERS,
    element: (
      <PrivateRoutes rol={["ADMIN"]}>
        <TeachersTable />
      </PrivateRoutes>
    ),
  },
  {
    path: routes.ADMIN.ATTENDANTS,
    element: <div>Attendants</div>,
  },
  {
    path: routes.ADMIN.COURSES,
    element: <div>Courses</div>,
  },
  {
    path: routes.ADMIN.SUBJECTS,
    element: <div>Subjects</div>,
  },
];

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
      ...ADMIN_ROUTES,
    ],
  },
]);

function RouterProvider() {
  return <ReactRouterProvider router={router} />;
}

export default RouterProvider;
