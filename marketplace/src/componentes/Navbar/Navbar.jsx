import { useState, useContext } from "react";
import { Link } from "react-router-dom";
import { FaTimes } from "react-icons/fa";
import { CiMenuFries } from "react-icons/ci";
import { UserContext } from "../../context/UserProvider";

const Navbar = () => {
    const [click, setClick] = useState(false);
    const handleClick = () => setClick(!click);

    const {user} = useContext(UserContext)

    return (
        <nav className="bg-slate-600">
            <div className="h-10vh flex justify-between z-50 text-white lg:py-5 px-20 py-4 flex-1 relative">
                <div className="flex items-center flex-1">
                    <span className=""><img src="../public/img/logoNav1.png" alt="" /></span>
                </div>
                <div className="lg:flex md:flex lg:flex-1 items-center justify-end font-normal hidden">
                    <div className="flex-10">
                        <ul className="flex gap-8 mr-16 text-[18px]">
                            <Link spy={true} smooth={true} to="/">
                                <li className="hover:text-green-700 transition border-b-2 border-slate-600 hover:border-green-700 cursor-pointer">Inicio</li>
                            </Link>
                            <Link spy={true} smooth={true} to="/Servicios">
                                <li className="hover:text-green-700 transition border-b-2 border-slate-600 hover:border-green-700 cursor-pointer">Servicios</li>
                            </Link>

                            {!user.token ? (
                                <>
                            <Link spy={true} smooth={true} to="Inicio">
                                <li className="bg-black bg-opacity-50 rounded-xl py-1 px-2 hover:text-green-700  cursor-pointer">Sign In</li>
                            </Link>
                            <Link spy={true} smooth={true} to="register">
                                <li className="bg-black bg-opacity-50 rounded-xl py-1 px-2 hover:text-green-700  cursor-pointer">Sign Up</li>
                            </Link>
                                </>
                            ) : ( 
                                <li>Bienvenido, {user.username}</li>
                            )}
                        </ul>
                    </div>
                </div>
                <div className="lg:hidden md:hidden w-full absolute top-16 left-0">
                    {click && (
                        <div className="bg-slate-600">
                            <ul className="text-center text-xl p-20">
                                <Link spy={true} smooth={true} to="/">
                                    <li className="my-4 py-4 border-b border-slate-500 hover:bg-slate-500">Inicio</li>
                                </Link>
                                <Link spy={true} smooth={true} to="Servicios">
                                    <li className="my-4 py-4 border-b border-slate-500 hover:bg-slate-500">Servicios</li>
                                </Link>
                                <Link spy={true} smooth={true} to="Login">
                                    <li className="my-4 py-4 border-b border-slate-500 hover:bg-slate-500">Sign In</li>
                                </Link>
                                <Link spy={true} smooth={true} to="register">
                                    <li className="my-4 py-4 border-b border-slate-500 hover:bg-slate-500">Sign Up</li>
                                </Link>
                            </ul>
                        </div>
                    )}
                </div>
                <button className="block sm:hidden transition" onClick={handleClick}>
                    {click ? <FaTimes /> : <CiMenuFries />}
                </button>
            </div>
        </nav>
    );
}

export default Navbar;
