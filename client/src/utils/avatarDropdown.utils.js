export const parseName = (name) => {
  return (name?.charAt(0).toUpperCase() + name?.slice(1))?.split(" ")[0];
};
