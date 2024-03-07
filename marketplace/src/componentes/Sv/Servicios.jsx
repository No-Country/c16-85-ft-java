import SideBar from "./Sidebar";
import CardServiceProvider from "./CardServiceProvider";
import { useState } from "react";
import { useEffect } from "react";
import { useSearchParams } from "react-router-dom";
import { tarjetas } from "../../assets/datos";

const Servicios = () => {
  const [params, setParams] = useSearchParams();

  const [showCards, setShowCards] = useState([]);
  const category = params.get("categoria");



  useEffect(() => {
    if (category) {
   
      setShowCards(tarjetas.filter((item) => item.profesion === category));
    } else {
      setShowCards(tarjetas);
    }
  }, [params]);

  return (
    <section className="min-h-[80vh]   bg-gray-100 ">
      <div className="flex ml-5 flex-col  sm:flex-row  ">
        <div className=" m-auto  min-w-[200px]   sm:w-[10%] md:max-w-[260px]   w-full sm:m-0">
          <SideBar category={category} />
        </div>
        {/* Cambio: md:justify-start */}
        <div className="flex    gap-4  flex-wrap  justify-center  my-2 m-0  sm:m-4 p-4 bg-white  rounded-md w-full">
          {showCards.map((tarjeta, index) => (
            <CardServiceProvider key={index} tarjeta={tarjeta} />
          ))}
        </div>
      </div>
    </section>
  );
};

export default Servicios;
