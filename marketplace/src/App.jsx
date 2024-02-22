import { FaQq } from 'react-icons/fa'
import './App.css'
import Header from './componentes/Index/Header'
import Hire from './componentes/Index/Hire'
import Service from './componentes/Index/Service'
import Navbar from './componentes/Navbar/Navbar'
import Faqs from './componentes/Index/Faqs'
import Footer from './componentes/Footer/Footer'

function App() {

  return (
    <>
      <div>
        <Navbar/>
      </div>
      <Header/>
      <Hire />
      <Service />
      <Faqs/>
      <Footer/>
    </>


  )
}

export default App
