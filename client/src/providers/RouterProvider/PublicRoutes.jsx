import PropTypes from "prop-types";
import { useUserStore } from "@store";
import { Navigate } from "react-router-dom";
import { routes } from "@config";

const PublicRoutes = ({ children }) => {
  const id = Boolean(useUserStore((state) => state.id));
  const rol = useUserStore((state) => state.roles[0]);

  return id ? <Navigate to={routes[rol].APP} /> : children;
};

PublicRoutes.propTypes = {
  children: PropTypes.node.isRequired,
};

export default PublicRoutes;
