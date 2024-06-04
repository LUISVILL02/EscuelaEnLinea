import { useMutation, useQuery } from "@tanstack/react-query";
import { useEffect, useState } from "react";
import { createSubject, deleteSubject, getSubjects } from "@services";

const useSubject = () => {
  const [subjectTerm, setsubjectTerm] = useState("");
  const [subjectData, setSubjectData] = useState([]);

  const { data, refetch, isLoading } = useQuery({
    queryKey: ["getSubject"],
    queryFn: getSubjects,
  });

  useEffect(() => {
    if (!isLoading) {
      setSubjectData(data);
    }
  }, [data, isLoading]);

  const mutationCreate = useMutation({
    mutationFn: createSubject,
    onSuccess: () => {
      refetch();
    },
  });

  const mutationDelete = useMutation({
    mutationFn: deleteSubject,
    onSuccess: () => {
      refetch();
    },
  });

  const handleSave = async (data) => {
    mutationCreate.mutate(data);
  };

  const handleDelete = async (id) => {
    mutationDelete.mutate(id);
  };

  const handleFilter = (e) => {
    if (!data) {
      return;
    }
    const term = e.target.value;
    setsubjectTerm(term);

    const filteredData = data.filter((subject) =>
      subject.nombre.toLowerCase().includes(term.toLowerCase()),
    );

    setSubjectData(filteredData);
  };

  return {
    subjectTerm,
    subjectData,
    handleSave,
    handleDelete,
    isLoading,
    handleFilter,
  };
};

export default useSubject;
