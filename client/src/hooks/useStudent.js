import {
  getAlumnos,
  createAlumno,
  deleteAlumno,
  getAlumnoPorAcudiente,
} from "@services";
import { useEffect, useState } from "react";
import { useMutation, useQuery } from "@tanstack/react-query";
import { formatDate } from "@utils";

const useStudent = ({start, limit}) => {
  const [student, setstudent] = useState({});
  //const [courseFilterS, setCourseFilterS] = useState("");
  //const [courseFilterOp, setCourseFilterOp] = useState(courseD);

  const { data, refetch, isLoading } = useQuery({
    queryKey: ["getAlumnos", start, limit],
    queryFn: getAlumnos,
  });

  useEffect(() => {
    if (!isLoading) {
      setstudent(data);
      //setCourseFilterOp(data);
    }
  }, [data, isLoading]);

  const mutationCreate = useMutation({
    mutationFn: createAlumno,
    onSuccess: () => {
      refetch();
    },
  });

  const mutationDelete = useMutation({
    mutationFn: deleteAlumno,
    onSuccess: () => {
      refetch();
    },
  });

  const handleSave = async (data) => {
    console.log(data)
    const payload = {
      ...data,
      fechaNacimiento: formatDate(data.fechaNacimiento),
    };
    console.log("handleSave: ",payload)
    mutationCreate.mutate(payload);
  };

  const handleDelete = async (id) => {
    mutationDelete.mutate(id);
  };

//   const handleFilter = (e) => {
//     if (!data) {
//       return;
//     }

//     const filter = e.target.value;

//     setCourseFilterS(filter);

//     const newData = { ...data };

//     newData.content = newData.content.filter((course) => {
//       return course.nombre.toLowerCase().includes(filter.toLowerCase());
//     });

//     setCourseFilterOp(newData);
//   };

  return {
    //courseFilter: courseFilterOp,
    //courseFilterSearh: courseFilterS,
    students: student,
    handleSave,
    handleDelete,
    //handleFilter,
  };
};

export default useStudent;
