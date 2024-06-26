import { extendTheme } from "@chakra-ui/react";

//https://coolors.co/palette/f8f9fa-e9ecef-dee2e6-ced4da-adb5bd-6c757d-495057-343a40-212529
//https://v2.chakra-ui.com/docs/styled-system/theme
const theme = extendTheme({
  colors: {
    black: "#000",
    white: "#fff",
    gray: {
      50: "#E9ECEF",
      100: "#F1F3F5",
      200: "#DEE2E6",
      300: "#CED4DA",
      400: "#ADB5BD",
      500: "#6C757D",
      600: "#495057",
      700: "#343A40",
    },
    primary: {
      50: "#E0AAFF",
      100: "#C77DFF",
      200: "#9D4EDD",
      300: "#7B2CBF",
      400: "#5A189A", // primario
      500: "#3C096C",
      600: "#240046",
      700: "#10002B",
    },
    secondary: {
      50: "#FFD6A5",
      100: "#FFC178",
      200: "#FFA64A",
      300: "#FF8A1D",
      400: "#FF6C00",
      500: "#E55A00",
      600: "#B44A00",
      700: "#813A00",
    },
    danger: {
      50: "#FFD6D6",
      100: "#FFA8A8",
      200: "#FF7A7A",
      300: "#FF4D4D",
      400: "#FF1F1F",
      500: "#E50000",
      600: "#B40000",
      700: "#810000",
    },
    success: {
      50: "#D1FFD1",
      100: "#A3FFA3",
      200: "#75FF75",
      300: "#48FF48",
      400: "#1AFF1A",
      500: "#00E500",
      600: "#00B400",
      700: "#008100",
    },
    warning: {
      50: "#FFF5D1",
      100: "#FFECA3",
      200: "#FFE375",
      300: "#FFDB48",
      400: "#FFD21A",
      500: "#E5C500",
      600: "#B4A400",
      700: "#817F00",
    },
    info: {
      50: "#D1F0FF",
      100: "#A3E1FF",
      200: "#75D2FF",
      300: "#48C3FF",
      400: "#1AB4FF",
      500: "#009CE5",
      600: "#0078B4",
      700: "#005581",
    },
  },
  fontSizes: {
    xs: "0.75rem",
    sm: "0.875rem",
    md: "1rem",
    lg: "1.125rem",
    xl: "1.25rem",
    "2xl": "1.5rem",
    "3xl": "1.875rem",
    "4xl": "2.25rem",
    "5xl": "3rem",
    "6xl": "3.75rem",
    "7xl": "4.5rem",
    "8xl": "6rem",
    "9xl": "8rem",
  },
  fontWeights: {
    hairline: 100,
    thin: 200,
    light: 300,
    normal: 400,
    medium: 500,
    semibold: 600,
    bold: 700,
    extrabold: 800,
    black: 900,
  },
  lineHeights: {
    normal: "normal",
    none: 1,
    shorter: 1.25,
    short: 1.375,
    base: 1.5,
    tall: 1.625,
    taller: "2",
    3: ".75rem",
    4: "1rem",
    5: "1.25rem",
    6: "1.5rem",
    7: "1.75rem",
    8: "2rem",
    9: "2.25rem",
    10: "2.5rem",
  },
  letterSpacings: {
    tighter: "-0.05em",
    tight: "-0.025em",
    normal: "0",
    wide: "0.025em",
    wider: "0.05em",
    widest: "0.1em",
  },
});

export default theme;
