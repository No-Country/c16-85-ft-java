import imgSearchJob from '../../../public/img/searchJob.jpg'
import imgSearchService from '../../../public/img/searchService.jpg'



const SearchJob = () => {
  return (
    <>
      <div className="px-4 py-16 mx-auto  md:max-w-full  md:px-24 lg:px-8 lg:py-20">
        <div className="flex flex-col items-center justify-between lg:flex-row">
          <div className="mb-2 lg:max-w-lg lg:pr-5 lg:mb-0">
            <div className="max-w-xl mb-2">

              <h2 className="max-w-lg mb-2 font-sans text-3xl font-bold tracking-tight text-gray-900 sm:text-4xl sm:leading-none text-center">
                Ofrece Tus Servicios en Nuestro Marketplace
              </h2>
              <p className="text-base text-gray-700 md:text-lg text-center">
                ¿Quieres ofrecer tus servicios? Únete a  nuestro Marketplace en donde podrás ofrecer tus habilidades en fontanería, albañilería y más.  ¡Regístrate ahora y comienza a ofrecer tus servicios en un entorno confiable con la oportunidad de atraer múltiples clientes!
              </p>
            </div>
            <div className="flex flex-col items-center md:flex-row justify-center">
              <a
                href="/"
                className="inline-flex items-center justify-center w-full h-12 px-6 mb-3 font-medium tracking-wide  transition duration-200 rounded shadow-md md:w-auto  md:mb-0 focus:shadow-outline focus:outline-none bg-slate-600  text-stone-50 py-2 border hover:text-green-600  "
              >
                <span className="m-auto ">Ofrezca tus servicios</span>

              </a>

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
      <div className="px-4  mx-auto sm:max-w-xl md:max-w-full  md:px-24 lg:px-8 lg:pb-10 ">
        <div className="flex flex-col items-center justify-between lg:flex-row">

          <div className="relative lg:w-1/2">
            <img
              className="object-cover w-full h-56 rounded-lg shadow-lg sm:h-96"
              src={imgSearchService}
              alt=""
            />
          </div>
          <div className="mb-10 lg:max-w-lg lg:pr-5  3  lg:mb-0     lg:pl-10" >
            <div className="max-w-xl mb-2 pt-3">
              <h2 className="max-w-lg mb-2 font-sans text-3xl font-bold tracking-tight text-gray-900 sm:text-4xl sm:leading-none text-center">
                Consiga el Servicio que Necesita en Nuestra Plataforma
              </h2>
              <p className="text-base text-gray-700 md:text-lg text-center">
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
