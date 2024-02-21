import './App.css'
import Header from './componentes/Index/Header'
import Hire from './componentes/Index/Hire'
import Service from './componentes/Index/Service'
import Navbar from './componentes/Navbar/Navbar'

function App() {

  return (
    <>
      <div>
        <Navbar/>
      </div>
      <Header/>
      <Hire />
      <Service />
    </>


  )
}

export default App
