import axios from "axios";

export const createCourse = async (course) => {
  return await axios.post("/curso", course);
};

export const getCourses = async () => {
  return await axios.get("/curso");
}

export const getCourseById = async (id) => {
  return await axios.delete(`/curso/${id}`);
}

export const deleteCourse = async (id) => {
  return await axios.delete(`/curso/${id}`);
}
