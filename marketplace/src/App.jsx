import './App.css';
import { BrowserRouter as Router, Routes, Route, Outlet } from "react-router-dom";
import Navbar from "./componentes/Navbar/Navbar";
import Footer from "./componentes/Footer/Footer";
import Index from './pages';
import Login from "./componentes/User/Login";
import Register from './componentes/User/Register';
import Servicios from "./componentes/Sv/Servicios"
import CardDetail from './componentes/Sv/CardDetail';
import ChargeService from './componentes/Sv/ChargeService';

function App() {
  return (
    <Router>

      <Routes>
        <Route path="/" element={<Home/>}>
          <Route index element={<Index/>} />
          <Route path="/Servicios" element={<Servicios/>} />
          <Route path="Inicio" element={<Login />} />
          <Route path="Carga-del-servicio" element={<ChargeService/>} />
        </Route>
        
        <Route path="Detalle" element={<CardDetail/>} />
        <Route path="Registro" element={<Register/>} />
        

      </Routes>
    </Router>
  );
}


function Home() {
  return (
    <div>
      <Navbar />
      <Outlet/>
      <Footer />
    </div>
  );
}

export default App;
