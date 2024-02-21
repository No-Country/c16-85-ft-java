import imgService from '../../../public/img/service.jpg'


const CardService = () => {
  return (<>
       <div className="flex flex-col overflow-hidden rounded-lg shadow-lg">
          <div className="flex-shrink-0">
            <img
              className="object-cover w-full h-48"
              src={imgService}
              alt=""
            />
          </div>
          <div className="flex flex-col justify-between flex-1 p-6 bg-white">
            <div className="flex-1">
              <p  className="block mt-2">
                <p className="text-xl  font-sans  font-bold tracking-tight text-gray-900">
                  Servicio 1
                </p>
                <p className="mt-3 text-base text-gray-500">
                  Lorem ipsum dolor sit amet consectetur adipisicing elit.
                  Architecto accusantium praesentium eius, ut atque fuga culpa,
                  similique sequi cum eos quis dolorum.
                </p>
              </p>

              <a class="inline-block mt-5 w-auto bg-blue-800 hover:cursor-pointer hover:bg-blue-700 text-white font-semibold py-2 px-4 border border-sky-800 rounded text-center">
              Buscar [NombreProfesión]
</a>
            </div>
       
          </div>
        </div>
  </>)
}




const Service = () => {
   
   const serviceDetails = ['Servicio 1' , 'Servicio 2' , 'Servicio 3' , 'Servicio 4']


    return (<>

<section className="bg-gradient-to-r from-slate-500 to-slate-800">
<h1 className="text-center text-3xl font-semibold text-white pt-5">Servicios</h1>
  <div className="relative px-4 py-12 sm:px-6 lg:py-8 lg:px-8">
    <div className="relative mx-auto max-w-7xl">
      <div className="grid max-w-lg gap-5 mx-auto lg:grid-cols-2 lg:max-w-none w-[80%] ">
            {
              serviceDetails.map(service =>   <CardService/> )
            }
      </div>
    </div>
  </div>
</section>
 


    
    </>)
}


export default Service;


