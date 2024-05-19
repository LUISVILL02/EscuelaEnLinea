import PropTypes from "prop-types";
import { useUserStore } from "@store";
import { Navigate } from "react-router-dom";
import { routes } from "@config";

const PublicRoutes = ({ children }) => {
  const id = Boolean(useUserStore((state) => state.id));

  return id ? <Navigate to={routes.APP} /> : children;
};

PublicRoutes.propTypes = {
  children: PropTypes.node.isRequired,
};

export default PublicRoutes;
