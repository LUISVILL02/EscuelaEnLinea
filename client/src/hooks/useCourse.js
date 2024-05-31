import { getCourses, createCourse, deleteCourse } from "@services";
import { useEffect, useState } from "react";
import { useMutation, useQuery } from "@tanstack/react-query";

const useCourse = () => {
  const [courseD, setCourse] = useState({});
  const [courseFilterS, setCourseFilterS] = useState(" ");
  const [courseFilterOp, setCourseFilterOp] = useState(courseD);

  const { data, refetch, isLoading} = useQuery({
    queryKey: ["getCourses"],
    queryFn: getCourses,
  });

  useEffect(() => {
    if(!isLoading) {
        setCourse(data);
        setCourseFilterOp(data);
    }
  }, [data]);

  const mutationCreate = useMutation({
    mutationFn: createCourse,
    onSuccess: () => {
      refetch();
    },
  });

  const mutationDelete = useMutation({
    mutationFn: deleteCourse,
    onSuccess: () => {
      refetch();
    },
  });

  const handleSave = async (data) => {
    const payload = {
      ...data,
    };
    mutationCreate.mutate(payload);
  };

  const handleDelete = async (id) => {
    mutationDelete.mutate(id);
  };

  const handleFilter = (e) => {
    if (!data) return;

    const filter = e.target.value;

    setCourseFilterS(filter);

    const newData = { ...data };

    newData.content = newData.content.filter((course) => {
      return course.nombre.toLowerCase().includes(filter.toLowerCase());
    });

    setCourseFilterOp(newData);
    
  };

  return {
    courseFilter: courseFilterOp,
    courseFilterSearh: courseFilterS,
    courses: courseD,
    handleSave,
    handleDelete,
    handleFilter,
  };
};

export default useCourse;
