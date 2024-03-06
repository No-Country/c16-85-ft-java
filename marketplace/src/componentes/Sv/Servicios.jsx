import SideBar from "./Sidebar";
import CardServiceProvider from "./CardServiceProvider";



const Servicios = () => {

  return (
    <section className="min-h-[80vh]   bg-gray-100 ">
      <div className="flex ml-5 flex-col  sm:flex-row  ">
        <div className=" m-auto  min-w-[200px]   sm:w-[10%] md:max-w-[260px]   w-full sm:m-0">
          <SideBar />
        </div>
        {/* Cambio: md:justify-start */}
        <div className="flex    gap-4  flex-wrap  justify-center  my-2 m-0  sm:m-4 p-4 bg-white  rounded-md w-full">
          <CardServiceProvider />
          <CardServiceProvider />
          <CardServiceProvider />
          <CardServiceProvider />
          <CardServiceProvider />
        </div>
      </div>
    </section>
  );
};

export default Servicios;
