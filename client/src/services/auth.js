const api = import.meta.env.VITE_URL_API;

export const login = async (correo, contraseña) => {
    const datos = {correo, contraseña};

    console.log("datos de sesion:" ,datos);
    const res = await fetch(`${api}/EscuelaEnLinea/V.1.0.0/auth/login`, {
                            method: "POST",
                            body: JSON.stringify(datos),
                            headers: {"Content-type": "application/json; charset=UTF-8"}
                        });
    const data = await res.json();
    return data;
}