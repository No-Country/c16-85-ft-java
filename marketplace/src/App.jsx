import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <h1 class=" text-5xl bg-black text-stone-50">
          Hello world!
      </h1>
    </>
  )
}

export default App
