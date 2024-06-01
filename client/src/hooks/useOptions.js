import useCourse from "@hooks/useCourse";
import useTeacher from "@hooks/useTeacher";
import {
  mapTeacherData,
  mapCourseData,
} from "../components/Admin/data/mappedData";

const useOptions = (options) => {
  const { data: teacherData } = useTeacher();
  const { data: courseData } = useCourse();

  if (options.name === "curso") {
    return mapCourseData(courseData);
  }

  if (options.name === "idProfesor") {
    return mapTeacherData(teacherData);
  }

  return null;
};

export default useOptions;
