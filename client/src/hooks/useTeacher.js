import { useMutation, useQuery } from "@tanstack/react-query";
import { useEffect, useState } from "react";
import { createTeacher, deleteTeacher, getTeachers } from "@services";
import { formatDate } from "@utils";

const useTeacher = () => {
  const [teacherTerm, setTeacherTerm] = useState("");
  const [teacherData, setTeacherData] = useState([]);

  const { data, refetch } = useQuery({
    queryKey: ["getTeachers"],
    queryFn: getTeachers,
  });

  useEffect(() => {
    setTeacherData(data);
  }, [data]);

  const mutationCreate = useMutation({
    mutationFn: createTeacher,
    onSuccess: () => {
      refetch();
    },
  });

  const mutationDelete = useMutation({
    mutationFn: deleteTeacher,
    onSuccess: () => {
      refetch();
    },
  });

  const handleSave = async (data) => {
    const payload = {
      ...data,
      fechaNacimiento: formatDate(data.fechaNacimiento),
      roles: ["PROFESOR"],
    };
    mutationCreate.mutate(payload);
  };

  const handleDelete = async (id) => {
    mutationDelete.mutate(id);
  };

  const handleFilter = (e) => {
    if (!data) {
      return;
    }
    const term = e.target.value;
    setTeacherTerm(term);

    const filteredData = data.filter((teacher) => {
      const fullName = `${teacher.nombre} ${teacher.apellido}`;
      return fullName.toLowerCase().includes(term.toLowerCase());
    });

    setTeacherData(filteredData);
  };

  return {
    teacherTerm,
    data: teacherData,
    handleSave,
    handleDelete,
    handleFilter,
  };
};

export default useTeacher;
