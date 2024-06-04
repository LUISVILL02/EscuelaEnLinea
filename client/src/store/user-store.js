import { create } from "zustand";

const initialState = {
  id: "",
  roles: "",
  identificacion: "",
  email: "",
  nombre: "",
};

export const useUserStore = create((set, get) => ({
  ...initialState,
  isActive: () => (get().id ? true : false),
  nombre: () => get().nombre,
  logIn: (user) => {
    localStorage.setItem("token", user.token);
    set({ ...user });
  },
  logOut: () => {
    localStorage.removeItem("token");
    set({ ...initialState });
  },
}));
