import {
  getAlumnos,
  createAlumno,
  deleteAlumno,
  updateAlumno,
} from "@services";
import { useEffect, useState } from "react";
import { useMutation, useQuery } from "@tanstack/react-query";
import { formatDate } from "@utils";

const useStudent = ({start, limit}, idAlumno) => {
  const [student, setstudent] = useState([]);
  const [loading, setLoading] = useState(true);
  const [filterS, setStudentFilterS] = useState("");
  const [filtroSelect, setFiltroSelect] = useState("");

  const { data, refetch, isLoading } = useQuery({
    queryKey: ["getAlumnos", start, limit],
    queryFn: getAlumnos,
  });

  useEffect(() => {
    setLoading(isLoading);
    if (!isLoading) {
      setstudent(data.content);
    }
  }, [data, isLoading]);

  const mutationCreate = useMutation({
    mutationFn: createAlumno,
    onSuccess: () => {
      refetch();
    },
  });

  const mutationUpdate = useMutation({
    mutationFn: updateAlumno,
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
    const payload = {
      ...data,
      fechaNacimiento: formatDate(data.fechaNacimiento),
    };
    mutationCreate.mutate(payload);
  };

  const handleUpdate = async (data) => {
    const payload = {
      ...data,
      fechaNacimiento: formatDate(data.fechaNacimiento),
      idAlumno: idAlumno,
    };
    mutationUpdate.mutate(payload);
  }

  const handleDelete = async (id) => {
    mutationDelete.mutate(id);
  };

  const handleFilter = (e) => {
    if (!data) {
      return;
    }
    const filter = e.target.value;
    let filteredData = [];

    if(filtroSelect === "Acudiente"){
      filteredData = data.content.filter((student) => {
        const fullName = `${student.nombreAcudiente} ${student.apellidoAcudiente}`;
        return fullName.toLowerCase().includes(filter.toLowerCase());
      }
    )};
    if (filtroSelect === "Nombre estudiante") {
      filteredData = data.content.filter((student) => {
        const fullName = `${student.nombre} ${student.apellido}`;
        return fullName.toLowerCase().includes(filter.toLowerCase());
      });
    };
    if (filtroSelect === "Curso") {
      filteredData = data.content.filter((student) => {
        const fullName = `${student.nombreCurso}`;
        return fullName.toLowerCase().includes(filter.toLowerCase());
      });
    };
    setstudent(filteredData);
    setStudentFilterS(filter);
  };
  

  const selectFilter = async (e) => {
    const selectFil = e.target.value;
    setFiltroSelect(selectFil);
  }

  return {
    students: student,
    handleSave,
    handleUpdate,
    handleDelete,
    loading,
    handleFilter,
    selectFilter,
  };
};

export default useStudent;
