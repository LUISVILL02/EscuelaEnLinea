import { useMutation, useQuery } from "@tanstack/react-query";
import { useEffect, useState } from "react";
import { createAttendant, getAttendant, deleteAttendant } from "@services";
import { formatDate } from "@utils";

const useAttendant = () => {
  const [attendantTerm, setAttendantTerm] = useState("");
  const [AttendantData, setAttendantData] = useState([]);

  const { data, refetch, isLoading } = useQuery({
    queryKey: ["getAttendants"],
    queryFn: getAttendant,
  });

  useEffect(() => {
    if (!isLoading) {
      setAttendantData(data);
    }
  }, [data, isLoading]);

  const mutationCreate = useMutation({
    mutationFn: createAttendant,
    onSuccess: () => {
      refetch();
    },
  });

  const mutationDelete = useMutation({
    mutationFn: deleteAttendant,
    onSuccess: () => {
      refetch();
    },
  });

  const handleSave = async (data) => {
    const payload = {
      ...data,
      fechaNacimiento: formatDate(data.fechaNacimiento),
      roles: ["ACUDIENTE"],
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
    setAttendantTerm(term);

    const filteredData = data.filter((teacher) => {
      const fullName = `${teacher.nombre} ${teacher.apellido}`;
      return fullName.toLowerCase().includes(term.toLowerCase());
    });

    setAttendantData(filteredData);
  };

  return {
    attendantTerm,
    AttendantData,
    handleSave,
    handleDelete,
    isLoading,
    handleFilter,
  };
};

export default useAttendant;
