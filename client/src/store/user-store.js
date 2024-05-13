import { create } from "zustand";

export const useUserStore = create((_, get) => ({
  id: "550e8400-e29b-41d4-a716-446655440002",
  firtName: "ayen",
  lastName: "medina camargo ",
  identification: "1234567890",
  email: "ayenmedinac@unimagdalena.edu.co",
  phone: "+57 300 123 4567",
  imgUrl: "https://bit.ly/dan-abramov",
  rol: "teacher",
  isActive: () => (get().id ? true : false),
}));
