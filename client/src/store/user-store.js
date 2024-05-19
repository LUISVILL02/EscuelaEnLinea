import { create } from "zustand";

const initialState = {
  id: "",
  roles: "",
  identificacion: "",
  email: "",
};

export const useUserStore = create((set, get) => ({
  ...initialState,
  isActive: () => (get().id ? true : false),
  logIn: (user) => {
    localStorage.setItem("token", JSON.stringify(user.token));
    set({ ...user });
  },
  logOut: () => {
    localStorage.removeItem("token");
    set({ ...initialState });
  },
}));
