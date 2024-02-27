import { useState } from 'react';
import { FaTimes, FaArrowLeft, FaArrowRight } from 'react-icons/fa';
import { Link } from 'react-router-dom';


const CardDetail = () => {
    // Lista de imágenes
    const images = [
        "../public/img/albañil.webp",
        "../public/img/electricista.webp",
        "../public/img/Gasista.webp",
    ];

    const [startIndex, setStartIndex] = useState(0);
    const [endIndex, setEndIndex] = useState(1); // Número de imágenes a mostrar en un slice

    const [expandedImage, setExpandedImage] = useState(null);

    const changeSlice = (direction) => {
        if (direction === 'prev' && startIndex > 0) {
            setStartIndex(startIndex - 1);
            setEndIndex(endIndex - 1);
        } else if (direction === 'next' && endIndex < images.length) {
            setStartIndex(startIndex + 1);
            setEndIndex(endIndex + 1);
        }
    };

    return (
        <div>
            <div>
                <nav className="bg-slate-100 lg:bg-slate-600 flex justify-between items-center px-4 py-2">
                    <Link to="/Servicios">
                        <FaTimes className="text-slate-600 lg:text-white cursor-pointer" />
                    </Link>
                </nav>
            </div>
            <div className="flex flex-col lg:flex-row">
                <div className="lg:basis-1/2 flex flex-col justify-center items-center gap-4 lg:m-8">
                    {images.slice(startIndex, endIndex).map((image, index) => (
                        <img
                            key={index}
                            src={image}
                            alt=""
                            className="cursor-pointer w-full bg-contain"
                            onClick={() => setExpandedImage(image)} // Expandir la imagen cuando se hace clic
                        />
                    ))}
                    <div className="flex gap-3">
                        <FaArrowLeft
                            className="text-slate-600 cursor-pointer"
                            onClick={() => changeSlice('prev')}
                        />
                        <FaArrowRight
                            className="text-slate-600 cursor-pointer"
                            onClick={() => changeSlice('next')}
                        />
                    </div>
                </div>
                <div className="md:basis-1/2 flex flex-col gap-4 lg:gap-7 lg:m-8 m-5 lg:rounded-xl lg:shadow-2xl lg:bg-gray-100 lg:p-5">
                    <h3 className=" font-semibold text-2xl lg:text-3xl">Electricista en Mar del Plata</h3>
                    <p className=" font-medium text-lg lg:text-xl">$750</p>
                    <hr />
                    <h4 className="font-semibold text-xl lg:text-2xl">Descripción</h4>
                    <p className=" font-normal text-sm lg:text-base">
                        Lorem ipsum dolor sit, amet consectetur adipisicing elit. Vitae, quisquam rem
                        tenetur quis asperiores sapiente, illum voluptate, fugiat sequi vero excepturi
                        nostrum aliquam eius iusto nulla. Autem quod itaque praesentium?
                    </p>
                    <hr />
                    <h4 className="font-semibold text-xl lg:text-2xl">Información del trabajador</h4>
                    <p className=" font-normal text-sm lg:text-base">Juan Jose</p>
                    <p className=" font-normal text-sm lg:text-base">Gimenez Rojas 10 Oeste</p>
                </div>
            </div>
            {expandedImage && (
                <div className="fixed top-0 left-0 w-full h-full flex justify-center items-center bg-black bg-opacity-75">
                    <img
                        src={expandedImage}
                        alt=""
                        className="max-w-4/5 max-h-4/5"
                        onClick={() => setExpandedImage(null)} 
                    />

                </div>
            )}
        </div>
    );
}

export default CardDetail;
