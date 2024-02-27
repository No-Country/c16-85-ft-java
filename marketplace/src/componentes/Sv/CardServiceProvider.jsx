const CardServiceProvider = () => {
    return (<>
                   <div
    href="#"
    className="relative block overflow-hidden rounded-lg border border-gray-200 p-1 sm:p-6 lg:p-8 max-w-[260px] w-[100%]   "
  >
    <span
      className="absolute inset-x-0 bottom-0 h-2 bg-gradient-to-r from-slate-500 to-slate-800"
    ></span>
  
    <div className="sm:flex sm:justify-between sm:gap-4  ">
      <div className=" text-center sm:text-start">
        <h3 className="text-lg font-bold text-gray-900 sm:text-xl ">
           Nombre Apellido
        </h3>
        <h4 className="mt-1 text-xs sm:text-lg font-medium text-gray-600 ">Profesión</h4>
        <div className="flex items-center mt-1  justify-center sm:justify-start">
        <svg className="w-4 h-4 fill-current text-yellow-600" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"><path d="M10 15l-5.878 3.09 1.123-6.545L.489 6.91l6.572-.955L10 0l2.939 5.955 6.572.955-4.756 4.635 1.123 6.545z"/></svg>
        <svg className="w-4 h-4 fill-current text-yellow-600" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"><path d="M10 15l-5.878 3.09 1.123-6.545L.489 6.91l6.572-.955L10 0l2.939 5.955 6.572.955-4.756 4.635 1.123 6.545z"/></svg>
        <svg className="w-4 h-4 fill-current text-yellow-600" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"><path d="M10 15l-5.878 3.09 1.123-6.545L.489 6.91l6.572-.955L10 0l2.939 5.955 6.572.955-4.756 4.635 1.123 6.545z"/></svg>
        <svg className="w-4 h-4 fill-current text-yellow-600" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"><path d="M10 15l-5.878 3.09 1.123-6.545L.489 6.91l6.572-.955L10 0l2.939 5.955 6.572.955-4.756 4.635 1.123 6.545z"/></svg>
        <svg className="w-4 h-4 fill-current text-gray-400" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 20 20"><path d="M10 15l-5.878 3.09 1.123-6.545L.489 6.91l6.572-.955L10 0l2.939 5.955 6.572.955-4.756 4.635 1.123 6.545z"/></svg>
      </div>
      </div>
  
      <div className=" sm:block sm:shrink-0">
          
        <img
          alt=""
          src="https://images.unsplash.com/photo-1633332755192-727a05c4013d?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1180&q=80"
          className="size-24 rounded-lg object-cover shadow-sm m-auto"
        />
      </div>
    </div>
    
    <div className="mt-4   text-center   sm:text-start">
    <p className="text-pretty text-sm text-gray-500 ">
        Empresa : Lorem, ipsum dolor.
      </p>
      <p className="text-pretty text-sm text-gray-500">
        Dirección : Lorem, ipsum dolor.
      </p>
      <p className="text-pretty text-sm text-gray-500">
        Precio estimado : Lorem, ipsum dolor.
      </p>
  
    </div>
  
    <dl className="mt-6 flex gap-4 sm:gap-6 justify-center sm:justify-start">
      <div className="flex flex-col-reverse">
  
      <button to="/register" className="inline-flex items-center  justify-center w-full  px-6 mb-3 font-medium tracking-wide transition duration-200 rounded shadow-md md:w-auto md:mb-0 focus:shadow-outline focus:outline-none bg-slate-600 text-stone-50 py-2 border hover:text-green-600">
                  <span className="m-auto">Ver servicios</span>
      </button>
      </div>
  
  
    </dl>
  </div></>)
  }


  export default CardServiceProvider;