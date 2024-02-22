import imgSearchJob from '../../../public/img/searchJob.jpg'
import imgSearchService from '../../../public/img/searchService.jpg'
import { Link } from 'react-router-dom';


const SearchJob = () => {
  return (
    <>
      <div className="px-4 py-16 mx-auto sm:max-w-xl md:max-w-full lg:max-w-screen-xl md:px-24 lg:px-8 lg:py-20">
        <div className="flex flex-col items-center justify-between lg:flex-row md:gap-14">
          <div className="mb-2 lg:max-w-lg lg:pr-5 lg:mb-0">
            <div className="max-w-xl mb-2">
              <h2 className="text-4xl font-bold text-gray-800  mb-4">
                Ofrece tus servicios en nuestro marketplace
              </h2>
              <p className="text-gray-600 my-6">
                ¿Quieres ofrecer tus servicios? Únete a  nuestro Marketplace en donde podrás ofrecer tus habilidades en fontanería, albañilería y más.  ¡Regístrate ahora y comienza a ofrecer tus servicios en un entorno confiable con la oportunidad de atraer múltiples clientes!
              </p>
            </div>
            <div className="flex flex-col items-center md:flex-row justify-center">
              <Link to="/Prueba" className="inline-flex items-center justify-center w-full h-12 px-6 mb-3 font-medium tracking-wide transition duration-200 rounded shadow-md md:w-auto md:mb-0 focus:shadow-outline focus:outline-none bg-slate-600 text-stone-50 py-2 border hover:text-green-600">
                <span className="m-auto">Ofrezca tus servicios</span>
              </Link>
            </div>
          </div>
          <div className="relative lg:w-1/2">
            <img
              className="object-cover w-full h-56 rounded-lg shadow-lg sm:h-96 "
              src={imgSearchJob}
              alt=""
            />

          </div>
        </div>
      </div>
    </>
  );
};

const SearchService = () => {
  return (
    <>
      <div className="px-4  mx-auto sm:max-w-xl md:max-w-full lg:max-w-screen-xl md:px-24 lg:px-8 lg:pb-10 ">
        <div className="flex flex-col items-center justify-between lg:flex-row md:gap-14">

          <div className="relative lg:w-1/2">
            <img
              className="object-cover w-full h-56 rounded-lg shadow-lg sm:h-96"
              src={imgSearchService}
              alt=""
            />
          </div>
          <div className="mb-10 lg:max-w-lg lg:pr-5  3  lg:mb-0     lg:pl-10" >
            <div className="max-w-xl mb-2 pt-3">
              <h2 className="text-4xl font-bold text-gray-800  mb-4">
                Consiga el servicio que necesita en nuestra plataforma


              </h2>
              <p className="text-gray-600 my-6">
                Descubre una amplia variedad de servicios profesionales y encuentra la opción perfecta para tus necesidades en nuestra plataforma. Al registrarte, podrás contratar servicios fácilmente, comunicarte con los proveedores y puntuar los servicios que recibiste. Únete ahora y experimenta la comodidad y confiabilidad de encontrar servicios de calidad en un solo lugar.
              </p>
            </div>
            <div className="flex flex-col items-center md:flex-row justify-center">
              <a
                href="/"
                className="inline-flex items-center justify-center w-full h-12 px-6 mb-3 font-medium tracking-wide  transition duration-200 rounded shadow-md md:w-auto  md:mb-0 focus:shadow-outline focus:outline-none bg-slate-600  text-stone-50 py-2 border hover:text-green-600  "
              >
                <span className="m-auto ">Regístrate</span>

              </a>
            </div>
          </div>

        </div>
      </div>
    </>
  );
};

const Hire = () => {
  return (
    <>
      <div style={{ margin: "auto", width: "100%" }}>
        <SearchJob />
        <SearchService />
      </div>
    </>
  );
};

export default Hire;
