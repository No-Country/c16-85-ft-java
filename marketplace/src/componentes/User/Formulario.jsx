import { useState } from "react"



const Formulario = () => {

    const servicios = {
        "businessName": "string",
        "ceoName": "string",
        "ceoLastName": "string",
        "address": "string"
    }


    const [service, setService] = useState(servicios)


    const handleChange = e => {

        const { name, value } = e.target
        const valueServicios = { ...servicios, [name]: value };
        setLogin(valueServicios)
    }




    const handleSubmit = async (e) => {
        e.preventDefault()
        console.log(Servicios);
        let response = await fetch('https://c16-85-ft-java.onrender.com/auth/authenticate', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
        })

    }

    return(
        <div className="flex justify-center items-center h-screen bg-slate-600">
        <div className="flex justify-center items-center">
            <div className="flex justify-center items-center gap-8 p-8 mx-auto max-w-4xl bg-slate-400 md:rounded-lg">
                <div className="flex flex-col text-center items-center gap-8 basis-1/2">
                    <h1 className="text-4xl font-bold text-gray-800 text-center">Ofece tus servicios</h1>
                    <p className="text-center text-gray-600 text-sm mt-2">¡Bienvenido al registro para unirte a nuestro vibrante Marketplace de Servicios! Estamos emocionados de que te unas a nuestra comunidad donde podrás encontrar una amplia variedad de servicios ofrecidos por profesionales cualificados. Completa el formulario a continuación para comenzar tu viaje con nosotros.</p>
                    <p>ACA El LOGO</p>
                </div>
                <div className="basis-1/2">
                    <form onSubmit={handleSubmit} className="flex flex-col gap-4">
                        <input onChange={handleChange} value={service.businessName} type="text" name="businessName" placeholder="Nombre de empresa" className="rounded-md py-2.5 px-4 border text-sm outline-[#007bff]" />
                        <input onChange={handleChange} value={service.ceoName} type="text" name="ceoName" placeholder="Nombre" className="rounded-md py-2.5 px-4 border text-sm outline-[#007bff]" />
                        <input onChange={handleChange} value={service.ceoLastName} type="text" name="ceoLastName" placeholder="Apellido" className="rounded-md py-2.5 px-4 border text-sm outline-[#007bff]" />
                        <input onChange={handleChange} value={service.address} type="text" name="address" placeholder="Ubicacion" className="rounded-md py-2.5 px-4 border text-sm outline-[#007bff]" />
                        <button type="submit" className="text-white bg-[#007bff] hover:bg-blue-600 font-semibold rounded-md text-sm px-4 py-2.5 w-full">Enviar</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
    )
}

export default Formulario