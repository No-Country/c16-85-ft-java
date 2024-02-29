import { useState } from "react"

const Register = () => {


    const initialState = {
        username: '',
        password: '',
        birthday: '',
        mobile: '',
        address: '',
        firstname: '',
        lastname: ''

    }


    const [form, setForm] = useState(initialState)



    const handleChange = e => {

        const { name, value } = e.target
        const valueForm = { ...form, [name]: value };
        setForm(valueForm)


    }
    const handleSubmit = async (e) => {
        e.preventDefault()
        console.log(form);
        const response = await fetch('https://c16-85-ft-java.onrender.com/auth/register', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'

            },
            body: JSON.stringify(form)
        })
        const data = await response.json();
        console.log(data);


    }

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
                            <form onSubmit={handleSubmit} class="flex flex-col gap-4">
                                <input onChange={handleChange} value={form.username} type="mail" name="username" placeholder="Email" class="rounded-md py-2.5 px-4 border text-sm outline-[#007bff]" />
                                <input onChange={handleChange} value={form.password} type="password" name="password" placeholder="Contraseña" class="rounded-md py-2.5 px-4 border text-sm outline-[#007bff]" />
                                <input onChange={handleChange} value={form.firstname} type="text" name="firstname" placeholder="Nombre" class="rounded-md py-2.5 px-4 border text-sm outline-[#007bff]" />
                                <input onChange={handleChange} value={form.lastname} type="text" name="lastname" placeholder="Apellido" class="rounded-md py-2.5 px-4 border text-sm outline-[#007bff]" />
                                <input onChange={handleChange} value={form.birthday} type="date" name="birthday" placeholder="Fecha de nacimiento" class="rounded-md py-2.5 px-4 border text-sm outline-[#007bff]" />
                                <input onChange={handleChange} value={form.address} type="direccion" placeholder="Direccion" name="address" class="rounded-md py-2.5 px-4 border text-sm outline-[#007bff]" />
                                <input onChange={handleChange} value={form.mobile} type="direccion" placeholder="Celular" name="mobile" class="rounded-md py-2.5 px-4 border text-sm outline-[#007bff]" />
                                <button type="submit" class="text-white bg-[#007bff] hover:bg-blue-600 font-semibold rounded-md text-sm px-4 py-2.5 w-full">Registrarse</button>
                            </form>
                        </div>

                    </div>
                </div>
            </div>

        </>
    )
}

export default Register