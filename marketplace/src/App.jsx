import './App.css'
import Hire from './componentes/Index/Hire'
import Service from './componentes/Index/Service'

import { StickyNavbar } from './componentes/Navbar/Navbar'

function App() {

  return (
    <>
    <div>
      <StickyNavbar/>
    </div>
      <Hire/>
      <Service/>
    </>
   
    
  )
}

export default App
