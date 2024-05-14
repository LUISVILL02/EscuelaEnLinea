import Statistics from "./Statistics";
import Hero from "./Hero";
import BlogPost from "./BlogPost";
import { Box } from "@chakra-ui/react";
import Simple from "./Newsletter";

const LandingPage = () => {
  return (
    <Box mb={20}>
      <Hero />
      <Statistics />
      <BlogPost />
      <Simple />
    </Box>
  );
};

export default LandingPage;
