import PropTypes from "prop-types";
import { useUserStore } from "@store";
import { routes } from "@config";
import { Navigate } from "react-router-dom";

const PrivateRoutes = ({ rol, children }) => {
  const id = Boolean(useUserStore((state) => state.id));
  const role = useUserStore((state) => state.roles[0]);

  if (!rol.includes(role)) {
    return <Navigate to={routes.AUTH} />;
  }

  return id ? children : <Navigate to={routes.AUTH} />;
};

PrivateRoutes.propTypes = {
  rol: PropTypes.arrayOf(PropTypes.string),
  children: PropTypes.node.isRequired,
};

export default PrivateRoutes;
