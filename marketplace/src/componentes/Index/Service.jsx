

const OptionTwo = () => {

    return (<>

  <div className="flex w-[90%] md:w-[80%] justify-center m-auto my-6 flex-wrap">
  <div className="h-64 rounded-lg bg-gray-200 max-w-[40%] w-[100%]   min-w-[95%]  md:min-w-[60%]   lg:min-w-[300px]    ml-4  my-5 "></div>
  <div className="h-64 rounded-lg bg-gray-200 max-w-[40%] w-[100%]   min-w-[95%]  md:min-w-[60%]  lg:min-w-[300px]    ml-4 my-5"></div>
  <div className="h-64 rounded-lg bg-gray-200 max-w-[40%] w-[100%]   min-w-[95%]  md:min-w-[60%]  lg:min-w-[300px]    ml-4 my-5"></div>
  <div className="h-64 rounded-lg bg-gray-200 max-w-[40%] w-[100%]   min-w-[95%]  md:min-w-[60%]  lg:min-w-[300px]    ml-4 my-5"></div>
</div>
    </>)
}

const Service = () => {

   const serviceName = ["Servicio 1" , "Servicio 2" , "Servicio 3" , "Servicio 4"]


    return (<>


    <div >
    <h1 className="text-center text-3xl font-semibold">Servicios</h1>
     {/* <div className="flex flex-wrap justify-center "> */}
        {/* {
            serviceName.map(service => <CardOne/>) 
        } */}
   
      
     {/* </div> */}
  
      


     <OptionTwo/>
    </div>


    
    </>)
}


export default Service;


