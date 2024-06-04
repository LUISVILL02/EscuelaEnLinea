import {
  Auth,
  LandingPage,
  Layout,
  AdminPanel,
  TeachersPanel,
  CoursePanel,
  AttendantsPanel,
  StudentPanel,
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
    element: (
      <PrivateRoutes rol={["ADMIN"]}>
        <StudentPanel />
      </PrivateRoutes>
    ),
  },
  {
    path: routes.ADMIN.TEACHERS,
    element: (
      <PrivateRoutes rol={["ADMIN"]}>
        <TeachersPanel />
      </PrivateRoutes>
    ),
  },
  {
    path: routes.ADMIN.ATTENDANTS,
    element: (
      <PrivateRoutes rol={["ADMIN"]}>
        <AttendantsPanel />
      </PrivateRoutes>
    ),
  },
  {
    path: routes.ADMIN.COURSES,
    element: (
      <PrivateRoutes rol={["ADMIN"]}>
        <CoursePanel />
      </PrivateRoutes>
    ),
  },
  {
    path: routes.ADMIN.SUBJECTS,
    element: <div>Subjects</div>,
  },
];

const PROFESOR_ROUTES = [
  {
    path: routes.PROFESOR.APP,
    element: <div>vista profesor</div>,
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
      ...PROFESOR_ROUTES,
    ],
  },
]);

function RouterProvider() {
  return <ReactRouterProvider router={router} />;
}

export default RouterProvider;
