import React, { createContext, useState } from 'react'


export const UserContext = createContext()

const UserProvider = ({ children }) => {
   const [user, setUser] = useState({});

   
   const signIn = (value) => setUser(value);
   const signOut = () => setUser({});
   return (
      <UserContext.Provider value={{ user, signIn, signOut }}>
         {children}
      </UserContext.Provider>
   );
};

export default UserProvider