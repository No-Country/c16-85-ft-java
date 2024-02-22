import imgService from '../../../public/img/service.jpg'


const CardService = ({name , description }) => {
  console.log(name);
  return (<>
    <div className="flex flex-col overflow-hidden rounded-lg shadow-lg">
      <div className="flex-shrink-0">
        <img
          className="object-cover w-full h-44 md:h-60"
          src={imgService}
          alt=""
        />
      </div>
      <div className="flex flex-col justify-between flex-1 p-6 bg-white">
        <div className="flex-1">
          <p className="block mt-2">
            <p className="text-xl  font-sans  font-bold tracking-tight text-gray-900">
              {name}
            </p>
            <p className="mt-3 text-base text-gray-500">
            {description}
            </p>
          </p>
          <a class="inline-block mt-5 w-auto bg-slate-600 hover:cursor-pointer hover:bg-slate-700 text-white font-semibold py-2 px-4 border border-sky-800 rounded text-center">
            Buscar {name}</a>
        </div>
      </div>
    </div>
  </>)
}

const Service = () => {

  const serviceDetails = [{name: 'Electricista' , description : '¡Soluciones eléctricas confiables al alcance de tu mano! Nuestro equipo de electricistas expertos ofrece servicios de instalación, reparación y mantenimiento eléctrico para hogares, negocios y proyectos industriales. ' } ,
   {name: 'Plomero' , description : '¿Problemas con tuberías? ¡Relájate! Somos tu solución. Nuestro equipo de fontaneros está listo para atender tus necesidades, desde pequeñas reparaciones hasta instalaciones completas.'} , 
   {name: 'Carpintero' , description: '¿Deseas darle vida a tus espacios con muebles únicos y de calidad? Entra en el mundo de la carpintería  con nosotros. Nuestro equipo de carpinteros expertos está listo para transformar tus ideas en piezas de arte. '} , 
   {name: 'Albañil' , description: '¿Quieres hacer realidad tus sueños de construcción? Nosotros te ayudamos. Nuestro equipo de albañiles expertos combina habilidad y pasión para crear estructuras sólidas y estéticamente impresionantes.'}]
  
  return (<>

    <section className="bg-gradient-to-r from-slate-500 to-slate-800">
      <h1 className="text-center text-3xl font-semibold text-white pt-5">Servicios</h1>
      <div className="relative px-4 py-12 sm:px-6 lg:py-8 lg:px-8">
        <div className="relative mx-auto max-w-7xl">
          <div className="grid max-w-lg gap-5 mx-auto lg:grid-cols-2 lg:max-w-none w-[80%] ">
            {
              serviceDetails.map(service => <CardService  name={service.name} description={service.description} />)
            }
          </div>
        </div>
      </div>
    </section>




  </>)
}


export default Service;


