import useCourse from "@hooks/useCourse";
import useTeacher from "@hooks/useTeacher";
import useAttendant from "@hooks/useAttendant";
import {
  mapTeacherData,
  mapCourseData,
  mapAttendantData
} from "../components/Admin/data/mappedData";

const useOptions = (options) => {
  const { data: teacherData } = useTeacher();
  const { courses } = useCourse();
  const { AttendantData } = useAttendant();

  if (options.name === "idCurso") {
    return mapCourseData(courses.content);
  }

  if (options.name === "idProfesor") {
    return mapTeacherData(teacherData);
  }

  if (options.name === "idAcudiente") {
    return mapAttendantData(AttendantData);
  }

  return null;
};

export default useOptions;
