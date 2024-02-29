import React, { useState } from 'react';
import { Link } from "react-router-dom";
import { FaTimes } from 'react-icons/fa';
import { TbPointFilled } from "react-icons/tb";



// Importa las imágenes
import imageUrl from "../../../public/img/electricista.webp";
import imageUrl2 from "../../../public/img/albañil.webp";
import imageUrl3 from "../../../public/img/Gasista.webp";
import Review from './Review';

const CardDetail = () => {
    // Estado para controlar la descripción mostrada debajo de cada botón
    const [description, setDescription] = useState("Carpinteria");

    // Función para cambiar la descripción según el botón que se presione
    const handleDescriptionChange = (text) => {
        setDescription(text);
    };

    return (
        <div className="card-detail bg-gray-100">
            <nav className="bg-slate-600 flex justify-between items-center px-4 py-2">
                <Link to="/Servicios">
                    <FaTimes className="text-white cursor-pointer" />
                </Link>
            </nav>

            <div className="md:shadow-2xl md:rounded-xl md:m-5 p-5 bg-white">
                <div className="flex justify-center items-center">
                    <div className="grid grid-cols-4 grid-rows-2 gap-4">
                        <img className="col-span-2 row-span-2 w-full" src={imageUrl} alt="Carpinteria a domicilio" />
                        <img className="col-span-1 row-span-1" src={imageUrl2} alt="Segunda imagen" />
                        <img className="col-span-1 row-span-1" src={imageUrl3} alt="Tercera imagen" />
                        <img className="col-span-1 row-span-1" src={imageUrl3} alt="Tercera imagen" />
                        <img className="col-span-1 row-span-1" src={imageUrl3} alt="Tercera imagen" />
                    </div>
                </div>
                <div className='m-2'>
                    <h2 className='font-bold text-2xl md:text-3xl'>Servicios a domicilio</h2>
                    <p className="pt-3 text-sm md:text-base text-gray-900">
                        Si estás buscando algo único, algo hecho con amor y dedicación, estoy aquí para ti. ¡Contáctame y hagamos realidad tus ideas!
                    </p>
                    <hr className='mt-3 border-slate-600' />
                    <div className='flex flex-wrap gap-3 md:gap-7 md:p-4 p-2'>
                        <button 
                            className={`py-1 px-2 md:px-8 md:py-2 bg-slate-600 text-stone-50 font-semibold ${description === 'Carpinteria' ? 'active' : ''}`}
                            onClick={() => handleDescriptionChange('Carpinteria')}
                        >
                            Carpinteria 
                        </button>
                        <button 
                            className={`py-1 px-2 md:px-8 md:py-2 bg-slate-600 text-stone-50 font-semibold ${description === 'Electricista' ? 'active' : ''}`}
                            onClick={() => handleDescriptionChange('Electricista')}
                        >
                            Electricista
                        </button>
                        <button 
                            className={`py-1 px-2 md:px-8 md:py-2 bg-slate-600 text-stone-50 font-semibold ${description === 'Gasista' ? 'active' : ''}`}
                            onClick={() => handleDescriptionChange('Gasista')}
                        >
                            Gasista 
                        </button>
                    </div>
                    <div className='p-4 flex flex-col gap-3 text-gray-900 text-sm md:text-base'>
                        {description === 'Carpinteria' && <p>Mi objetivo es llevar tus ideas y necesidades a la realidad, creando muebles y estructuras que no solo sean funcionales, sino que también reflejen tu estilo y personalidad. Desde elegantes mesas y sillas hasta armarios y estanterías diseñadas a medida, estoy aquí para transformar tus sueños en piezas únicas y duraderas. </p>}
                        {description === 'Carpinteria' && <p>Precio: $100usd</p>}
                        {description === 'Electricista' && <p>Como electricista certificado, ofrezco una amplia gama de servicios para satisfacer tus necesidades eléctricas en casa o en tu negocio. Desde la instalación y reparación de sistemas eléctricos hasta la actualización de iluminación y la resolución de problemas eléctricos, estoy aquí para brindarte soluciones seguras y confiables. </p>}
                        {description === 'Electricista' && <p>Precio: $200usd</p>}
                        {description === 'Gasista' && <p>¿Buscas un gasista confiable y profesional? ¡Has llegado al lugar correcto! Como gasista con experiencia, ofrezco una variedad de servicios para garantizar el funcionamiento seguro y eficiente de tu sistema de gas. </p>}
                        {description === 'Gasista' && <p>Precio: $250usd</p>}
                    </div>
                    <hr className='mt-3 border-slate-600' />
                    <div className=' md:rounded-lg bg-slate-600 m-4 p-2'>
                        <h2 className='flex justify-center mt-3 font-semibold text-2xl md:text-3xl text-stone-50'>Mi perfil</h2>
                        <div className='flex flex-row justify-around m-4'>
                            <div className=''>
                                <h4 className='text-xl  font-semibold text-stone-50 text-center sm:text-left m-2'>Datos del perfil</h4>
                                <ul className='flex flex-col items-start'>
                                    <li className='flex justify-center items-center text-stone-50'><TbPointFilled/>Raul Carlos</li>
                                    <li className='flex justify-center items-center text-stone-50 '><TbPointFilled/>12/12/2020</li>
                                </ul>
                            </div>
                            <div>
                                <h4 className='text-xl  font-semibold text-stone-50 text-center sm:text-left m-2'>Datos de contacto</h4>
                                <ul className='flex flex-col items-start'>
                                    <li className='flex justify-center items-center text-stone-50'><TbPointFilled/>correo@gmail.com</li>
                                    <li className='flex justify-center items-center text-stone-50'><TbPointFilled/>+54 264515132</li>
                                </ul>
                            </div>
                            <div>
                                <h4 className='text-xl  font-semibold text-stone-50 text-center sm:text-left m-2'>Datos de ubicacion</h4>
                                <ul className='flex flex-col items-start'>
                                    <li className='flex justify-center items-center text-stone-50'><TbPointFilled/>Los Alamos 123 oeste</li>
                                    <li className='flex justify-center items-center text-stone-50'><TbPointFilled/>Barrio x - Mar del plata</li>
                                </ul>
                            </div>
                        </div>
                        
                    </div>
                    <hr className='mt-3 border-slate-600'/>
                    <Review/>
                </div>
            </div>
        </div>
    );
};

export default CardDetail;
