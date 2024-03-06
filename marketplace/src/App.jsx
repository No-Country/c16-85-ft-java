import './App.css';
import { BrowserRouter as Router, Routes, Route, Outlet } from "react-router-dom";
import Navbar from "./componentes/Navbar/Navbar";
import Footer from "./componentes/Footer/Footer";
import Index from './pages';
import Login from "./componentes/User/Login";
import Register from './componentes/User/Register';
import Servicios from "./componentes/Sv/Servicios"
import Review from "./componentes/Sv/Review"
import ChargeService from './componentes/Sv/ChargeService';
import CardDetail from './componentes/Sv/CardDetail';
import UserProvider from './context/UserProvider'

function App() {
  return (
    <UserProvider>
    
    <Router>
      <Routes>
        <Route path="/" element={<Home/>}>
          <Route index element={<Index/>} />
          <Route path="/Servicios" element={<Servicios/>} />
          <Route path="Inicio" element={<Login />} />
          <Route path="Carga-del-servicio" element={<ChargeService/>} />
          <Route path="/register" element={<Register/>} />
          <Route path="/login" element={<Login />} />
        </Route>
        <Route path="/Detalle" element={<CardDetail/>} />
        <Route path="/review" element={<Review/>} />
        <Route path="/Detalle" element={<CardDetail/>} />
      </Routes>
    </Router>
    
    </UserProvider>
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
