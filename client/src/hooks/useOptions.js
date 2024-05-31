import useCourse from "@hooks/useCourse";
import useTeacher from "@hooks/useTeacher";
import {
  mapTeacherData,
  mapCourseData,
} from "../components/Admin/data/mappedData";

const useOptions = (options) => {

  if (options.name === "curso") {
    const { data } = useCourse();
    return mapCourseData(data);
  }else if (options.name === "idProfesor") {
    const { data } = useTeacher();
    return mapTeacherData(data);
  }
};

export default useOptions;
