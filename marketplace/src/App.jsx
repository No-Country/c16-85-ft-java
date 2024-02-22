import './App.css';
import { BrowserRouter as Router, Routes, Route, Outlet } from "react-router-dom";
import Navbar from "./componentes/Navbar/Navbar";
import Footer from "./componentes/Footer/Footer";
import Index from './pages';
import Login from "./componentes/User/Login";
import Register from './componentes/User/Register';


function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<Home/>}>
          <Route index element={<Index/>} />
           <Route path="Registrarse" element={<Login/>} />
           <Route path="Prueba" element={<Register/>} />
      </Route>
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
