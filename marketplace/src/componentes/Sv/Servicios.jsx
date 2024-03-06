import SideBar from "./Sidebar";
import CardServiceProvider from "./CardServiceProvider";
import { useState } from "react";



const Servicios = () => {

  const tarjetas = [
    // Electricistas
    {
      nombre: "Fernando",
      profesion: "Electricista",
      empresa: "Electricidad Fernández",
      direccion: "Calle Volta 123, Ciudad Energética",
      precio: "$50/hora",
      imagen: "https://picsum.photos/967",
    },
    {
      nombre: "Gabriela",
      profesion: "Electricista",
      empresa: "Energía Iluminada S.A.",
      direccion: "Av. Luminaria 456, Ciudad Energía",
      precio: "$45/hora",
      imagen: "https://picsum.photos/978",
    }
    ,
    {
      nombre: "Luis",
      profesion: "Electricista",
      empresa: "Luz Brillante Ltda.",
      direccion: "Calle Edison 789, Ciudad Energía",
      precio: "$55/hora",
      imagen: "https://picsum.photos/923",
    }
    ,
    // Albañiles
    {
      nombre: "Javier",
      profesion: "Albañil",
      empresa: "Construcciones Javier",
      direccion: "Av. Obras 456, Ciudad Construcción",
      precio: "$40/hora",
      imagen: "https://picsum.photos/987",
    }
    ,
    {
      nombre: "Marta",
      profesion: "Albañil",
      empresa: "Albañilería Marta",
      direccion: "Calle Construcción 101, Ciudad Albañil",
      precio: "$35/hora",
      imagen: "https://picsum.photos/977",
    }
    ,
    {
      nombre: "Pedro",
      profesion: "Albañil",
      empresa: "Construcciones Progreso",
      direccion: "Av. Edificación 789, Ciudad Albañil",
      precio: "$45/hora",
      imagen: "https://picsum.photos/435",
    }
    ,
    // Plomeros
    {
      nombre: "Marta",
      profesion: "Plomero",
      empresa: "Fontanería Marta",
      direccion: "Calle Caños 789, Ciudad Fontana",
      precio: "$55/hora",
      imagen: "https://picsum.photos/654",
    }
    ,
    {
      nombre: "Laura",
      profesion: "Plomero",
      empresa: "Plomería Laura",
      direccion: "Av. Agua 123, Ciudad Fontana",
      precio: "$50/hora",
      imagen: "https://picsum.photos/80",
    }
    ,
    {
      nombre: "Roberto",
      profesion: "Plomero",
      empresa: "Caños Rápidos S.A.",
      direccion: "Av. Fontanería 456, Ciudad Fontana",
      precio: "$60/hora",
      imagen: "https://picsum.photos/973",
    }
    ,
    // Carpintero
    {
      nombre: "Roberto",
      profesion: "Carpintero",
      empresa: "Gas Rápido",
      direccion: "Av. Gas 101, Ciudad Gas",
      precio: "$60/hora",
      imagen: "https://picsum.photos/972",
    }
    ,
    {
      nombre: "Valentina",
      profesion: "Carpintero",
      empresa: "Pajaro Carpintero",
      direccion: "Calle Aserrin 456, Ciudad Gas",
      precio: "$65/hora",
      imagen: "https://picsum.photos/971",
    }
    ,
    {
      nombre: "Pedro",
      profesion: "Carpintero",
      empresa: "Carpinteria Pedro",
      direccion: "Av. Maderas 789, Ciudad Gas",
      precio: "$55/hora",
      imagen: "https://picsum.photos/970",
    }
    ,
  ];



  return (
    <section className="min-h-[80vh]   bg-gray-100 ">
      <div className="flex ml-5 flex-col  sm:flex-row  ">
        <div className=" m-auto  min-w-[200px]   sm:w-[10%] md:max-w-[260px]   w-full sm:m-0">
          <SideBar />
        </div>
        {/* Cambio: md:justify-start */}
        <div className="flex    gap-4  flex-wrap  justify-center  my-2 m-0  sm:m-4 p-4 bg-white  rounded-md w-full">
          {tarjetas.map((tarjeta, index) => (
            <CardServiceProvider key={index} tarjeta={tarjeta} />
          ))}
        </div>
      </div>
    </section>
  );
};

export default Servicios;
