import { create } from "zustand";

const initialState = {
  id: "",
  firtName: "",
  lastName: "",
  identification: "",
  email: "",
  phone: "",
  imgUrl: "",
  rol: "",
};

export const useUserStore = create((set, get) => ({
  ...initialState,
  isActive: () => (get().id ? true : false),
  logIn: (user) => set({ ...user }),
  logOut: () => set({ ...initialState }),
}));
