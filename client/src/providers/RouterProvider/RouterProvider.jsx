import {
  Auth,
  LandingPage,
  Layout,
  AdminPanel,
  TeachersPanel,
  CoursePanel,
  AttendantsPanel,
  StudentPanel,
  SubjectsPanel,
  AttendantView,
  TeacherView,
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
    element: (
      <PrivateRoutes rol={["ADMIN"]}>
        <SubjectsPanel />
      </PrivateRoutes>
    ),
  },
];

const PROFESOR_ROUTES = [
  {
    path: routes.PROFESOR.APP,
    element: (
      <PrivateRoutes rol={["PROFESOR"]}>
        <TeacherView />
      </PrivateRoutes>
    )
  },
  {
    path: routes.PROFESOR.ASSISTNCE,
    element: <div>asistencias</div>,
  },
  {
    path: routes.PROFESOR.OBSERVATIONS,
    element: <div>observaciones</div>,
  },
  {
    path: routes.PROFESOR.GRADE,
    element: <div>notas</div>,
  },
];

const ATTENDANT_ROUTES = [
  {
    path: routes.ACUDIENTE.APP,
    element: (
      <PrivateRoutes rol={["ACUDIENTE"]}>
        <AttendantView />
      </PrivateRoutes>
    )
  },
  {
    path: routes.ACUDIENTE.STUDENTS,
    element: (
      <PrivateRoutes rol={["ACUDIENTE"]}>
        <div>
          <h1>Estudiantes Acudidos</h1>
        </div>
      </PrivateRoutes>
    )
  },
  {
    path: routes.ACUDIENTE.APPOINTMENT,
    element: <div>Citas del acudiente</div>,
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
      ...ATTENDANT_ROUTES
    ],
  },
]);

function RouterProvider() {
  return <ReactRouterProvider router={router} />;
}

export default RouterProvider;
