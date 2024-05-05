import PropTypes from "prop-types";

const PrivateRoutes = ({ children }) => {
  return <>{children}</>;
};

PrivateRoutes.propTypes = {
  children: PropTypes.node.isRequired,
};

export default PrivateRoutes;
