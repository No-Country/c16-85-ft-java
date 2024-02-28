import React from 'react';

const ChargeService = () => {
    return (
        <div className="flex justify-center items-center h-screen bg-slate-600">
            <div className="flex justify-center items-center">
                <div className="flex justify-center items-center gap-8 p-8 mx-auto max-w-4xl bg-slate-400 md:rounded-lg">
                    <div className="flex flex-col text-center items-center gap-8 basis-1/2">
                        <h1 className="text-4xl font-bold text-gray-800 text-center">¡Comparte tus talentos! Registra tu Servicio Aquí</h1>
                        <p className="text-center text-gray-600 text-sm mt-2">¡Bienvenido al espacio donde tus habilidades brillan! Este es tu lugar para conectar con quienes necesitan lo que tú haces mejor. En nuestro vibrante Marketplace de Servicios, te invitamos a compartir tus talentos y conocimientos con el mundo. Completa nuestro sencillo formulario y comienza a formar parte de nuestra comunidad de creadores y proveedores de servicios</p>
                        <p>ACA El LOGO</p>
                    </div>
                    <div className="basis-1/2">
                        <form action="https://fabform.io/f/xxxxx" method="post" className="flex flex-col gap-4">
                            <input type="text" name="name" placeholder="Titulo del servicio" className="rounded-md py-2.5 px-4 border text-sm outline-[#007bff]" required />
                            <textarea name="Descripcion del servicio" placeholder="Descripcion del servicio (recomendado)" cols="30" rows="5" className="rounded-md py-2.5 px-4 border text-sm outline-[#007bff]" required></textarea>
                            <input type="text" placeholder="Direccion" name="subject" className="rounded-md py-2.5 px-4 border text-sm outline-[#007bff]" required/>
                            <input type="text" placeholder="Celular" name="subject" className="rounded-md py-2.5 px-4 border text-sm outline-[#007bff]" required/>
                            <input type="text" placeholder="Departamento opcional" name="subject" className="rounded-md py-2.5 px-4 border text-sm outline-[#007bff]"/>
                            <button type="button" className="text-white bg-[#007bff] hover:bg-blue-600 font-semibold rounded-md text-sm px-4 py-2.5 w-full">Registrarse</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default ChargeService;
