import {
  Button,
  Flex,
  Heading,
  Stack,
  Text,
  VStack,
  useBreakpointValue,
} from "@chakra-ui/react";
import { routes } from "@config";
import { useEffect, useState } from "react";
import { NavLink } from "react-router-dom";

import img1 from "@assets/imgs/carousel/carousel1.jpeg";
import img2 from "@assets/imgs/carousel/carousel2.jpeg";
import img3 from "@assets/imgs/carousel/carousel3.jpeg";
import img4 from "@assets/imgs/carousel/carousel4.jpeg";
import img5 from "@assets/imgs/carousel/carousel5.jpeg";
import img6 from "@assets/imgs/carousel/carousel6.jpeg";

const ALL_URL_IMG = [img1, img2, img3, img4, img5, img6];

const Hero = () => {
  const [img, setImg] = useState(ALL_URL_IMG[0]);

  useEffect(() => {
    const interval = setInterval(() => {
      const index = ALL_URL_IMG.indexOf(img);
      if (index === ALL_URL_IMG.length - 1) {
        setImg(ALL_URL_IMG[0]);
      } else {
        setImg(ALL_URL_IMG[index + 1]);
      }
    }, 5000);

    return () => clearInterval(interval);
  }, [img]);

  const scroll = () => {
    const section = document.querySelector("#blog");
    section.scrollIntoView({ behavior: "smooth", block: "start" });
  };

  return (
    <Flex
      w={"full"}
      h={"calc(100vh - 62px)"}
      backgroundImage={`url(${img})`}
      backgroundSize={"cover"}
      backgroundPosition={"center center"}
    >
      <VStack
        w={"full"}
        justify={"center"}
        px={useBreakpointValue({ base: 4, md: 8 })}
        bgGradient={"linear(to top, blackAlpha.700, blackAlpha.200)"}
      >
        <Stack maxW={"4xl"} align={"flex-start"} spacing={6}>
          <Heading
            fontWeight={600}
            color={"white"}
            fontSize={{ base: "5xl", sm: "5xl", md: "6xl" }}
            lineHeight={"110%"}
          >
            Transforma tu vida con eduación de{" "}
            <Text
              as={"span"}
              bg={"primary.400"}
              color={"white"}
              px={3}
              pb={2}
              borderRadius={10}
              my={0}
              lineHeight={"150%"}
            >
              alta calidad
            </Text>
          </Heading>
          <Text color={"gray.50"} maxW={"3xl"}>
            La Universidad del Magdalena es una universidad pública
            departamental cuya sede principal está ubicada en la ciudad de Santa
            Marta, capital del Magdalena, Colombia. Posee uno de los campus más
            grandes de la región.
          </Text>
          <Stack direction={"row"}>
            <Button
              as={NavLink}
              to={routes.AUTH}
              bg={"primary.400"}
              rounded={"full"}
              color={"white"}
              _hover={{
                bg: "primary.500",
              }}
            >
              Inciar Sesión
            </Button>
            <Button
              onClick={() => scroll()}
              bg={"whiteAlpha.300"}
              rounded={"full"}
              color={"white"}
              _hover={{ bg: "whiteAlpha.500" }}
            >
              ver noticias
            </Button>
          </Stack>
        </Stack>
      </VStack>
    </Flex>
  );
};

export default Hero;
