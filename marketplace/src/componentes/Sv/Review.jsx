import React from "react";
import {valoraciones} from "../../assets/valoraciones.js"



const CardReview = ({nombre, titulo, descripcion}) => {

  

  return (
    <>
      <div className="mb-8 sm:break-inside-avoid w-full  max-w-[290px]  sm:max-w-[350px] m-auto md:shadow-2xl md:rounded-xl">
        <blockquote className="rounded-lg bg-gray-50  p-5 shadow-sm sm:p-8">
          <div className="flex flex-col   items-center gap-4   sm:flex-row">
            <img
              alt=""
              src="https://images.unsplash.com/photo-1595152772835-219674b2a8a6?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1180&q=80"
              className="size-24 sm:size-14  rounded-full object-cover"
            />
            <div>
              <p className="mt-0.5 text-lg font-medium text-gray-700 text-center">
                {nombre}
              </p>
            </div>
          </div>
          <div className="flex items-center mt-3  justify-center sm:justify-start">
            <svg className="w-4 h-4 fill-current text-yellow-600" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"><path d="M10 15l-5.878 3.09 1.123-6.545L.489 6.91l6.572-.955L10 0l2.939 5.955 6.572.955-4.756 4.635 1.123 6.545z" /></svg>
            <svg className="w-4 h-4 fill-current text-yellow-600" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"><path d="M10 15l-5.878 3.09 1.123-6.545L.489 6.91l6.572-.955L10 0l2.939 5.955 6.572.955-4.756 4.635 1.123 6.545z" /></svg>
            <svg className="w-4 h-4 fill-current text-yellow-600" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"><path d="M10 15l-5.878 3.09 1.123-6.545L.489 6.91l6.572-.955L10 0l2.939 5.955 6.572.955-4.756 4.635 1.123 6.545z" /></svg>
            <svg className="w-4 h-4 fill-current text-yellow-600" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"><path d="M10 15l-5.878 3.09 1.123-6.545L.489 6.91l6.572-.955L10 0l2.939 5.955 6.572.955-4.756 4.635 1.123 6.545z" /></svg>
            <svg className="w-4 h-4 fill-current text-gray-400" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"><path d="M10 15l-5.878 3.09 1.123-6.545L.489 6.91l6.572-.955L10 0l2.939 5.955 6.572.955-4.756 4.635 1.123 6.545z" /></svg>
          </div>
          <p className="mt-4  text-xl  font-semibold text-gray-600 text-center sm:text-left ">
            {titulo}
          </p>
          <p className=" text-gray-700 text-center sm:text-left break-words">
            {descripcion}
          </p>
        </blockquote>
      </div>
    </>
  );
};

const Review = () => {
  return (
    <>
      <section className="bg-white">
        <div className="mx-auto  py-12 sm:px-6 lg:px-8 lg:py-16">
          <h2 className="text-center text-2xl font-bold tracking-tight text-gray-900 sm:text-5xl break-words">
            Valoraciones
          </h2>

          <div className="mt-8 [column-fill:_balance] sm:columns-2 sm:gap-6 lg:columns-3 lg:gap-8 m-5 sm:m-4 ">
            {valoraciones.map((valoracion, index) => (
              <CardReview
              key={index}
              nombre={valoracion.nombreApellido}
              titulo={valoracion.titulo}
              descripcion={valoracion.descripcion}
              />
            )
            )}
          </div>
        </div>
      </section>
    </>
  );
};

export default Review;
