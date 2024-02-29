import React, { useState } from "react";


const Login = () => {

    const LoginState = {
        username: '',
        password: ''
    }


    const [login, setLogin] = useState(LoginState)

    const handleChange = e => {

        const { name, value } = e.target
        const valueLogin = { ...login, [name]: value };
        setLogin(valueLogin)
    }


    const handleSubmit = async (e) => {
        e.preventDefault()
        console.log(login);
        const response = await fetch('https://c16-85-ft-java.onrender.com/auth/authenticate', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(login)
        })
        const data = await response.json();
        console.log(data);
    }


    return(
        <div class="flex items-center min-h-screen bg-slate-600">
        <div class="container mx-auto bg-stone-50 w-[400px] rounded-lg">
            <div class="max-w-md mx-auto my-10">
                <div class="text-center">
                    <h1 class="my-3 text-3xl font-semibold text-gray-700 dark:text-gray-200">Sign in</h1>
                    <p class="text-gray-500 dark:text-gray-400">Sign in to access your account</p>
                </div>
                <div class="m-7">
                    <form onSubmit={handleSubmit}>
                        <div class="mb-6">
                            <label for="email" class="block mb-2 text-sm text-gray-600 dark:text-gray-400">Email Address</label>
                            <input onChange={handleChange} type="username" name="username" id="username" placeholder="you@company.com" class="w-full px-3 py-2 placeholder-gray-300 border border-gray-300 rounded-md focus:outline-none focus:ring focus:ring-indigo-100 focus:border-indigo-300 dark:bg-gray-700 dark:text-white dark:placeholder-gray-500 dark:border-gray-600 dark:focus:ring-gray-900 dark:focus:border-gray-500" />
                        </div>
                        <div class="mb-6">
                            <div class="flex justify-between mb-2">
                                <label for="password" class="text-sm text-gray-600 dark:text-gray-400">Password</label>
                                <a href="#!" class="text-sm text-gray-400 focus:outline-none focus:text-indigo-500 hover:text-indigo-500 dark:hover:text-indigo-300">Forgot password?</a>
                            </div>
                            <input onChange={handleChange} type="password" name="password" id="password" placeholder="Your Password" class="w-full px-3 py-2 placeholder-gray-300 border border-gray-300 rounded-md focus:outline-none focus:ring focus:ring-indigo-100 focus:border-indigo-300 dark:bg-gray-700 dark:text-white dark:placeholder-gray-500 dark:border-gray-600 dark:focus:ring-gray-900 dark:focus:border-gray-500" />
                        </div>
                        <div class="mb-6">
                            <button type="submit" class="w-full px-3 py-3 text-white bg-slate-600 rounded-md focus:bg-indigo-600 focus:outline-none">Sign in</button>
                        </div>
                        <p class="text-sm text-center text-gray-400">Don&#x27;t have an account yet? <a href="#!" class="text-indigo-400 focus:outline-none focus:underline focus:text-indigo-500 dark:focus:border-indigo-800">Sign up</a>.</p>
                    </form>
                </div>
            </div>
        </div>
    </div>
    )
}

export default Login;