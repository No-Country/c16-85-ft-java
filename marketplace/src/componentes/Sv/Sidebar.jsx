import { MdOutlineLabel } from "react-icons/md";

const SelectProfession = () => {
  return (<>
    <div className="sm:hidden ml-4 mr-2 ">
      <select required
        className="text-black/70 bg-white px-3 py-1 transition-all cursor-pointer  border border-gray-200 rounded-lg w-[140px] ">
        <option value="" >Profesión</option>
        <option value="option-1">Electricista</option>
        <option value="option-2">Plomero</option>
        <option value="option-3">Carpintero</option>
        <option value="option-3">Albañil</option>
      </select>
    </div>
  </>)
}


const SideBar = ({category}) => {



  return (<>


    <ul className="space-y-1 sm:mt-10  mt-2 flex sm:block  flex-wrap justify-center  ">

      <li className="w-[20%]  sm:w-[100%] ">
        <a href="#" className="flex   items-center gap-2 rounded-lg  px-2   py-1 text-gray-700">
          <p className="text-lg font-medium   w-[100%]  m-auto  text-center"> Buscar </p>
        </a>
      </li>
      <li className=" ">
        <form className="flex items-center max-w-sm mx-auto">

          <div className="relative w-full">
            <div className="absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none">
            </div>
            <input
              type="text"
              id="simple-search"
              className="bg-gray-50 border border-gray-300 text-gray-900 text-sm rounded-lg focus:ring-blue-500 focus:border-blue-500 block w-full p-1  dark:bg-gray-700 dark:border-gray-600 dark:placeholder-gray-400 dark:text-white dark:focus:ring-blue-500 dark:focus:border-blue-500"
              placeholder=""

            />
          </div>
          <button
            type="submit"
            className="p-1.5 ml-1 text-sm font-medium text-white bg-blue-700 rounded-lg border border-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 dark:bg-blue-600 dark:hover:bg-blue-700 dark:focus:ring-blue-800"
          >
            <svg
              className="w-4 h-4"
              aria-hidden="true"
              xmlns="http://www.w3.org/2000/svg"
              fill="none"
              viewBox="0 0 20 20"
            >
              <path
                stroke="currentColor"
                strokeLinecap="round"
                strokeLinejoin="round"
                strokeWidth={2}
                d="m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z"
              />
            </svg>
            <span className="sr-only">Search</span>
          </button>
        </form>

      </li>

      <li className="hidden sm:block">
        <a href="#" className="flex items-center gap-2 rounded-lg  px-4 py-2 text-gray-700">
          <p className="text-lg font-medium  w-[100%] text-center"> Filtros </p>
        </a>
      </li>

      <li>
        <SelectProfession />
      </li>

      <li className="hidden sm:block">
        <a
          href={ category === "Electricista" ? "Servicios" : "Servicios?categoria=Electricista"   }
          className={
             category === "Electricista" ? "flex items-center gap-2 rounded-lg px-4 py-2  bg-gray-200 text-gray-700" : "flex items-center gap-2 rounded-lg px-4 py-2 text-gray-500 hover:bg-gray-200 hover:text-gray-700"
          }
      
         
        >
          <MdOutlineLabel />

          <span className="text-sm font-medium"> Electricista </span>
        </a>
      </li>

      <li className="hidden sm:block" >
        <a
              href={ category === "Plomero" ? "Servicios" : "Servicios?categoria=Plomero"   }
          className={
            category === "Plomero" ? "flex items-center gap-2 rounded-lg px-4 py-2  bg-gray-200 text-gray-700" : "flex items-center gap-2 rounded-lg px-4 py-2 text-gray-500 hover:bg-gray-200 hover:text-gray-700"
         }
        >
          <MdOutlineLabel />

          <span className="text-sm font-medium"> Plomero </span>
        </a>
      </li>

      <li className="hidden sm:block" >
        <a
        href = { category === "Carpintero" ? "Servicios" : "Servicios?categoria=Carpintero"   }
         
          className={
            category === "Carpintero" ? "flex items-center gap-2 rounded-lg px-4 py-2  bg-gray-200 text-gray-700" : "flex items-center gap-2 rounded-lg px-4 py-2 text-gray-500 hover:bg-gray-200 hover:text-gray-700"
         }
        >
          <MdOutlineLabel />

          <span className="text-sm font-medium"> Carpintero </span>
        </a>
      </li>

      <li className="hidden sm:block">
        <a
          href = { category === "Albañil" ? "Servicios" : "Servicios?categoria=Albañil"   }
          className={
            category === "Albañil" ? "flex items-center gap-2 rounded-lg px-4 py-2  bg-gray-200 text-gray-700" : "flex items-center gap-2 rounded-lg px-4 py-2 text-gray-500 hover:bg-gray-200 hover:text-gray-700"
         }
        >
          <MdOutlineLabel />

          <span className="text-sm font-medium"> Albañil </span>
        </a>
      </li>

      <li>


        <button to="/register" className="sm:mt-2   sm:w-full sm:m-auto sm:mb-2 sm:h-[40px]  duration-200    md:py-2   sm: m-auto  ml-4 mr-2 py-1  md:mb-0 focus:shadow-outline   transition flex items-center justify-center  px-4  shadow-md font-medium tracking-wide  focus:outline-none  hover:text-green-600 rounded-2xl border bg-slate-600 text-stone-50 ">
          <span className="m-auto">Crear publicación</span>

        </button>
      </li>
    </ul>


  </>)
}

export default SideBar
