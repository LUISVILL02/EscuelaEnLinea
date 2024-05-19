import {
  Box,
  Button,
  Flex,
  Heading,
  Image,
  SimpleGrid,
  Stack,
  Text,
  chakra,
} from "@chakra-ui/react";
import { IoIosArrowForward } from "react-icons/io";
import { arrBlogs } from "./data/blogs";
import PropTypes from "prop-types";

const BlogPost = () => {
  return (
    <Box maxW="4xl" mx={{ base: "36px", lg: "auto" }} pt={5}>
      <Flex direction="column" alignItems="flex-start" py={10}>
        <chakra.h2 fontSize={"3xl"} fontWeight={"bold"} id="blog">
          Ultimas noticias
        </chakra.h2>
        <Box width="100px" height="5px" bg="primary.400" />
      </Flex>
      <SimpleGrid columns={{ base: 1, sm: 1, md: 2, lg: 3 }} spacing={5}>
        {arrBlogs.map((blog, i) => (
          <CardBlog
            title={blog.title}
            key={i}
            imgUrl={blog.imgUrl}
            text={blog.text}
            cat={blog.cat}
          />
        ))}
      </SimpleGrid>
    </Box>
  );
};

const CardBlog = ({ imgUrl, title, text, cat }) => {
  return (
    <Box
      maxW={"445px"}
      borderColor={"gray.100"}
      borderWidth={1}
      boxShadow={"none"}
      rounded={"md"}
      display="flex"
      flexDirection="column"
      justifyContent="space-between"
    >
      <Box>
        <Box bg={"gray.100"} mb={6}>
          <Image src={imgUrl} />
        </Box>
        <Stack px={5} pb={5}>
          <Heading color={"gray.700"} fontSize={"2xl"} fontFamily={"body"}>
            {title}
          </Heading>
          <Text
            textTransform={"uppercase"}
            color={"primary.400"}
            fontWeight={800}
            fontSize={"sm"}
            letterSpacing={1.1}
          >
            {cat}
          </Text>
          <Text color={"gray.500"}>
            {text.split(" ").slice(0, 40).join(" ")}...
          </Text>
        </Stack>
      </Box>
      <Box px={5} pb={5}>
        <Button
          mt={5}
          bg={"primary.500"}
          color={"white"}
          rightIcon={<IoIosArrowForward />}
          colorScheme="gray"
          _hover={{
            bg: "#fff",
            color: "primary.400",
            border: "1px solid #4D44B5",
          }}
        >
          Ver mas
        </Button>
      </Box>
    </Box>
  );
};

CardBlog.propTypes = {
  imgUrl: PropTypes.string,
  title: PropTypes.string,
  text: PropTypes.string,
  cat: PropTypes.string,
};

export default BlogPost;
