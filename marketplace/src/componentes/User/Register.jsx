
const Register = () => {
    return (
<>
        <nav>
            
        </nav>

        <div class="flex justify-center items-center h-screen bg-slate-600">
            <div class="flex justify-center items-center">
                <div class="flex justify-center items-center gap-8 p-8 mx-auto max-w-4xl bg-slate-400 md:rounded-lg">
                    <div className="flex flex-col text-center items-center gap-8 basis-1/2">
                        <h1 class="text-4xl font-bold text-gray-800 text-center">Únete a nuestro Marketplace de Servicios</h1>
                        <p class="text-center text-gray-600 text-sm mt-2">¡Bienvenido al registro para unirte a nuestro vibrante Marketplace de Servicios! Estamos emocionados de que te unas a nuestra comunidad donde podrás encontrar una amplia variedad de servicios ofrecidos por profesionales cualificados. Completa el formulario a continuación para comenzar tu viaje con nosotros.</p>
                        <p>ACA El LOGO</p>
                    </div>
                    <div className="basis-1/2">
                        <form action="https://fabform.io/f/xxxxx" method="post" class="flex flex-col gap-4">
                        <input type="mail" name="mail" placeholder="Email" class="rounded-md py-2.5 px-4 border text-sm outline-[#007bff]"/>
                        <input type="password" name="pasword" placeholder="Contraseña" class="rounded-md py-2.5 px-4 border text-sm outline-[#007bff]"/>
                        <input type="text" name="name" placeholder="Nombre" class="rounded-md py-2.5 px-4 border text-sm outline-[#007bff]"/>
                        <input type="text" name="apellido" placeholder="Apellido" class="rounded-md py-2.5 px-4 border text-sm outline-[#007bff]"/>
                        <input type="date" name="Fecha de nacimiento" placeholder="Fecha de nacimiento" class="rounded-md py-2.5 px-4 border text-sm outline-[#007bff]"/>
                        <input type="direccion" placeholder="Direccion" name="subject" class="rounded-md py-2.5 px-4 border text-sm outline-[#007bff]"/>
                        <input type="direccion" placeholder="Celular" name="subject" class="rounded-md py-2.5 px-4 border text-sm outline-[#007bff]"/>
                        <button type="button" class="text-white bg-[#007bff] hover:bg-blue-600 font-semibold rounded-md text-sm px-4 py-2.5 w-full">Registrarse</button>
                    </form>
                    </div>
                    
                </div>
            </div>
        </div>
        
</>
    )
}

export default Register