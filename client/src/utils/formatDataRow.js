export const formatDataRow = (data, columns) => {
  return data?.map((teacher) => {
    const formattedData = {};

    columns?.forEach((column) => {
      const { id } = column;
      formattedData[id] = teacher[id];
    });

    return { ...formattedData, id: teacher.idUser };
  });
};
