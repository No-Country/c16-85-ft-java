import React from "react"

const Header = () => {
    return (
        <section className="bg-img h-screen w-full sm:bg-no-repeat lg:bg-cover ">
            <div className="text-container w-full bg-black bg-opacity-50 text-white h-screen flex flex-col justify-center items-start px-16 gap-y-10">
                <h1 className="text-3xl md:text-5xl lg:w-[700px]">Encuentra a los mejores Profesionales de la Cuidad</h1>
                <p className="text-sm md:text-lg w-[200px] sm:w-[350px] md:w-[631px] lg:w-[700px]">Bienvenido a nuestro Marketplace, donde la calidad y la confiabilidad se encuentran en cada servicio. Descubre una variedad de opciones para resolver tus necesidades de hogar y jardín de manera rápida y eficiente.</p>
                <div>
                    <button className="
                px-8 
                py-2 
                bg-slate-600 
                text-stone-50 
                hover:text-green-600
                ease-in 
                duration-150 
                font-semibold"><a href="#contactos">Contacto</a>

                    </button>
                </div>
            </div>
        </section>
    )
}

export default Header